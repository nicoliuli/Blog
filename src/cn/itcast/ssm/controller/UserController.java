package cn.itcast.ssm.controller;


//使用注解开发控制器需要导入的包
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sun.misc.BASE64Encoder;

import cn.itcast.ssm.pojo.Message;
import cn.itcast.ssm.pojo.User;
import cn.itcast.ssm.service.UserService;
import cn.itcast.ssm.util.CreateMD5;

@Controller("UserController01")
public class UserController{
	@Resource(name="userService")
	private UserService userService;
	
	
	//将新注册的用户添加到数据库中
	@RequestMapping("/insertUser.action")
	public String  insertUser(User u,HttpSession session) throws Exception{
		//将密码转为MD5码
		String s = CreateMD5.getMD5(u.getPassword());
		u.setPassword(s);
		List<User> userList = userService.findUserByUsername(u);
		if(userList == null || userList.size()==0){//用户名在数据库中不存在
			session.setAttribute("user",u);
			userService.insertUser(u);	//注册的用户名插入到数据库中
			return "redirect:/registerSuccess.action";	//重定向到注册成功页面
		}else{
			return "redirect:/register.action"; //重定向到注册页面重新注册
		}
		
	}
	//Ajax测试注册用户名是否合法
	@RequestMapping("/testRegisterUserName.action")
	public void testRegisterUserName(HttpServletRequest request,HttpServletResponse response) throws Exception{
		int ucount = userService.testUsername(request);
		Message m = new Message();
		if(ucount != 0){
			m.setMsg("用户名已存在");
		}
		JSONObject json = JSONObject.fromObject(m);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json.toString());
//		response.getWriter().flush();
		
	}
	//Ajax测试登录用户名是否正确
	@RequestMapping("/testLoginUserName.action")
	public void testLoginUserName(HttpServletRequest request,HttpServletResponse response) throws Exception{

		int ucount = userService.testUsername(request);
		Message m = new Message();
		if(ucount == 0){
			m.setMsg("用户名不存在");
		}
		JSONObject json = JSONObject.fromObject(m);
		System.out.println("对象转json："+json.toString());
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json.toString());
		response.getWriter().flush();
	}
	//Ajax测试登录密码是否正确
	@RequestMapping("/testLoginPassword.action")
	public void testLoginPassword(HttpServletRequest request,HttpServletResponse response) throws Exception{
		int pcount = userService.testPassword(request);
		Message m = new Message();
		if(pcount == 0){
			m.setMsg("密码输入错误");
		}
		JSONObject json = JSONObject.fromObject(m);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json.toString());
		response.getWriter().flush();
	}
	//登陆，查看当前用户是否在数据库中存在
	@RequestMapping("/findUser.action")
	public ModelAndView findUser(User u,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		//在这里将password转码（MD5）
		String s = CreateMD5.getMD5(u.getPassword());
		u.setPassword(s);
		User user = userService.findUsernameAndPassword(u);//检查用户输入的用户名和密码是否正确
		if(user != null){//输入的用户名和密码正确
			System.out.println("登陆的用户id："+user.getId());
			System.out.println("登陆的用户的username："+user.getUsername());
			session.setAttribute("userid",user.getId());	//将登陆的用户id设置到session域
			session.setAttribute("username",user.getUsername());//将登陆的用户username设置到session域
			//还要将该用户的帖子分类查找出来
			List<String> classList = userService.getClassByUserId(user);
			
			if(classList !=  null){
				session.setAttribute("classList", classList);//将该用户的tip分类存入session中
				Cookie cookie = new Cookie("JSESSIONID",session.getId());
				cookie.setPath("/Blog");
				cookie.setMaxAge(60*20);
				response.addCookie(cookie);
			}	
			modelAndView.setViewName("/WEB-INF/jsp/loginSuccess.jsp");//跳转到登陆成功页面
		}else{
			Message m = new Message();
			modelAndView.setViewName("/WEB-INF/jsp/login.jsp");//跳转到登陆页面重新登陆
		}
		return modelAndView;
	}
	
	//跳转到用户登录页面
	@RequestMapping("/login.action")
	public ModelAndView login() throws Exception{
		System.out.println("用户登陆");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/jsp/login.jsp");
		return modelAndView;	
	}
	
	//跳转到用户注册页面
	@RequestMapping("/register.action")
	public ModelAndView register() throws Exception{
		System.out.println("用户注册");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/jsp/register.jsp");
		return modelAndView;	
	}
	
	//跳转到用户注册成功页面
	@RequestMapping("/registerSuccess.action")
	public ModelAndView registerSuccess() throws Exception{
		System.out.println("用户注册");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/WEB-INF/jsp/registerSuccess.jsp");
		return modelAndView;	
	}
	
	//注销
	@RequestMapping("/logout.action")
	public String logout(HttpServletRequest request) throws Exception{
		request.getSession(true).removeAttribute("userid");
		return "index.jsp";	//重定向到用户登陆页面
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}	
	
}
