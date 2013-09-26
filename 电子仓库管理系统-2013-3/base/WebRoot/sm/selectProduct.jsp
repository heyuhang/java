<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
  <head>
    <title>selectProduct.jsp</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
    <script type="text/javascript">
    function productSelected()
    {
    var value=document.getElementById("goods").value;
	var no=document.getElementById("goods").attributes["no"].value;
	
	window.opener.document.getElementById("productName"+no).value=value;
	window.opener.document.getElementById("productId"+no).value=value;
	window.opener.number(no);
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
function goods(){
    createXMLHttp();
    xmlHttp.open("POST","/base/goods?action=all",true); 
    xmlHttp.onreadystatechange=goodsCallback;
    xmlHttp.send(null);
}
function goodsCallback(){

   	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
			var msg=xmlHttp.responseText;
			document.getElementById("goods").innerHTML=msg;
		}
   	}
}


    </script>
  </head>
<body style="margin:0;background-color:#ECEEF0" onload="goods();">
	<table width="100%" border="0">
	<tr><td align="center">选择商品</td></tr>
  <tr>
  <%
  	String no=request.getParameter("no");
   %>
    <td align="center">
    <div id="test">
        <select name="selectProductForm" size="20" id="goods" no="<%=no%>">
        </select>
    </div>&nbsp;</td>
  </tr>
  <tr>
    <td align="center"><input type="button" value=" 确  定 " onClick="productSelected()" />
	<input type="button" value=" 取  消 " onClick="window.close()" />&nbsp;</td>
  </tr>
</table>
</body>
</html>
