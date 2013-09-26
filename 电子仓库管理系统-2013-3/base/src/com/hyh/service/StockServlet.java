package com.hyh.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyh.factory.ServiceFactory;
import com.hyh.vo.stock;

/*
 * 库存管理
 */
public class StockServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action!=null && action.equals("search")){
			this.doSearch(request, response);
		}
	}

	private void doSearch(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String product=request.getParameter("product")!=null?request.getParameter("product"):"";
		String shelf=request.getParameter("shelf")!=null?request.getParameter("shelf"):"";
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );
		int size=10;
		if(page<1){
			page=1;
		}		
		int count=ServiceFactory.getStockInService().findCount(product, shelf);
		int pagesize=0;
		if(count%size>0){
			pagesize=count/size+1;
		}else pagesize=count/size;
		if(pagesize!=0 && page>pagesize){
			page=pagesize;
		}
		List<stock> list=ServiceFactory.getStockInService().searchStock(page, size, product, shelf);
		request.setAttribute("stocks", list);
		request.setAttribute("page", page);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("shelf", shelf);
		request.setAttribute("product", product);
		request.setAttribute("shelf", shelf);
		request.getRequestDispatcher("/sq/stockQuery.jsp").forward(request, response);	
	}
}
