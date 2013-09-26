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
    
    <title>上传相册</title>
    
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
		request.setCharacterEncoding("utf-8") ;
		smartupload.initialize(pageContext) ;	// 初始化上传
		smartupload.upload() ;					// 准备上传
		String name = its.getIPTimeStampRand() + "." + smartupload.getFiles().getFile(0).getFileExt() ;
		String fileName = this.getServletContext().getRealPath("/") + "phone/" + name ;
		System.out.println(fileName);
		smartupload.getFiles().getFile(0).saveAs(fileName) ;
	%>
	<%
	    Photo photo=new Photo();
		photo.setLabel(smartupload.getRequest().getParameter("label"));
		
		photo.setDescription(smartupload.getRequest().getParameter("description"));
		photo.setPath(name);
		request.setAttribute("Photo",photo);
	 %>
<jsp:forward page="uploadPhoto"></jsp:forward>
  </body>
</html>
