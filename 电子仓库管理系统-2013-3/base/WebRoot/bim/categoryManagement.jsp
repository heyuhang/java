<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.hyh.vo.*"  %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=GBK">
	<title>��Ʒ�������</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<link href="/base/resources/css/hottest.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td height="30">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr height="30">
						<td width="15"><img src="/base/resources/images/tab_03.gif" width="15"/></td>
						<td background="/base/resources/images/tab_05.gif" align="left"><img src="/base/resources/images/311.gif" width="16" height="16" /> <span class="STYLE4">��Ʒ�������</span>	</td>
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
									<td bgcolor="#eceef0" colspan="7" align="center">
										<table width="100%" border="0" cellspacing="0" cellpadding="0" align="left" height="40" style="border: 1px dashed #d4d4d4;">
											<tr class="my">
												<td height="20" align="left" width="50%" style="padding-left: 10px;">
													<form action="/base/sort?action=searchsort&page=1" method="post" class="STYLE1">
														�������ƣ�
														<input type="text" name="categoryName" class="bt_03" />
														<input type="submit" name="Submit" value="��ѯ" class="bt_02" />
													</form>
		             <%
                    	String key=(String)request.getAttribute("key");
                    	if(key!=null && !key.equals("")){
                    		out.print("<span style='font-sise:8px;color:red'>��ǰ����'"+key+"'���Ϊ��</span>");
                    	}
                     %>
												</td>
												<td align="right" width="50%" style="padding-left: 10px;">
													<table width="151" border="0" cellspacing="0"
														cellpadding="0"
														style="background: url(/base/resources/images/htbutton.gif) no-repeat; margin: 5px;">
														<tr>
															<td align="center" height="34">
																<a href="/base/bim/addCategory.jsp"
																	style="font-size: 15px; font-weight: bold; color: #fff;">��ӷ���</a>
															</td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr class="dz" align="center">
									<td width="10%" height="28"
										background="/base/resources/images/sale_bg.gif">
										ID
									</td>
									<td width="25%" background="/base/resources/images/sale_bg.gif">
										��������
									</td>
									<td background="/base/resources/images/sale_bg.gif" width="25%">
										����
									</td>
									<td background="/base/resources/images/sale_bg.gif" width="10%">
										������
									</td>
									<td background="/base/resources/images/sale_bg.gif" width="10%">
										״̬
									</td>
									<td background="/base/resources/images/sale_bg.gif" width="20%"
										colspan="2">
										�޸ı༭
									</td>
								</tr>
								<%
									List<goodssort> list=(List)request.getAttribute("sorts");
									if(list!=null && list.size()>0){
									for(int i=0;i<list.size();i++){
										goodssort ss=list.get(i);
								 %>
                                <tr class="my" align="center" bgcolor="#ffffff">
                                    <td><%=ss.getId() %></td>
                                    <td align="left"><%=ss.getSortname() %></td>
                                    <td><%=ss.getSortgrade()%></td>
                                    <td><%=ss.getSortfather()%></td>
                                    <td><%=ss.getState() %></td>
                                    <td><a href="/base/sort?action=updatesort&id=<%=ss.getId()%>">�޸�</a></td>
                                    <td><a href="/base/sort?action=delsort&id=<%=ss.getId()%>&page=${page}&action2=${action}&categoryName=${key}">ɾ��</a></td>
                                </tr>
                                <%
                                	}
                                	}
                                 %>
							</table>
						</td>
						<td width="14"
							style="background: url(/base/resources/images/tab_16.gif) repeat-y right #d3e7fc;">&nbsp;
							
						</td>
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
						<td background="../resources/images/tab_21.gif">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="21%" height="14">&nbsp;</td>
									<td width="79%" class="STYLE1" align="right">
									<%
										if(list!=null){
									 %>
										<a href="/base/sort?action=${action}&page=1&categoryName=${key}">��ҳ</a> |
										<a href="/base/sort?action=${action}&page=${page-1}&categoryName=${key}">��һҳ</a> |
										<a href="/base/sort?action=${action}&page=${page+1}&categoryName=${key}">��һҳ</a> |
										<a href="/base/sort?action=${action}&page=${pagesize}&categoryName=${key}">βҳ</a>&nbsp;
                                        ��ǰ��${page}<span class="font_1">/${pagesize}</span>ҳ
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
