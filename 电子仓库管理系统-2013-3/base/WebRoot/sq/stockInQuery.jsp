<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.hyh.vo.*"  %>
<html>
	<head>
        <meta http-equiv="content-type" content="text/html; charset=gb2312">
		<title>入库一览表</title>
		<script defer="defer" language="javascript" type="text/javascript" src="/base/datepicker/WdatePicker.js"></script>
		<link href="/base/resources/css/hottest.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
var xmlHttp;
function createXMLHttp(){
    if(window.XMLHttpRequest){
		xmlHttp=new XMLHttpRequest();
	}else{
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
}
function vendor(){
    createXMLHttp();
    xmlHttp.open("POST","/base/vendor?action=all",true); 
    xmlHttp.onreadystatechange=vendorCallback;
    xmlHttp.send(null);
}
function vendorCallback(){

   	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
			var msg=xmlHttp.responseText;
		
			document.getElementById("vendor").innerHTML=msg;
		}
   	}
}
</script>
		<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.STYLE1 {
	font-size: 12px
}

.STYLE4 {
	font-size: 12px;
	color: #1F4A65;
	font-weight: bold;
	font-family: "宋体";
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

.bt_01 {
	width: 71px;
	height: 25px;
	border: 0px;
	background: url(/base/resources/images/htdl.gif) no-repeat;
	color: #fff;
	font-size: 12px;
}

.bt_02 {
	width: 60px;
	height: 20px;
	border: 0px;
	background: #0099CC;
	color: #fff;
	font-size: 12px;
}

.bt_03 {
	width: 150px;
	height: 18px;
}
-->
</style>

	</head>
	<body onload="vendor();">
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="30">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="15" height="30"><img src="/base/resources/images/tab_03.gif" width="15" height="30" /></td>
							<td background="/base/resources/images/tab_05.gif" align="left"><img src="/base/resources/images/311.gif" width="16" height="16" /> <span class="STYLE4">入库一览表</span></td>
							<td width="14"><img src="/base/resources/images/tab_07.gif" width="14" height="30" /></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="15"
								style="background: url(/base/resources/images/tab_12.gif) repeat-y left #d3e7fc;">&nbsp;
								

							</td>
							<td width="97%" bgcolor="#FFFFFF" height="500" valign="top"
								align="center">
								<table width="100%" border="0" cellspacing="1" cellpadding="0"
									bgcolor="#cecece" align="center">
									<tr class="dz">
										<td bgcolor="#eceef0" colspan="9" align="center">
										<form action="/base/stockin?action=search&page=1" method="post">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0" align="left" height="40"
												style="border: 1px dashed #d4d4d4;">
												<tr class="my">
													<td height="20" align="left" width="30%" style="padding-left: 10px;">
														开始日期：
														<input type="text" id="startDate" class="bt_03" name="startDate" value="${startDate}"/>&nbsp;
                                                        <img onClick="WdatePicker({el:$dp.$('startDate')})" src="/base/datepicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
															
														结束日期：
														<input type="text" id="endDate" class="bt_03"
															name="endDate" value="${endDate}"/>&nbsp;<img onClick="WdatePicker({el:$dp.$('endDate')})" src="/base/datepicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">

														供&nbsp;&nbsp;应&nbsp;&nbsp;商：
														
														<select id="vendor" name="vendor" width="20">
															<option value="0" selected>
																--请选择供应商--
															</option>
														</select>
														<input type="submit" name="Submit" value="查询"
															class="bt_02" />
													</td>
												</tr>
											</table>
										  </form>
										</td>
									</tr>
									<tr class="dz" align="center">
										<td width="10%" height="28"
											background="/base/resources/images/sale_bg.gif">
											入库单号
										</td>
										<td width="15%" background="/base/resources/images/sale_bg.gif">
											入库日期
										</td>
										<td width="10%" background="/base/resources/images/sale_bg.gif">
											操作员
										</td>
										<td width="20%" background="/base/resources/images/sale_bg.gif">
											供应商
										</td>
										<td width="15%" background="/base/resources/images/sale_bg.gif">
											货架
										</td>
										<td width="20%" background="/base/resources/images/sale_bg.gif">
											商品
										</td>
										<td width="10%" background="/base/resources/images/sale_bg.gif">
											商品数量
										</td>
									</tr>
									<%
										List<stockin> list=(List)request.getAttribute("stockins");
										if(list!=null && list.size()>0){
										for(int i=0;i<list.size();i++){
											stockin stockin=list.get(i);
									 %>
											<tr class="my" align="center" bgcolor="#ffffff">
												<td align="right"><%=stockin.getNum() %></td>
												<td align="left"><%=stockin.getStockindate() %></td>
												<td align="left"><%=stockin.getCreateby() %></td>
												<td align="left"><%=stockin.getVendor() %></td>
												<td align="left"><%=stockin.getShelf() %></td>
												<td align="left"><%=stockin.getGoods() %></td>
												<td align="right"><%=stockin.getNumber() %></td>
											</tr>
										<%
												}
											}
										 %>
							  </table>
							</td>
							<td width="14"
								style="background: url(/base/resources/images/tab_16.gif) repeat-y right #d3e7fc;">&nbsp;</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="29">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="15" height="29">
								<img src="/base/resources/images/tab_20.gif" width="15" height="29" />
							</td>
							<td background="/base/resources/images/tab_21.gif">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="21%" height="14">&nbsp;</td>
										<td width="79%" class="STYLE1" align="right">
										<% 
										if(list!=null){
										%>
            <a href="/base/stockin?action=search&page=1&vendor=${vendor}&startDate=${startDate}&endDate=${endDate}">首页</a> | 
			<a href="/base/stockin?action=search&page=${page-1}&vendor=${vendor}&startDate=${startDate}&endDate=${endDate}">上一页</a> |
			<a href="/base/stockin?action=search&page=${page+1}&vendor=${vendor}&startDate=${startDate}&endDate=${endDate}">下一页</a> |
			<a href="/base/stockin?action=search&page=${pagesize}&vendor=${vendor}&startDate=${startDate}&endDate=${endDate}">尾页</a>&nbsp;
                                            当前第${page}<span class="font_1">/${pagesize}</span>页
                                         <%
                                         	}
                                          %>
                                        </td>
									</tr>
								</table>
							</td>
							<td width="14">
								<img src="/base/resources/images/tab_22.gif" width="14" height="29" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>