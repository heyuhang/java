package com.hyh.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyh.factory.ServiceFactory;
import com.hyh.vo.client;

/*
 * 客户管理
 * @author hyh
 */
public class CustomerServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action!=null && action.equals("addclient")){
			this.doAddClient(request, response);
		}else if(action!=null && action.equals("delclient")){
			this.doDelClient(request, response);
		}else if(action!=null && action.equals("updateclient")){
			this.doUpdateClient(request, response);
		}else if(action!=null && action.equals("updateclientx")){
			this.doUpdateClientX(request, response);
		}else if(action!=null && action.equals("searchclient")){
			this.doSearchClient(request, response);
		}else if(action!=null && action.equals("all")){
			this.doAll(request, response);
		}else{
			this.doClient(request, response);
		}
	}

	//分页查看
	private void doClient(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );
		String key=request.getParameter("customerName") != null?request.getParameter("customerName"):"";
		int size=10;
		if(page<1){
			page=1;
		}		
		int count=ServiceFactory.getClientService().findCount();
		int pagesize=0;
		if(count%size>0){
			pagesize=count/size+1;
		}else pagesize=count/size;
		if(pagesize!=0 && page>pagesize){
			page=pagesize;
		}
		List<client> list=null;
		list=ServiceFactory.getClientService().findClient(page, size);
		request.setAttribute("clients", list);
		request.setAttribute("page", page);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("action", "");
		request.setAttribute("key", "");
		request.getRequestDispatcher("/bim/customerManagement.jsp").forward(request, response);		
		
	}
	//查看所有
	private void doAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		List<client> list=null;
		PrintWriter out=response.getWriter();
		list=ServiceFactory.getClientService().findAll();
		StringBuilder str=new StringBuilder();
		
		for(int i=0;i<list.size();i++){
			client client=list.get(i);
			str.append("<option selected='' value="+client.getCname()+"> "+client.getCname()+" </option>");			
		}
		out.write(str.toString());
		str.reverse();		
	}
	//搜索
	private void doSearchClient(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String key=request.getParameter("customerName") != null?request.getParameter("customerName"):"";
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );
		
		int size=10;
		if(page<1){
			page=1;
		}
		List<client> list=null;
		int count=ServiceFactory.getClientService().findCount(key);
		int pagesize=0;
		if(count%size>0){
			pagesize=count/size+1;
		}else pagesize=count/size;
		if(page>pagesize){
			page=pagesize;
		}		
		list=ServiceFactory.getClientService().searchClient(page, size, key);
		request.setAttribute("clients", list);
		request.setAttribute("page", page);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("action", "searchclient");
		request.setAttribute("key", key);
		request.getRequestDispatcher("/bim/customerManagement.jsp").forward(request, response);			
	}

	//修改
	private void doUpdateClient(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		int id=Integer.parseInt( (String) (request.getParameter("id") != null?request.getParameter("id"):-1) );
		client client=null;
		client=ServiceFactory.getClientService().findClient(id);
		if(client!=null){
			request.setAttribute("client", client);
			request.getRequestDispatcher("/bim/updateCustomer.jsp").forward(request, response);
		}		
	}

	//修改
	private void doUpdateClientX(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		int id=Integer.parseInt( (String) (request.getParameter("id") != null?request.getParameter("id"):-1) );
		String customerName=request.getParameter("customerName")!=null?request.getParameter("customerName"):"";
		String city=request.getParameter("city")!=null?request.getParameter("city"):"";
		String address=request.getParameter("address")!=null?request.getParameter("address"):"";
		String postcode=request.getParameter("postcode")!=null?request.getParameter("postcode"):"";
		String telphone=request.getParameter("telphone")!=null?request.getParameter("telphone"):"";
		String contact=request.getParameter("contact")!=null?request.getParameter("contact"):"";
		String status=request.getParameter("status")!=null?request.getParameter("status"):"";
		client client=new client();
		client.setId(id);
		client.setCname(customerName);
		client.setCaddress(address);
		client.setCcity(city);
		client.setCpost(postcode);
		client.setCphone(telphone);
		client.setClpeople(contact);
		client.setState(Integer.parseInt(status));
		if(ServiceFactory.getClientService().updateClient(client)){
			request.setAttribute("msg", " 修改成功！");
		}else{
			request.setAttribute("msg", " 修改失败！");
		}
		this.doUpdateClient(request, response);			
	}

	//删除
	private void doDelClient(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		int id=Integer.parseInt( (String) (request.getParameter("id") != null?request.getParameter("id"):-1) );
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );

		String action2=request.getParameter("action2")!=null?request.getParameter("action2"):"";
		String key=request.getParameter("customerName")!=null?request.getParameter("customerName"):"";
		if(ServiceFactory.getClientService().deleteClient(id)){
			if(action2.equals("")){
				response.sendRedirect("client?page="+page);
				return ;
			}
			response.sendRedirect("client?action=searchclient&page=1&customerName="+key);			
			
		}
		
	}

	//增加
	private void doAddClient(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String customerName=request.getParameter("customerName")!=null?request.getParameter("customerName"):"";
		String city=request.getParameter("city")!=null?request.getParameter("city"):"";
		String address=request.getParameter("address")!=null?request.getParameter("address"):"";
		String postcode=request.getParameter("postcode")!=null?request.getParameter("postcode"):"";
		String telphone=request.getParameter("telphone")!=null?request.getParameter("telphone"):"";
		String contact=request.getParameter("contact")!=null?request.getParameter("contact"):"";
		String status=request.getParameter("status")!=null?request.getParameter("status"):"";
		client client=new client();
		
		client.setCname(customerName);
		client.setCaddress(address);
		client.setCcity(city);
		client.setCpost(postcode);
		client.setCphone(telphone);
		client.setClpeople(contact);
		client.setState(Integer.parseInt(status));
		if(ServiceFactory.getClientService().addClient(client)){
			request.setAttribute("msg", "添加成功！");
			
		}else{
			request.setAttribute("msg", "添加失败！");
		}	
		request.getRequestDispatcher("/bim/addCustomer.jsp").forward(request, response);		
		
	}
}
