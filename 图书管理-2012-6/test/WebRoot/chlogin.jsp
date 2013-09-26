<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html;charset=GBK">
    <title>My JSP 'chlogin.jsp' starting page</title>
  </head>
  
<%
	String name=request.getParameter("name");
	String pwd=request.getParameter("pwd");
	String radio=request.getParameter("radio");
	Connection con=null;
	ResultSet rs=null;
	Statement sm=null;
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost/library","root","heyuhang");
	sm=con.createStatement();
	if("1".equals(radio))
	{
		rs=sm.executeQuery("select pwd from tb_manager where name='"+name+"';");
		if(rs.next())
		{
			if(rs.getString("pwd").equals(pwd))
			{
				response.sendRedirect("index.jsp");
				out.print("succes");
				session.setAttribute("user",name);
			}
			else response.sendRedirect("login.jsp?info=2");
		}
		else response.sendRedirect("login.jsp?info=1");
	}
	else 
	{
		rs=sm.executeQuery("select barcode from tb_reader where name='"+name+"';");
		if(rs.next())
		{
			if(rs.getString("barcode").equals(pwd))
			{
				out.print("succes");
				response.sendRedirect("index.jsp");
				session.setAttribute("user",name);
			}
			else response.sendRedirect("login.jsp?info=2");
		}
		else response.sendRedirect("login.jsp?info=1");
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(rs!=null)
		{
			try
			{
				rs.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(sm!=null)
		{
			try{sm.close();}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(con!=null)
		{
			try{con.close();}catch(Exception e){
				e.printStackTrace();
			}
		}	
	}
 %>
</html>
