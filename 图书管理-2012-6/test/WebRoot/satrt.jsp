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
	background: url(th_bg.png) repeat-y left top;
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
#wap #dd
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
<div id="wap">
<ul>
	<li><a href="/test/ba?method=shouye">��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ҳ</a></li>
    <li ><a href="#">ϵͳ����</a></li>
    <li ><a href="#">���߹���</a></li>
    <li ><a href="#">ͼ�����</a> </li>
    <li onmouseover="Show('e');" onmouseout="Close('e');"><a href="#">ͼ��軹</a></li>
    <li onmouseover="Show('f');" onmouseout="Close('f');"><a href="#">ϵͳ��ѯ</a></li>
    <li><a href="login.html">�˳�ϵͳ</a></li>
    <li><div id="dd"></div></li>
</ul>

</div>
<div id="center" style="z-index:1">	
	<div id="temp">
		��ǰλ�ã���ҳ
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
	<div id="table1">		
    <table width="984" height="150">
      <caption class="temp1">
      	</caption>
			<tr class="tr1">
				<th width="34">����</th>
				<th width="73">����������</th>
				<th width="60">��������</th>
				<th width="34">֤������</th>
				<th width="47">֤����</th>
				<th width="34">�绰</th>
				<th width="124">�Ա�</th>
			</tr>
				<%
					ArrayList list=(ArrayList)request.getAttribute("list1");
					ArrayList list2=(ArrayList)request.getAttribute("list2");
					for(int i=0;i<list.size();i++)
					{
						student g=(student)list.get(i);
					%>
			<tr>
				<th width="34"><%=g.getID()%></th>
				<th width="73"><%=g.getBarcode() %></th>
				<th width="60"><%=g.getVocation() %></th>
				<th width="34"><%=g.getPaperType() %></th>
				<th width="47"><%=g.getpaperNO() %></th>
				<th width="34"><%=g.getTel() %></th>
				<th width="124"><%=g.getSex() %></th>
			</tr>
			<%} %>
		</table>
	</div>
	<div id="table2">
    <table width="984" height="150">
   			<caption class="temp2"></caption>
			<tr class="tr1" height="50">
				<th width="34">����</th>
				<th width="73">ͼ��������</th>
				<th width="60">ͼ������</th>
				<th width="34">���</th>
				<th width="100">������</th>
				<th width="34">����</th>
				<th width="74">���ۣ�Ԫ��</th>
			</tr>
			<tr>
				<%
					for(int i=0;i<list2.size();i++)
					{
						book g=(book)list2.get(i);
				%>
							<tr class="tr1">
				<th width="34"><%=g.getID() %></th>
				<th width="73"><%=g.getBarcode() %></th>
				<th width="60"><%=g.getbooknsme() %></th>
				<th width="34"><%=g.getbookcase() %></th>
				<th width="47"><%=g.getISBN() %></th>
				<th width="34"><%=g.getauthor() %></th>
				<th width="124"><%=g.getprice() %></th>
			</tr>
			<%} %>
		</table>
	</div>
</div>
<address>
CopyRight @ 2006 www.*******.com <a href="#">�����ʵ��ѧ</a>�����ѧԺ
<br>*******************************************************************
</address>
</body>
</html>


