<%@ page contentType="text/html" language="java" import="java.util.*,com.heyuhang.servet.*" pageEncoding="gbk"%>

<%@page import="java.util.ArrayList,com.heyuhang.item.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
	function $$(id)
{
	return document.getElementById(id);
}
function Show(id)
{
	$$(id).style.display="block";
}
function Close(id)
{
	$$(id).style.display="none";
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
.tr1
{
	background: url(th_bg.png) no-repeat left top;
}
#temp1
{
	width:100%;
	height:240px;
	background:url(tushu5.png) repeat-x;
	border:1px solid #000;
}
#temp2, #temp3, #temp4
{
	width:320px;
	height:140px;
	border-right:1px dashed red;
}
#temp2, #temp3, #temp4 p
{
	width:300px;
}
#temp5 th
{
	height:30px;
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
table
{
	margin-left:0px;
	width:100%;
}
p
{
	margin-left:200px;
	margin-top:70px;
}
#center ul li
{
	width:100px;
	height:35px;
	text-align:center;
	list-style: none;
	background: url(bg_li.png) repeat-x left top;
}
#center  ul li a
{
	text-decoration: none;
	color:#fff;
}
#b,#c,#d,#e
{
	margin-top:-37px;
}
</style>
</head>

<body onload="showTime()">
<div id="top">
	<div id="leap2">
	<a href="login.html">登陆进入</a>
	</div>
	<div id="leep">
	<%String name=(String)request.getAttribute("name");
	 %>
		当前登录用户：<%=name %>
	</div>
</div>
<div id="wap" style="z-index:1">
<ul>
	<li><a href="/test/ba?method=shouye">首&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;页</a></li>
    <li onmouseover="Show('b');" onmouseout="Close('b');"><a href="#">系统设置</a></li>
    <li onmouseover="Show('c');" onmouseout="Close('c');"><a href="#">读者管理</a></li>
    <li onmouseover="Show('d');" onmouseout="Close('d');"><a href="#">图书管理</a> </li>
    <li onmouseover="Show('e');" onmouseout="Close('e');"><a href="#">图书借还</a></li>
    <li onmouseover="Show('f');" onmouseout="Close('f');"><a href="#">系统查询</a></li>
    <li><a href="login.html">退出系统</a></li>
    <li><div id="dd"></div></li>
</ul>
</div>

<div id="center" style="z-index:1">	
	<div id="temp">
		当前位置：首页》》
	</div>
 <div id="b" style="position:absolute;display:none;left:165px;" onmousemove="Show('b');" onmouseout="Close('b')">
  <ul>
  <li><a href="/test/ba?method=managertianjia">管理员添加</a></li>
   <li><a href="/test/ba?method=deletemanager">管理员删除</a></li>
   <li><a href="library.jsp">图书馆信息</a></li>
  </ul>
 </div>

 <div id="c" style="position:absolute;display:none;left:265px" onmousemove="Show('c');" onmouseout="Close('c')">
  <ul>
   <li><a href="#">读者档案管理</a></li>
   <li><a href="/test/ba?method=findreader">读者查询</a></li>
   <li><a href="/test/ba?method=tianjiareader">添加读者</a></li>
  </ul>
 </div>

 <div id="d" style="position:absolute;display:none;left:365px" onmousemove="Show('d');" onmouseout="Close('d')">
  <ul>
   <li><a href="/test/ba?method=tianjiabook">图书添加</a></li>
   <li><a href="/test/ba?method=bookupdate">图书信息修改</a></li>
   <li><a href="/test/ba?method=bookdelete">图书删除</a></li>
  </ul>
 </div>
 
  <div id="e" style="position:absolute;display:none;left:465px" onmousemove="Show('e');" onmouseout="Close('e')">
  <ul>
   <li><a href="/test/ba?method=bookfind">图书检索</a></li>
   <li><a href="/test/ba?method=bookborrow">图书借阅</a></li>
   <li><a href="/test/ba?method=booreturn">图书归还</a></li>
  </ul>
 </div>
 <form action="/test/ba?method=jieyue" method="post">
  <p>请输选择检索方式： 
    <select name="select">
      <option value="1">条形码</option>
      <option value="2">书名</option>
      <option value="3">出版社</option>
      <option value="4">作者</option>
    </select>
    <input name="input" type="text" size="40" height="30"/>
    <input value=" 查 询 " type="submit" />
   </p>
  </form>
  <div id="temp5"> 
    <table style="margin-top:10px;" border="0">
      <tr style="background:#c90d0d;"> 
        <th width="170">条形码</th>
        <th width="129">图书名称</th>
        <th width="143">作者</th>
        <th width="241">出版社</th>
        <th width="141">书架</th>
        <th width="124">借阅</th>
      </tr>
	<%
	ArrayList list=(ArrayList)request.getAttribute("list4");
	for(int i=0;i<list.size();i++)
	{
		book g=(book)list.get(i);
	%>
      <tr style="background:#fff;"> 
        <th><%=g.getBarcode() %></th>
        <th><%=g.getbooknsme()%></th>
        <th><%=g.getauthor()%></th>
        <th><%=g.getISBN() %></th>
        <th><%=g.getbookcase()%></th>
        <th width="124"><a href="/test/ba?method=borrow&bookid=<%=g.getBarcode()%>" >借阅</a></th>
      </tr>
      <%} %> 
    </table>
  </div>
</div>
<address>
CopyRight @ 2006 www.*******.com <a href="#">西安邮电大学</a>计算机学院
</address>
</body>
</html>

