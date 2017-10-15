package cn.itcast.ssm.controller;


//使用注解开发控制器需要导入的包
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.filter.HtmlFilter;
import cn.itcast.ssm.pojo.Say;
import cn.itcast.ssm.pojo.Tip;
import cn.itcast.ssm.pojo.TipUser;
import cn.itcast.ssm.service.SayService;
import cn.itcast.ssm.service.TipService;

@Controller("SayController")
public class SayController{
	@Resource(name="SayService")
	private SayService sayService;
	
	//跳转到评论页面
	@RequestMapping("/gotoSayPage.action")
	public String gotoSayPage(Say say,HttpServletRequest request){
		
		request.setAttribute("say", say);
		return "/WEB-INF/jsp/sayPage.jsp";
	}
	
	//将用户的评论插入到say表中
	@RequestMapping("/say.action")
	public String say(Say say) throws Exception{
		System.out.println("用户id："+say.getId());
		System.out.println("发表tip的用户id："+say.getUserid());
		System.out.println("评论的tipid："+say.getTipid());
		System.out.println("评论的内容是："+say.getDetail());
		String detail = say.getDetail();
		detail = HtmlFilter.filter(detail);	//将评论的内容进行html文本转码
		
		System.out.println("转码后的评论是："+detail);
		say.setDetail(detail);	//重新设置评论内容
		sayService.say(say);	//将评论内容发表到数据库中
		//重定向到alltiplist.jsp
		return "redirect:/gotoGetTipList.action";
	}
	//重定向
	@RequestMapping("/gotoGetTipList.action")
	public String gotoGetTipList(){
		return "/getTipList.action";
	}
	
	//查看所有的评论,根据tipid
	@RequestMapping("/getAllSay.action")
	public ModelAndView getAllSay(int tipid) throws Exception{
		List<Say> sayList = sayService.getAllSay(tipid);
	/*	if(sayList != null){
			for(Say s:sayList){
				System.out.println(s.getId()+"评论了"+s.getUserid()+"发表tip,tipid:"+s.getTipid()+",评论的内容是"+s.getDetail());
			}
		}*/
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("sayList",sayList);
		modelAndView.setViewName("/WEB-INF/jsp/getAllSay.jsp");
		return modelAndView;
	}
	
	
	public SayService getSayService() {
		return sayService;
	}

	public void setSayService(SayService sayService) {
		this.sayService = sayService;
	}
	
	
	
	
	
}
