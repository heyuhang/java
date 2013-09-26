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
<title>动态</title>
<script src="js/CJL.0.1.min.js"></script>
<script src="js/AlertBox.js"></script>
<script src="js/index_ajax.js"></script>
<script src="http://ajax.microsoft.com/ajax/jquery/jquery-1.4.4.min.js"></script>
<link href="css/user.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header">
  <div class="toplogo"> </div>
  <div class="top"> 
    <ul>
      <li><a href="login">登陆</a></li>
      <li><a href="regist">注册</a></li>
      <li><a href="index">首页</a></li>
    </ul>
  </div>
</div>
<div id="contents">
<div class="person">消息中心<span style="float:right" onclick="delall()">忽略全部</span></div>
<div id="userleft">

		<div class="descration">
			<div class="publish"><a id="trigger" href="javascript:;" rel="targetBox">
			回复消息<s:property value="atteno"/></a>
			</div>		      		
		</div>

</div>
<div id="userright">
<div class="myphoto"><span>回复动态</span></div>
<div id="replay-all">
<s:iterator value="dmessages" status="dmessages">
	<div style="border-bottom:1px solid #BBB;padding:10px;font-size:13px;" id="repaly_box<s:property value="id"/>">
		<div style="background-color: rgb(244, 244, 244);padding:5px">
			关于“<s:property value="title"/>”<span class="username"><s:property value="name"/></span>回复你：
			<a href="javascript:;" class="replay_msg" style="float:right;color:#d14e08;" onclick="close_replay(<s:property value="id"/>)">关闭</a>	
		<div style="line-height:25px;letter-spacing:.3px;text-indent:30px;">
			<s:property value="message"/>
		</div>
		</div>
		<div id="replay<s:property value="id"/>"></div>
		<div style="width:550px;">
		<div style="margin-top:10px">
			<textarea id="replay_text<s:property value="id"/>" class="question" placeholder="回复:<s:property value="name"/>" cols="60"></textarea>
		</div>
		<div class="located">
			<input type="button" value="评论" onclick="replay(<s:property value="id"/>,<s:property value="fileid"/>,<s:property value="userid"/>);" type="image"/>
		</div>
		</div>
	</div>
</s:iterator>
</div>
</div>
	<div style="clear:both"></div>
	<div id="footer"> 
    <address>
    	CopyRight-xiyoulinux 2006-2013 
    </address>
	</div>	
</div>

</body>
</html>

