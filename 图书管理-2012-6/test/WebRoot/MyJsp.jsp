<%@ page contentType="text/html" language="java" import="java.util.*,com.heyuhang.servet.*" pageEncoding="gbk"%>

<%@page import="java.util.ArrayList,com.heyuhang.item.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'view.jsp' starting page</title>
    
	
  </head>
  
  <body>
  <table  align="center" border="1" background="" width="60%" >
   <tr><td>ID</td><td>name</td><td>password</td></tr>
	<%
	ArrayList list=(ArrayList)request.getAttribute("list2");
	for(int i=0;i<list.size();i++)
	{
		item g=(item)list.get(i);
	 %>
      <tr style="background:#fff;"> 
        <th><%=g.getName() %></th>
        <th><%=g.getborrow()%></th>
        <th><%=g.getbacktime()%></th>
        <th><%=g.getPwd() %></th>
        <th><%=g.getID()%></th>
        <th><%=g.getprice()%></th>
      </tr>
      <%} %>
  </table>
  
  
  </body>
</html>