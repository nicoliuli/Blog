package cn.itcast.ssm.controller;


//使用注解开发控制器需要导入的包
import java.util.List;
import java.util.Scanner;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import cn.itcast.ssm.filter.HtmlFilter;
import cn.itcast.ssm.pojo.Pager;
import cn.itcast.ssm.pojo.Tip;
import cn.itcast.ssm.pojo.TipUser;
import cn.itcast.ssm.service.TipService;


@Controller("TipController")
public class TipController{
	@Resource(name="TipService")
	private TipService tipService;
	
	//将用户的帖子插入到数据库中
	@RequestMapping("/insertTip.action")
	public ModelAndView insertTip(Tip tip,HttpServletRequest request) throws Exception{
		String [] classesValues = request.getParameterValues("classes");	//得到用户发表的帖子分类，由option提交过来的数据
		tip.setClasses(classesValues[0]);
		//将tip的内容进行html文本转码,怎么定义拦截器?
		String title = tip.getTitle();
		String detail = tip.getDetail();
		title = HtmlFilter.filter(title);
		detail = HtmlFilter.filter(detail);
		System.out.println("过滤后的title："+title);
		System.out.println("过滤后的detail:"+detail);
		tip.setTitle(title);	//重新赋值
		tip.setDetail(detail);
		
		tipService.insertTip(tip);	//将用户发表的tip插入数据库
		//跳转到发表帖子的明细上
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("tip",tip);
		modelAndView.setViewName("/WEB-INF/jsp/tipDetail.jsp");
		return modelAndView;	
	}
	
	//查看我发表的所有帖子,根据用户id
	@RequestMapping("/getAllTip.action")
	public ModelAndView getAllTip(int userid) throws Exception{
		
		List<Tip> tipList = tipService.getALlTip(userid);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userid",userid);
		modelAndView.addObject("tipList",tipList);
		modelAndView.setViewName("/WEB-INF/jsp/tiplist.jsp");
		return modelAndView;
	}
	//首页，浏览所有的tip
	@RequestMapping("/getTipList.action")
	public void getTipList(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String current = request.getParameter("currentPage");
		if(current == null || current == "" || current.equals("0")){
			current = "1";
		}
		int currentPage = Integer.parseInt(current);
		System.out.println("Controller层输出的数据-----------");
		System.out.println("要访问的页数："+currentPage);
		
		
		Pager<Tip> pager = tipService.getTipList(currentPage, 5);
		
		System.out.println("prePage="+pager.getPrePage()+"++++");
		System.out.println("nextPage="+pager.getNextPage());
		request.setAttribute("pager",pager);
		request.getRequestDispatcher("/WEB-INF/jsp/alltiplist.jsp").forward(request, response);
				
	}
	
	/*------------------------------------------------------------*/
	//查看我发表的tip的想详细内容，根据tipid和userid
	@RequestMapping("/getNeirong.action")
	public ModelAndView getNeirong(HttpServletRequest request) throws Exception{
		String tipid = request.getParameter("tipid");
		String userid = request.getParameter("userid");
		System.out.println("tipid=:"+tipid);
		System.out.println("userid=:"+userid);
		Tip tip= new Tip();
		tip.setId(Integer.parseInt(tipid));
		tip.setUserid(Integer.parseInt(userid));
		tip = tipService.getNeirong(tip);
		System.out.println("得到的分类是："+tip.getClasses()+"====================");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("tip",tip);
		modelAndView.setViewName("/WEB-INF/jsp/neirong.jsp");
		return modelAndView;
	}
	
	
	
	
	//根据tipid删除帖子,跳转到tiplist.jsp
	@RequestMapping("/deleteTipById.action")
	public ModelAndView deleteTipById(TipUser tipUser) throws Exception{
		tipService.deleteTipById(tipUser);
		System.out.println("帖子id"+tipUser.getTip().getId());
		System.out.println("用户id："+tipUser.getUser().getId());
		List<Tip> tipList = tipService.getALlTip(tipUser.getUser().getId());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userid",tipUser.getUser().getId());
		modelAndView.addObject("tipList",tipList);
		modelAndView.setViewName("/WEB-INF/jsp/tiplist.jsp");
		return modelAndView;
	}
	
	//修改帖子内容，首先查询帖子的详细信息,根据userid和tipid
	@RequestMapping("/getTipDetail.action")
	public ModelAndView getTipDetail(TipUser tipUser)throws Exception{
		//查询出帖子的详细内容,根据tipid和userid
		Tip tip = tipService.getDetail(tipUser);
		//当修改帖子分类时，根据userid查询出该用户所有的分类
	//	System.out.println("修改的用户的分类的id："+tipUser.getUser().getId()+"-------------------");
		List<String> classesList = tipService.getAllClassByUserId(tipUser.getUser().getId());
	/*	if(classesList != null){
			for(String c:classesList){
				System.out.println(tipUser.getUser().getId()+"的tip分类："+c);
			}
		}*/
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("tip",tip);
		modelAndView.addObject("classesList", classesList);
		modelAndView.setViewName("/WEB-INF/jsp/updateTip.jsp");
		return modelAndView;
	}
	
	
	//根据userid和tipid修改帖子内容
	@RequestMapping("/updateTipById.action")
	public String updateTipById(TipUser tipUser) throws Exception{
		tipService.updateTipById(tipUser);	
		return "/getAllTip.action?userid="+tipUser.getTip().getUserid();	//跳转到tipList.jsp
	}
	
	
	// 跳转到写博客的页面
	@RequestMapping("/writeTip.action")
	public String writeTip(){
		return "/WEB-INF/jsp/writeTip.jsp";
	}
	public TipService getTipService() {
		return tipService;
	}

	public void setTipService(TipService tipService) {
		this.tipService = tipService;
	}
	
	
}
