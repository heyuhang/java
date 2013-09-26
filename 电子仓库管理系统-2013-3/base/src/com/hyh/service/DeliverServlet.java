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
import com.hyh.vo.deliver;
import com.hyh.vo.stockout;
/*
 * 送货  管理
 */
public class DeliverServlet extends HttpServlet{
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
		}else if(action!=null && action.equals("all")){
			this.doAll(request, response);
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
		String startDate=request.getParameter("startDate") != null?request.getParameter("startDate"):"";
		String endDate=request.getParameter("endDate") != null?request.getParameter("endDate"):"";
		String city=request.getParameter("city") != null?request.getParameter("city"):"";		
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );
		int size=10;
		if(page<1){
			page=1;
		}		
		int count=ServiceFactory.getDeliverService().findCount();
		int pagesize=0;
		if(count%size>0){
			pagesize=count/size+1;
		}else pagesize=count/size;
		if(pagesize!=0 && page>pagesize){
			page=pagesize;
		}
		List<deliver> list=null;
		list=ServiceFactory.getDeliverService().searchIn(page, size, startDate, endDate, city);
		request.setAttribute("delivers", list);
		request.setAttribute("page", page);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("city", city);
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		request.getRequestDispatcher("/sq/deliverQuery.jsp").forward(request, response);		
	}

	private void doAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<stockout> list=null;
		list=ServiceFactory.getStockOutService().getAll();
		StringBuilder str=new StringBuilder();
		PrintWriter out=response.getWriter();
		for(int i=0;i<list.size();i++){
			stockout stockout=list.get(i);
			str.append("<option selected='' value="+stockout.getOutnum()+">"+stockout.getNum()+" </option>");
		}
		out.write(str.toString());
		str.reverse();	
	}

	private void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String createBy=request.getParameter("createBy") != null?request.getParameter("createBy"):"";
		String city=request.getParameter("city") != null?request.getParameter("city"):"";
		String deliverDate=request.getParameter("deliverDate") != null?request.getParameter("deliverDate"):"";
		String createTime=request.getParameter("createTime") != null?request.getParameter("createTime"):"";
		String status=request.getParameter("status") != null?request.getParameter("status"):"";
		String remark=request.getParameter("remark") != null?request.getParameter("remark"):"";
		String deliverId=request.getParameter("deliverId") != null?request.getParameter("deliverId"):"";
		//获取记录数
		String no=request.getParameter("num") != null?request.getParameter("num"):"0";
		int count=Integer.parseInt(no);
		List<deliver> list=new ArrayList<deliver>();
		for(int i=1;i<=count;i++){
			String num=request.getParameter("stockoutId"+i) != null?request.getParameter("stockoutId"+i):"0";
			String number=request.getParameter("qty"+i) != null?request.getParameter("qty"+i):"0";
			if(!num.equals("") && !number.equals("") ){
				deliver deliver=new deliver();
				deliver.setNum(deliverId);
				deliver.setCreateby(createBy);
				deliver.setCity(city);
				deliver.setDeliverdate(deliverDate);
				deliver.setCreatetime(createTime);
				deliver.setState(Integer.parseInt(status));
				deliver.setRemark(remark);
				deliver.setOutid(num);
				deliver.setVendor(deliverId);
				deliver.setNumber(Integer.parseInt(number));
				//客户
				String vendor=ServiceFactory.getStockOutService().getVendor(deliverId);
				deliver.setVendor(vendor);
				list.add(deliver);
			}
		}
		PrintWriter out=response.getWriter();
		if(ServiceFactory.getDeliverService().addDeliver(list)){
			out.print("<script>alert('提交成功！');history.go(-1);</script>");
		}else out.print("<script>alert('提交失败！');history.go(-1);</script>");
		
		request.getRequestDispatcher("/sm/deliver.jsp").forward(request, response);
	}
}
