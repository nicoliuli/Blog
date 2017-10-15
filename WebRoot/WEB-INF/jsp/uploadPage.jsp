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
    
    <title>写博客</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css\uploadPage.css">
		
	
  <script type="text/javascript" src="js\jquery-1.7.2.min.js"></script>
  <script type="text/javascript">
  
  	$(function(){
			var date = new Date();
			var time = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
		//	document.getElementById("time").value=time;
			
			$("#box #show #submit").click(function(){
					setInterval(function(){
						$.get("${pageContext.request.contextPath }/servlet/uploadData",true,function(data){
							eval("var a="+data);	//服务器返回json串
						
							$("#box #show #process").html("已上传："+a.hasUpload+"M,----总大小："+a.total+"M,上传百分比："+a.present+"%");
							$("#box #show #all #pre").css("width",500*(a.present*0.01)+'px');
						});
					},500);	
				});
	  	})
  
  </script>
  </head>
  	
  <body>
  <div id="top">
		<div><img src="image/alltiplist_top.png"/></div>
	</div>
 	<div id="box">
 		<div id="show">
 			<form action="${pageContext.request.contextPath}/servlet/Upload" method="post" enctype="multipart/form-data">
 				<input type="text" name="userid" value="${sessionScope.userid}" hidden/>
 				<input type="text" name="username" value="${sessionScope.username}" hidden/>
 				<input id="selectFile" type="file" name="file1">
 				<p id="text1">资源类型</p>
 				<select>
 					<option>请选择</option>
 					<option>文档</option>
 					<option>代码类</option>
 					<option>工具类</option>
 					<option>其他</option>
 				</select>
 				<p id="text2">资源描述</p>
 				<textarea id="detail"></textarea>
 				<input id="submit" type="submit" value="上传"/>
 				<p id="process"></p>
 				<div id="all">
 					<div id="pre"></div>
 				</div>
 				<c:if test="${message != null && message != ''}">
 					<!--<p id="message">${message}</p>-->
 					<script type="text/javascript">
 						alert("上传成功");
 					</script>
 				</c:if>
 				
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


<!-- 


上传文件页面
 	<form action="${pageContext.request.contextPath}/servlet/Upload" method="post" enctype="multipart/form-data">
 		用户id：<input type="text" name="userid" value="${sessionScope.userid}" hidden/>
 		用户名：<input type="text" name="username" value="${sessionScope.username}" hidden/><br/>
 		<!-- 必须要有name属性 
    	选择文件：<input type="file" name="file1"><br/>
    	文件描述:<input type="text" name="detail">
 		<br/><br/>
 		<input type="submit" value="上传"/>
 	</form>

 -->
