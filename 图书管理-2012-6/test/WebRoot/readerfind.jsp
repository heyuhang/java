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
        +"��"+(now.getMonth()+1) 
        +"��"+now.getDate() 
        +"��"+now.getHours() 
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
	<a href="login.html">��½����</a>
	</div>
	<div id="leep">
	<%String name=(String)request.getAttribute("name");
	 %>
		��ǰ��¼�û���<%=name %>
	</div>
</div>
<div id="wap" style="z-index:1">
<ul>
	<li><a href="/test/ba?method=shouye">��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ҳ</a></li>
    <li onmouseover="Show('b');" onmouseout="Close('b');"><a href="#">ϵͳ����</a></li>
    <li onmouseover="Show('c');" onmouseout="Close('c');"><a href="#">���߹���</a></li>
    <li onmouseover="Show('d');" onmouseout="Close('d');"><a href="#">ͼ�����</a> </li>
    <li onmouseover="Show('e');" onmouseout="Close('e');"><a href="#">ͼ��軹</a></li>
    <li onmouseover="Show('f');" onmouseout="Close('f');"><a href="#">ϵͳ��ѯ</a></li>
    <li><a href="login.html">�˳�ϵͳ</a></li>
    <li><div id="dd"></div></li>
</ul>
</div>

<div id="center" style="z-index:1">	
	<div id="temp">
		��ǰλ�ã���ҳ����
	</div>
 <div id="b" style="position:absolute;display:none;left:165px;" onmousemove="Show('b');" onmouseout="Close('b')">
  <ul>
  <li><a href="/test/ba?method=managertianjia">����Ա���</a></li>
   <li><a href="/test/ba?method=deletemanager">����Աɾ��</a></li>
   <li><a href="library.jsp">ͼ�����Ϣ</a></li>
  </ul>
 </div>

 <div id="c" style="position:absolute;display:none;left:265px" onmousemove="Show('c');" onmouseout="Close('c')">
  <ul>
   <li><a href="#">���ߵ�������</a></li>
   <li><a href="/test/ba?method=findreader">���߲�ѯ</a></li>
   <li><a href="/test/ba?method=tianjiareader">��Ӷ���</a></li>
  </ul>
 </div>

 <div id="d" style="position:absolute;display:none;left:365px" onmousemove="Show('d');" onmouseout="Close('d')">
  <ul>
   <li><a href="/test/ba?method=tianjiabook">ͼ�����</a></li>
   <li><a href="/test/ba?method=bookupdate">ͼ����Ϣ�޸�</a></li>
   <li><a href="/test/ba?method=bookdelete">ͼ��ɾ��</a></li>
  </ul>
 </div>
 
  <div id="e" style="position:absolute;display:none;left:465px" onmousemove="Show('e');" onmouseout="Close('e')">
  <ul>
   <li><a href="/test/ba?method=bookfind">ͼ�����</a></li>
   <li><a href="/test/ba?method=bookborrow">ͼ�����</a></li>
   <li><a href="/test/ba?method=booreturn">ͼ��黹</a></li>
  </ul>
 </div>
	<div id="temp1">		
    <table height="235" border="0">
      <tr >
    		
        <th width="292" height="46"></th>
		</tr>
		<tr style="background-color:#fff;border:1px solid #000;">
				
        <th height="181"> 
				<div id="temp2" style="float:left;">        		
           		<P style="background-color:red;width:250px;height:20px;margin-left:20px;text-align:left;">������֤</P>
				<p style="width:250px;height:20px;margin-left:20px;text-align:left;">���������룺</p>
				<p ><form action="/test/ba?method=findone2" method="post"><input type="text" name="barcode"><input type="submit" value="ȷ��"></form></p>
				</div>
				<div id="temp3" style="float:left;">
				<p>��&nbsp;&nbsp;&nbsp;���� <input type="text" size="20"></p>
				<p>֤�����ͣ�<input type="text" size="20"></p>
				<p>�������ͣ�<input type="text" size="20"></p>
				</div>
				<div id="temp4" style="float:right;">
				<p>��&nbsp&nbsp&nbsp;�� <input type="text" size="20"></p>
				<p>֤�����룺<input type="text" size="20"></p>
				<p>�ɽ�������<input type="text" size="20"></p>
				</div>
			</tr>
		</table>
	</div>
  <div id="temp5"> 
    <table style="margin-top:10px;" border="0">
      <tr style="background:#c90d0d;"> 
        <th width="170">ͼ������</th>
        <th width="129">����ʱ��</th>
        <th width="143">Ӧ��ʱ��</th>
        <th width="241">������</th>
        <th width="141">���</th>
        <th width="124">���ۣ�Ԫ��</th>
      </tr>
    </table>
  </div>
</div>
<address>
CopyRight @ 2006 www.*******.com <a href="#">�����ʵ��ѧ</a>�����ѧԺ
</address>
</body>
</html>

