<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.hyh.vo.*"%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=GBK">
    <title>网站后台管理</title>
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
    </style>
</head>
<body>
<%
	user user=(user)request.getAttribute("user");
 %>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="/base/resources/images/tab_03.gif" width="15" height="30" /></td>
        <td background="/base/resources/images/tab_05.gif" align="left"><img src="/base/resources/images/311.gif" width="16" height="16" /> <span class="STYLE4">用户详细信息</span></td>
        <td width="14"><img src="/base/resources/images/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" style="background:url(/base/resources/images/tab_12.gif) repeat-y left #d3e7fc; ">&nbsp;</td>
        <td width="97%" bgcolor="#FFFFFF"  valign="top" align="center" height="500" style="padding-top:20px;">
		    <table width="505px" border="0" cellspacing="0" cellpadding="0">
			<tr style="width:100%;height:20px;background:url(/base/resources/images/htbg1.gif);">
				<td></td>
			</tr>
			<tr style="width:100%; height:250px; background: url(/base/resources/images/htbg3.gif) repeat-y; text-align:center;">
				<td>		<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="40%" height="30" align="right" class="STYLE4">用户编号：</td>
    <td align="left"><%=user.getId() %></td>
  </tr>
  <tr>
    <td height="30" align="right" class="STYLE4">用&nbsp;&nbsp;户&nbsp;&nbsp;名：</td>
    <td height="20" align="left"><%=user.getUsername() %></td>
  </tr>
  <tr>
  
    <td height="30" align="right" class="STYLE4">用户类型：</td>
    <td height="20" align="left" ><%=user.getUsertype() %></td>
  
    </tr>
    <tr>
    <td height="30" align="right" class="STYLE4">部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门：</td>
    <td height="20" align="left"><%=user.getSectionname() %></td>
  </tr>
    
    <tr>
    <td height="30" align="right" class="STYLE4">电子邮件：</td>
    <td height="20" align="left"><%=user.getEmail() %></td>
    </tr>
 
    <tr>
    <td height="30" align="right" class="STYLE4">创建时间：</td>
    <td height="20" align="left"><%=user.getCtime() %></td>
    </tr>
	 <tr>
    <td height="30" align="right" class="STYLE4">最后登录：</td>
    <td height="20" align="left"><%=user.getOtime() %></td>
    </tr>
    <tr>
    <td height="30" align="right" class="STYLE4">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：</td>
    <td height="20" align="left"><%=user.getState() %></td>
  </tr>
   <tr></tr>
  <tr>
    <td height="30" colspan="2" align="center">
    <a href="/base/user?page=1" target="content" method="post">返回</a>
  </tr>
</table>
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

