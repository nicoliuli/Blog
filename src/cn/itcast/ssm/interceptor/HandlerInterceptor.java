package cn.itcast.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

public class HandlerInterceptor implements
		org.springframework.web.servlet.HandlerInterceptor {

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		//需要拦截评论的url
		String url = request.getRequestURI();
		System.out.println("拦截的url是:"+url);
		if(url.startsWith("/Blog/gotoSayPage.action")){	//拦截的url是评论的url
			//说明已经登陆
			HttpSession session =  request.getSession();
			Object obj = session.getAttribute("userid");	
			if(obj != null){
				System.out.println("已经登陆");
				return true;
			}else{
				System.out.println("未登陆");
				//跳转到登陆页面
				request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
				return false;
			}
		}
		//其他地址不拦截
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	

}
