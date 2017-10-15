<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String warning = (String)request.getAttribute("warning");//当登录失败时，后台modelAndView.addObject("warning","对不起，您的用户名或密码输入错误");
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录界面</title>
    
	<meta charset="utf-8">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/login.css">
	
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.2.min.js"></script>
  	<script type="text/javascript">
  		$(function(){
  			var uname = document.getElementById('username');
  			var pwd = document.getElementById('password');
  			uname.onblur = function(){
  				var username = document.getElementById('username').value;
  				$.get("${pageContext.request.contextPath }/testLoginUserName.action?&username="+username,true,function(data){
  					eval("var a="+data);
  					document.getElementById('warning').innerHTML = a.msg;
  				})
  			}
  			pwd.onblur = function(){
  				
  				
	  			var password = document.getElementById('password').value;
	  			$.get("${pageContext.request.contextPath }/testLoginPassword.action?&password="+password,true,function(data){
					eval("var a="+data);	//服务器返回json串*/
					document.getElementById('warning').innerHTML = a.msg;
				});
  			}
  			
  		})
  	</script>
</head> 
  <body>
	  <div id="box">
				<div id="show">
					<div id="pic">
						<img src="image/login.png">
					</div>
					<div id="in">
						<p id="text">账号登陆</p>
						<form action="/Blog/findUser.action" method="post">
						  		<input id="username" type="text" name="username" placeholder="输入用户名/邮箱/手机号"><br/><br/>
								<input id="password" type="text" name="password" placeholder="输入密码"><br/><br/>					
								<input id="submit" type="submit" value="登录" id="login"><br/><br/>
						</form>
						<span id="warning"></span>
						<a href="" id="losepass">忘记密码</a>
						<div id="down">
							<p id="b_text">第三方账号登陆</p>
							<img src="image/login_b.png">
							<p id="hasLogin">还没有CSDN帐号？</p>
							<a id="register" href="">立即注册</a>
						</div>
					</div>
					
				</div>
			</div>
	
			<div id="foot">
				<div>
					<img src="image/login_bottom.png">
				</div>
			</div>
  </body>

</html>


 