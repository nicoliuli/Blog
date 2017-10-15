<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String warning = (String)request.getAttribute("warning");//当注册失败时，后台modelAndView.addObject("warning","对不起，该用户名已存在");
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录界面</title>
    
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css\register.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
		$(function(){
			var uname = document.getElementById('username');
			var warning = document.getElementById('warning');
			uname.onblur = function(){
				var username = document.getElementById('username').value;
				$.get("${pageContext.request.contextPath }/testRegisterUserName.action?&username="+username,true,function(data){
					eval("var a ="+data)
					warning.innerHTML = a.msg;
				})
			}
		})
	</script>
	
  </head>
  
  <body>
  	<div id="box">
			<div id="show">
				<img id="imgR" src="image/register.jpg">
				<div id="in">
					<p id="text1">注册</p>
					<form action="/Blog/insertUser.action" method="post">
						<span id="warning"></span>
	    				<input id="username" type="text" name="username" placeholder="输入用户名"><br/><br/>
	  					<input id="password" type="text" name="password" placeholder="输入密码"><br/><br/>
	  					<input id="submit" type="submit" value="注册"><br/><br>
    				</form>
    				<div id="bottom">
    					<p id="text2">第三方账号登录</p>
    					<img src="image/login_b.png">
    				</div>	
				</div>
			</div>
			<div id="foot">
				<div>
					<img src="image/login_bottom.png">
				</div>
			</div>
		</div>		
  			
  </body>
</html>
