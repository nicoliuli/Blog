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
    
    <title>评论</title>
    
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css\sayPage.css">
	
  </head>
  
  <body>
  	
  		<div id="top">
			<div><img src="image/alltiplist_top.png"/></div>
		</div>
  	<div id="box">
  		<div id="show">
  			<form action="/Blog/say.action" method="post">
				<input type="text" name="id" value="${say.id }" hidden/>
				<input type="text" name="userid" value="${say.userid }" hidden/>
				<input type="text" name="tipid" value="${say.tipid}" hidden/>
				<textarea id="say" name="detail"></textarea>
				<br/><br/>
			<input id="submit" type="submit" value="提交评论">
	</form>		
  		</div>
  	</div>	
			
		
  		<div id="foot">
 			<div>
				<img src="image/login_bottom.png">
			</div>
 		</div>	
  </body>
</html>
