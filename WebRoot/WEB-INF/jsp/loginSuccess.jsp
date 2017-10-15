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
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css\loginSuccess.css">
		<script type="text/javascript">
			window.onload = function(){
				var img = document.getElementById('img');
				var index = 1;
				setInterval(function(){
					img.src = "image/loginSuccess_lunbo"+index+".png";
					index++;
					if(index == 6){
						index = 1;
					}
				},2000);
			}
		</script>
	
  </head>
  
  <body>
   <div id="top">
		 	<div>
		 		<img src="image/alltiplist_top.png">
		 	</div>
		 </div>
		 <div id="list">
		 	<div id="show">
		 		<div id="one"><a href="${pageContext.request.contextPath }/getTipList.action?currentPage=0" target="_blank">查看所有文章</a></div>
		 		<div id="two"><a href="/Blog/getAllTip.action?userid=${userid }&currentPage=0" target="_blank">我的文章</a></div>
		 		<div id="three"><a href="${pageContext.request.contextPath}/addClass.action" target="_blank">添加分类</a></div>
		 		<div id="four"><a  href="${pageContext.request.contextPath}/writeTip.action" target="_blank">写文章</a></div>
		 		<!-- 上传资料，根据userid和username,从session域中取值 -->
		 		<div id="five"><a  href="${pageContext.request.contextPath}/gotoUploadPage.action?userid=${sessionScope.userid}&username=${sessionScope.username}" target="_blank">传资源</a></div>
		 		<div id="six"><a  href="${pageContext.request.contextPath}/servlet/ListFileServlet" target="_blank">下载</a></div>
		 		
		 		<div id="eight"><a href="/Blog/logout.action">注销</a></div>
		 	</div>
		 </div>
		 <!--  -->
		<div id="lunbo">
			<img id="img" src="image/loginSuccess_lunbo1.png">
		</div>
		 <div id="foot">
		 	<div>
		 		<img src="image/login_bottom.png">
		 	</div>
		 </div>
  </body>
</html>
