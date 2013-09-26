<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
  <head>
    <title>选择出货单</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <link rel="stylesheet" type="text/css" href="../resources/css/hottest.css">
<script type="text/javascript">
function stockoutSelected()
{
    try
    {
        var tests = document.getElementById("deliver");
        window.opener.addItem();
        var j = window.opener.document.getElementById("rowId").value;
       
        window.opener.document.getElementById("stockoutId"+j).value=tests.options[tests.selectedIndex].text;
        window.opener.document.getElementById("qty"+j).value=tests.options[tests.selectedIndex].value;
    }
    catch(e){}
    window.close();
}
var xmlHttp;
function createXMLHttp(){
    if(window.XMLHttpRequest){
		xmlHttp=new XMLHttpRequest();
	}else{
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
}
function deliver(){
    createXMLHttp();
    xmlHttp.open("POST","/base/deliver?action=all",true); 
    xmlHttp.onreadystatechange=deliverCallback;
    xmlHttp.send(null);
}
function deliverCallback(){

   	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
			var msg=xmlHttp.responseText;
			document.getElementById("deliver").innerHTML=msg;
		}
   	}
}
</script>

  </head>

<body style="margin:0;background-color:#ECEEF0" onload="deliver();">
<table width="100%" border="0">
    <tr><td align="center">选择出库单</td></tr>
    <tr>
        <td align="center">
            <div id="test">
            <select name="selectStockoutForm" property="qty" size="10" id="deliver">

            </select>
            </div>
       </td>
  </tr>
  <tr>
    <td align="center"><input type="button" value=" 确  定 " onClick="stockoutSelected()" />
    <input type="button" value=" 取  消 " onClick="window.close()" />&nbsp;</td>
  </tr>
</table>

</body>
</html>
