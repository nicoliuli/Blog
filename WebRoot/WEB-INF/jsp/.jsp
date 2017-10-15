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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  	
  <body>
  		<p>tipid:${tip.id} </p>
  		<p>userid:${tip.userid }</p>
  		<p>classes:${tip.classes }</p>
  		<p>time:${tip.time}</p>
  		<form action="/Blog/updateTipById.action" method="post">
  			<input type="text" name="tip.id" value="${tip.id}" hidden/>
  			<input type="text" name="tip.userid" value="${tip.userid }" hidden/>
<!--  			<input type="text" name="tip.time" value="${tip.time}" hidden/>-->
  			<select name="tip.classes">
  				<c:forEach	items="${classesList}" var="classes">
  					<option>${classes}</option>
  				</c:forEach>
  			</select>
  			<br/><br/>
  			title:<input type="text" name="tip.title" value="${tip.title}"><br/><br/>
  			detail:<input type="text" name="tip.detail" value="${tip.detail }"/><br/><br/>
  			<input type="submit" value="提交" />
  		</form>
  </body>
</html>
