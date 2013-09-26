<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.hyh.util.*,Hibernate.*"%>
<jsp:useBean id="smartupload" class="org.lxh.smart.SmartUpload"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>小组成员管理</title>
    
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
<%
		IPTimeStamp its = new IPTimeStamp(request.getRemoteAddr()) ; 
		request.setCharacterEncoding("gbk") ;
		smartupload.initialize(pageContext) ;	// 初始化上传
		smartupload.upload() ;					// 准备上传
		String name = its.getIPTimeStampRand() + "." + smartupload.getFiles().getFile(0).getFileExt() ;
		String fileName = this.getServletContext().getRealPath("/") + "images/member/" + name ;
		System.out.println(fileName);
		smartupload.getFiles().getFile(0).saveAs(fileName) ;
	%>
	<%
	    Member mem=new Member();
		mem.setName(smartupload.getRequest().getParameter("name"));
		mem.setGrade(smartupload.getRequest().getParameter("grade"));
		mem.setEmail(smartupload.getRequest().getParameter("email"));
		mem.setDescrable(smartupload.getRequest().getParameter("description"));
		mem.setPhoto(name);
		request.setAttribute("member",mem);
	 %>
<jsp:forward page="memberManage"></jsp:forward>
  </body>
</html>
