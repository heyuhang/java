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
<title>pianliao</title>
<script src="http://ajax.microsoft.com/ajax/jquery/jquery-1.4.4.min.js"></script>
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script type="text/javascript" src="js/index_ajax.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/login.css" rel="stylesheet" type="text/css" />
<SCRIPT type=text/javascript> 
$(document).ready(function(){
	$('#navigation li').hover(function(){
		$(this).find('.subnav').animate({opacity:1.0,height:'toggle'},500);
		$(this).find('a').addClass("active");
	},function(){
		$(this).find('.subnav').animate({opacity:0,height:'toggle'},500);
		$(this).find('a').removeClass("active");
	});
});
</SCRIPT>
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
            <form action="land" method="post" class="from_class">
         
              <div class="input-group"> 
                <label for="username">用户名(Username)</label>
                <div class="inputs"> 
                  <input id="username" name="username" type="text">
                </div>
                <div id="msg">
                	<s:property  value="msg"/>
                </div>
              </div>

              <div class="input-group"> 
                <label for="password">密码(Password)</label>
                <div class="inputs"> 
                  <input id="password" name="password" type="password">
                </div>              
              </div>
              <div class="input-group"> 
                <div class="inputsu"> 
                  <input type="image" src="./images/denglu.png" />
                </div>
              </div>
            </form>
          </div>
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
</div>
</body>
