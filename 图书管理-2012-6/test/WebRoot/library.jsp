<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
<title>无标题文档</title>
<style type="text/css">
body
{
	background-color:#eee;
}
#swap
{
	width:680px;
	margin:0 auto;
	margin-top:20px;


	border:5px solid #ccc;
	padding:10px;
	background-color:#000011;
}
body
{
	margin:0 auto;
}
#pTool
{
	margin-top:-20px;
}
#pTool span
{
	background:#eee;
	border:2px solid #000;
	padding:4px 8px;
	margin-top:0px;
	text-derotion:none;
}
</style>
<script type="text/javascript">
function $$(id)
{
	return document.getElementById(id);
}
function v_load()
{
	$$("spnPlay").innerHTML="播放";
	$$("vdoMain").load();
}
function v_play(e)
{
	if(e.innerHTNL=="播放")
	{
		$$("vdoMain").play();
		e.innerHTML="暂停";
	}
	else
	{
		$$("vdoMain").pause();
		e.innerHTML="播放";
	}
}
function pagload()
{
	var nav=$$("cnvMain");
	var cxt=nav.getContext("2d");
	var gnt1=cxt.createLinearGradient(0,0,0,20);

	cxt.shadowOffsetX=0;
	cxt.shadowOffsetY=6;
	cxt.shadowColor="#220000";
	cxt.shadowBlur=0;	
	gnt1.addColorStop(0,"#000");
	gnt1.addColorStop(1,"#fee");
	cxt.fillStyle=gnt1;
	cxt.fillRect(0,0,1366,50);
	
	
}
function swap1()
{
	var s=$$("cnvMain");
	s.innerHTML="src:he.mp4";
}
</script>
</head>
 
<body onLoad="pagload();">
<canvas id="cnvMain" width="1366px" height="50px"></canvas>
<div id="swap">
<video id="vdoMain" width="680px" height="500px"  autoplay="false" poster="ff.jpg">
 
  <source src="he.mp4" type="video/mp4">
Your browser does not support the video tag.
</video>
<p id="pTool">
	 <input type="button" onClick="swap1();" value="加载"></input>
	 <input type="button" onClick="swap2();" value="播放">播放</input> 
</p>
</div>
</body>
</html>
