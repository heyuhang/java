<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.hyh.vo.*"  %>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=GBK">
    <title>部门管理</title>
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
.bt_02{
    width:60px;
	height:20px;
	border:0px;
    background:#0099CC;
	color:#fff;
	font-size:12px;
	}
.bt_03{
    width:200px;
	height:15px;
	}	
-->
</style>
</head>
<body >

<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="/base/resources/images/tab_03.gif" width="15" height="30" /></td>
        <td background="/base/resources/images/tab_05.gif" align="left">
            <img src="/base/resources/images/311.gif" width="16" height="16" />
            <span class="STYLE4">部门管理</span>
        </td>
        <td width="14"><img src="/base/resources/images/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" style="background:url(/base/resources/images/tab_12.gif) repeat-y left #d3e7fc; ">&nbsp;</td>
        <td width="97%" bgcolor="#FFFFFF" height="500" valign="top" align="center">
        <table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#cecece" align="center">
          <tr class="dz">
            <td bgcolor="#eceef0"  colspan="7" align="center">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" align="left" height="40" style="border:1px dashed #d4d4d4;">
                <tr >
                  <td height="20" align="left" width="50%" style="padding-left:10px;">
          <form action="/base/section?action=searchsection&page=1" method="post" class="STYLE1">
          部门名：<input type="text" name="deptName" class="bt_04"/> 
          <input type="submit" name="Submit" value="查询" class="bt_02" /></form>
                     <%
                    	String key=(String)request.getAttribute("key");
                    	if(key!=null && !key.equals("")){
                    		out.print("<span style='font-sise:8px;color:red'>当前搜索'"+key+"'结果为：</span>");
                    	}
                     %>
          <td width="40%" style="color:red"></td>
                  <td align="right" width="50%" style="padding-left:10px;"><table width="151" border="0" cellspacing="0" cellpadding="0" style="background:url(/base/resources/images/htbutton.gif) no-repeat; margin:5px; ">
                      <tr>
                        <td align="center" height="34"><a href="/base/um/addDepartment.jsp" style="font-size:15px; font-weight:bold; color:#fff;">添加部门</a></td>
                      </tr>
                  </table></td>
                </tr>
            </table></td>
          </tr>
          <tr class="dz" align="center" style="font:12">
            <td width="10%" height="28" background="/base/resources/images/sale_bg.gif">ID</td>
            <td background="/base/resources/images/sale_bg.gif" width="15%">部门名称</td>
            <td background="/base/resources/images/sale_bg.gif" width="15%">部门经理</td>
            <td background="/base/resources/images/sale_bg.gif" width="20%">描述</td>
            <td background="/base/resources/images/sale_bg.gif" width="20%">状态</td>
            <td background="/base/resources/images/sale_bg.gif" colspan="2" width="20%">操作</td>
          </tr>
          <%
          		List<section> list=(List)request.getAttribute("sections");
          		if(list!=null && list.size()>0){
          		for(int i=0;i<list.size();i++){
          			section section=list.get(i);
           %>
           <tr class="my" align="center" bgcolor="#ffffff">
              <td><%=section.getId() %></td>
    		  <td align="left"><%=section.getSename() %></td>
    		  <td><%=section.getSeleader() %></td>
    		  <td><%=section.getSedescription() %></td>
    		  <td><%=section.getState() %></td>
    		  <td><a href="/base/section?action=updatesection&id=<%=section.getId()%>">修改</a></td>
              <td><a style="font:12" href="/base/section?action=delsection&id=<%=section.getId()%>&page=${page}&action2=${action}&deptName=${key}">删除</a></td>
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
            <a href="/base/section?action=${action}&page=1&deptName=${key}">首页</a> | 
            <a href="/base/section?action=${action}&page=${page-1}&deptName=${key}">上一页</a>
             <span><font color="red"></font></span> <a href="/base/section?action=${action}&page=${page+1}&deptName=${key}">下一页</a> | <a href="/base/section?action=${action}&page=${pagesize}&deptName=${key}">尾页</a>&nbsp;
            当前第${page} <span
			style="FONT-WEIGHT: bold; COLOR: #f46521"></span><span class="font_1">/${pagesize}</span>页
          	<%
          		}
          	 %>
          	</td>
          </tr>
        </table></td>
        <td width="14"><img src="/base/resources/images/tab_22.gif" width="14" height="29" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>

