<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>tipList</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css\tipDetail.css">

  </head>
  
  <body>
  	<div id="top">
			<div><img src="image/alltiplist_top.png"/></div>
		</div>
		

		 <div id="box">
		 	<div id="show">
		 		<a href="/Blog/getAllTip.action?userid=${tip.userid}">点击查看所有帖子</a>
		 		<p id="text1">文章标题</p>
		 		<p id="text2">${tip.title }</p> 			
		 		<p id="text3">文章分类</p>
		 		<p id="text4">${tip.classes }</p> 
		 		<p id="text5">文章内容</p>
		 		<p id="text6">${tip.detail }</p> 
		 	</div>		 	
		 </div>
  </body>
</html>


<!-- 

<a href="/Blog/getAllTip.action?userid=${tip.userid}">点击查看所有帖子</a>
    发表成功：以下是tip的详细内容<br/>
    Id：<p>${tip.id}</p>
    用户id：<p>${tip.userid }</p>
  帖子分类:<p>${tip.classes }</p>
   标题title:<p>${tip.title }</p>
  内容detail：<p>${tip.detail }</p>
  发表时间：<p>${tip.time }</p>



 -->