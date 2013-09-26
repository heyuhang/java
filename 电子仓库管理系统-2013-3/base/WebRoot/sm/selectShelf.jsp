<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
<head>
	<title>selectProduct.jsp</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
<script type="text/javascript">
var xmlHttp;
function createXMLHttp(){
    if(window.XMLHttpRequest){
		xmlHttp=new XMLHttpRequest();
	}else{
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
}
function shelf(){
    createXMLHttp();
    xmlHttp.open("POST","/base/shelf?action=all",true); 
    xmlHttp.onreadystatechange=shelfCallback;
    xmlHttp.send(null);
}
function shelfCallback(){

   	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
			var msg=xmlHttp.responseText;
			document.getElementById("shelf").innerHTML=msg;
		}
   	}
}
function shelfSelected()
{
    var value=document.getElementById("shelf").value;
	var no=document.getElementById("shelf").attributes["no"].value;
	window.opener.document.getElementById("shelfName"+no).value=value;
	window.opener.document.getElementById("shelfId"+no).value=value;
	window.opener.number(no);
	window.close();
}
</script>

</head>

<body style="margin:0;background-color:#ECEEF0" onload="shelf();">
<%
	String no=request.getParameter("no");
 %>
	<table width="100%" border="0">
	<tr><td align="center">选择货架</td></tr>
		<tr>
			<td align="center">
				<div id="test">
					<select name="selectShelfForm" property="shelfName" size="10" id="shelf" no="<%=no%>">

					</select>
				</div>
				&nbsp;
			</td>
		</tr>
		<tr>
			<td align="center">
				<input type="button" value=" 确  定 " onClick="shelfSelected()" />
				<input type="button" value=" 取  消 " onClick="window.close()" />
				&nbsp;
			</td>
		</tr>
	</table>

</body>
</html>

