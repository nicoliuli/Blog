package cn.itcast.ssm.controller;


//使用注解开发控制器需要导入的包

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.pojo.User;
import cn.itcast.ssm.service.UserService;

@Controller("UploadController")
public class UploadController{
	
	
	
	//跳转到上传资料页面uploadPage.jsp
	@RequestMapping("/gotoUploadPage.action")
	public String gotoUploadPage(){
		return "/WEB-INF/jsp/uploadPage.jsp";
	}
	//跳转到下载列表页面
	@RequestMapping("/gotoDownloadpage.action")
	public String gotoDownloadpage(){
		return "/WEB-INF/jsp/listfile.jsp";
	}
	
	//跳转到小游戏
	@RequestMapping("/gotoGame.action")
	public String gotoGame(){
		return "/WEB-INF/jsp/game.html";
	}
	
}
