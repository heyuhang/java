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
#temp1
{
	margin-left:90px;
}
input, select
{
	margin-left:40px;
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
<div id="wap">
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
	<div id="temp1">
	<form action="/test/ba?method=insert" method="post">
      <table width="544" border="0">
        <tr> 
          <th width="326" height="42" ><div align="right">条形码：</div></th>
          <th width="208" ><input type="text"  name="barcode"/></th>
        </tr>
        <tr> 
          <th height="36" ><div align="right">图书名称：</div></th>
          <th><input type="text"  name="bookname"/></th>
        </tr>
        <tr> 
          <th height="36" ><div align="right">图书类型：</div></th>
          <th><select name="typeid"/><option value="1">计算机</option><option value="2">文学</option><option value="3">建筑</option><option value="4">音乐</option> </select></th>
        </tr>
        <tr> 
          <th height="30" ><div align="right">作者：</div></th>
          <th><input type="text" name="author"/></th>
        </tr>
        <tr> 
          <th height="38" ><div align="right">译者：</div></th>
          <th><input type="text"  name="translator"/></th>
        </tr>
        <tr> 
          <th height="37" ><div align="right">出版社：</div></th>
          <th><select name="ISBN" ><option value="新华">新华</option><option value="机械">机械</option><option value="工业">工业</option><option value="清华">清华</option> </select>
            </th>
        </tr>
        <tr> 
          <th height="46" ><div align="right">价格：</div></th>
          <th><input type="text"  name="price"/></th>
        </tr>
        <tr> 
          <th height="56" ><p align="right">页码：</p></th>
          <th><input type="text"  name="page"/></th>
        </tr>
        <tr> 
          <th height="59" ><div align="right">书架：</div></th>
          <th><select name="bookcase" ><option value="1">no 1</option><option value="2">no 2</option><option value="3">no 3</option><option value="4">no 4</option><option value="5">no 5</option> </select></th>
        </tr>
        <tr> 
          <th height="43" > 
            <div align="right">库存总量：</div></th>
          <th><input type="text" name="storage"/></th>
        </tr>
	 	<tr> 
          <th height="48" >&nbsp;</th>
          <th><input type="submit" value="保存"> <input type="reset" value="返回"></th>
        </tr>
      </table>
	</form>
	</div>
</div>
<address>
CopyRight @ 2006 www.*******.com <a href="#">西安邮电大学</a>计算机学院
</address>
</body>
</html>
