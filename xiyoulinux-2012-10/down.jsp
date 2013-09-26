<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.hyh.util.*"%>
<%@ page language="java" import="Hibernate.*"%>
<jsp:useBean id="smartupload" class="org.lxh.smart.SmartUpload"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>下载</title>
    
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
		String filename=request.getParameter("url");
		request.setCharacterEncoding("GBK") ;
		smartupload.initialize(pageContext) ;	// 初始化上传
		smartupload.downloadFile(filename);				// 下载
		response.getOutputStream().close();
		System.out.println(filename);
	%>
	<jsp:forward page="index"></jsp:forward>
  </body>
</html>
