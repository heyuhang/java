<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.hyh.vo.*"  %>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=GBK">
    <title>修改商品</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link rel="stylesheet" type="text/css" href="/base/resources/css/hottest.css">
	<style type="text/css">
        <!--
        body {
            margin-left: 0px;
            margin-top: 0px;
            margin-right: 0px;
            margin-bottom: 0px;
        }
        .STYLE1 {font-size: 12px}
        .STYLE4 {
            font-size: 12px;
            color: #1F4A65;
            font-weight: bold;
            font-family:"宋体";
        }

        a:link {
            font-size: 12px;
            color: #06482a;
            text-decoration: none;
        }
        a:visited {
            font-size: 12px;
            color: #06482a;
            text-decoration: none;
        }
        a:hover {
            font-size: 12px;
            color: #FF0000;
            text-decoration: underline;
        }
        a:active {
            font-size: 12px;
            color: #FF0000;
            text-decoration: none;
        }
        .bt_01{
            width:71px;
            height:25px;
            border:0px;
            background: url(/base/resources/images/htdl.gif) no-repeat;
            color:#fff;
            font-size:12px;
            }
        -->
    </style>
    </head>
    <body>
    <%
    	goods goods=(goods)request.getAttribute("goods");
     %>
<form action="" method="post" >
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="/base/resources/images/tab_03.gif" width="15" height="30" /></td>
        <td background="/base/resources/images/tab_05.gif" align="left"><img src="/base/resources/images/311.gif" width="16" height="16" /> <span class="STYLE4">商品修改</span></td>
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
				<td>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td width="20%" height="30" align="right" class="STYLE4">商品名称：</td>
    <td align="left"><input type="text" name="productName" value="<%=goods.getGname()%>"/></td>
  </tr>
  <tr>
    <td height="20" align="right" class="STYLE4">条&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
    <td height="20" align="left"><input type="text" name="barcode" value="<%=goods.getGcode()%>"/></td>
  </tr>
  <tr>
    <td height="30" align="right" class="STYLE4">类&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
    <td height="20" align="left"><input type="text" name="category" value="<%=goods.getSort()%>"/>
	<input type="submit" name="Submit" value="选择类别" /></td>
  </tr>
    <tr>
    <td height="30" align="right" class="STYLE4">品&nbsp;&nbsp;&nbsp;&nbsp;牌：</td>
    <td height="20" align="left"><input type="text" name="brand" value="<%=goods.getBrand()%>"/>
	<input type="submit" name="Submit" value="选择品牌" /></td>
  </tr>
    <tr>
    <td height="30" align="right" class="STYLE4">型&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
    <td height="20" align="left"><input type="text" name="specification" value="<%=goods.getMarker()%>"/></td>
    </tr>
    <tr>
    <td height="30" align="right" class="STYLE4">临&nbsp;界&nbsp;值：</td>
    <td height="20" align="left"><input type="text" name="threshold" value="<%=goods.getLimitvalue()%>"/></td>
    </tr>
  <tr>
    <td height="20" align="right" class="STYLE4">描&nbsp;&nbsp;&nbsp;&nbsp;述：</td>
    <td height="20" align="left"><input type="textarea"  cols="40" rows="4" name="description" value="<%=goods.getGdescription()%>" /></td>
  </tr>
    <tr>
    <td height="30" align="right" class="STYLE4">创建时间：</td>
    <td height="20" align="left"><input type="text" name="createTime" value="<%=goods.getCtime()%>"/></td>
    </tr>
    <tr>
    <td height="30" align="right" class="STYLE4">状&nbsp;&nbsp;&nbsp;&nbsp;态：</td>
    <td height="20" align="left">
      <select name="status">
        <option value="1">激活</option>
        <option value="0">冻结</option>
      </select></td>
  </tr>
  <tr>
    <td height="30" colspan="2" align="center">
	<input type="submit" name="" value="确定" class="bt_01" />&nbsp; 
	<input type="submit" name="" value="取消"  class="bt_01"/></td>
  </tr>
  	<tr><td height="40" colspan="2" align="center" class="STYLE4">成功失败标志</td>
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
        <td width="15" height="29"><img src="../resources/images/tab_20.gif" width="15" height="29" /></td>
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
