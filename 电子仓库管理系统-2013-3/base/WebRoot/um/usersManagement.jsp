<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.hyh.vo.*"  %>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=GBK">
    <title>用户管理</title>
    <link href="/base/resources/css/hottest.css" rel="stylesheet" type="text/css" />
    <style>
    .STYLE1 {font-size: 12px}
    .bt_02{
        width:60px;
        height:20px;
        border:0px;
        background:#0099CC;
        color:#fff;
        font-size:12px;
        }
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
            <span class="STYLE4">用户管理</span>
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
            <td bgcolor="#eceef0"  colspan="10" align="center">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" align="left" height="40" style="border:1px dashed #d4d4d4;">
                  <tr width="100%">
                    <td height="20" align="left" width="50%" style="padding-left:10px;">
                  <form action="/base/user?action=searchuser&page=1" method="post" class="STYLE1">
                  用户名：<input type="text" name="username" class="bt_04"/> 
                    <input type="submit" name="Submit" value="查询" class="bt_02" /></form>
                     <%
                    	String key=(String)request.getAttribute("key");
                    	if(key!=null && !key.equals("")){
                    		out.print("<span style='font-sise:8px;color:red'>当前搜索'"+key+"'结果为：</span>");
                    	}
                     %>
                    
                    </td>

                    <td width="40%" style="color:red"></td>
                    <td align="right" width="40%" style="padding-left:10px;">
					<td align="right" width="40%" style="padding-left:10px;">
                    <table width="151" border="0" cellspacing="0" cellpadding="0" style="background:url(/base/resources/images/htbutton.gif) no-repeat; margin:5px; ">
           <tr>
                <td align="center" height="34"><a href="/base/um/addUsers.jsp" style="font-size:15px; font-weight:bold; color:#fff;">添加用户</a></td>
           </tr>
       	</table></td>
                  </tr>
                </table>  
  </td>
          </tr>
          <tr class="dz" align="center" >
            <td width="10%" height="28"  class="STYLE1" background="/base/resources/images/sale_bg.gif">用户编号</td>
            <td width="10%"  class="STYLE1" background="/base/resources/images/sale_bg.gif">用户名</td>
            <td width="15%" class="STYLE1" background="/base/resources/images/sale_bg.gif">用户类型</td>
            <td width="10%" class="STYLE1" background="/base/resources/images/sale_bg.gif">部门</td>
            <td width="15%"  class="STYLE1" background="/base/resources/images/sale_bg.gif">创建时间</td>
            <td width="20%"  class="STYLE1" background="/base/resources/images/sale_bg.gif">最后登录时间</td>
            <td width="20%"  class="STYLE1" background="/base/resources/images/sale_bg.gif" colspan="4" >操作</td>
          </tr>
          <%
          		List<user> list=(List)request.getAttribute("users");
          		if(list!=null && list.size()>0){
          		for(int i=0;i<list.size();i++){
          		user user=list.get(i);
           %>
             <tr class="my" align="center"  bgcolor="#ffffff">
              <td class="STYLE1"><%=user.getId()%></td>
    		  <td align="left" class="STYLE1"><%
    		  if(key!=null && !key.equals("")){
    		  char name[]=user.getUsername().toCharArray();
    		  
    		  char names[]=key.toCharArray();
    		  for(int j=0;j<name.length;j++){
    		  	for(int k=0;k<names.length;k++)
    		  			if(name[j]==names[k])
    		  				out.print("<span style='color:red'>"+name[j]+"</span>");
    		  		 	else out.print(name[j]);
    		  	}
    		}else out.print(user.getUsername());
    		  %></td>
    		  <td align="center" class="STYLE1"><%=user.getUsertype()%></td>
    		  <td align="left" class="STYLE1"><%=user.getSectionname()%></td>
    		  <td align="left" class="STYLE1"><%=user.getCtime()%></td>
     		  <td align="left" class="STYLE1"><%=user.getCtime()%></td>
         	  <td width="5%"  class="STYLE1"><a href="/base/user?action=lookuser&id=<%=user.getId()%>&action2=${action}&username=${key}" >详细</a></td>
    		  <td width="5%" class="STYLE1"><a href="/base/um/grantsManagement.jsp?id=<%=user.getId()%>" >权限</a></td>
    		  <td width="5%" class="STYLE1"><a href="/base/user?action=updateuserl&id=<%=user.getId()%>" >修改</a></td>
              <td width="5%" class="STYLE1"><a href="/base/user?action=deluser&id=<%=user.getId()%>&page=${page}&action2=${action}&username=${key}">删除</a></td>
            </tr>
            <%
            	}
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
            <%
            	if(list!=null){
             %>
            <a href="/base/user?action=${action}&page=1&username=${key}">首页</a> | 
            <a href="/base/user?action=${action}&page=${page-1}&username=${key}">上一页</a>
             <span><font color="red"></font></span>
                <a href="/base/user?action=${action}&page=${page+1}&username=${key}">下一页</a> | <a href="/base/user?action=${action}&page=${pagesize}&username=${key}">尾页</a>&nbsp;
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

