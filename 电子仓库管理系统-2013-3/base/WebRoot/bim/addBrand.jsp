<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=GBK">
    <title>品牌管理</title>
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
<script type="text/javascript">
function check(){
	var dd=true;
	if(form.brandName.value==""){
		var msg="品牌名称";
		dd=false;
	}
	if(form.comments.value==""){
		msg+="描述";
		dd=false;
	}
	if(dd==false){
		msg+="不能为空！";
		alert(msg);
	}else form.submit();
	
}
</script>
<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="/base/resources/images/tab_03.gif" width="15" height="30" /></td>
        <td background="/base/resources/images/tab_05.gif" align="left"><img src="/base/resources/images/311.gif" width="16" height="16" /> <span class="STYLE4">品牌添加</span></td>
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
				<form action="/base/brand?action=addbrand" method="post" name="form" >
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					   <tr>
							<td width="25%" height="30" align="right" class="STYLE4">品牌名称：</td>
							<td align="left"><input type="text" name="brandName">
							</td>
						</tr>
						<tr>
							<td height="20" align="right" class="STYLE4">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述：</td>
							<td height="20" align="left"><textarea name="comments" cols="40" rows="4"></textarea></td>
						</tr>
						<tr>
							<td height="40" colspan="2" align="center" style="color:blue">
							<input type="button" onclick="check()" name="registerSub" value="确定" class="bt_01" />&nbsp;
							<input type="reset" name="cancel;" value="取消"   class="bt_01"/></td>
						</tr>
						<tr><td height="40" colspan="2" align="center" class="STYLE4">${msg}</td>
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