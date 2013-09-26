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
    
    <title>上传文件</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
	<%
		IPTimeStamp its = new IPTimeStamp(request.getRemoteAddr()) ; 
		request.setCharacterEncoding("utf-8") ;
		smartupload.initialize(pageContext) ;	// 初始化上传
		smartupload.upload() ;					// 准备上传
		String name = its.getIPTimeStampRand() + "." + smartupload.getFiles().getFile(0).getFileExt() ;
		String fileName = this.getServletContext().getRealPath("/") + "uploadFile/" + name ;
		System.out.println(fileName);
		smartupload.getFiles().getFile(0).saveAs(fileName) ;
	%>
	<%
	    File file=new File();
		file.setTitle(smartupload.getRequest().getParameter("title"));
		
		file.setAuthor(smartupload.getRequest().getParameter("author"));
		file.setLabel(smartupload.getRequest().getParameter("label"));
		file.setAddress(smartupload.getRequest().getParameter("address"));
		file.setPath(fileName);
		file.setContent(smartupload.getRequest().getParameter("content"));
		file.setTime(new Date());
		request.setAttribute("File",file);
	 %>
<jsp:forward page="/upload"></jsp:forward>
  </body>
</html>
