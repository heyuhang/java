<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=GBK">
    <title>商品类别管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link href="/base/resources/css/hottest.css" rel="stylesheet" type="text/css" />
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
 <script type="text/javascript">
function check(){
	var dd=true;
	if(form.categoryName.value==""){
		var msg="类别名称";
		dd=false;
	}
	if(dd==false){
		msg+="不能为空！";
		alert(msg);
	}else form.submit();
	
}
</script>
  <body>
<form action="/base/sort?action=addsort" method="post" name="form">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="/base/resources/images/tab_03.gif" width="15" height="30" /></td>
        <td background="/base/resources/images/tab_05.gif" align="left"><img src="/base/resources/images/311.gif" width="16" height="16" /> <span class="STYLE4">商品类别添加</span></td>
        <td width="14"><img src="/base/resources/images/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
  <td>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" style="background:url(/base/resources/images/tab_12.gif) repeat-y left #d3e7fc; "></td>
        <td width="97%" bgcolor="#FFFFFF" height="500" valign="top" align="center" style="padding-top:20px;">
		    <table width="505px" border="0" cellspacing="0" cellpadding="0">
			<tr style="width:100%;height:20px;background:url(/base/resources/images/htbg1.gif);">
				<td></td>
			</tr>
			<tr style="width:100%; height:250px; background: url(/base/resources/images/htbg3.gif) repeat-y; text-align:center;">
				<td>
				<table width="80%" border="0" cellspacing="0" cellpadding="0">
				  <tr>
					<td width="20%" height="40" align="right" class="STYLE4">类别名称：</td>
					<td align="left"><input type="text" name="categoryName"/></td>
				  </tr>
				  <tr>
				  <td height="40" align="right" class="STYLE4">类别层次：</td>
					<td height="30" align="left">
					<select name="tlevel">
					  <option value="2">2</option>
					  <option value="3">3</option>
					</select>
					</td>
				  </tr>
				  <tr>
					 <td height="40" align="right" class="STYLE4">父&nbsp;&nbsp;&nbsp;&nbsp;类：</td>
					<td height="30" align="left">
					<select name="parentCategory">
					  <option value="1">所有商品</option>
					  <option value="2">数码产品</option>
					  <option value="3">手机通讯</option>
					  <option value="4">随身视听</option>
					  <option value="5">电脑办公</option>
					  <option value="6">家用电器</option>
					  <option value="7">母婴用品</option>
					  <option value="8">运动户外</option>
					  <option value="9">交通工具</option>
					  <option value="10">美容护肤</option>
					  <option value="11">珠宝钟表</option>
					</select>
					</td>
				  </tr>
				  <tr>
					<td height="40" align="right" class="STYLE4">状&nbsp;&nbsp;&nbsp;&nbsp;态：</td>
					<td height="30" align="left">
					  <select name="status"> <option value="1">激活</option><option value="0">冻结</option></select></td>
				  </tr>
				  <tr>
					<td height="40" colspan="2" align="center">
					<input type="button" onclick="check()" value="确定"  class="bt_01"/>&nbsp; 
					<input type="reset" value="取消"  class="bt_01"/></td>
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
       
    </table>
   
    </td>
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