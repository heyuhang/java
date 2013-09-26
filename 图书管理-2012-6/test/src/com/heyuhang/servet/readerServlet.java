package com.heyuhang.servet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heyuhang.dao.jdbcConnection;
import com.heyuhang.item.*;

public class readerServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String m=request.getParameter("method");
		if("findone".equals(m))
		{
			this.findone(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void findone(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		ResultSet rs=null;
		ResultSet rs2=null;
	//	String stuName=request.getParameter("name");
		String code=request.getParameter("barcode");
		String sql2="select tb_book.barcode,tb_book.bookname,tb_borrow.borrowTime,tb_borrow.backtime,tb_book.ISBN,tb_book.bookcase,tb_book.price from tb_book," +
		"tb_borrow where tb_book.barcode=tb_borrow.bookid and tb_borrow.readerid="+code;
		String sql="select tb_reader.*,tb_readertype.number from tb_reader,tb_readertype where tb_reader.name=tb_readertype.name and tb_reader.barcode="+code;
		rs=jdbcConnection.getResult(sql);
		rs2=jdbcConnection.getResult(sql2);
		List list=new ArrayList();
		student stu=new student();
		if(rs==null && rs2==null)
		{
			request.setAttribute("student", stu);
			request.setAttribute("list2", list);
			request.getRequestDispatcher("reader.jsp").forward(request, response);
			return ;
		}
		try
		{
			if(rs.next())
			{
				stu.setBarcode(rs.getString("barcode"));
				stu.setName(rs.getString("name"));
				stu.setPaperType(rs.getString("paperType"));
				stu.setVocation(rs.getString("vocation"));
				stu.setSex(rs.getString("sex"));
				stu.setpaperNO(rs.getString("paperNO"));
				stu.setName(rs.getString("number"));
			}
			while(rs2.next())
			{
				item stu2=new item();
				stu2.setbarcode(rs2.getString(1));
				stu2.setName(rs2.getString(2));
				stu2.setbborrow(rs2.getDate(3));
				stu2.setbacktime(rs2.getDate(4));
				stu2.setPwd(rs2.getString(5));
				stu2.setID(rs2.getInt(6));
				stu2.setprice(rs2.getFloat(7));
				list.add(stu2);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		request.setAttribute("student", stu);
		request.setAttribute("list2", list);
		request.getRequestDispatcher("reader.jsp").forward(request, response);
	}
	
}
