<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.hyh.vo.*"  %>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=GBK">
    <title>客户管理</title>
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
 	client client=(client)request.getAttribute("client");
  %>
<form action="/base/client?action=updateclientx&id=<%=client.getId() %>" onSubmit="" method="post">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="/base/resources/images/tab_03.gif" width="15" height="30" /></td>
        <td background="/base/resources/images/tab_05.gif" align="left"><img src="/base/resources/images/311.gif" width="16" height="16" /> <span class="STYLE4"> 客户修改</span></td>
        <td width="14"><img src="/base/resources/images/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" style="background:url(/base/resources/images/tab_12.gif) repeat-y left #d3e7fc; ">&nbsp;</td>
        <td width="97%" bgcolor="#FFFFFF"  valign="top" align="center" height="500" style=" padding-top:20px">
		<table width="505px" border="0" cellspacing="0" cellpadding="0">
			<tr style="width:100%;height:20px;background:url(/base/resources/images/htbg1.gif);">
				<td></td>
			</tr>
			<tr style="width:100%; height:250px; background: url(/base/resources/images/htbg3.gif) repeat-y; text-align:center;">
				<td>
					<table width="80%" border="0" cellspacing="0" cellpadding="0">
					<tr><td width="20%" height="30" align="right" class="STYLE4">客户名称：</td>
						<td align="left"><input type="text" name="customerName" value="<%=client.getCname()%>"/></td>
					</tr>
					<tr><td width="20%" height="30" align="right" class="STYLE4">城市名称：</td>
						<td align="left"><input type="text" name="city" value="<%=client.getCcity()%>"/></td>
					</tr>
					<tr><td width="20%" height="30" align="right" class="STYLE4">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：</td>
						<td align="left"><input  type="text" name="address" value="<%=client.getCaddress()%>"/></td>
					</tr>
					<tr><td width="20%" height="30" align="right" class="STYLE4">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;编：</td>
						<td align="left"><input dataType="Zip" type="text" name="postcode" msg="邮编格式(6位数字)" value="<%=client.getCpost()%>"/></td>
					</tr>
					<tr><td width="20%" height="30" align="right" class="STYLE4">固定电话：</td>
						<td align="left"><input dataType="Phone" type="text" name="telphone" msg="电话格式：区号-电话" value="<%=client.getCphone()%>"/></td>
					</tr>
					<tr><td width="20%" height="30" align="right" class="STYLE4">联 系 人：</td>
						<td align="left"><input type="text" name="contact" value="<%=client.getClpeople()%>"/></td>
					</tr>
					<tr><td width="20%" height="30" align="right" class="STYLE4">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：</td>
						<td align="left"><select name="status">
						<option value="1" >激活</option>
						<option  value="0">冻结</option>
						</select></td>
					</tr>
					<tr><td height="40" colspan="2" align="center">
						<input type="submit" name="" value="确定" class="bt_01" />&nbsp;
						<input type="reset" name="" value="取消"  class="bt_01"/>
						</td>
					</tr>
					<tr><td height="40" colspan="2" align="center" class="STYLE4">${msg}</td>
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
</form>
</body>
</html>
