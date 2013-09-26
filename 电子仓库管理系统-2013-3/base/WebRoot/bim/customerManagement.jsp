<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.hyh.vo.*"  %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=GBK">
    <title>客户管理</title>
	<link href="/base/resources/css/hottest.css" rel="stylesheet" type="text/css" />
</head>
<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
 <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="/base/resources/images/tab_03.gif" width="15" height="30" /></td>
        <td background="/base/resources/images/tab_05.gif" align="left"><img src="/base/resources/images/311.gif" width="16" height="16" /> <span class="STYLE4">客户管理</span></td>
        <td width="14"><img src="/base/resources/images/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>

</tr>
  <tr>
    <td>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">

      <tr>
        <td width="15" style="background:url(/base/resources/images/tab_12.gif) repeat-y left #d3e7fc; ">&nbsp;</td>
        <td width="97%" bgcolor="#FFFFFF" height="500" valign="top" align="center"><table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#cecece" align="center">
          <tr class="dz">
            <td bgcolor="#eceef0"  colspan="9" align="center"><table width="100%" border="0" cellspacing="0" cellpadding="0"
				align="left" height="40" style="border:1px dashed #d4d4d4;">
				                <tr >
                  <td height="20" align="left" width="50%" style="padding-left:10px;">
                      <form action="/base/client?action=searchclient&page=1" method="post" class="STYLE1"> 
						    客户名称：<input type="text" name="customerName" class="bt_03"/>
							<input type="submit" name="Submit" value="查询" class="bt_02"/>
                      </form>
                     <%
                    	String key=(String)request.getAttribute("key");
                    	if(key!=null && !key.equals("")){
                    		out.print("<span style='font-sise:8px;color:red'>当前搜索'"+key+"'结果为：</span>");
                    	}
                     %>
                  <td align="right" width="50%" style="padding-left:10px;"><table width="151" border="0" cellspacing="0" cellpadding="0" style="background:url(/base/resources/images/htbutton.gif) no-repeat; margin:5px; ">
                      <tr>
                        <td align="center" height="34"><a href="/base/bim/addCustomer.jsp" style="font-size:15px; font-weight:bold; color:#fff;">添加客户</a></td>
                      </tr>
                  </table></td>
                </tr>
            </table></td>
          </tr>

            <tr class="dz" align="center">
				<td width="5%" height="28"background="/base/resources/images/sale_bg.gif">ID</td>
				<td width="15%" background="/base/resources/images/sale_bg.gif">客户</td>
				<td width="15%" background="/base/resources/images/sale_bg.gif">地址</td>
				<td width="10%" background="/base/resources/images/sale_bg.gif">邮编</td>
				<td width="10%" background="/base/resources/images/sale_bg.gif">电话</td>
				<td width="10%" background="/base/resources/images/sale_bg.gif">联系人</td>
				<td width="10%" background="/base/resources/images/sale_bg.gif" >状态</td>
				<td width="20%" background="/base/resources/images/sale_bg.gif" colspan="2">修改编辑</td>
			</tr>


			<tr class="separator" align="center"  bgcolor="#ffffff">
           <%
          		List<client> list=(List)request.getAttribute("clients");
          		if(list!=null && list.size()>0){
          		for(int i=0;i<list.size();i++){
          			client client=list.get(i);
           %>
			<tr class="my" align="center" bgcolor="#ffffff">
				<td><%=client.getId() %></td>
				<td><%=client.getCname() %></td>
				<td><%=client.getCaddress() %></td>
				<td><%=client.getCpost() %></td>
				<td><%=client.getCphone() %></td>
				<td><%=client.getClpeople() %></td>
				<td><%=client.getState() %></td>
				<td><a href="/base/client?action=updateclient&id=<%=client.getId()%>">修改</a></td>
				<td><a href="/base/client?action=delclient&id=<%=client.getId()%>&page=${page}&action2=${action}&customerName=${key}">删除</a></td>
			</tr>
			<%
				}
				}
			 %>
        </table></td>

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
            <td width="79%" class="STYLE1" align="right">
									<%
										if(list!=null){
									 %>
            <a href="/base/client?action=${action}&page=1&customerName=${key}">首页</a> | 
			<a href="/base/client?action=${action}&page=${page-1}&customerName=${key}">上一页</a> |
			<a href="/base/client?action=${action}&page=${page+1}&customerName=${key}">下一页</a> |
			<a href="/base/client?action=${action}&page=${pagesize}&customerName=${key}">尾页</a>
			&nbsp;当前第${page}<span style="FONT-WEIGHT: bold; COLOR: #f46521">/${pagesize}</span>页
			<%
				}
			 %>
          </tr>
        </table></td>
        <td width="14"><img src="/base/resources/images/tab_22.gif" width="14" height="29" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
