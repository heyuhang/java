package com.hyh.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyh.factory.ServiceFactory;
import com.hyh.vo.shelf;

/*
 * 货架管理
 * 
 */
public class ShelfServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action!=null && action.equals("addshelf")){
			this.doAddShelf(request, response);
		}else if(action!=null && action.equals("delshelf")){
			this.doDelShelf(request, response);
		}else if(action!=null && action.equals("updateshelf")){
			this.doUpdateShelf(request, response);
		}else if(action!=null && action.equals("updateshelfx")){
			this.doUpdateShelfX(request, response);
		}else if(action!=null && action.equals("searchshelf")){
			this.doSearchShelf(request, response);
		}else if(action!=null && action.equals("all")){
			this.doAll(request, response);
		}else{
			this.doShelf(request, response);
		}
	}
	//查看所有
	private void doAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		List<shelf> list=null;
		PrintWriter out=response.getWriter();
		list=ServiceFactory.getShelfService().findAll();
		StringBuilder str=new StringBuilder();
		
		for(int i=0;i<list.size();i++){		
			shelf shelf=list.get(i);
			str.append("<option value="+shelf.getShname()+"> "+shelf.getShname()+" </option>");
		}
		out.write(str.toString());
		str.reverse();
	}
	//分页查询
	private void doShelf(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );
		String key=request.getParameter("customerName") != null?request.getParameter("customerName"):"";
		int size=10;
		if(page<1){
			page=1;
		}		
		int count=ServiceFactory.getShelfService().findCount();
		int pagesize=0;
		if(count%size>0){
			pagesize=count/size+1;
		}else pagesize=count/size;
		if(pagesize!=0 && page>pagesize){
			page=pagesize;
		}
		List<shelf> list=null;
		list=ServiceFactory.getShelfService().findShelf(page, size);
		request.setAttribute("shelfs", list);
		request.setAttribute("page", page);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("action", "");
		request.setAttribute("key", "");
		request.getRequestDispatcher("/bim/shelfManagement.jsp").forward(request, response);			
	}

	//搜索
	private void doSearchShelf(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String key=request.getParameter("shelfName") != null?request.getParameter("shelfName"):"";
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );
		
		int size=10;
		if(page<1){
			page=1;
		}		
		List<shelf> list=null;
		int count=ServiceFactory.getShelfService().findCount(key);
		int pagesize=0;
		if(count%size>0){
			pagesize=count/size+1;
		}else pagesize=count/size;
		if(page>pagesize){
			page=pagesize;
		}		
		list=ServiceFactory.getShelfService().searchShelf(page, size, key);
		request.setAttribute("shelfs", list);
		request.setAttribute("page", page);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("action", "searchshelf");
		request.setAttribute("key", key);
		request.getRequestDispatcher("/bim/shelfManagement.jsp").forward(request, response);			
	}

	//修改
	private void doUpdateShelf(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		int id=Integer.parseInt( (String) (request.getParameter("id") != null?request.getParameter("id"):-1) );
		shelf shelf=null;
		shelf=ServiceFactory.getShelfService().findShelf(id);
		if(shelf!=null){
			request.setAttribute("shelf", shelf);
			request.getRequestDispatcher("/bim/updateShelf.jsp").forward(request, response);
		}				
	}

	//修改
	private void doUpdateShelfX(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		int id=Integer.parseInt( (String) (request.getParameter("id") != null?request.getParameter("id"):-1) );
		String shelfName=request.getParameter("shelfName")!=null?request.getParameter("shelfName"):"";
		String comment=request.getParameter("comment")!=null?request.getParameter("comment"):"";
		String status=request.getParameter("status")!=null?request.getParameter("status"):"";		
		shelf shelf=new shelf();
		shelf.setId(id);
		shelf.setShdescription(comment);
		shelf.setShname(shelfName);
		shelf.setState(Integer.parseInt(status));		
		if(ServiceFactory.getShelfService().updateShelf(shelf)){
			request.setAttribute("msg", " 修改成功！");
		}else{
			request.setAttribute("msg", " 修改失败！");
		}
		this.doUpdateShelf(request, response);			
	}

	//删除
	private void doDelShelf(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		int id=Integer.parseInt( (String) (request.getParameter("id") != null?request.getParameter("id"):-1) );
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );

		String action2=request.getParameter("action2")!=null?request.getParameter("action2"):"";
		String key=request.getParameter("shelfName")!=null?request.getParameter("shelfName"):"";
		if(ServiceFactory.getShelfService().deleteShelf(id)){
			if(action2.equals("")){
				response.sendRedirect("shelf?page="+page);
				return ;
			}
			response.sendRedirect("shelf?action=searchshelf&page=1&shelfName="+key);			
			
		}		
		
	}

	//增加
	private void doAddShelf(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String shelfName=request.getParameter("shelfName")!=null?request.getParameter("shelfName"):"";
		String comment=request.getParameter("comment")!=null?request.getParameter("comment"):"";
		String status=request.getParameter("status")!=null?request.getParameter("status"):"";		
		shelf shelf=new shelf();
		shelf.setShdescription(comment);
		shelf.setShname(shelfName);
		shelf.setState(Integer.parseInt(status));
		if(ServiceFactory.getShelfService().addShelf(shelf)){
			request.setAttribute("msg", "添加成功！");
			
		}else{
			request.setAttribute("msg", "添加失败！");
		}	
		request.getRequestDispatcher("/bim/addShelf.jsp").forward(request, response);		
	}
}
