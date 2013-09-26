<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.hyh.util.*"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>上传文件</title>
    
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
  <div id="wrapper">
    <div id="topbar"></div>
    <div id="nav"><div id="mydroplinemenu" class="droplinebar">
<ul>
<li><a href="#">首页-文件管理</a></li>
<li><a href="#">博客管理</a>
</li>
<li><a href="#">相册管理</a>
<li><a href="#">管理员设置</a></li>
  </ul>
</div>
</div>
<div id="header"><div id='coin-slider'>
	<img src='images/headerpic.jpg' />
</div>
</div>
    <div id="topbar2"></div>
    <div id="content">
      <div id="left">
        <div class="paddingbox">
           <h2>文件管理-文件上传</h2>
			<form action="uploadFile.jsp" method="post" enctype="multipart/form-data">
			<table border="0" width="560">
				<tr>
					<td>标题:</td>
					<td><input type="text" name="title"/></td>
					<td>&nbsp;</td>
					<td>作者:</td>
					<td><input type="text" name="author"/></td>
				</tr>
				<tr>
					<td>标签:</td>
					<td><select name="label">
					    <option value="Linux内核" label="Linux内核">Linux内核</option>
						<option value="云计算" label="云计算">云计算</option>
			            <option value="web" label="web">web</option>
			            <option value="移动互联网" label="移动互联网">移动互联网</option>
						</select></td>
					<td>&nbsp;</td>
					<td>地址：</td>
					<td><input type="text" name="address"/></td>
				</tr>
		   		<tr>
				    <td>上传文件：</td>
					<td colspan="4">
						<input type="file" name="path"/>
					</td>
				</tr>
	             <tr>
				    <td>内容说明：</td>
					<td colspan="4">
						<textarea rows="5" cols="50" name="content"></textarea>
					</td>
				</tr>
				<tr align="center">
					<td colspan="5">
						<input type="submit" value="提交"/>
					</td>
				</tr>	</table>	
	</form>   
		   
        </div>
        <div class="line"></div>
        <div class="paddingbox">
		  <h2>文件管理-文件列表</h2>
		  <table border="1" width="560">
		  	<tr>
				<td>标题</td>
				<td>标签</td>
				<td>作者</td>
				<td>日期</td>
				<td>编辑</td>
				<td>删除</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="#">编辑</a></td>
				<td><a href="#">删除</a></td>
			</tr>
		  </table>
       	</div>
      </div>
      <div id="right">
        <div class="paddingrightbox">
          <h1>天气预报</h1>
      <iframe src="http://www.7stk.com/1/6/200903.htm" width="130" height="110" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" name="I2" align="middle">
</iframe>
        </div>
        <div class="line"></div>
        <div class="paddingrightbox">
          <h1>关于小组</h1>
          <p>&nbsp;</p>
          <p><span class="browntext"> 西邮Linux兴趣小组直属于西安邮电学院计算机学院</span><br />
           由王亚刚老师,王聪,刘洋等同学于2006年9月策划并组建,现已成为陕西高校中具有深远影响力的技术小组。 <br />
            小组本着"学习Linux系统，崇尚自由软件，宣传开源文化"的精神，在Linux的学习和应用中起到了带头的作用！小组成员主要学习方向有：<br />
            Linux平台应用软件开发、Linux平台嵌入式开发、Linux内核分析、Linux服务器配置等。</p>
        </div>
      </div>
    </div>
    <div id="bottom"></div>
    <div id="footer">
      <div style="width:400px; float:left;"><a href="http://www.xiyoulinux.org">xiyoulinux.org</a>  All Rights</div>
      <div style="width:400px; float:right; text-align: right;"> 友情链接：• 西安邮电大学  •  西邮图书馆  •  西邮BBS  •  计算机学院  </div></div>
  </div>
  </body>
</html>
