package com.hyh.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyh.factory.ServiceFactory;
import com.hyh.vo.resource;
import com.hyh.vo.user;

/*
 * 资源  服务
 */
public class ResourceServlet extends  HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action!=null && action.equals("addresource")){
			this.doAddResource(request, response);
		}else{
			this.doResource(request, response);
		}
	}
	//分页查看
	protected void doResource(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );
		
		int size=10;
		if(page<1){
			page=1;
		}
		List<resource> list=null;

		int count=ServiceFactory.getResourceService().findCount();
		int pagesize=0;
		if(count%size>0){
			pagesize=count/size+1;
		}else pagesize=count/size;
		if(page>pagesize){
			page=pagesize;
		}
		list=ServiceFactory.getResourceService().findResource(page, size);
		request.setAttribute("page", page);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("resources", list);
		request.getRequestDispatcher("/um/resourceManagement.jsp").forward(request, response);	
		return ;
	}
	
	protected void doAddResource(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String resourceName=request.getParameter("resourceName")!=null?request.getParameter("resourceName"):"";
		String comments=request.getParameter("comments")!=null?request.getParameter("comments"):"";
		String createTime=request.getParameter("createTime")!=null?request.getParameter("createTime"):"";
		String status=request.getParameter("status")!=null?request.getParameter("status"):"";
		
		resource resource=new resource();
		resource.setResname(resourceName);
		resource.setRedescription(comments);
		resource.setCtime(createTime);
		resource.setState(Integer.parseInt(status));
		
		if(ServiceFactory.getResourceService().addResource(resource)){
			response.sendRedirect("resource?page=1");
		}	
	}
}
