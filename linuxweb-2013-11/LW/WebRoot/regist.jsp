<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta content="西邮linuxgroup,linux,西邮,西邮linux兴趣小组" name="keywords"></meta>
<meta content="西邮linux兴趣小组官网" name="description"></meta>
<link rel="shortcut icon" href="./images/topl.jpg" type="image/x-icon" />
<link rel="icon" href="./images/topl.jpg" type="image/gif" >
<title>注册</title>
<script src="http://ajax.microsoft.com/ajax/jquery/jquery-1.4.4.min.js"></script>
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/regist.js" type="text/javascript"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/register.css" rel="stylesheet" type="text/css" />
</head>
<body>
<s:include value="head.jsp"></s:include>
<div id="wrap">
<div id="contents">
    <ul id="tabs" class="clearfix">
      <li><a href="login" >登陆</a></li>
      <li><a href="regist" >注册</a></li>
    </ul>
    <div id="header"> 
      <div class="header2"> 
        <div class="header3"> 
          <div class="content_label"> 
            <form action="adduser" method="post" id="signupForm" >
              <div class="input-group"> 
                <label for="username">用户名(Username)</label>
                <div class="inputs"> 
                  <input id="username" name="username" type="text" onblur="checkusername(this.value);"/>
                </div>
              </div>
              <div class="input-group"> 
                <label for="password">密码(Password)</label>
                <div class="inputs"> 
                  <input id="password" name="password" type="password" />
                </div>
              </div>
              <div class="input-group"> 
                <label for="password">重复密码(RepeatPassword)</label>
                <div class="inputs"> 
                  <input id="confirm_password" name="confirm_password" type="password" />
                </div>
              </div>
              <div class="input-group"> 
                <label for="password">电子邮件(Email)</label>
                <div class="inputs"> 
                  <input id="email" name="email" type="email" />
                </div>
              </div>
              <div class="input-group"> 
                <label for="interest">技术特长(Interest)</label>
                <div class="inputs"> 
                  <input id="interest" name="interest" type="text" />
                </div>
              </div>
              <div class="input-group"> 
                <label for="introduct">自我介绍(Introduction)</label>
                <div class="inputs"> 
                  <input id="introduct" name="introduct" type="text" />
                </div>
              </div>
              <div class="input-group"> 
                <label for="checkcode">验证码(Checkcode)</label>
                <div class="inputs"> 
                  <input id="checkcode" name="checkcode" type="text" />
                </div>
              </div>
              <div class="input-group"> 
                <label></label>
                <div class="inputs"> <img id="img" src="images/image.jsp"/><a href="regist" style="text-decoration:none;color:red">看不清</a> 
                </div>
              </div>
              <div class="input-group"> 
                <div class="inputsu"> 
                  <input id="form_submit" type="image" src="./images/register.png"/>
                </div>
              </div>
              
            </form>
            <div class="intro">
            		欢迎注册本网站。
            </div>
            <div style="clear:both"></div>
          </div>
          <div style="clear:both"></div>
        </div>
      </div>
    </div>
	<div style="clear:both"></div>
	<div id="footer"> 
    <address>
    	CopyRight-xiyoulinux 2006-2013 
    </address>
	</div>
</div>
</div>
</body></html>
