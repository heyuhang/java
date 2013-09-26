<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=GBK">
    <title>添加商品</title>
	<script defer="defer" language="javascript" type="text/javascript" src="/base/datepicker/WdatePicker.js"></script>
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
 <script type="text/javascript">
 var xmlHttp;
function createXMLHttp(){
    if(window.XMLHttpRequest){
		xmlHttp=new XMLHttpRequest();
	}else{
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
}
function brand(){
    createXMLHttp();
    xmlHttp.open("POST","/base/brand?action=all",true); 
    xmlHttp.onreadystatechange=brandCallback;
    xmlHttp.send(null);
}
function brandCallback(){

   	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
			var msg=xmlHttp.responseText;
			
		
			document.getElementById("brand").innerHTML=msg;
		}
   	}
}
function sort(){
    createXMLHttp();
    xmlHttp.open("POST","/base/sort?action=all",true); 
    xmlHttp.onreadystatechange=sortCallback;
    xmlHttp.send(null);
}
function sortCallback(){

   	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
			var msg=xmlHttp.responseText;
			
		
			document.getElementById("sort").innerHTML=msg;
			brand();
		}
   	}
}
window.onload=function()//用window的onload事件，窗体加载完毕的时候
{
   sort();
   
}
function check(){
	var dd=true;
	if(form.productName.value==""){
		var msg="商品名称、";
		dd=false;
	}
	if(form.barcode.value==""){
		msg+="条码、";
		dd=false;
	}
	if(form.specification.value==""){
		msg+="型号、";
		dd=false;
	}
	if(form.threshold.value==""){
		msg+="临界值、";
		dd=false;
	}
	if(form.description.value==""){
		msg+="描述、";
		dd=false;
	}
	if(form.createTime.value==""){
		msg+="创建时间、";
		dd=false;
	}
	if(dd==false){
		msg+="不能为空！";
		alert(msg);
	}else form.submit();
	
}
</script>
<body>
<form action="/base/goods?action=addgoods" method="post" name="form">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="/base/resources/images/tab_03.gif" width="15" height="30" /></td>
        <td background="/base/resources/images/tab_05.gif" align="left"><img src="/base/resources/images/311.gif" width="16" height="16" /> <span class="STYLE4">商品添加</span></td>
        <td width="14"><img src="/base/resources/images/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" height="97">
      <tr>
        <td width="15" style="background:url(/base/resources/images/tab_12.gif) repeat-y left #d3e7fc; "></td>
        <td width="97%" bgcolor="#FFFFFF" height="500" valign="top" align="center" style="padding-top:20px;">
				<table width="505px" border="0" cellspacing="0" cellpadding="0">
			<tr style="width:100%;height:20px;background:url(/base/resources/images/htbg1.gif);">
				<td></td>
			</tr>
			<tr style="width:100%; height:250px; background: url(/base/resources/images/htbg3.gif) repeat-y; text-align:center;">
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td width="20%" height="30" align="right" class="STYLE4">商品名称：</td>
						<td align="left"><input type="text" name="productName"/></td>
					  </tr>
					  <tr>
						<td height="30" align="right" class="STYLE4">条&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
						<td height="20" align="left"><input type="text" name="barcode"/></td>
					  </tr>
					  <tr>
						<td height="30" align="right" class="STYLE4">类&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
						<td height="20" align="left">
						<select name="category" width="20" id="sort">
								<option value="0" selected>  --请选择类别--</option>
								</select></td>
					  </tr>
						<tr>
						<td height="30" align="right" class="STYLE4">品&nbsp;&nbsp;&nbsp;&nbsp;牌：</td>
						<td height="20" align="left">
						<select id="brand" name="brand" width="20">
								<option value="0" selected>  --请选择品牌--</option>
								</select></td>
					  </tr>
						<tr>
						<td height="30" align="right" class="STYLE4">型&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
						<td height="20" align="left"><input type="text" name="specification"/></td>
						</tr>
						<tr>
						<td height="30" align="right" class="STYLE4">临&nbsp;界&nbsp;值：</td>
						<td height="20" align="left"><input type="text" name="threshold"/></td>
						</tr>
					  <tr>
						<td height="20" align="right" class="STYLE4">描&nbsp;&nbsp;&nbsp;&nbsp;述：</td>
						<td height="20" align="left"><textarea name="description" cols="40" rows="4"></textarea></td>
					  </tr>
						<tr>
						<td height="30" align="right" class="STYLE4">创建时间：</td>
						<td height="20" align="left"><input id="createTime" type="text" name="createTime"/>
						&nbsp;<img onClick="WdatePicker({el:$dp.$('createTime')})" src="/base/datepicker/skin/datePicker.gif" width="16" height="22" align="absmiddle"></td>
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
						<input type="button" onclick="check()" value="确定" class="bt_01" />&nbsp; 
						<input type="reset" name="" value="取消"  class="bt_01"/></td>
					  </tr>
					  <tr>
						<td height="40" colspan="2" align="center" class="STYLE4">${msg}</td>
					  </tr>
					</table>
				</td>
			</tr>
			<tr style="width:100%; height:17px; background: url(/base/resources/images/htbg2.gif) no-repeat;">
				<td>&nbsp;</td>
			</tr>
		</table>
		</td>
        <td width="13"  style="background:url(/base/resources/images/tab_16.gif) repeat-y right #d3e7fc; ">&nbsp;</td>
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

