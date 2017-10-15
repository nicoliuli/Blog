<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加分类</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css\registerSuccess.css">
	
	<script type="text/javascript">
		window.onload = function(){
		var form = document.getElementById("form");
			var addClass = document.getElementById("addClass");
			addClass.onclick = function(){
				var inputClass = document.getElementById("inputClass");
				var ClassValue = inputClass.value;
				var newSpan = document.createElement("span");
				newSpan.className = "newSpan";
				newSpan.innerHTML = ClassValue;
				var newNode = document.createElement("input");
				newNode.className = "newNode";
				newNode.setAttribute("type","checkbox");//多选框
				newNode.setAttribute("name","classes");
				newNode.setAttribute("value",ClassValue);//
				newNode.setAttribute("checked","checked");	//自动选中所添加的分类
				form.insertBefore(newSpan,document.getElementById("submit"));
				form.insertBefore(newNode,document.getElementById("submit"));
				
				//向分类列表中追加分类节点
				var shows = document.getElementsByClassName("show");
				var lastShow = shows[shows.length-1];
				var newShow = document.createElement("div");
				newShow.innerHTML = "<p>"+ClassValue+"</p>";
				newShow.className="show";
				document.getElementById("box").appendChild(newShow);
				var shows = document.getElementsByClassName("show");
				inputClass.value = "";
				for(var i = 0;i<shows.length;i++){
					if(i % 2 == 0){
						shows[i].style.background = "white";
					}else{
						shows[i].style.background = "#F9F9F9";
					}
					shows[i].onmouseover = function(){
						this.style.background = "#F9FAD1";
					}
					shows[i].onmouseout = function(){
						this.style.background = "white";
					}
				}	
			}
			var shows = document.getElementsByClassName("show");
			for(var i = 0;i<shows.length;i++){
				if(i % 2 == 0){
					shows[i].style.background = "white";
				}else{
					shows[i].style.background = "#F9F9F9";
				}
				shows[i].onmouseover = function(){
					this.style.background = "#F9FAD1";
				}
				shows[i].onmouseout = function(){
					this.style.background = "white";
				}
			}
		}
		
		/*

				var addClass = document.getElementById("addClass");
				addClass.onclick = function(){
				var inputClass = document.getElementById("inputClass");
				var ClassValue = inputClass.value;
				var newSpan = document.createElement("span");
				newSpan.innerHTML = ClassValue;
				var newNode = document.createElement("input");
				newNode.setAttribute("type","checkbox");//多选框
				newNode.setAttribute("name","classes");
				newNode.setAttribute("value",ClassValue);//
				newNode.setAttribute("checked","checked");	//自动选中所添加的分类
				form.insertBefore(newSpan,document.getElementById("submit"));
				form.insertBefore(newNode,document.getElementById("submit"));


		*/
	</script>
	
  </head>
  

  <body>
  <div id="top">
			<div><img src="image/alltiplist_top.png"/></div>
	</div>
  	
	<div id="box">
			<div id="title">
				<p id="text1">类别</p>
			</div>
			
		</div>
	<div id="add">
		<input type="text" id="inputClass"><input id="addClass" type="button" value="添加分类"/>
 		<form id="form" action="/Blog/setClasses.action" method="post">
 			<input id="submit" type="submit" value="确定">
 		</form>
 	</div>
	
	<div id="foot">
 			<div>
				<img src="image/login_bottom.png">
			</div>
 	</div>
  </body>
</html>


<!-- 
 注册成功,请定义自己的帖子分类
  	 <input type="text" id="inputClass"><input id="addClass" type="button" value="添加"/><br/>
	<form id="form" action="/Blog/setClasses.action" method="post"> 
		<input id="submit" type="submit" value="提交">
	</form>



 -->
