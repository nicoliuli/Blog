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
	
	<link rel="stylesheet" type="text/css" href="css\getAllSay.css">
  </head>
  
  <body>
  	
  	<div id="top">
  		<div><img src="image/alltiplist_top.png"/></div>
  	</div>
  	<div id="box">
  		<c:forEach items="${sayList}" var="say">
  			<div class="show">
  				<p class="text1">${say.username}评论：</p>
  				<p class="text2">${say.detail }</p>
  			</div>
  		</c:forEach>
  	</div>
  	<div id="foot">
 			<div>
				<img src="image/login_bottom.png">
			</div>
 		</div>
  </body>
</html>

<!-- 




<table width="80%">
  		<tr>
  			<td>评论者id</td>
  			<td>评论者username</td>
  			<td>被评论者id</td>
  			<td>tipid</td>
  			<td>评论</td>
  		</tr>
  		<c:forEach items="${sayList}" var="say">
  			<tr>
  				<td>${say.id }</td>
  				<td>${say.username}</td>
  				<td>${say.userid }</td>
  				<td>${say.tipid }</td>
  				<td>${say.detail }</td>
  			</tr>
  		</c:forEach>
  	</table>		
		<hr/>



 -->