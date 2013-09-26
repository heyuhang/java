package com.hyh.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyh.factory.ServiceFactory;
import com.hyh.vo.stockout;

public class StockOutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action!=null && action.equals("add")){
			this.doAdd(request, response);
		}else if(action!=null && action.equals("num")){
			this.doNum(request, response);
		}else if(action!=null && action.equals("search")){
			this.doSearch(request, response);
		}else if(action!=null && action.equals("check")){
			this.doCheck(request, response);
		}
	}
	//验证编号
	private void doCheck(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String num=request.getParameter("num") != null?request.getParameter("num"):"";
		PrintWriter out=response.getWriter();
		if(ServiceFactory.getStockOutService().checkNum(num)){
			out.write("true");
		}else{
			out.write("false");
		}
		out.close();	
	}
	private void doSearch(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String startDate=request.getParameter("startDate") != null?request.getParameter("startDate"):"";
		String endDate=request.getParameter("endDate") != null?request.getParameter("endDate"):"";
		String vendor=request.getParameter("vendor") != null?request.getParameter("vendor"):"";		
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );
		int size=10;
		if(page<1){
			page=1;
		}		
		int count=ServiceFactory.getStockInService().findCount();
		int pagesize=0;
		if(count%size>0){
			pagesize=count/size+1;
		}else pagesize=count/size;
		if(pagesize!=0 && page>pagesize){
			page=pagesize;
		}
		List<stockout> list=null;
		list=ServiceFactory.getStockOutService().searchIn(page, size, startDate, endDate, vendor);
		request.setAttribute("stockouts", list);
		request.setAttribute("page", page);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("vendor", vendor);
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		request.getRequestDispatcher("/sq/stockOutQuery.jsp").forward(request, response);		
		
	}

	private void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String stockOutType=request.getParameter("stockOutType") != null?request.getParameter("stockOutType"):"";
		String createBy=request.getParameter("createBy") != null?request.getParameter("createBy"):"";
		String customer=request.getParameter("customer") != null?request.getParameter("customer"):"";
		String createTime=request.getParameter("createTime") != null?request.getParameter("createTime"):"0";
		String stockOutDate=request.getParameter("stockOutDate") != null?request.getParameter("stockOutDate"):"";
		String status=request.getParameter("status") != null?request.getParameter("status"):"";
		String remark=request.getParameter("remark") != null?request.getParameter("remark"):"";
		String stockOutId=request.getParameter("stockOutId") != null?request.getParameter("stockOutId"):"";

		//获取记录数
		String no=request.getParameter("num") != null?request.getParameter("num"):"0";
		int count=Integer.parseInt(no);
		List<stockout> list=new ArrayList<stockout>();
		for(int i=1;i<=count;i++){
			String goods=request.getParameter("productId"+i) != null?request.getParameter("productId"+i):"";
			String shelf=request.getParameter("shelfId"+i) != null?request.getParameter("shelfId"+i):"";
			String stockQty=request.getParameter("stockQty"+i) != null?request.getParameter("stockQty"+i):"0";
			String qty=request.getParameter("qty"+i) != null?request.getParameter("qty"+i):"0";			
			if(!goods.equals("") && !shelf.equals("") && !stockQty.equals("") && !qty.equals("") ){
				stockout out=new stockout();
				out.setNum(stockOutId);
				out.setStockouttype(stockOutType);
				out.setCreateby(createBy);
				out.setCreatetime(createTime);
				out.setStockoutdate(stockOutDate);
				out.setVendor(customer);
				out.setRemark(remark);
				out.setState(Integer.parseInt(status));
				out.setGoods(goods);
				out.setShelf(shelf);
				out.setNumber(Integer.parseInt(stockQty)-Integer.parseInt(qty));
				out.setOutnum(Integer.parseInt(qty));
				list.add(out);
			}
		}
		PrintWriter out=response.getWriter();
		if(ServiceFactory.getStockOutService().addStockOut(list)){
			out.print("<script>alert('提交成功！');history.go(-1);</script>");
		}else out.print("<script>alert('提交失败！');history.go(-1);</script>");
		
		request.getRequestDispatcher("/sm/stockOut.jsp").forward(request, response);		
	}
	//获取库存数量
	private void doNum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		String product=request.getParameter("product") != null?request.getParameter("product"):"";
		String shelf=request.getParameter("shelf") != null?request.getParameter("shelf"):"";
		int count=ServiceFactory.getStockOutService().getStockOut(product, shelf);
		if(count==-1)
			count=ServiceFactory.getStockInService().getStockIn(product, shelf);
		PrintWriter out=response.getWriter();
		//System.out.println(count);
		out.write(String.valueOf(count));
	}	
}
