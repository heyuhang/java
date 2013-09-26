package com.hyh.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hyh.factory.ServiceFactory;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action!=null && action.equals("in")){
			this.doLogin(request, response);
		}else{
			this.doOUtLogin(request, response);
		}
	}

	protected void doLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String rands=request.getParameter("rands");
		String rand=(String) request.getSession().getAttribute("rand");
		if(username.equals("") || password.equals("") || rands.equals(""))
		{
			request.setAttribute("error", "用户名、密码、验证码不能为空！");
			request.getRequestDispatcher("index.jsp").forward(request, response);		
			return;
		}
		if(!rands.equals(rand))
		{
			request.setAttribute("error", "验证码错误！");
			request.getRequestDispatcher("index.jsp").forward(request, response);		
			return;			
		}
		String type=ServiceFactory.getUserService().checkUser(username, password);
		if(type!=null && type.indexOf("sm")<type.length() && type.indexOf("sm")>=0){

			request.getSession().setAttribute("sm", "ok");
		}
		if(type!=null && type.indexOf("bim")<type.length() && type.indexOf("bim")>=0){

			request.getSession().setAttribute("bim", "ok");			
		}
		if(type!=null && type.indexOf("sq")<type.length() && type.indexOf("sq")>=0){
			//一般用户
			request.getSession().setAttribute("sq", "ok");		
		}
		if(type!=null && type.indexOf("um")<type.length() && type.indexOf("um")>=0){
			//一般用户
			request.getSession().setAttribute("um", "ok");		
		}
		if(type!=null){
			//request.getRequestDispatcher("common/mainpage.html").forward(request, response);
			request.getSession().setAttribute("username", username);
			response.sendRedirect("common/mainpage.html");
			return ;
		}else{
			request.setAttribute("error", "用户名或密码错误！");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

	protected void doOUtLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession  session=request.getSession();
		session.removeAttribute("username");
		session.removeAttribute("sm");
		session.removeAttribute("bim");
		session.removeAttribute("sq");
		session.removeAttribute("um");
		session.invalidate();
		PrintWriter out=response.getWriter();
		out.print("<script>alert('成功退出！');</script>");
		out.print("<script>parent.window.location = 'index.jsp';</script>");
	}
}
