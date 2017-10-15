package cn.itcast.ssm.controller;


//使用注解开发控制器需要导入的包
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.pojo.Classes;
import cn.itcast.ssm.pojo.User;
import cn.itcast.ssm.service.ClassService;
import cn.itcast.ssm.service.UserService;

//将每一个新注册的用户的帖子分类存到数据库class表中
@Controller("ClassController")
public class ClassController{
	@Resource(name="ClassService")
	private ClassService classService;
	
	@RequestMapping("setClasses.action")
	public String getClasses(HttpSession session,String []classes) throws Exception{
		User u = (User) session.getAttribute("user");
	/*	System.out.println("ID："+u.getId());
		System.out.println("用户名 ："+u.getUsername());
		if(Class != null){
			for(String c:Class){
				System.out.println("分类："+c);
			}
		}*/
		System.out.println("当前用户的ID是："+u.getId());
		Classes classe = new Classes();
		classe.setUser_id(u.getId());
		if(classes != null){
			for(String clas:classes){
				classe.setUser_id(u.getId());
				classe.setClasses(clas);
				//插入数据库
				classService.addClass(classe);
			}
		}
		//添加分类成功,重定向到登陆页面
		return "redirect:/login.action";
	}
	
	// 添加分类
	@RequestMapping("/addClass.action")
	public String addClass(HttpSession session,HttpServletRequest request) throws Exception{
		System.out.println("session:id"+session.getAttribute("userid"));
		String userid = session.getAttribute("userid").toString();
		System.out.println("转化后的userid："+userid);
		//查找出该用户原有的分类,根据userid from classes
		List<Classes> classes = classService.getClassesByUserId(Integer.parseInt(userid));
		request.setAttribute("classes", classes);
		
		return "/WEB-INF/jsp/addClass.jsp";
	}
	//将添加的分类插入到classses表中
	@RequestMapping("/addClassIntoDB.action")
	public String addClassIntoDB(String []classes,HttpServletRequest request,HttpSession session) throws Exception{
		String userid = session.getAttribute("userid").toString();
		System.out.println("添加分类的用id是："+userid);
		if(classes != null){
			for(String s:classes){
				System.out.println("重新添加的分类是："+s);
			}
		}
		Classes classe = new Classes();
		classe.setUser_id(Integer.parseInt(userid));
		if(classes != null){
			for(String clas:classes){
				classe.setUser_id(Integer.parseInt(userid));
				classe.setClasses(clas);
				//插入数据库
				classService.addClass(classe);
			}
		}
		System.out.println("添加成功");
		//重定向loginSuccess.jsp
		return "redirect:/gotoIndex.action";
	}
	
	//跳到loginSuccess.jsp页面，相当于首页
	@RequestMapping("/gotoIndex.action")
	public String gotoIndex(HttpSession session,HttpServletRequest request) throws Exception{
		int userid = Integer.parseInt(session.getAttribute("userid").toString());
		
		//根据userid查询该用户的所有分类
		List<Classes> classes = classService.getClassesByUserId(userid);
		System.out.println("查找到的分类个数是："+classes.size());
		request.setAttribute("classes",classes);
		request.setAttribute("userid",userid);
		return "/WEB-INF/jsp/login.jsp";
	}
	public ClassService getClassService() {
		return classService;
	}

	public void setClassService(ClassService classService) {
		this.classService = classService;
	}
	
	
	
	
}
