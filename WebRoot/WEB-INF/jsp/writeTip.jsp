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
	<link rel="stylesheet" type="text/css" href="css\writeTip.css">
		<script type="text/javascript">
			window.onload = function(){
				var date = new Date();
				var time = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
				document.getElementById("time").value=time;
			}
		</script>
	
  </head>
  	
  <body>
 	<div id="top">
		 	<div>
		 		<img src="image/alltiplist_top.png">
		 	</div>
		 </div>
		 <div id="box">
		 	<div id="show">
		 		<form action="/Blog/insertTip.action" method="post">
		 			<p id="text1">文章标题</p>
		 			<select name="classes">
						<c:forEach items="${classList}" var="Class">
	    					<option value="${Class }">${Class }</option>
	    				</c:forEach>
		 			</select>
		 			<input id="title" type="text" name="title">
		 			<p id="text2">文章内容</p>
		 			<textarea  id="detail" name="detail"></textarea>
		 			<input type="text" name="time" id="time" hidden>
		 			<input type="text" name="userid" value="${userid}" hidden> <!--  	从session中取数据，作为隐藏域传递数据,user.id  -->
		 			<input id="submit" type="submit" value="发表文章">
		 			<input id="reset" type="reset" value="重置">
		 		</form>
		 	</div>
		 	
		 </div>
		 <hr/>
		 <div id="foot">
		 	<div>
		 		<img src="image/login_bottom.png">
		 	</div>
		 </div>
  		
  </body>
</html>

<!-- 



<form action="/Blog/insertTip.action" method="post">
	    	<select name="classes">
	    		<c:forEach items="${classList}" var="Class">
	    			<option value="${Class }">${Class }</option>
	    		</c:forEach>
	    	</select>
	    	标题：<input type="text" name="title"> <br/><br/>
	    	内容:<textarea name="detail"></textarea><br/><br/>
	    	发表时间：<input type="text" name="time" id="time">
	 		<input type="text" name="userid" value="${userid}" hidden>   <!--  	从session中取数据，作为隐藏域传递数据,user.id 
	    	<input type="submit" value="发表">
    </form>








 -->
