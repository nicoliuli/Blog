<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css\listfile.css">
	<script type="text/javascript">
		window.onload = function(){
			var box = document.getElementsByClassName("show");
			var color = null;
			for(var i = 0;i<box.length;i++){
				if(i%2 == 0){
					box[i].style.background = "#FFFFFF";					
				}else{
					box[i].style.background = "#F9F9F9";	
				}
				box[i].onmouseover = function(){
					this.style.background = "#F9FAD1";
				}
				box[i].onmouseout = function(){					
					this.style.background = "#FFFFFF";				
				}
			}
		}
	
	</script>
  </head>
  
  <body>
  	<div id="top">
		<div><img src="image/alltiplist_top.png"/></div>
	</div>
   	<div id="box">
   		<c:forEach var="entry" items="${requestScope.map}">
   			<div class="show">
   				<c:url value="/servlet/Download" var="url"><!-- 请求url -->
    				<c:param name="filename" value="${entry.key}"></c:param><!-- 请求参数-->
    			</c:url>
    			<a href="${url}">${entry.value}</a>
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

<c:forEach var="entry" items="${requestScope.map}">
    	<!--<a href="${pageContext.request.contextPath}/servlet/DownLoad?filename=${entry.key}">${entry.value}</a>--><br/>
    	
    	<!-- 由于href最好不要有中文，所以要用url编码将中文编码，生成新的url，但是提交给服务器仍可以获得原来的中文请求参数 
    	<c:url value="/servlet/Download" var="url"><!-- 请求url 
    		<c:param name="filename" value="${entry.key}"></c:param><!-- 请求参数
    	</c:url>
    	<a href="${url}">${entry.value}</a>
    	<!--
    		//key：文件在服务器中的文件名（UUID_文件名.txt）
			//value：文件的真实文件名（文件名.txt）
    
	</c:forEach>





 -->