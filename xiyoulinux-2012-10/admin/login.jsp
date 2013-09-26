<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <link rel="stylesheet" type="text/css" href="css/style2.css" />
  </head>
  <SCRIPT language=javascript>
function fsubmit(obj){
obj.submit();
}
function freset(obj){
obj.reset();
}
</SCRIPT>
  <body>
<!-- Main Body Starts Here -->
<div id="main_body">

<!-- Form Title Starts Here -->
<div class="form_title">
<img src="images/form_title.gif" alt="Sleek &amp; Modern Login Form - Design3Edge" />
</div>
<!-- Form Title Ends Here -->

<!-- Form Starts Here -->
<div class="form_box">

<form id="loginform" name="loginform" method="post" action="/xiyoulinux2/login">
 <div style="margin-left:140px;color:red">${error }</div>
<!-- User Name -->
<table border="0">
<tr>
	<td>
用户名：
	</td>
	<td colspan="2">
		<div class="form_input_BG"><input type="text" name="name" id="name" value=""/></div>
	</td>
</tr>
<tr>
	<td>
密码：
	</td>
	<td colspan="2">
<div class="form_input_BG"><input type="password" name="pwd" id="pwd" value=""/></div>
	</td>
</tr>
<tr>
	<td >
验证码：
	</td>
	<td width="100">
<div class="form_input_BGC"><input type="text" name="code" id="code" value=""/></div>
	</td>
	<td>
		<img src="./image.jsp" width=100 height="40"/>
	</td>
</tr>
</table>
<p class="form_login_signup_btn">
<input   onclick="javascript:fsubmit(document.form1);return false;" style="margin-left:96px;" type="image" src="images/login_btn.png" name="login" id="login" /> 
<input  onclick="javascript:freset(document.form1);return false;" type="image" src="images/signup_btn.png"  name="signup" id="signup" />
</p>

</form>
</div>
<!-- Form Ends Here -->

</div>
<!-- Main Body Ends Here -->

<!-- Copyright -->
<div style="text-align:right;margin:20px 20px 0px 0px;">
<a href="http://www.xiyoulinux.org" ><img src="images/design3edge.png" alt="Design3Edge" title="Design3Edge" /></a>
</div>
<!-- Copyright -->

  </body>
</html>
