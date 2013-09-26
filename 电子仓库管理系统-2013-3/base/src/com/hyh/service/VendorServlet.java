package com.hyh.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyh.factory.ServiceFactory;
import com.hyh.vo.goodsbrand;
import com.hyh.vo.supplier;

/*
 *	供应商  guanli
 *	@author heyuhang 
 */
public class VendorServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action!=null && action.equals("addvendor")){
			this.doAddVendor(request, response);
		}else if(action!=null && action.equals("delvendor")){
			this.doDelVendor(request, response);
		}else if(action!=null && action.equals("updatevendor")){
			this.doUpdateVendor(request, response);
		}else if(action!=null && action.equals("updatevendorx")){
			this.doUpdateVendorX(request, response);
		}else if(action!=null && action.equals("searchvendor")){
			this.doSearchVendor(request, response);
		}else if(action!=null && action.equals("all")){
			this.doAll(request, response);
		}else{
			this.doVendor(request, response);
		}
	}
	//查看所有
	private void doAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		List<supplier> list=null;
		PrintWriter out=response.getWriter();
		list=ServiceFactory.getSupplierService().findAll();
		StringBuilder str=new StringBuilder();
		
		for(int i=0;i<list.size();i++){
			supplier vendor=list.get(i);
			str.append("<option selected='' value="+vendor.getSuname()+"> "+vendor.getSuname()+" </option>");
		}
		out.write(str.toString());
		str.reverse();
	}
	//分页查找
	private void doVendor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );
		String key=request.getParameter("vendorName") != null?request.getParameter("vendorName"):"";
		int size=10;
		if(page<1){
			page=1;
		}		
		int count=ServiceFactory.getSupplierService().findCount();
		int pagesize=0;
		if(count%size>0){
			pagesize=count/size+1;
		}else pagesize=count/size;
		if(pagesize!=0 && page>pagesize){
			page=pagesize;
		}
		List<supplier> list=null;
		list=ServiceFactory.getSupplierService().findSupplier(page, size);
		request.setAttribute("vendors", list);
		request.setAttribute("page", page);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("action", "");
		request.setAttribute("key", "");
		request.getRequestDispatcher("/bim/vendorManagement.jsp").forward(request, response);			
	}

	//搜索
	private void doSearchVendor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String key=request.getParameter("vendorName") != null?request.getParameter("vendorName"):"";
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );
		
		int size=10;
		if(page<1){
			page=1;
		}
		List<supplier> list=null;
		int count=ServiceFactory.getSupplierService().findCount(key);
		int pagesize=0;
		if(count%size>0){
			pagesize=count/size+1;
		}else pagesize=count/size;
		if(page>pagesize){
			page=pagesize;
		}		
		list=ServiceFactory.getSupplierService().searchSupplier(page, size, key);
		request.setAttribute("vendors", list);
		request.setAttribute("page", page);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("action", "searchvendor");
		request.setAttribute("key", key);
		request.getRequestDispatcher("/bim/vendorManagement.jsp").forward(request, response);		
	}

	//修改
	private void doUpdateVendor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		int id=Integer.parseInt( (String) (request.getParameter("id") != null?request.getParameter("id"):-1) );
		supplier vendor=null;
		vendor=ServiceFactory.getSupplierService().findVendor(id);
		if(vendor!=null){
			request.setAttribute("vendor", vendor);
			request.getRequestDispatcher("/bim/updateVendor.jsp").forward(request, response);
		}
		
	}

	//修改
	private void doUpdateVendorX(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		int id=Integer.parseInt( (String) (request.getParameter("id") != null?request.getParameter("id"):-1) );
		String vendorName=request.getParameter("vendorName")!=null?request.getParameter("vendorName"):"";
		String city=request.getParameter("city")!=null?request.getParameter("city"):"";
		String address=request.getParameter("address")!=null?request.getParameter("address"):"";
		String postcode=request.getParameter("postcode")!=null?request.getParameter("postcode"):"";
		String telphone=request.getParameter("telphone")!=null?request.getParameter("telphone"):"";
		String contact=request.getParameter("contact")!=null?request.getParameter("contact"):"";
		String status=request.getParameter("status")!=null?request.getParameter("status"):"";
		supplier vendor=new supplier();
		vendor.setId(id);
		vendor.setSuname(vendorName);
		vendor.setSucity(city);
		vendor.setAddress(address);
		vendor.setSpost(postcode);
		vendor.setSphone(telphone);
		vendor.setSlpeople(contact);
		vendor.setState(Integer.parseInt(status));
		if(ServiceFactory.getSupplierService().updateSupplier(vendor)){
			request.setAttribute("msg", " 修改成功！");
		}else{
			request.setAttribute("msg", " 修改失败！");
		}
		this.doUpdateVendor(request, response);			
	}

	//删除
	private void doDelVendor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		int id=Integer.parseInt( (String) (request.getParameter("id") != null?request.getParameter("id"):-1) );
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );

		String action2=request.getParameter("action2")!=null?request.getParameter("action2"):"";
		String key=request.getParameter("vendorName")!=null?request.getParameter("vendorName"):"";
		if(ServiceFactory.getSupplierService().deleteSupplier(id)){
			if(action2.equals("")){
				response.sendRedirect("vendor?page="+page);
				return ;
			}
			response.sendRedirect("vendor?action=searchvendor&page=1&vendorName="+key);			
			
		}
		
	}

	//增加
	private void doAddVendor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String vendorName=request.getParameter("vendorName")!=null?request.getParameter("vendorName"):"";
		String city=request.getParameter("city")!=null?request.getParameter("city"):"";
		String address=request.getParameter("address")!=null?request.getParameter("address"):"";
		String postcode=request.getParameter("postcode")!=null?request.getParameter("postcode"):"";
		String telphone=request.getParameter("telphone")!=null?request.getParameter("telphone"):"";
		String contact=request.getParameter("contact")!=null?request.getParameter("contact"):"";
		String status=request.getParameter("status")!=null?request.getParameter("status"):"";
		supplier vendor=new supplier();

		vendor.setSuname(vendorName);
		vendor.setSucity(city);
		vendor.setAddress(address);
		vendor.setSpost(postcode);
		vendor.setSphone(telphone);
		vendor.setSlpeople(contact);
		vendor.setState(Integer.parseInt(status));
		if(ServiceFactory.getSupplierService().addSupplier(vendor)){
			request.setAttribute("msg", "添加成功！");
			
		}else{
			request.setAttribute("msg", "添加失败！");
		}	
		request.getRequestDispatcher("/bim/addVendor.jsp").forward(request, response);		
	}
	
	
}
