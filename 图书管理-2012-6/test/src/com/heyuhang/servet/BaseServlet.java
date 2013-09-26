package com.heyuhang.servet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heyuhang.dao.jdbcConnection;
import com.heyuhang.item.book;
import com.heyuhang.item.item;
import com.heyuhang.item.student;


public class BaseServlet  extends HttpServlet{
	
	String Pname;   //登陆名
	List List=new ArrayList();  
	List List2=new ArrayList();
	List List3=new ArrayList();
	String manager;
	protected void insert(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {  //tb_book往表中插入数据
		String sq=null;
		int ID = jdbcConnection.findID("tb_book");
		ID++;
		String barcode=request.getParameter("barcode");
		String name=request.getParameter("bookname");
		String typeid=request.getParameter("typeid");
		int type=Integer.valueOf(typeid);
		String author=request.getParameter("author");
		String translator=request.getParameter("translator");
		String isbn=request.getParameter("ISBN");
		String price=request.getParameter("price");
		float Price=Float.parseFloat(price);
		String page=request.getParameter("page");
		int Page=Integer.valueOf(page);
		String bookcase=request.getParameter("bookcase");
		int Bookcase=Integer.valueOf(bookcase);
		String storage=request.getParameter("storage");
		int Storage=Integer.valueOf(storage);
		int code=jdbcConnection.findBarcode("tb_book");
		sq="insert into tb_book(barcode,bookname,typeid,author,translator,ISBN,price,page,bookcase,storage) values('"+barcode+"','"+name+"','"+type+"','"+author+"','"+translator+"','"+isbn+"','"+Price+"','"+Page+"','"+Bookcase+"','"+Storage+"')";
		jdbcConnection.insert(sq);
		for(int i=0;i<Storage;i++)  
		{
			++code;
			String sql="insert into tb_book(barcode,bookname,typeid,author,translator,ISBN,price,page,bookcase,storage) values('"+code+"','"+name+"','"+type+"','"+author+"','"+translator+"','"+isbn+"','"+Price+"','"+Page+"','"+Bookcase+"','"+Storage+"')";
			jdbcConnection.insert(sql);
		}
	}
	
	public void insert2(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {  //tb_reader插入数据
		int ID = jdbcConnection.findID("tb_reader");
		ID++;
		int id=jdbcConnection.findID("tb_readertype");
		id++;
		System.out.print(ID);
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String code=request.getParameter("barcode");
		String vocation=request.getParameter("vocation");
		String birthday=request.getParameter("birthday");
		String Type=request.getParameter("paperType");
		String no=request.getParameter("paperNO");
		String tel=request.getParameter("tel");
		String email=request.getParameter("email");
		String sql="insert into tb_reader(ID,name,sex,barcode,vocation,birthday,paperType,paperNO,tel,email) values('"+ID+"','"+name+"','"+sex+"','"+code+"','"+vocation+"','"+birthday+"','"+Type+"','"+no+"','"+tel+"','"+email+"')";
		jdbcConnection.insert(sql);
		jdbcConnection.insert("insert into tb_readertype values('"+id+"','"+name+"','"+4+"');");
	}
	
	public int check(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {   //用户登陆  检查用户名和密码
		response.setContentType("test/html;charset=GBK");
		request.setCharacterEncoding("GBK");
		ResultSet rs=null;
		List list=new ArrayList();
		String Name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		String radio=request.getParameter("radio");
		manager=radio;
		if(Name==null || pwd==null || radio==null)
		{
			return 0;
		}
		item b=new item(2,Name,pwd);
		int leap=0;
		if(radio.equals("1"))
		{
			rs=jdbcConnection.getResult("select name from tb_manager where pwd="+"'"+pwd+"'");
		}
		else 
		{
			rs=jdbcConnection.getResult("select name from tb_reader where barcode="+"'"+pwd+"'");
		}
		
		try {
			while(rs.next()){
				item obj=new item();
				obj.setName(rs.getString("name"));
				list.add(obj);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		for(int i=0;i<list.size();i++)
		{
			item a=(item)list.get(i);
			System.out.println(a.getName().equals(b.getName()));
			if(a.getName().equals(b.getName()))
			{	
				request.setAttribute("name", a.getName());
				Pname=a.getName();
				return 1;   //匹配成功  返回1
			}

		}
		return 0;
	}
	public  void find(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { // 登陆成功，往主页显示读者排行，和图书排行信息
		ResultSet rs=null;
		ResultSet rs2=null;
		int leap=this.check(request, response);
		if(leap==1)
		{
			List list1=new ArrayList();
			List list2=new ArrayList();
			rs=jdbcConnection.getResult("select barcode,vocation,paperType,paperNO,tel,sex from tb_reader");
			rs2=jdbcConnection.getResult("select barcode,bookname,bookcase,ISBN,author,price from tb_book");
			try
			{
				for(int i=0;i<=3;i++)
				{
					rs.next();
					student obj=new student();
					obj.setID(++i);
					obj.setBarcode(rs.getString(1));
					obj.setVocation(rs.getString(2));
					obj.setPaperType(rs.getString(3));
					obj.setpaperNO(rs.getString(4));
					obj.setTel(rs.getString(5));
					obj.setSex(rs.getString(6));
					list1.add(obj);
				}
				for(int i=0;i<=3;i++)
				{
					rs2.next();
					book obj=new book();
					obj.setID(++i);
					obj.setBarcode(rs2.getString(1));
					obj.setbooknsme(rs2.getString(2));
					obj.setbookcase(rs2.getInt(3));
					obj.setISBN(rs2.getString(4));
					obj.setauthor(rs2.getString(5));
					obj.setprice(rs2.getFloat(6));
					list2.add(obj);
				}
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			List2=list1;
			List3=list2;
			request.setAttribute("list1", list1);   //list1存储读者排行
			request.setAttribute("list2", list2);  // list2存储图书排行
			if(manager.equals("1"))
				request.getRequestDispatcher("shouye.jsp").forward(request, response);  //重定向到首页
			else
				request.getRequestDispatcher("satrt.jsp").forward(request, response);
		}
		else
			request.getRequestDispatcher("error.jsp").forward(request, response);
	}
	
	public void findbook(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException { //搜索图书信息
		ResultSet rs=null;
		String sql = null;
		String code=request.getParameter("barcode");
		if(!"".equals(code))
			sql="select barcode,bookname,author,ISBN,bookcase from tb_book where barcode="+code+";";
		String name=request.getParameter("bookname");
		if(!"".equals(name) && !"".equals(code))
			sql="select barcode,bookname,author,ISBN,bookcase from tb_book where barcode='"+code+"' and bookname like '%"+name+"%';";
		else if(!"".equals(name))
		{
			sql="select barcode,bookname,author,ISBN,bookcase from tb_book where bookname like '%"+name+"%';";
		}
		String author=request.getParameter("author");
		if(!"".equals(code) && !"".equals(name) && !"".equals(author))
			sql="select barcode,bookname,author,ISBN,bookcase from tb_book where barcode='"+code+"' and bookname like '%"+name+"%' and author='"+author+"';";
		else if(!"".equals(code) && !"".equals(author))
			sql="select barcode,bookname,author,ISBN,bookcase from tb_book where barcode='"+code+"' and author='"+author+"';";
		else if(!"".equals(name) && !"".equals(author))
			sql="select barcode,bookname,author,ISBN,bookcase from tb_book where author='"+author+"' and bookname like '%"+name+"%';";
		else if(!"".equals(author))
			sql="select barcode,bookname,author,ISBN,bookcase from tb_book where author='"+author+"';";
		rs=jdbcConnection.getResult(sql);
		int id=1;
		List list=new ArrayList();
		try
		{
			while(rs.next())
			{
				student t=new student();
				t.setID(id++);
				t.setBarcode(rs.getString(1));
				t.setName(rs.getString(2));
				t.setOperator(rs.getString(3));
				t.setpaperNO(rs.getString(4));
				t.setNumber(rs.getInt(5));
				list.add(t);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		request.setAttribute("list3", list);
	}
	
	public void renewbook(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException { //更新图书信息

		String code=request.getParameter("barcode");
		String sql1 = null;
		sql1="delete from tb_borrow where  bookid='"+code+"';";
		jdbcConnection.delete(sql1);
		for(int i=0;i<List.size();i++)
		{
			item sub=(item)List.get(i);
			if(code.equals(sub.getbarcode()))
				List.remove(i);
		}
	}
///////////////////////////////////////////////////////////////////////////////////////	
	public void findone(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {  //更新图书信息
		ResultSet rs=null;
		ResultSet rs2=null;
		String code=request.getParameter("barcode");
		rs=jdbcConnection.getResult("select bookid from tb_borrow where readerid='"+code+"';");
		if(rs==null)
		{
			request.setAttribute("name", Pname);
			request.getRequestDispatcher("Renewbook.jsp").forward(request, response);	
			return ;
		}
		String bookid=null;
		String arg = null;
		int argv[]=new int[7];
		List list =new ArrayList();
		String sql=null;
		int i=0;
		try 
		{
			while(rs.next())
			{
				 arg=rs.getString("bookid");
				 argv[i]=Integer.valueOf(arg);//获取bookid
				 System.out.print(argv[i]);
				 i++;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		//int j=0;
		for(int j=0;j<i;j++)
		{
			sql="select bookname,typeid,author,translator,ISBN,price,page,bookcase from tb_booked where barcode<="+argv[j]+" and barcoded>="+argv[j]+";";
			rs=jdbcConnection.getResult(sql);
			rs2=jdbcConnection.getResult("select borrowTime,backtime from tb_borrow where bookid='"+argv[j]+"';");
			if(rs==null)
			{
				request.setAttribute("name", Pname);
				request.getRequestDispatcher("Renewbook.jsp").forward(request, response);	
			}
			sql=null;
			try
			{
				item stu2=new item();
				if(rs.next())
				{					
					sql="insert into tb_book(barcode,bookname,typeid,author,translator,ISBN,price,page,bookcase) values('"+argv[j]+"','"+rs.getString(1)+"','"+rs.getInt(2)+"','"+rs.getString(3)+"','"+rs.getString(4)+"','" +rs.getString(5)+"','"+rs.getFloat(6)+"','"+rs.getInt(7)+"','"+rs.getInt(8)+"');";
					
					jdbcConnection.insert(sql);
					stu2.setbarcode(String.valueOf(argv[j]));
					System.out.print(stu2.getbarcode());
					stu2.setName(rs.getString(1));		
					System.out.print(stu2.getName());
					stu2.setPwd(rs.getString(5));
					System.out.print(stu2.getPwd());
					stu2.setID(rs.getInt(8));
					System.out.print(stu2.getID());
				}
				jdbcConnection.insert(sql);
				if(rs2.next())
				{
					stu2.setbborrow(rs2.getDate(1));
					System.out.print(stu2.getborrow());
					stu2.setbacktime(rs2.getDate(2));
					System.out.println(stu2.getbacktime());
				}
				list.add(stu2);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			List.clear();
			List=list;
			for(int k=0;k<list.size();k++)
			{
				item stu2=(item)list.get(k);
				System.out.print(stu2.getbarcode());
				System.out.print(stu2.getName());
				System.out.print(stu2.getPwd());
				System.out.print(stu2.getID());System.out.print(stu2.getborrow());
				System.out.println(stu2.getbacktime());
			}
			request.setAttribute("list2", list);
		}
	}
	
	public void findone2(HttpServletRequest request, HttpServletResponse response)
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
				stu.setBarcode(rs.getString(4));
				stu.setName(rs.getString(2));
				stu.setPaperType(rs.getString(7));
				stu.setVocation(rs.getString(5));
				stu.setSex(rs.getString(3));
				stu.setpaperNO(rs.getString(8));
				stu.setNumber(rs.getInt(15));
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
	
	public void jieyue(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		ResultSet rs=null;
		String select=request.getParameter("select");
		String value=request.getParameter("input");
		String sql = null;
		int option=Integer.valueOf(select);
		switch(option)
		{
			case 1:sql="select barcode,bookname,author,ISBN,storage from tb_book where barcode='"+value+"';";break;
			case 2:sql="select barcode,bookname,author,ISBN,storage from tb_book where bookname like '%"+value+"%';";break;
			case 3:sql="select barcode,bookname,author,ISBN,storage from tb_book where ISBN='"+value+"';";break;
			case 4:sql="select barcode,bookname,author,ISBN,storage from tb_book where author='"+value+"';";break;
		}
		rs=jdbcConnection.getResult(sql);
		List list=new ArrayList();
		if(rs==null)
		{
			request.setAttribute("list4", list);
			request.getRequestDispatcher("jieyue.jsp").forward(request, response);
			return ;
		}
		try
		{
			while(rs.next())
			{
				book book=new book();
				book.setBarcode(rs.getString(1));
				book.setbooknsme(rs.getString(2));
				book.setauthor(rs.getString(3));
				book.setISBN(rs.getString(4));
				book.setbookcase(rs.getInt(5));
				list.add(book);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		List.clear();
		List=list;//list放查到的书
		request.setAttribute("list4", list);		
	}
	
	
	public void borrow(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		ResultSet rs=null;
		String readerid=null;
		Date borrow=null ;
		Date back=null;
		int ID = jdbcConnection.findID("tb_borrow");
		ID++;
//			DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//			try {
//				borrow = sdf.parse("2012-01-01");
//				back=sdf.parse("2012-02-02");
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//			System.out.print(borrow);    
		String bookid=request.getParameter("bookid");
		for(int i=0;i<List.size();i++)
		{
			book g=(book)List.get(i);
			if(g.getBarcode().equals(bookid))
				List.remove(i);
		}
		jdbcConnection.delete("delete from tb_book where barcode='"+bookid+"';");
		rs=jdbcConnection.getResult("select barcode from tb_reader where name='"+Pname+"';");
		try
		{
			if(rs.next())
				readerid=rs.getString(1);
			System.out.print(readerid);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		String sql="insert into tb_borrow(ID,readerid,bookid,operator) values('"+ID+"','"+readerid+"','"+bookid+"','"+Pname+"')";
		jdbcConnection.insert(sql);
	}
	
	public void deletebooks(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		ResultSet rs=null;
		String readerid=null;     
		String bookid=request.getParameter("bookid");
		for(int i=0;i<List.size();i++)
		{
			book g=(book)List.get(i);
			if(g.getBarcode().equals(bookid))
				List.remove(i);
		}
		jdbcConnection.delete("delete from tb_book where barcode='"+bookid+"';");
		rs=jdbcConnection.getResult("select barcode from tb_reader where name='%"+Pname+"%';");
		try
		{
			if(rs.next())
				readerid=rs.getString(1);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		String sql="delete from tb_book where barcode='"+bookid+"';";
		jdbcConnection.delete(sql);
	}
	
	public void updatebooks(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		ResultSet rs=null;
		String readerid=null;     
		String bookid=request.getParameter("bookid");
		String sql="select  barcode,bookname,typeid,author,translator,ISBN,price,page,bookcase,storage from tb_book where barcode='"+bookid+"';";
		rs=jdbcConnection.getResult(sql);
		sql="delete from tb_book where barcode='"+bookid+"';";
		jdbcConnection.delete(sql);
		book book=new book();
		try
		{
			if(rs.next())
			{
				book.setBarcode(rs.getString(1));
				book.setbooknsme(rs.getString(2));
				book.settypeid(rs.getInt(3));
				book.setauthor(rs.getString(4));
				book.settranslator(rs.getString(5));
				book.setISBN(rs.getString(6));
				book.setprice(rs.getFloat(7));
				book.setpage(rs.getInt(8));
				book.setbookcase(rs.getInt(9));
				book.setstorage(rs.getInt(10));
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		for(int i=0;i<List.size();i++)
		{
			book g=(book)List.get(i);
			if(g.getBarcode().equals(bookid))
				List.remove(i);
		}
		request.setAttribute("book", book);
	}
	
	
	public void insertmanager(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String name=request.getParameter("mname");
		String pwd=request.getParameter("mpwd");
		int ID = jdbcConnection.findID("tb_manager");
		ID++;
		String sql="insert into tb_manager(ID,name,pwd) values('"+ID+"','"+name+"','"+pwd+"')";
		jdbcConnection.insert(sql);
	}

			
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String m=request.getParameter("method");
		if("find".equals(m) )
		{
			this.find(request, response);
		}
		else if("insert".equals(m))
		{
			this.insert(request, response);
			request.setAttribute("name", Pname);
			request.getRequestDispatcher("tianjiabook.jsp").forward(request, response);
		}
		else if("insert2".equals(m))
		{
			this.insert2(request, response);
			request.setAttribute("name", Pname);
			request.getRequestDispatcher("tianjianreader.jsp").forward(request, response);
		}
		else if("findbook".equals(m))
		{
			this.findbook(request, response);
			request.setAttribute("name", Pname);
			request.getRequestDispatcher("findbook.jsp").forward(request, response);
		}
		else if("findone".equals(m))
		{
			this.findone(request, response);
			request.setAttribute("name", Pname);
			request.getRequestDispatcher("newbook.jsp").forward(request, response);
		}
		////////////////////////////////////////////////////////////////////
		else if("renewbook".equals(m))
		{
			this.renewbook(request, response);
			request.setAttribute("name", Pname);
			request.setAttribute("list2", List);
			request.getRequestDispatcher("Renewbook.jsp").forward(request, response);
		}
		else if("borrow".equals(m))
		{
			this.borrow(request, response);
			request.setAttribute("list4", List);
			request.setAttribute("name", Pname);
			request.getRequestDispatcher("jieyue.jsp").forward(request, response);
		}
		else if("jieyue".equals(m))
		{
			this.jieyue(request, response);
			request.setAttribute("name", Pname);
			request.getRequestDispatcher("jieyue.jsp").forward(request, response);
		}else if("deletebook".equals(m))
		{
			this.jieyue(request, response);
			request.setAttribute("name", Pname);
			if(List==null)
				request.getRequestDispatcher("deleteBook.jsp").forward(request, response);
			else
				request.getRequestDispatcher("deletebooks.jsp").forward(request, response);
		}else if("deletebooks".equals(m))
		{
			this.deletebooks(request, response);
			request.setAttribute("list4", List);
			request.setAttribute("name", Pname);
			if(List==null)
				request.getRequestDispatcher("deleteBook.jsp").forward(request, response);
			else
				request.getRequestDispatcher("deletebooks.jsp").forward(request, response);
		}else if("updatebook".equals(m))
		{
			this.jieyue(request, response);
			request.setAttribute("name", Pname);
			request.getRequestDispatcher("updatebooks.jsp").forward(request, response);			
		}else if("updatebooks".equals(m))
		{
			this.updatebooks(request, response);
			//request.setAttribute("list4", List);
			request.setAttribute("name", Pname);
			request.getRequestDispatcher("updatebookinformation.jsp").forward(request, response);
		}else if("update".equals(m))
		{
			this.insert(request, response);
			request.setAttribute("list4", List);
			request.setAttribute("name", Pname);
			request.getRequestDispatcher("updatebooks.jsp").forward(request, response);	
		}
		else if("shouye".equals(m))
		{
			request.setAttribute("list1", List2);
			request.setAttribute("list2", List3);
			request.setAttribute("name", Pname);
			if(manager.equals("1"))
				request.getRequestDispatcher("shouye.jsp").forward(request, response);
			else
				request.getRequestDispatcher("satrt.jsp").forward(request, response);
		}
		else if("tianjiabook".equals(m))
		{
			request.setAttribute("name", Pname);
			request.getRequestDispatcher("tianjiabook.jsp").forward(request, response);
		}
		else if("tianjiareader".equals(m))
		{
			request.setAttribute("name", Pname);
			request.getRequestDispatcher("tianjianreader.jsp").forward(request, response);
		}
		else if("findreader".equals(m))
		{
			request.setAttribute("name", Pname);
			request.getRequestDispatcher("readerfind.jsp").forward(request, response);
		}
		else if("findone2".equals(m))
		{
			request.setAttribute("name", Pname);
			this.findone2(request, response);
		}
		else if("bookupdate".equals(m))
		{
			request.setAttribute("name", Pname);
			request.getRequestDispatcher("updatebook.jsp").forward(request, response);
		}
		else if("bookdelete".equals(m))
		{
			request.setAttribute("name", Pname);
			request.getRequestDispatcher("deleteBook.jsp").forward(request, response);
		}
		else if("bookfind".equals(m))
		{
			request.setAttribute("name", Pname);
			request.getRequestDispatcher("find.jsp").forward(request, response);
		}
		else if("bookborrow".equals(m))
		{
			request.setAttribute("name", Pname);
			request.getRequestDispatcher("jieRue.jsp").forward(request, response);			
		}
		else if("booreturn".equals(m))
		{
			request.setAttribute("name", Pname);
			request.getRequestDispatcher("Renewbook.jsp").forward(request, response);	
		}
		else if("manager".equals(m))
		{
			this.insertmanager(request, response);
			request.setAttribute("name", Pname);
			request.getRequestDispatcher("tianjianmanager.jsp").forward(request, response);
		}
		else if("managertianjia".equals(m))
		{
			request.setAttribute("name", Pname);
			request.getRequestDispatcher("tianjianmanager.jsp").forward(request, response);
		}
		else if("deletemanager".equals(m))
		{
			this.deletemanager(request, response);
			request.setAttribute("list", List);
			request.setAttribute("name", Pname);
			request.getRequestDispatcher("deletemanager.jsp").forward(request, response);
		}
		else if("managerdelete".equals(m))
		{
			this.managerdelete(request, response);
			request.setAttribute("list", List);
			request.setAttribute("name", Pname);
			request.getRequestDispatcher("deletemanager.jsp").forward(request, response);
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void deletemanager(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		List.clear();
		ResultSet rs=null;
		String sql;
		sql="select * from tb_manager;";
		rs=jdbcConnection.getResult(sql);
		try
		{
			while(rs.next())
			{
				item obj=new item();
				obj.setName(rs.getString(2));
				obj.setPwd(rs.getString(3));
				List.add(obj);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void managerdelete(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String Name=request.getParameter("name");
		String sql="delete from tb_manager where name='"+Name+"';";
		jdbcConnection.delete(sql);
		for(int i=0;i<List.size();i++)
		{
			item g=(item)List.get(i);
			if(g.getName().equals(Name))
				List.remove(i);
		}
	}
}
