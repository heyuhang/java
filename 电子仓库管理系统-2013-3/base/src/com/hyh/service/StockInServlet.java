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
import com.hyh.vo.stockin;

/*
 * 入库  业务逻辑
 */
public class StockInServlet extends HttpServlet{

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
		if(ServiceFactory.getStockInService().checkNum(num)){
			out.write("true");
		}else{
			out.write("false");
		}
		out.close();	
	}

	//入库
	protected void doAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String stockInDate=request.getParameter("stockInDate") != null?request.getParameter("stockInDate"):"";
		String stockInType=request.getParameter("stockInType") != null?request.getParameter("stockInType"):"";
		String batchNo=request.getParameter("batchNo") != null?request.getParameter("batchNo"):"0";
		String createBy=request.getParameter("createBy") != null?request.getParameter("createBy"):"0";
		String createTime=request.getParameter("createTime") != null?request.getParameter("createTime"):"";
		String vendor=request.getParameter("vendor") != null?request.getParameter("vendor"):"";
		String status=request.getParameter("status") != null?request.getParameter("status"):"";
		String remark=request.getParameter("remark") != null?request.getParameter("remark"):"";
		String stockInId=request.getParameter("stockInId") != null?request.getParameter("stockInId"):"";

		//获取记录数
		String no=request.getParameter("num") != null?request.getParameter("num"):"0";
		int count=Integer.parseInt(no);
		List<stockin> list=new ArrayList<stockin>();
		for(int i=1;i<=count;i++){
			String goods=request.getParameter("productId"+i) != null?request.getParameter("productId"+i):"";
			String shelf=request.getParameter("shelfId"+i) != null?request.getParameter("shelfId"+i):"";
			String num=request.getParameter("qty"+i) != null?request.getParameter("qty"+i):"0";
			if(!goods.equals("") && !shelf.equals("") && !num.equals("") ){
				stockin in=new stockin();
				in.setNum(stockInId);
				in.setStockindate(stockInDate);
				in.setStockintype(stockInType);
				in.setBatchno(Integer.parseInt(batchNo));
				in.setCreateby(createBy);
				in.setCreatetime(createTime);
				in.setVendor(vendor);
				in.setState(Integer.parseInt(status));
				in.setRemark(remark);
				in.setGoods(goods);
				in.setShelf(shelf);
				in.setNumber(Integer.parseInt(num));
				list.add(in);
			}
		}
		PrintWriter out=response.getWriter();
		if(ServiceFactory.getStockInService().addStockIn(list)){
			
			out.print("<script>alert('提交成功！');</script>");
		}else out.print("<script>alert('提交失败！');</script>");
		
		request.getRequestDispatcher("/sm/stockIn.jsp").forward(request, response);
	}
	
	protected void doSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		List<stockin> list=null;
		list=ServiceFactory.getStockInService().searchIn(page, size, startDate, endDate, vendor);
		request.setAttribute("stockins", list);
		request.setAttribute("page", page);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("vendor", vendor);
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		request.getRequestDispatcher("/sq/stockInQuery.jsp").forward(request, response);	
	}
}
