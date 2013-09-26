<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.hyh.vo.*"%>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>资源管理</title>
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

<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="/base/resources/images/tab_03.gif" width="15" height="30" /></td>
        <td background="/base/resources/images/tab_05.gif" align="left">
            <img src="/base/resources/images/311.gif" width="16" height="16" />
            <span class="STYLE4">资源管理</span>
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
            <td bgcolor="#eceef0"  colspan="7" align="center" valign="middle">
                <table width="100%" border="0" cellspacing="0" cellpadding="0"
				align="left" height="40" style="border:1px dashed #d4d4d4;">
                  <tr >
                    <td height="20" align="left" width="50%" style="padding-left:10px;" >
                    <form action="/base/resource?action=addresource" method="post" class="STYLE1">
                    资源名：<input type="text" name="resourceName" class="bt_04"/>
                    <input type="submit" name="Submit" value="查询" class="bt_02" /></form></td>
                    <td width="40%" style="color:red"></td>
                    <td align="right" width="50%" style="padding-left:10px;">
					<table width="151" border="0" cellspacing="0" cellpadding="0" style="background:url(/base/resources/images/htbutton.gif) no-repeat; margin:5px; ">
           <tr>
                <td align="center" height="34"><a href="/base/um/addResource.html" style="font-size:15px; font-weight:bold; color:#fff;">添加资源</a></td>
           </tr>
       	</table></td>
                  </tr>
                </table>            </td>
          </tr>
          <tr class="dz" align="center" style="font:12">
            <td width="20%" height="28" background="/base/resources/images/sale_bg.gif">资源编号</td>
            <td width="20%" background="/base/resources/images/sale_bg.gif">资源名称</td>
            <td background="/base/resources/images/sale_bg.gif" width="30%">资源描述</td>
			<td background="/base/resources/images/sale_bg.gif" width="10%">创建时间</td>
			<td background="/base/resources/images/sale_bg.gif" width="10%">状态</td>
            <td background="/base/resources/images/sale_bg.gif" colspan="2" width="10%">操作</td>
          </tr>
          <%
				List<resource> resource=(List)request.getAttribute("resources");
				for(resource res:resource){
 		  %>
           <tr class="my" align="center" bgcolor="#ffffff">
              <td><%=res.getId() %></td>
    		  <td align="left"><%=res.getResname() %></td>
    		  <td><%=res.getRedescription()%></td>
    		  <td><%=res.getCtime()%></td>
    		  <td><%=res.getState()%></td>
    		  <td><a href="updateResource.html">修改</a></td>
              <td><a href="#" onclick="">删除</a></td>
          </tr>
          <%
          	}
           %>
        </table>
		</td>
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
            
            <a href="/base/resource?page=1">首页</a> | 
            <a href="/base/resource?page=${page-1}">上一页</a>
             <span><font color="red"></font></span> <a href="/base/resource?page=${page+1}">下一页</a> | <a href="/base/resource?page=${pagesize}">尾页</a>&nbsp;
            当前第 ${page}<span
			style="FONT-WEIGHT: bold; COLOR: #f46521"></span><span class="font_1">/${pagesize}</span>页
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
