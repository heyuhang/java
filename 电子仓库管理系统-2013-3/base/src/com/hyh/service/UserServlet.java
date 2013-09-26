package com.hyh.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyh.factory.ServiceFactory;
import com.hyh.vo.user;

public class UserServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action!=null && action.equals("adduser")){
			this.doAddUser(request, response);
		}else if(action!=null && action.equals("deluser")){
			this.doDelUser(request, response);
		}else if(action!=null && action.equals("lookuser")){
			this.doLookUser(request, response);
		}else if(action!=null && action.equals("updateuserl")){
			this.doUpdateUserl(request, response);
		}else if(action!=null && action.equals("updateuserx")){
			this.doUpdateUserx(request, response);
		}else if(action!=null && action.equals("searchuser")){
			this.doSearchUser(request, response);
		}else if(action!=null && action.equals("grant")){
			this.doGrant(request, response);
		}else{
			this.doUser(request, response);
		}
	}	
	//修改权限
	protected void doGrant(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id") != null?request.getParameter("id"):"0";
		String grant[]=request.getParameterValues("grantsManage");
		StringBuilder str=new StringBuilder();
		for(int i=0;i<grant.length;i++){
			str.append(grant[i]);
			str.append(",");
		}
		if(ServiceFactory.getUserService().addGrant(str.toString(), Integer.parseInt(id))){
			request.setAttribute("msg", "增加成功！");
		}else request.setAttribute("msg", "增加失败！");
			
		request.getRequestDispatcher("/um/grantsManagement.jsp").forward(request, response);
	}
	//查找分页
	protected void doUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );
		String key=request.getParameter("username") != null?request.getParameter("username"):"";
		int size=10;
		if(page<1){
			page=1;
		}
		List<user> list=null;

		int count=ServiceFactory.getUserService().findCount();
		int pagesize=0;
		if(count%size>0){
			pagesize=count/size+1;
		}else pagesize=count/size;
		if(pagesize!=0 && page>pagesize){
			page=pagesize;
		}
		list=ServiceFactory.getUserService().findUser(page, size);
		request.setAttribute("page", page);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("users", list);
		request.setAttribute("action", "");
		request.setAttribute("key", "");
		request.getRequestDispatcher("/um/usersManagement.jsp").forward(request, response);
		return ;		
	}
	//添加用户
	protected void doAddUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=request.getParameter("username")!=null?request.getParameter("username"):"";
		String password=request.getParameter("password")!=null?request.getParameter("password"):"";
		String usertype=request.getParameter("usertype")!=null?request.getParameter("usertype"):"";
		String sectionname=request.getParameter("sectionname")!=null?request.getParameter("sectionname"):"";
		String str[]=sectionname.split("&");
		String email=request.getParameter("email")!=null?request.getParameter("email"):"";
		String ctime=request.getParameter("ctime")!=null?request.getParameter("ctime"):"";
		String state=request.getParameter("state")!=null?request.getParameter("state"):"";
		
		user user=new user();
		user.setUsername(username);
		user.setPassword(password);
		user.setUsertype(usertype);
		user.setSectionid(Integer.parseInt(str[0]));
		user.setSectionname(str[1]);
		user.setEmail(email);
		user.setCtime(ctime);
		user.setOtime(ctime);
		user.setState(Integer.parseInt(state));
		if(usertype.equals("超级管理员"))
			user.setPower("um,bim,sm,sq");
		if(usertype.equals("一般管理员"))
			user.setPower("um");
		if(ServiceFactory.getUserService().addUser(user)){
			request.setAttribute("msg", "添加成功！");
			
		}else{
			request.setAttribute("msg", "添加失败！");
		}	
		request.getRequestDispatcher("/um/addUsers.jsp").forward(request, response);
	}
	//删除
	protected void doDelUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt( (String) (request.getParameter("id") != null?request.getParameter("id"):-1) );
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );

		String action2=request.getParameter("action2")!=null?request.getParameter("action2"):"";
		String key=request.getParameter("username")!=null?request.getParameter("username"):"";
		if(ServiceFactory.getUserService().deleteUser(id)){
			if(action2.equals("")){
				response.sendRedirect("user?page="+page);
				return ;
			}
			response.sendRedirect("user?action=searchuser&page=1&username="+key);			
			
		}
	}
	//详情
	protected void doLookUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt( (String) (request.getParameter("id") != null?request.getParameter("id"):-1) );
		user user=null;
		user=ServiceFactory.getUserService().findUser(id);
		
		if(user!=null){
			request.setAttribute("user", user);
			request.getRequestDispatcher("/um/usersDetail.jsp").forward(request, response);
		}
	}
	//修改
	protected void doUpdateUserl(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt( (String) (request.getParameter("id") != null?request.getParameter("id"):-1) );
		user user=null;
		user=ServiceFactory.getUserService().findUser(id);
		
		if(user!=null){
			request.setAttribute("user", user);
			request.getRequestDispatcher("/um/updateUser.jsp").forward(request, response);
		}
	}
	//修改
	protected void doUpdateUserx(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt( (String) (request.getParameter("id") != null?request.getParameter("id"):-1) );
		String username=request.getParameter("username")!=null?request.getParameter("username"):"";
		String password=request.getParameter("password")!=null?request.getParameter("password"):"";
		String usertype=request.getParameter("usertype")!=null?request.getParameter("usertype"):"";
		String sectionname=request.getParameter("sectionname")!=null?request.getParameter("sectionname"):"";
		String str[]=sectionname.split("&");
		String email=request.getParameter("email")!=null?request.getParameter("email"):"";
		String ctime=request.getParameter("ctime")!=null?request.getParameter("ctime"):"";
		String state=request.getParameter("state")!=null?request.getParameter("state"):"";
		String usertype2=new String(usertype.getBytes("utf-8"));
		user user=new user();
		user.setId(id);
		user.setUsername(username);
		user.setPassword(password);
		user.setUsertype(usertype2);
		user.setSectionid(Integer.parseInt(str[0]));
		user.setSectionname(str[1]);
		user.setEmail(email);
		user.setCtime(ctime);
		user.setOtime(ctime);
		user.setState(Integer.parseInt(state));
		if(ServiceFactory.getUserService().updateUser(user)){
			request.setAttribute("msg", " 修改成功！");
			request.getSession().setAttribute("username", username);
		}else{
			request.setAttribute("msg", " 修改失败！");
		}
		this.doUpdateUserl(request, response);
	}
	//搜索
	protected void doSearchUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String key=request.getParameter("username") != null?request.getParameter("username"):"";
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );
		
		int size=10;
		if(page<1){
			page=1;
		}
		List<user> list=null;
		
		int count=ServiceFactory.getUserService().findCount(key);
		int pagesize=0;
		if(count%size>0){
			pagesize=count/size+1;
		}else pagesize=count/size;
		if(page>pagesize){
			page=pagesize;
		}		
		list=ServiceFactory.getUserService().searchUser(page, size, key);
		request.setAttribute("users", list);
		request.setAttribute("page", page);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("action", "searchuser");
		request.setAttribute("key", key);
		request.getRequestDispatcher("/um/usersManagement.jsp").forward(request, response);
	}
}
