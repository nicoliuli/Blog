<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Integer id = (Integer)request.getSession().getAttribute("userid");	//得到当前登陆的 用户id
pageContext.setAttribute("id",id);
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>所有的tip分类</title>
    
	<link rel="stylesheet" type="text/css" href="css\alltiplist.css">
	<script type="text/javascript">
		window.onload = function(){
			var box = document.getElementsByClassName("box");
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
  	<div id="show">
  		<div id="title">
  			<p id="text1">标题</p>
  			<p id="text2">类别</p>
  			<p id="text3">评论</p>
  			<p id="text4">查看评论</p>
  		</div>
  		<c:forEach items="${pager.dataList}" var="tip">
  			<div class="box">
  				<a class="title_detail" href="${pageContext.request.contextPath }/getNeirong.action?tipid=${tip.id }&userid=${tip.userid }" target="_blank">${tip.title }</a>
  				<p class="classes">${tip.classes }</p>
  				<a class="say" href="/Blog/gotoSayPage.action?id=<%=id %>&tipid=${tip.id }&userid=${tip.userid}">评论</a>
  				<a class="allSay" href="/Blog/getAllSay.action?tipid=${tip.id }" target="_blank">查看所有评论</a>
  			</div>  		
  		</c:forEach>
  		<hr/>
  		
  		<div id="bar">
  			<div id="box">
  				<a class="prePage" href="${pageContext.request.contextPath }/getTipList.action?currentPage=${pager.prePage}">上一页</a>
		  		<c:forEach items="${pager.bar}" var="bar">
		  			<a class="page" href="${pageContext.request.contextPath }/getTipList.action?currentPage=${bar}">${bar}</a>
		  		</c:forEach>
		  		<a class="nextPage" href="${pageContext.request.contextPath }/getTipList.action?currentPage=${pager.nextPage}">下一页</a>
  			</div>
  			
  		</div>
  		
  		<div id="foot">
			<div>
				<img src="image/login_bottom.png">
			</div>
		</div>
  	</div>
  	
  </body>
</html>
