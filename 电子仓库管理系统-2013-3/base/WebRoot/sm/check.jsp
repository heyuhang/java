<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
	<head>
		<title>�̵����</title>
        <meta http-equiv="Content-Type" content="text/html; charset=GBK" />
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<script type="text/javascript" src="/base/resources/js/jquery.js"></script>
        <script defer="defer" language="javascript" type="text/javascript" src="/base/datepicker/WdatePicker.js"></script>
		<link href="/base/resources/css/hottest.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
        <!--
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
            font-family: "����";
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
            width: 100px;
            height: 20px;
            border: 0px;
            background: #0099CC;
            color: #fff;
            font-size: 12px;
        }

        .bt_03 {
            width: 150px;
            height: 15px;
        }

        .bt_021 {
            width: 100px;
            height: 20px;
            border: 0px;
            background: #0099CC;
            color: #fff;
            font-size: 12px;
        }
        -->
        </style>
<script type="text/javascript">
<!--
//�����
var k = 1; //����Ԫ��Ψһ��ʶ�����k
function addItem(){
	var detailList = document.getElementById("detailList");
	var i=detailList.rows.length;

	var row = detailList.insertRow(i);
	var rowIndex = detailList.rows[i].rowIndex;
	var j=k;
	
	detailList.rows[i].setAttribute("align","center");
	detailList.rows[i].setAttribute("bgcolor","#FFFFFF");
	detailList.rows[i].setAttribute("id","tr"+j);
	
	detailList.rows[i].insertCell(0);

	var text = document.createTextNode(j);
	detailList.rows[i].cells[0].appendChild(text);
	
	detailList.rows[i].insertCell(1);
	var input10 = document.createElement("input");
		input10.setAttribute("type","hidden");
		input10.setAttribute("name","productId"+j);
		input10.setAttribute("id","productId"+j);	
	detailList.rows[i].cells[1].appendChild(input10);
	var input1 = document.createElement("input");
		input1.setAttribute("type","text");
		input1.setAttribute("size","38");
		input1.setAttribute("name","productName"+j);
		input1.setAttribute("disabled","true");
		input1.setAttribute("id","productName"+j);	
	detailList.rows[i].cells[1].appendChild(input1);
	var input8 = document.createElement("input");
		input8.setAttribute("type","button");
		input8.setAttribute("value","ѡ����Ʒ");
		input8.onclick= selectProduct;
	detailList.rows[i].cells[1].appendChild(input8);	
	
	detailList.rows[i].insertCell(2);
	var input6 = document.createElement("input");
		input6.setAttribute("type","hidden");
		input6.setAttribute("size","26");
		input6.setAttribute("name","qtys"+j);
		input6.setAttribute("id","qtys"+j);
	detailList.rows[i].cells[2].appendChild(input6);
	var input2 = document.createElement("input");
		input2.setAttribute("type","text");
		input2.setAttribute("size","26");
		input2.setAttribute("name","qty"+j);
		input2.setAttribute("disabled","true");
		input2.setAttribute("id","qty"+j);
	detailList.rows[i].cells[2].appendChild(input2);
	
	detailList.rows[i].insertCell(3);
	var input5 = document.createElement("input");
		input5.setAttribute("type","hidden");
		input5.setAttribute("size","26");
		input5.setAttribute("name","checkQtys"+j);
		input5.setAttribute("id","checkQtys"+j);
	detailList.rows[i].cells[3].appendChild(input5);
	var input3 = document.createElement("input");
		input3.setAttribute("type","text");
		input3.setAttribute("size","26");
		input3.setAttribute("disabled","true");
		input3.setAttribute("name","checkQty"+j);
		input3.setAttribute("id","checkQty"+j);
	detailList.rows[i].cells[3].appendChild(input3);
		
	detailList.rows[i].insertCell(4);
	detailList.rows[i].cells[4].setAttribute("height","25");	
	var deleteRow = document.createElement("a");
	deleteRow.setAttribute("href","javascript:deleteItem("+j+")");
	deleteRow.appendChild(document.createTextNode("ɾ��"));
	detailList.rows[i].cells[4].appendChild(deleteRow);	
	
	//ѡ����Ʒ
	function selectProduct()
    {
		var checkSid = document.getElementById("shelf").value;
		//alert(checkSid);
		if(checkSid==10000){
			alert("����ѡ����Ҫ�̵�Ļ��ܣ�");
			return;
		}
        //ʵ�ʱ���ʱ���÷���
		window.open("<%=request.getContextPath()%>/sm/selectProduct.jsp?no="+j+"&checkSid="+checkSid,"Window","width=400px,height=430px,status=no,resizable=yes,scrollable=yes");
        //������,ʵ�ʱ���ʱȥ���þ�
        //window.open("selectProduct.jsp","Window","width=400px,height=230px,status=no,resizable=yes,scrollable=yes");
	}
	//��ȡcount
	document.getElementById("count").innerHTML="<input type='hidden' name='num' value="+k+">";		
	k++;	
}

//ɾ����
function deleteItem(m){
	var myrow = document.getElementById("tr"+m);
	detailList.deleteRow(myrow.rowIndex);
}
var xmlHttp;
function createXMLHttp(){
    if(window.XMLHttpRequest){
		xmlHttp=new XMLHttpRequest();
	}else{
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
}
function number(no){
	var product=document.getElementById("productId"+no).value;

	if(product!="" && shelf!=""){
    	createXMLHttp();
    	xmlHttp.open("POST","/base/checks?action=num&product="+product,true); 
    	xmlHttp.onreadystatechange= function(){numberCallback(no)};
    	xmlHttp.send(null);
    }
}
function numberCallback(no){

   	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
			var msg=xmlHttp.responseText;

			var strs=msg.split(","); //�ַ��ָ�
			document.getElementById("qty"+no).value=strs[0];
			document.getElementById("checkQty"+no).value=strs[1];
			document.getElementById("qtys"+no).value=strs[0];
			document.getElementById("checkQtys"+no).value=strs[1];
		}
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
function check(){
	var num=document.getElementById("checkId").value;
	if(num==""){
		document.getElementById("checkId").focus();
		document.getElementById("msg").innerHTML="��Ų�����";
		return ;	
	}
    createXMLHttp();
    xmlHttp.open("POST","/base/checks?action=check&num="+num,true); 
    xmlHttp.onreadystatechange=checkCallback;
    xmlHttp.send(null);
}
function checkCallback(){

   	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
			var msg=xmlHttp.responseText;
			if(msg=="false"){
				
				document.getElementById("msg").innerHTML="��ſ���";
			}else{
				document.getElementById("checkId").focus();
				document.getElementById("msg").innerHTML="��Ų�����";
			}
		}
   	}
}

function checks(){
	var dd=true;
	if(forms.checkId.value==""){
		var msg="�̵㵥�š�";
		dd=false;
	}
	if(forms.checkDate.value==""){
		msg+="�̵����ڡ�";
		dd=false;
	}
	if(forms.createBy.value==""){
		msg+="������Ա��";
		dd=false;
	}
	if(forms.createTime.value==""){
		msg+="����ʱ�䡢";
		dd=false;
	}
	if(dd==false){
		msg+="����Ϊ�գ�";
		alert(msg);
	}else forms.submit();
	
}
</script>
	</head>

	<body onload="shelf();">
		<form action="/base/checks?action=add" method="post" name="forms">
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td height="30">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="15" height="30"><img src="/base/resources/images/tab_03.gif" width="15" height="30" /></td>
								<td background="/base/resources/images/tab_05.gif" align="left"><img src="/base/resources/images/311.gif" width="16" height="16" /> <span class="STYLE4">�̵����</span></td>
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
									style="background: url(/base/resources/images/tab_12.gif) repeat-y left #d3e7fc;">&nbsp;</td>
								<td width="97%" bgcolor="#FFFFFF" height="500" valign="top" align="center">
									<table id="detailList" width="100%" border="0" cellspacing="1"
										cellpadding="0" bgcolor="#cecece" align="center">
										<tr class="dz">
											<td bgcolor="#eceef0" colspan="7" align="center">
												<table width="101%" border="0" cellspacing="0"
													cellpadding="0" align="left" height="20%"
													style="border: 1px dashed #d4d4d4;">
													<tr>
														<td colspan="7" height="2" align="left"
															style="padding-left: 10px;">
													<tr>
														<td width="84%" height="52">
															<table width="100%" border="0">
																<tr class="dz">
																	<td>
																		<table width="100%" border="0">
																			<tr class="my">
																				<td width="25%">
																					�̵㵥�ţ�
																					  <input id="checkId" type="text" name="checkId"
																						value="" size="12" onblur="check()"/>
																					 <span id="msg" style="color:red"></span>
																					 </td>
																				<td width="25%">
																					������Ա��
																					<input name="createBy" type="text" value=""
																						size="12"></td>
																			  <td width="25%">
																					��&nbsp;&nbsp;��&nbsp;&nbsp;�ţ�
                                                                                      <select id="shelf" name="shelf" width="20">
                                                                                        <option value="0" selected> -��ѡ�����- </option>
                                                                                      </select></td>
																				<td width="25%">&nbsp;</td>
																		  </tr>
																	  </table>																	</td>
																</tr>
																<tr align="left" class="dz">
																	<td>
																		<table width="100%" border="0">
																			<tr class="my">
																				<td width="25%">�̵����ڣ�
                                                                                    <input name="checkDate" type="text" id="checkDate" size="12">
                                                                                    &nbsp;<img onClick="WdatePicker({el:$dp.$('checkDate')})" src="/base/datepicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
                                                                                </td>
																				<td width="25%">����ʱ�䣺
																					<input name="createTime" type="text" id="createTime" size="12">
                                                                                    &nbsp;<img onClick="WdatePicker({el:$dp.$('createTime')})" src="/base/datepicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
                                                                                </td>
																			  <td width="25%">
                                                                               ״&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;̬��
                                                                                  <select name="status">
                                                                                    <option value="1"> ���� </option>
                                                                                    <option value="0"> ���� </option>
                                                                                  </select>
                                                                              </td>
																				<td width="25%">&nbsp;</td>
																		  </tr>
																	  </table></td>
																</tr>
																<tr class="dz">
																	<td>
																		<table width="100%" border="0">
																			<tr>
																				<td width="75%" class="my">
																					��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ע��
																			  <input type="text" name="remark" size="80">																			  </td>
																				<td width="25%"><input type="button" name="Input2" value="����̵�" class="bt_021" onClick="addItem()" /></td>
																			</tr>
																	</table></td>
																</tr>
															</table></td>
													</tr>
												</table></td>
										</tr>
										<tr class="dz" align="center">
											<td width="10%" height="25"
												background="/base/resources/images/sale_bg.gif">
												���											</td>
											<td width="50%" height="25"
												background="/base/resources/images/sale_bg.gif">
												��Ʒ���� 											</td>
											
											<td width="15%" background="/base/resources/images/sale_bg.gif">
												����											</td>
											<td width="15%" background="/base/resources/images/sale_bg.gif">ʵ�ʿ��</td>
											<td width="10%" background="/base/resources/images/sale_bg.gif">����</td>
										</tr>
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
									<img src="/base/resources/images/tab_20.gif" width="15"
										height="29" />
								</td>
								<td background="/base/resources/images/tab_21.gif">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td colspan="2" width="21%" height="14" class="STYLE1"
												align="right" style="padding-right: 90px;" valign="middle">
												<input type="button" onclick="checks()" name="Input" value="�ύ�̵�" class="bt_02" />
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
			<span id="count"></span>
		</form>
	</body>
</html>
