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
import com.hyh.vo.checks;

public class ChecksServlet extends HttpServlet{
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
		if(ServiceFactory.getStockInService().checkNum(num)){
			out.write("true");
		}else{
			out.write("false");
		}
		out.close();	
	}
	private void doSearch(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getInputStream();
		String startDate=request.getParameter("startDate") != null?request.getParameter("startDate"):"";
		String endDate=request.getParameter("endDate") != null?request.getParameter("endDate"):"";
		String shelf=request.getParameter("shelf") != null?request.getParameter("shelf"):"";		
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );
		int size=10;
		if(page<1){
			page=1;
		}		
		int count=ServiceFactory.getChecksService().findCount();
		int pagesize=0;
		if(count%size>0){
			pagesize=count/size+1;
		}else pagesize=count/size;
		if(pagesize!=0 && page>pagesize){
			page=pagesize;
		}
		List<checks> list=null;
		list=ServiceFactory.getChecksService().searchIn(page, size, startDate, endDate, shelf);
		request.setAttribute("checks", list);
		request.setAttribute("page", page);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("shelf", shelf);
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		request.getRequestDispatcher("/sq/checkQuery.jsp").forward(request, response);			
	}

	private void doNum(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String product=request.getParameter("product") != null?request.getParameter("product"):"";
		int count=ServiceFactory.getStockInService().getStockIn(product);
		int cur=ServiceFactory.getStockOutService().getStockOut(product);
		if(cur==-1){
			cur=count;//说明  没出库  盘点为入库数量
		}else cur=count-cur;
		PrintWriter out=response.getWriter();
		out.write(String.valueOf(count)+","+String.valueOf(cur));
		out.close();
	}
	

	private void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String checkId=request.getParameter("checkId") != null?request.getParameter("checkId"):"";
		String createBy=request.getParameter("createBy") != null?request.getParameter("createBy"):"";
		String shelf=request.getParameter("shelf") != null?request.getParameter("shelf"):"";
		String checkDate=request.getParameter("checkDate") != null?request.getParameter("checkDate"):"";
		String createTime=request.getParameter("createTime") != null?request.getParameter("createTime"):"";
		String status=request.getParameter("status") != null?request.getParameter("status"):"";
		String remark=request.getParameter("remark") != null?request.getParameter("remark"):"";
		//获取记录数
		String no=request.getParameter("num") != null?request.getParameter("num"):"0";
		int count=Integer.parseInt(no);		
		List<checks> list=new ArrayList<checks>();
		for(int i=1;i<=count;i++){
			String goods=request.getParameter("productId"+i) != null?request.getParameter("productId"+i):"";
			String qty=request.getParameter("qtys"+i) != null?request.getParameter("qtys"+i):"0";
			String checkQty=request.getParameter("checkQtys"+i) != null?request.getParameter("checkQtys"+i):"0";	
			if(!goods.equals("") && !checkQty.equals("") &&  !qty.equals("") ){
				checks checks=new checks();
				checks.setNum(checkId);
				checks.setCreateby(createBy);
				checks.setShelfname(shelf);
				checks.setCheckdate(checkDate);
				checks.setCreatetime(createTime);
				checks.setState(Integer.parseInt(status));
				checks.setRemark(remark);
				checks.setGoods(goods);
				checks.setNumber(Integer.parseInt(qty));
				checks.setRealnum(Integer.parseInt(checkQty));
				list.add(checks);
			}
		}
		PrintWriter out=response.getWriter();
		if(ServiceFactory.getChecksService().addChecks(list)){
			out.print("<script>alert('提交成功！');history.go(-1);</script>");
		}else out.print("<script>alert('提交失败！');history.go(-1);</script>");
		
		request.getRequestDispatcher("/sm/check.jsp").forward(request, response);	
	}
}
