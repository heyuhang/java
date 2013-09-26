<%@ page contentType="text/html" language="java" import="java.util.*,com.heyuhang.servet.*" pageEncoding="gbk"%>

<%@page import="java.util.ArrayList,com.heyuhang.item.*,java.text.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>tushu2</title>
<script language="JavaScript" type="text/javascript"> 
    function showTime(){ 
        var now=new Date; 
        document.getElementById("dd").innerHTML=now.getFullYear() 
        +"年"+(now.getMonth()+1) 
        +"月"+now.getDate() 
        +"日"+now.getHours() 
        +":"+now.getMinutes()+":"+now.getSeconds(); 
        setTimeout("showTime()","1000"); 
    } 
</script> 
<style type="text/css">
body
{
	width:1000px;
	height:930px;
	margin-top:10px;
	border-left:1px solid #000;
	border-right:1px solid #000;
	border-bottom:1px dashed #000;
	margin:0 auto;
}
#top
{
	background:url(tushu2.png) no-repeat;
	width:1000px;
	height:250px;
}
#wap ul
{
	margin: 0;
	padding: 0;
	list-style: none;
	background: url(bg_li.png) repeat-x left top;
	float: left;
	border-bottom: 1px solid #000;
	width: 100%;
	text-align:center;
}
#wap ul li
{
	float:left;
	padding: 0;
	margin: 0;
}
#top a
{
	text-decoration: none;
	color:#fff;	
}
#wap ul li a,#wap li a:link 
{
	color: #FFFFFF;
	text-decoration: none;
	padding: .5em 1em;
	border-right: 1px solid #000;
	display: block;
	font: bold 1em "Lucida Grande", Verdana, Geneva, Lucida, Arial, Helvetica, sans-serif;
}
li a:hover
{
	background: url(gb.png);
}
#center
{

	margin-top:20px;
	width:99.7%;
	height:620px;
	border:1px solid #999;
	background:url(red.png) repeat-x;
}
address
{
	text-align:center;
}
#leep
{
	margin-top:0px;
	padding-left:820px;
	padding-top:190px;
}
#temp
{
	margin-top:6px;;
	padding-left:820px;
	padding-top:5px;
	border-bottom:2px #c90d0d solid;
	color:#c90d0d;
	font-weight:bold;
}
table
{
	margin-left:5px;
}
td,th {
	border: 1px solid #73afb7;
	padding: 3px 5px 2px 5px;
	font-size: 1em;
}
th {
	
	text-align: center;
}
.tr1
{
	background: url(th_bg.png) no-repeat left top;
}
.temp2
{
	background:url(tushu3.png) no-repeat center;
	height:70px;
	border:1px solid #000;
	margin:2px;
}
.temp1
{
	background:url(tushu4.png) no-repeat center;
	height:70px;
	border:1px solid #000;
	margin:2px;
}
#leap2
{
	padding-top:10px;
	margin-left:900px;
}
#dd
{
	margin-left:100px;
	margin-top:8px;
}
</style>
</head>

<body onload="showTime()">
<div id="top">
	<div id="leap2">
	<a href="login.jsp">登陆进入</a>
	</div>
	<div id="leep">
		当前登录用户：<%=session.getAttribute("user") %>
	</div>
</div>
<div id="wap">
<ul>
	<li class="shouye"><a href="index.jsp">首&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;页</a></li>
    <li class="xtsz"><a href="login.jsp">系统设置</a></li>
    <li class="dzgl"><a href="login.jsp">读者管理</a></li>
    <li class="tsgl"><a href="login.jsp">图书管理</a> </li>
    <li class="tsjh"><a href="login.jsp">图书借还</a></li>
    <li class="xtcx"><a href="login.jsp">系统查询</a></li>
    <li class="tcxt"><a href="login.jsp">退出系统</a></li>
    <li><div id="dd"></div></li>
</ul>

</div>
<div id="center" style="z-index:1">	
	<div id="temp">
		当前位置：首页
	</div>
	<div id="table1">		
    <table width="984" height="63">
      <caption class="temp1">
      	</caption>
			<tr class="tr1">
				<th width="34">排名</th>
				<th width="73">读者条形码</th>
				<th width="60">读者类型</th>
				<th width="34">证件类型</th>
				<th width="47">证件号</th>
				<th width="34">电话</th>
				<th width="124">性别</th>
			</tr>
		</table>
	</div>
	<div id="table2">
    <table width="984" height="63">
   			<caption class="temp2"></caption>
			<tr class="tr1" height="50">
				<th width="34">排名</th>
				<th width="73">图书条形码</th>
				<th width="60">图书名称</th>
				<th width="34">书架</th>
				<th width="100">出版社</th>
				<th width="34">作者</th>
				<th width="74">定价（元）</th>
			</tr>
		</table>
	</div>
</div>
<address>
CopyRight @ 2006 www.*******.com <a href="#">西安邮电大学</a>计算机学院
<br>*******************************************************************
</address>
</body>
</html>


