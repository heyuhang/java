package com.hyh.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyh.factory.ServiceFactory;
import com.hyh.vo.section;

public class DepartmentServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action!=null && action.equals("addsection")){
			this.doAddSection(request, response);
		}else if(action!=null && action.equals("updatesection")){
			this.doUpdateSection(request, response);
		}else if(action!=null && action.equals("updatesectionx")){
			this.doUpdateSectionX(request, response);
		}else if(action!=null && action.equals("delsection")){
			this.doDelSection(request, response);
		}else if(action!=null && action.equals("searchsection")){
			this.doSearchSection(request, response);
		}else if(action!=null && action.equals("all")){
			this.doAll(request, response);
		}else{
			this.doSection(request, response);
		}
	}
	//
	protected void doAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<section> list=ServiceFactory.getSectionService().findAll();
		
		PrintWriter out=response.getWriter();
		StringBuilder str=new StringBuilder();
		for(int i=0;i<list.size();i++){
			section section=list.get(i);
			str.append("<option selected='' value="+section.getId()+"&"+section.getSename()+">"+section.getSename()+" </option>");
		}
		out.write(str.toString());
		str.reverse();
	}
	//
	protected void doAddSection(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sename=(String)(request.getParameter("deptName") != null?request.getParameter("deptName"):"");
		String seleader=(String)(request.getParameter("manager") != null?request.getParameter("manager"):"");
		String sedescription=(String)(request.getParameter("comments") != null?request.getParameter("comments"):"");
		String state=(String)(request.getParameter("status") != null?request.getParameter("status"):"");
		section section=new section();

		section.setSename(sename);
		section.setSeleader(seleader);
		section.setSedescription(sedescription);
		section.setState(Integer.parseInt(state));
		if(ServiceFactory.getSectionService().addSection(section)){
			request.setAttribute("msg", "添加成功！");
			request.getRequestDispatcher("/um/addDepartment.jsp").forward(request, response);			
		}
		
	}	
	//淇敼閮ㄩ棬
	protected void doUpdateSection(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id=Integer.parseInt( (String) (request.getParameter("id") != null?request.getParameter("id"):-1) );
		section section=null;
		section=ServiceFactory.getSectionService().findSection(id);
		if(section!=null){
			request.setAttribute("section", section);
			request.getRequestDispatcher("/um/updateDepartment.jsp").forward(request, response);
		}
	}
	//淇敼閮ㄩ棬
	protected void doUpdateSectionX(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id=Integer.parseInt( (String) (request.getParameter("id") != null?request.getParameter("id"):1) );
		
		String sename=(String)(request.getParameter("deptName") != null?request.getParameter("deptName"):"");
		String seleader=(String)(request.getParameter("manager") != null?request.getParameter("manager"):"");
		String sedescription=(String)(request.getParameter("comments") != null?request.getParameter("comments"):"");
		String state=(String)(request.getParameter("status") != null?request.getParameter("status"):"");
		section section=new section();
		section.setId(id);
		section.setSename(sename);
		section.setSeleader(seleader);
		section.setSedescription(sedescription);
		section.setState(Integer.parseInt(state));

		if(ServiceFactory.getSectionService().updateSection(section)){
			request.setAttribute("msg", "修改成功！");
		}else{
			request.setAttribute("msg", "修改失败！");
		}
		this.doUpdateSection(request, response);
	}
	//鍒嗛〉鏌ョ湅
	protected void doSection(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );
		String key=request.getParameter("deptName") != null?request.getParameter("deptName"):"";
		
		int size=10;
		if(page<1){
			page=1;
		}
		List<section> list=null;
		
		int count=ServiceFactory.getSectionService().findCount();
		int pagesize=0;
		if(count%size>0){
			pagesize=count/size+1;
		}else pagesize=count/size;
		if(page>pagesize){
			page=pagesize;
		}
		list=ServiceFactory.getSectionService().findSection(page, size);
		request.setAttribute("page", page);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("sections", list);
		request.setAttribute("action", "");
		request.setAttribute("key", "");
		request.getRequestDispatcher("/um/departmentManagement.jsp").forward(request, response);
	}
	//鍒犻櫎閮ㄩ棬
	protected void doDelSection(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt( (String) (request.getParameter("id") != null?request.getParameter("id"):-1) );
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );

		String action2=request.getParameter("action2")!=null?request.getParameter("action2"):"";
		String key=request.getParameter("deptName")!=null?request.getParameter("deptName"):"";
		if(ServiceFactory.getSectionService().deleteSection(id)){
			if(action2.equals("")){
				response.sendRedirect("section?page="+page);
				return ;
			}
			response.sendRedirect("section?action=searchsection&page=1&deptName="+key);				
		}		
	}
	//鎼滅储閮ㄩ棬
	protected void doSearchSection(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String key=request.getParameter("deptName") != null?request.getParameter("deptName"):"";
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );
		
		int size=10;
		if(page<1){
			page=1;
		}
		int count=ServiceFactory.getSectionService().findCount(key);
		int pagesize=0;
		if(count%size>0){
			pagesize=count/size+1;
		}else pagesize=count/size;
		if(page>pagesize){
			page=pagesize;
		}		
		List<section> list=null;
		list=ServiceFactory.getSectionService().searchSection(page, size, key);
		request.setAttribute("sections", list);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("page", page);
		request.setAttribute("action", "searchsection");
		request.setAttribute("key", key);
		request.getRequestDispatcher("/um/departmentManagement.jsp").forward(request, response);		
	}
}
