<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<title>login</title>
<style type="text/css">

#swap
{
	width:1000px;
	height:600px;
	margin:0 auto;
	background:url(tushu6.png) no-repeat center;
	margin-top:0px;
	border:2px solid red;
}
#wap
{
	float:right;
	margin-right:50px;
	margin-top:180px;
	margin-bottom:50px;
	padding:20px;
}
#name,#pwd
{
	margin:10px;
}
#Submit,#Submit3,#Submit2
{
	margin:10px;
	margin-left:10px;
	padding-left:10px;
}
body
{
	text-align:center;
	font:Arial, Helvetica, sans-serif;
}
a
{
	text-decoration: none;
	color:#fff;
	padding:4px 7px;
	background-color:#000;
}
</style>
<script language="javascript">
function loginsubmit()
{
	if(document.form.name.value=="")
	{
		alert("请输入用户名");
		document.form.name.focus();
	}
	else if(document.form.pwd.value=="")
	{
		alert("请输入密码");
		document.form.pwd.focus();
	}
	else document.form.submit();
}
</script>
</head>

<body>
<div id="swap">
	<div id="wap">
    	<form method="post" action="chlogin.jsp" name="form">
        	<br>用户名称： <input type="text" size="25" id="name" name="name">
            <br>用户密码： <input type="password" size="25" id="pwd" name="pwd">
            <br>验证码:<input type="text" name="check" size=8 /><img border=1 src="image.jsp" />
			<br><input type="radio" id="radio1" name="radio" value="1">管理员<input type="radio" id="radio2" name="radio" value="2">学生
            <br><input onClick="javascript:loginsubmit();" value="登陆" type="button"/>
            <a href="zhuce.jsp">注册</a>
          <a onclick="window.close();">关闭</a>
        </form>
    </div>
</div>
</body>
</html>
