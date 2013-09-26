package com.hyh.service;
/*
 * 品牌  管理
 * @author hyh(heyuhang521@gmail.com)
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyh.factory.ServiceFactory;
import com.hyh.vo.goodsbrand;

public class GoodsBrandServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action!=null && action.equals("addbrand")){
			this.doAddBrand(request, response);
		}else if(action!=null && action.equals("delbrand")){
			this.doDelBrand(request, response);
		}else if(action!=null && action.equals("updatebrand")){
			this.doUpdateBrand(request, response);
		}else if(action!=null && action.equals("updatebrandx")){
			this.doUpdateBrandX(request, response);
		}else if(action!=null && action.equals("searchbrand")){
			this.doSearchBrand(request, response);
		}else if(action!=null && action.equals("all")){
			this.doAll(request, response);
		}else{
			this.doBrand(request, response);
		}
	}
	//查看所有
	private void doAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		List<goodsbrand> list=null;
		PrintWriter out=response.getWriter();
		list=ServiceFactory.getGoodsBrandService().findAll();
		StringBuilder str=new StringBuilder();
		
		for(int i=0;i<list.size();i++){
			goodsbrand goods=list.get(i);
			str.append("<option selected='' value="+goods.getId()+'&'+goods.getBrname()+"> "+goods.getBrname()+" </option>");
		}
		out.write(str.toString());
		str.reverse();
	}
	//分页查看
	private void doBrand(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );
		String key=request.getParameter("brandName") != null?request.getParameter("brandName"):"";
		int size=10;
		if(page<1){
			page=1;
		}		
		int count=ServiceFactory.getGoodsBrandService().findCount();
		int pagesize=0;
		if(count%size>0){
			pagesize=count/size+1;
		}else pagesize=count/size;
		if(pagesize!=0 && page>pagesize){
			page=pagesize;
		}
		List<goodsbrand> list=null;
		list=ServiceFactory.getGoodsBrandService().findGoodsBrand(page, size);
		request.setAttribute("brands", list);
		request.setAttribute("page", page);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("action", "");
		request.setAttribute("key", "");
		request.getRequestDispatcher("/bim/brandManagement.jsp").forward(request, response);		
		
	}


	//搜索
	private void doSearchBrand(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException  {
		String key=request.getParameter("brandName") != null?request.getParameter("brandName"):"";
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );
		
		int size=10;
		if(page<1){
			page=1;
		}
		List<goodsbrand> list=null;
		int count=ServiceFactory.getUserService().findCount(key);
		int pagesize=0;
		if(count%size>0){
			pagesize=count/size+1;
		}else pagesize=count/size;
		if(page>pagesize){
			page=pagesize;
		}		
		list=ServiceFactory.getGoodsBrandService().searchGoodsBrand(page, size, key);
		request.setAttribute("brands", list);
		request.setAttribute("page", page);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("action", "searchbrand");
		request.setAttribute("key", key);
		request.getRequestDispatcher("/bim/brandManagement.jsp").forward(request, response);		
		
	}


	//修改
	private void doUpdateBrand(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		int id=Integer.parseInt( (String) (request.getParameter("id") != null?request.getParameter("id"):-1) );
		goodsbrand goodsbrand=null;
		goodsbrand=ServiceFactory.getGoodsBrandService().findBrand(id);
		if(goodsbrand!=null){
			request.setAttribute("goodsbrand", goodsbrand);
			request.getRequestDispatcher("/bim/updateBrand.jsp").forward(request, response);
		}
		
	}
	//修改
	private void doUpdateBrandX(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		int id=Integer.parseInt( (String) (request.getParameter("id") != null?request.getParameter("id"):-1) );
		String brandName=request.getParameter("brandName")!=null?request.getParameter("brandName"):"";
		String comments=request.getParameter("comments")!=null?request.getParameter("comments"):"";
		goodsbrand goodsbrand=new goodsbrand();
		goodsbrand.setId(id);
		goodsbrand.setBrname(brandName);
		goodsbrand.setBrdescription(comments);
		if(ServiceFactory.getGoodsBrandService().updateGoodsBrand(goodsbrand)){
			request.setAttribute("msg", " 修改成功！");
		}else{
			request.setAttribute("msg", " 修改失败！");
		}
		this.doUpdateBrand(request, response);		
	}

	//删除
	private void doDelBrand(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		int id=Integer.parseInt( (String) (request.getParameter("id") != null?request.getParameter("id"):-1) );
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );

		String action2=request.getParameter("action2")!=null?request.getParameter("action2"):"";
		String key=request.getParameter("brandName")!=null?request.getParameter("brandName"):"";
		if(ServiceFactory.getGoodsBrandService().deleteGoodsBrand(id)){
			if(action2.equals("")){
				response.sendRedirect("brand?page="+page);
				return ;
			}
			response.sendRedirect("brand?action=searchbrand&page=1&brandName="+key);			
			
		}
		
	}


	//增加
	private void doAddBrand(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String brandName=request.getParameter("brandName")!=null?request.getParameter("brandName"):"";
		String comments=request.getParameter("comments")!=null?request.getParameter("comments"):"";

		goodsbrand goodsbrand=new goodsbrand();
		goodsbrand.setBrname(brandName);
		goodsbrand.setBrdescription(comments);
		if(ServiceFactory.getGoodsBrandService().addGoodsBrand(goodsbrand)){
			request.setAttribute("msg", "添加成功！");
			
		}else{
			request.setAttribute("msg", "添加失败！");
		}	
		request.getRequestDispatcher("/bim/addBrand.jsp").forward(request, response);		
	}	
}
