<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>网页头</title>
    
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
  <div id="topbar"></div>
    <div id="nav"><div id="mydroplinemenu" class="droplinebar">
<ul>
<li><a href="index">首页</a></li>
<li><a href="introduction.jsp?Page=int">小组简介</a>
            <ul>
              <li><a href="introduction.jsp?Page=int">小组简介</a></li>
              <li><a href="introduction.jsp?Page=tea">辅导老师</a></li>
               <li><a href="introduction.jsp?Page=active">小组活动</a></li>
              <li><a href="introduction.jsp?Page=com">参与社区</a></li>
              <li><a href="href="introduction.jsp?Page=red"">获得奖励</a></li>
              <li><a href="member">历届成员</a></li>
              <li><a href="photoView">小组T恤</a></li>
              <li><a href="photoView">相册</a></li>
            </ul>
</li>
<li><a href="#">成员博客</a>
            <ul>
              <li><a href="#">2006级</a></li>
              <li><a href="#">2007级</a></li>
              <li><a href="#">2008级</a></li>
            </ul>
          </li>
<li><a href="member">历届成员</a></li>
  <li><a href="Lectures">小组讲座</a></li>
  <li><a href="photoView">相册</a></li>
  </ul>
</div>
</div>
<div id="header"><div id='coin-slider'>
	<a href="#" target="_blank"><img src='images/headerpic1.jpg' />
	</a>
	<a href="#">
		<img src='images/headerpic2.jpg' >
	</a>
    <a href="#">
		<img src='images/headerpic3.jpg' >
	</a>	
</div>
</div>
    <div id="topbar2"></div>
  </body>
</html>
