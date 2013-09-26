<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.hyh.vo.*"%>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=GBK">
    <title>用户管理</title>
    <script defer="defer" language="javascript" type="text/javascript" src="/base/datepicker/WdatePicker.js"></script>
	<script type="text/javascript"  src="http://ajax.microsoft.com/ajax/jquery/jquery-1.4.4.min.js"></script>
	
	<link href="/base/resources/css/hottest.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
        .bt_01{
            width:71px;
            height:25px;
            border:0px;
            background: url(/base/resources/images/htdl.gif) no-repeat;
            color:#fff;
            font-size:12px;
            }
                .msg{
        	font-size:12px;
        	color:red;
        }
    </style>
<script type="text/javascript">
var xmlHttp;
function createXMLHttp(){
    if(window.XMLHttpRequest){
		xmlHttp=new XMLHttpRequest();
	}else{
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
}
function section(){
    createXMLHttp();
    xmlHttp.open("POST","/base/section?action=all",true); 
    xmlHttp.onreadystatechange=sectionCallback;
    xmlHttp.send(null);
}
function sectionCallback(){

   	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
			var msg=xmlHttp.responseText;
			
			
			document.getElementById("section").innerHTML=msg;
		}
   	}
}
$(document).ready(function(){

	//注册验证
	var checkUsername=function(){
	var value=$("#username").attr("value");
		if(value==""){
			$("#namemsg").text("请输入用户名！");
			return false;
		}else
		if(value.length<5 || value.length>10){
			$("#namemsg").text("用户名长度在5-20个字符");
			return false;
		}else{
			$("#namemsg").text("");
		}	
		return true;
	};
	var value;
	var checkPassword=function(){
		value=$("#password").attr("value");
		if(value==""){
			$("#passmsg").text("请输入密码！");
			return false;
		}else
		if(value.length<5 || value.length>20){
			$("#passmsg").text("密码长度在5-20个字符");
			return false;
		}else{
			$("#passmsg").text("");
		}
		return true;
	};
	var checkRepassword=function(){
		var rvalue=$("#confirm").attr("value");
		if(rvalue==""){
			$("#repassmsg").text("请输入重复密码！");
			return false;
		}else
		if(rvalue.length<5 || value.length>20){
			$("#repassmsg").text("密码长度在5-20个字符");
			return false;
		}else if(rvalue!=value){
			$("#repassmsg").text("重复密码错误！");
			return false;
		}else{
			$("#repassmsg").text("");
		}	
		return true;
	};
	var checkEmail=function(){
		value=$("#email").attr("value");
		var patten = new RegExp(/^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]+$/);
		if(value==""){
			$("#emailmsg").text("请输入email！");
			return false;
		}else
		if(!patten.test(value)){
			$("#emailmsg").text("email格式不符合！");
			return false;
		}else{
			$("#emailmsg").text("");
		}
		return true;
	};
	var checkCode=function(){
		value=$("#createTime").attr("value");
		
		if(value==""){
			$("#timemsg").text("请输入时间！");
			return false;
		}else
		{
			$("#timemsg").text("");
		}	
		return true;
	};
	$("#username").bind("keyup",function(){
		
		checkUsername();
	});
	$("#password").bind("keyup",function(){
		checkPassword();
	});
	$("#confirm").bind("keyup",function(){
		checkRepassword();
	});
	$("#email").bind("keyup",function(){
		checkEmail();
	});

	

	var check=function(){
		var username=checkUsername();
		var password=checkPassword();
		var repassword=checkRepassword();
		var email=checkEmail();
		
		if(username && password && repassword && email){
			return true;
			
		}
		return false;	
	};
	$("#button").bind("click",function(){

		var form=$("#Form");
		if(check() && checkCode()){

			form.submit();
		}
	});	
});
</script>
</head>
<%
	user user=(user)request.getAttribute("user");
 %>
<body onload="section();">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" >
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="/base/resources/images/tab_03.gif" width="15" height="30" /></td>
        <td background="/base/resources/images/tab_05.gif" align="left"><img src="/base/resources/images/311.gif" width="16" height="16" /> <span class="STYLE4">用户修改</span></td>
        <td width="14"><img src="/base/resources/images/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" style="background:url(/base/resources/images/tab_12.gif) repeat-y left #d3e7fc; ">&nbsp;</td>
        <td width="97%" bgcolor="#FFFFFF"  valign="top" align="center" height="500" style="padding-top:20px">
			<table width="505px" border="0" cellspacing="0" cellpadding="0">
			<tr style="width:100%;height:20px;background:url(/base/resources/images/htbg1.gif);">
				<td></td>
			</tr>
			<tr style="width:100%; height:250px; background: url(/base/resources/images/htbg3.gif) repeat-y; text-align:center;">
				<td>
				<form action="/base/user?action=updateuserx&id=<%=user.getId() %>" method="post" id="Form" >
				<table width="505px" border="0" cellspacing="0" cellpadding="0">
				  <tr>
					<td height="10" width="25%" align="right" class="STYLE4">用户编号：</td>
					<td align="left"><input type="text" name="usercode" disabled="disabled" /></td>
					<td height="30" width="50%" ></td>
				  </tr>
				  <tr>
					<td height="30" align="right" class="STYLE4">用&nbsp;&nbsp;户&nbsp;&nbsp;名：</td>
					<td align="left"><input type="text" name="username" id="username" value="<%=user.getUsername()%>"/></td>
					<td height="30" width="50%"><span id="namemsg" class="msg"></span></td>
				  </tr>
				  <tr>
					<td height="30" align="right" class="STYLE4">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
					<td height="20" align="left"><input type="password" name="password" id="password" value="<%=user.getPassword()%>"/></td>
				  	<td height="30" width="50%"><span id="passmsg" class="msg"></span></td>
				  </tr>
				  <tr>
				  
					<td height="30" align="right" class="STYLE4">确认密码：</td>
					<td height="20" align="left"><input type="password" name="confirm" id="confirm" value="<%=user.getPassword()%>"/></td>
				  	<td height="30" width="50%"><span id="repassmsg" class="msg"></span></td>
				  </tr>
				  <tr>
					<td height="30" align="right" class="STYLE4">用户类型：</td>
					<td height="20" align="left">
						<select name="usertype" id="usertype">
							 <option value="超级管理员">超级管理员</option>
							<option value="一般管理员">一般管理员</option>
							<option value="一般用户">一般用户</option>
						</select>
					</td>
					<td height="30" width="50%"></td>
					</tr>
					<tr>
					<td height="30" align="right" class="STYLE4">部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门：</td>
					<td height="20" align="left">
						<select name="sectionname" id="section">
										
						</select>
					</td>
					<td height="30" width="50%"></td>
					</tr>
					
					<tr>
					<td height="30" align="right" class="STYLE4">电子邮件：</td>
					<td height="20" align="left"><input type="text" name="email" id="email" value="<%=user.getEmail()%>"/></td>
					<td height="30" width="50%"><span id="emailmsg" class="msg"></span></td>
					</tr>
				 
					<tr>
					<td height="30" align="right" class="STYLE4">创建时间：</td>
					<td height="20" align="left"><input id="createTime" type="text" name="ctime" value="<%=user.getCtime()%>"/>
					&nbsp;<img onClick="WdatePicker({el:$dp.$('createTime')})" src="/base/datepicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"></td>
					
					<td height="30" width="50%"><span id="timemsg" class="msg"></span></td>
					</tr>
					<tr>
					<td height="30" align="right" class="STYLE4">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：</td>
					<td height="20" align="left">
					  <select name="state" id="state">
						<option value="1">正常</option>
						<option value="0">冻结</option>
					  </select></td>
					  <td height="30" width="50%"></td>
				  </tr>
				  <tr>
					<td height="30" colspan="2" align="center">
					<input type="button" id="button" name="registerSub" value="确定" class="bt_01" />&nbsp; 
					<input type="reset" name="cancel" value="取消"  class="bt_01"/></td>
				  </tr>
				  <tr>
					  <td height="40" colspan="2" align="center" class="STYLE4">${msg}</td>
				  </tr>
				</table>
				</form>
				</td>
			</tr>
			<tr style="width:100%; height:17px; background: url(/base/resources/images/htbg2.gif) no-repeat;">
				<td>&nbsp;</td>
			</tr>
		</table>
	</td>
        <td width="14"  style="background:url(/base/resources/images/tab_16.gif) repeat-y right #d3e7fc; ">&nbsp;</td>
    </tr>
    </table></td>
  </tr>
  <tr>
    <td height="29"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="29"><img src="/base/resources/images/tab_20.gif" width="15" height="29" /></td>
        <td background="/base/resources/images/tab_21.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="21%" height="14">&nbsp;</td>
            <td width="79%" class="STYLE1" align="right">&nbsp;</td>
          </tr>
        </table></td>
        <td width="14"><img src="/base/resources/images/tab_22.gif" width="14" height="29" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
