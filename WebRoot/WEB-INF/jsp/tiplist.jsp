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
    
    <title>我的tip列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css\tiplist.css">

  </head>
  	
  
  <body>
  	<div id="top">
  		<div><img src="image/alltiplist_top.png"/></div>
  	</div>
  	
  	<div id="show">
  		
  		<div id="title">
  			<p id="logo">${sessionScope. username}的博客</p>
  			<a id="one" href="${pageContext.request.contextPath}">首页</a>
  			<a id="two" href="${pageContext.request.contextPath}/getTipList.action">查看所有tip</a>
  		</div>
  		<c:forEach items="${tipList}" var="tip">
  			<div class="box">
  				<a class="title_detail" href="${pageContext.request.contextPath }/getNeirong.action?tipid=${tip.id }&userid=${tip.userid }" target="_blank">${tip.title }</a>
  				<div class="detail_less"><p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp${tip.detail }</p></div>
  				
  				<p class="classes">类型：${tip.classes }</p>
	  			<a class="read" href="${pageContext.request.contextPath }/getNeirong.action?tipid=${tip.id }&userid=${tip.userid }" target="_blank">阅读</a>
	  			<a class="del" href="/Blog/deleteTipById.action?tip.id=${tip.id }&user.id=${tip.userid}">删除</a>
	  			<a class="change" href="/Blog/getTipDetail.action?tip.id=${tip.id }&user.id=${tip.userid}">修改</a>
	  			<a class="readSay" href="/Blog/getAllSay.action?tipid=${tip.id }" target="_blank">查看评论</a>
  			</div>
  			
  		</c:forEach>
  	</div>
  	<div id="foot">
  		<div><img src="image/login_bottom.png"/></div>
  	</div>
  </body>
</html>



<!-- 


<a href="${pageContext.request.contextPath}">首页</a>
  <a href="${pageContext.request.contextPath}/getTipList.action">查看所有tip</a>
  <hr/>
  		<table wiwdth="90%">
  			<tr>
  				<td>id</td>
  				<td>userid</td>
  				<td>title</td>
  				<td>detail</td>
  				<td>classes</td>
  				<td>time</td>
  				<td>删除</td>
  				<td>修改</td>
  				<td>查看评论</td>
  			</tr>
	  		<c:forEach items="${tipList}" var="tip">
	  			<tr>
	  				<td>${tip.id }</td>
		    		<td>${tip.userid }</td>
		    		<td><a href="${pageContext.request.contextPath }/getNeirong.action?tipid=${tip.id }&userid=${tip.userid }" target="_blank">${tip.title }</a></td>
		    		<!-- 点击查看tip的详细内容，根据tip.id和userid
		    		<td><a href="${pageContext.request.contextPath }/getNeirong.action?tipid=${tip.id }&userid=${tip.userid }" target="_blank">内容</a></td>
		    		<td>${tip.classes }</td>
		    		<td>${tip.time }</td>
		    		<td><a href="/Blog/deleteTipById.action?tip.id=${tip.id }&user.id=${tip.userid}">删除</a></td>
		    		<td><a href="/Blog/getTipDetail.action?tip.id=${tip.id }&user.id=${tip.userid}">修改</a></td>
		    		<td><a href="/Blog/getAllSay.action?tipid=${tip.id }">查看评论</a></td>
	  			</tr>
	    		
	    	</c:forEach>
  		</table>
    	

 -->
