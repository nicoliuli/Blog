<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head> 
    <title></title>
	<meta charset="utf-8" />
	<link rel="stylesheet" type="text/css" href="css\index.css">
	<script type="text/javascript">
			window.onload = function(){
				var i = 1;
				var lunbo = document.getElementById('imglunbo');
				var listLi = document.getElementsByClassName("listLi");
				setInterval(function(){
					lunbo.src="image/lunbo"+i+".jpg";
					for(var j = 0;j<listLi.length;j++){
						listLi[j].style.background = "#999999";
					}
					listLi[i-1].style.background = "#333333";
					i++;
					if(i > 5){
						i = 1;
					}
				},2000);
			}
		</script>
  </head>
  
 <body>
		
		<div id="box">
			<div id="show">
				<a id="login" href="/Blog/login.action">登录 |</a>
				<a id="register" href="/Blog/register.action">注册 |</a>
				<a id="help" href="/Blog/getTipList.action"> 浏览</a>
				<input id="search" type="text" placeholder="搜索">
				<img id="index1" src="image/index1.png">
				<img id="index2" src="image/index2.png">
				<img id="index3" src="image/index3.png">
				<img id="index4" src="image/index4.png">
				<img id="index5" src="image/index5.png">
				<img id="index6" src="image/index6.png">
				<div id="lunbo">
					<img class="" id="imglunbo" src="image/lunbo1.jpg">
					<ul id="list">
						<li class="listLi" id="list1"></li>
						<li class="listLi" id="list2"></li>
						<li class="listLi" id="list3"></li>
						<li class="listLi" id="list4"></li>
						<li class="listLi" id="list5"></li>
					</ul>
				</div>
				<img id="index7" src="image/index7.png">
				<img id="index8" src="image/index8.png">
				<img id="index9" src="image/index9.gif">
				<img id="index10" src="image/index10.png">
			</div>
		</div>
	</body>
</html>
