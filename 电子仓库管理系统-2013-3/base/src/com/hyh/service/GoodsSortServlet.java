package com.hyh.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyh.factory.ServiceFactory;
import com.hyh.vo.goodssort;

/*
 * 商品分类管理
 * @author heyuhang 
 */
public class GoodsSortServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action!=null && action.equals("addsort")){
			this.doAddSort(request, response);
		}else if(action!=null && action.equals("delsort")){
			this.doDelSort(request, response);
		}else if(action!=null && action.equals("updatesort")){
			this.doUpdateSort(request, response);
		}else if(action!=null && action.equals("updatesortx")){
			this.doUpdateSortX(request, response);
		}else if(action!=null && action.equals("searchsort")){
			this.doSearchSort(request, response);
		}else if(action!=null && action.equals("all")){
			this.doAll(request, response);
		}else{
			this.doSort(request, response);
		}
	}
	
	protected void doAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<goodssort> list=null;
		PrintWriter out=response.getWriter();
		list=ServiceFactory.getGoodsSortService().findAll();
		StringBuilder str=new StringBuilder();
		
		for(int i=0;i<list.size();i++){
			goodssort goods=list.get(i);
			str.append("<option selected='' value="+goods.getId()+'&'+goods.getSortname()+"> "+goods.getSortname()+" </option>");
		}
		out.write(str.toString());
		str.reverse();
	}
	//增加商品分类
	protected void doAddSort(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String categoryName=request.getParameter("categoryName")!=null?request.getParameter("categoryName"):"";
		int tlevel=Integer.parseInt( (String) (request.getParameter("tlevel") != null?request.getParameter("tlevel"):-1) );
		String parentCategory=request.getParameter("parentCategory")!=null?request.getParameter("parentCategory"):"";
		String status=request.getParameter("status")!=null?request.getParameter("status"):"";
		
		goodssort gsort=new goodssort();
		gsort.setSortname(categoryName);
		gsort.setSortgrade(tlevel);
		gsort.setSortfather(parentCategory);
		gsort.setState(Integer.parseInt(status));
		if(ServiceFactory.getGoodsSortService().addGoodsSort(gsort)){
			request.setAttribute("msg", "添加成功！");
			request.getRequestDispatcher("/bim/addCategory.jsp").forward(request, response);
		}
	}
	//删除分类
	protected void doDelSort(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt( (String) (request.getParameter("id") != null?request.getParameter("id"):-1) );
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );

		String action2=request.getParameter("action2")!=null?request.getParameter("action2"):"";
		String key=request.getParameter("categoryName")!=null?request.getParameter("categoryName"):"";
		if(ServiceFactory.getGoodsSortService().deleteGoodsSort(id)){
			if(action2.equals("")){
				response.sendRedirect("sort?page="+page);
				return ;
			}
			response.sendRedirect("sort?action=searchsort&page=1&categoryName="+key);			
			
		}		
	}
	//修改分类
	protected void doUpdateSort(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt( (String) (request.getParameter("id") != null?request.getParameter("id"):-1) );
		goodssort gsort=null;
		gsort=ServiceFactory.getGoodsSortService().findSort(id);
		if(gsort!=null){
			request.setAttribute("gsort", gsort);
			request.getRequestDispatcher("/bim/updateCategory.jsp").forward(request, response);
		}
	}
	//修改分类
	protected void doUpdateSortX(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt( (String) (request.getParameter("id") != null?request.getParameter("id"):-1) );
		String categoryName=request.getParameter("categoryName")!=null?request.getParameter("categoryName"):"";
		int tlevel=Integer.parseInt( (String) (request.getParameter("tlevel") != null?request.getParameter("tlevel"):-1) );
		String parentCategory=request.getParameter("parentCategory")!=null?request.getParameter("parentCategory"):"";
		String status=request.getParameter("status")!=null?request.getParameter("status"):"";
		
		goodssort gsort=new goodssort();
		gsort.setId(id);
		gsort.setSortname(categoryName);
		gsort.setSortfather(parentCategory);
		gsort.setSortgrade(tlevel);
		gsort.setState(Integer.parseInt(status));
		if(ServiceFactory.getGoodsSortService().updateGoodsSort(gsort)){
			request.setAttribute("msg", "修改成功！");
			
		}else{
			request.setAttribute("msg", "修改失败！");
		}		
		//request.getRequestDispatcher("/bim/updateCategory.jsp").forward(request, response);
		this.doUpdateSort(request, response);
	}
	//分页查看
	protected void doSort(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );
		String key=request.getParameter("categoryName") != null?request.getParameter("categoryName"):"";
		int size=10;
		if(page<1){
			page=1;
		}		
		int count=ServiceFactory.getGoodsSortService().findCount();
		int pagesize=0;
		if(count%size>0){
			pagesize=count/size+1;
		}else pagesize=count/size;
		if(pagesize!=0 && page>pagesize){
			page=pagesize;
		}
		List<goodssort> list=null;
		list=ServiceFactory.getGoodsSortService().findGoodsSort(page, size);
		request.setAttribute("sorts", list);
		request.setAttribute("page", page);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("action", "");
		request.setAttribute("key", "");
		request.getRequestDispatcher("/bim/categoryManagement.jsp").forward(request, response);
		
	}
	//分页搜索
	protected void doSearchSort(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String key=request.getParameter("categoryName") != null?request.getParameter("categoryName"):"";
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );
		
		int size=10;
		if(page<1){
			page=1;
		}	
		List<goodssort> list=null;
		int count=ServiceFactory.getGoodsSortService().findCount(key);
		int pagesize=0;
		if(count%size>0){
			pagesize=count/size+1;
		}else pagesize=count/size;
		if(page>pagesize){
			page=pagesize;
		}		
		list=ServiceFactory.getGoodsSortService().searchGoodsSort(page, size, key);
		request.setAttribute("sorts", list);
		request.setAttribute("page", page);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("action", "searchsort");
		request.setAttribute("key", key);
		request.getRequestDispatcher("/bim/categoryManagement.jsp").forward(request, response);		
	}
}
