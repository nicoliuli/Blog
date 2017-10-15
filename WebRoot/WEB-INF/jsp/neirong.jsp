<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>tipList</title>
    
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css\neirong.css">
	
  </head>
  
  <body>
  	<div id="top">
		<div><img src="image/alltiplist_top.png"/></div>
	</div>
  	<div id="box">
  		
  		<div id="title">
  			<p id="logo">${sessionScope.username}的博客</p>
  			<h1>${tip.title}</h1>		
  		</div>
  		<div id="classes">
  			<p id="text1">分类</p>
  			<p id="text2">${tip.classes}</p>
  		</div>
  		<div id="detail">
  			<p>${tip.detail }</p>
  		</div>
  	</div>
  	
  	<div id="foot">
 		<div>
			<img src="image/login_bottom.png">
		</div>
 	</div>
  </body>
</html>


<!-- 
tipid:${tip.id}<br/><br/>
  	分类：${tip.classes}<br/><br/>
  	标题：${tip.title}<br/><br/>
  	内容：${tip.detail }<br/><br/>

 -->