package com.hyh.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyh.factory.ServiceFactory;
import com.hyh.vo.goods;

/*
 * 商品  管理
 * @author hyh()
 */
public class GoodsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action!=null && action.equals("addgoods")){
			this.doAddGoods(request, response);
		}else if(action!=null && action.equals("delgoods")){
			this.doDelGoods(request, response);
		}else if(action!=null && action.equals("updategoods")){
			this.doUpdateGoods(request, response);
		}else if(action!=null && action.equals("updategoodsx")){
			this.doUpdateGoodsX(request, response);
		}else if(action!=null && action.equals("searchgoods")){
			this.doSearchGoods(request, response);
		}else if(action!=null && action.equals("lookgoods")){
			this.doLookGoods(request, response);
		}else if(action!=null && action.equals("all")){
			this.doAll(request, response);
		}else{
			this.doGoods(request, response);
		}
	}
	//查看所有
	private void doAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		List<goods> list=null;
		PrintWriter out=response.getWriter();
		list=ServiceFactory.getGoodsService().findAll();
		StringBuilder str=new StringBuilder();
		
		for(int i=0;i<list.size();i++){
			goods goods=list.get(i);
			str.append("<option value="+goods.getGname()+"> "+goods.getGname()+" </option>");
		}
		out.write(str.toString());
		str.reverse();
		
	}
	//分页查看
	private void doGoods(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );
		String key=request.getParameter("brandName") != null?request.getParameter("brandName"):"";
		int size=10;
		if(page<1){
			page=1;
		}		
		int count=ServiceFactory.getGoodsService().findCount();
		int pagesize=0;
		if(count%size>0){
			pagesize=count/size+1;
		}else pagesize=count/size;
		if(pagesize!=0 && page>pagesize){
			page=pagesize;
		}
		List<goods> list=null;
		list=ServiceFactory.getGoodsService().findGoods(page, size);
		request.setAttribute("goods", list);
		request.setAttribute("page", page);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("action", "");
		request.setAttribute("key", "");
		request.getRequestDispatcher("/bim/productManagement.jsp").forward(request, response);			
	}

	//详情
	private void doLookGoods(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		
	}

	//搜索
	private void doSearchGoods(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );
		String key=request.getParameter("brandName") != null?request.getParameter("brandName"):"";
		int size=10;
		if(page<1){
			page=1;
		}		
		int count=ServiceFactory.getGoodsService().findCount(key);
		int pagesize=0;
		if(count%size>0){
			pagesize=count/size+1;
		}else pagesize=count/size;
		if(pagesize!=0 && page>pagesize){
			page=pagesize;
		}
		List<goods> list=null;
		list=ServiceFactory.getGoodsService().searchGoods(page, size,key);
		request.setAttribute("goods", list);
		request.setAttribute("page", page);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("action", "");
		request.setAttribute("key", "");
		request.setAttribute("action", "searchgoods");
		request.getRequestDispatcher("/bim/productManagement.jsp").forward(request, response);		
		
	}
	//修改
	private void doUpdateGoods(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		int id=Integer.parseInt( (String) (request.getParameter("id") != null?request.getParameter("id"):-1) );
		goods goods=null;
		goods=ServiceFactory.getGoodsService().findGoods(id);
		if(goods!=null){
			request.setAttribute("goods", goods);
			request.getRequestDispatcher("/bim/updateProduct.jsp").forward(request, response);
		}		
		
	}
	//修改
	private void doUpdateGoodsX(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		int id=Integer.parseInt( (String) (request.getParameter("id") != null?request.getParameter("id"):-1) );
		String productName=request.getParameter("productName")!=null?request.getParameter("productName"):"";
		String barcode=request.getParameter("barcode")!=null?request.getParameter("barcode"):"";
		String category=request.getParameter("category")!=null?request.getParameter("category"):"";
		String brand=request.getParameter("brand")!=null?request.getParameter("brand"):"";
		String specification=request.getParameter("specification")!=null?request.getParameter("specification"):"";
		String threshold=request.getParameter("threshold")!=null?request.getParameter("threshold"):"";
		String description=request.getParameter("description")!=null?request.getParameter("description"):"";
		String createTime=request.getParameter("createTime")!=null?request.getParameter("createTime"):"";
		String status=request.getParameter("status")!=null?request.getParameter("status"):"";
		goods goods=new goods();
		//缺少id
		goods.setBrandid(id);
		goods.setGname(productName);
		goods.setGcode(barcode);
		goods.setSortid(1);
		goods.setSort(category);
		goods.setBrandid(1);
		goods.setBrand(brand);
		goods.setMarker(specification);
		goods.setLimitvalue(Integer.parseInt(threshold));
		goods.setGdescription(description);
		goods.setCtime(createTime);
		goods.setState(Integer.parseInt(status));
		if(ServiceFactory.getGoodsService().updateGoods(goods)){
			request.setAttribute("msg", " 修改成功！");
		}else{
			request.setAttribute("msg", " 修改失败！");
		}
		this.doUpdateGoods(request, response);	
	}
	//删除
	private void doDelGoods(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		int id=Integer.parseInt( (String) (request.getParameter("id") != null?request.getParameter("id"):-1) );
		int page=Integer.parseInt( (String) (request.getParameter("page") != null?request.getParameter("page"):1) );

		String action2=request.getParameter("action2")!=null?request.getParameter("action2"):"";
		String key=request.getParameter("productName")!=null?request.getParameter("productName"):"";
		if(ServiceFactory.getGoodsService().deleteGoods(id)){
			if(action2.equals("")){
				response.sendRedirect("goods?page="+page);
				return ;
			}
			response.sendRedirect("goods?action=searchgoods&page=1&productName="+key);			
			
		}
		
	}

	//添加
	private void doAddGoods(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String productName=request.getParameter("productName")!=null?request.getParameter("productName"):"";
		String barcode=request.getParameter("barcode")!=null?request.getParameter("barcode"):"";
		String category=request.getParameter("category")!=null?request.getParameter("category"):"";
		String brand=request.getParameter("brand")!=null?request.getParameter("brand"):"";
		String specification=request.getParameter("specification")!=null?request.getParameter("specification"):"";
		String threshold=request.getParameter("threshold")!=null?request.getParameter("threshold"):"";
		String description=request.getParameter("description")!=null?request.getParameter("description"):"";
		String createTime=request.getParameter("createTime")!=null?request.getParameter("createTime"):"";
		String status=request.getParameter("status")!=null?request.getParameter("status"):"";
		String brands[]=brand.split("&");
		String sorts[]=category.split("&");
		goods goods=new goods();
		//缺少id
		goods.setGname(productName);
		goods.setGcode(barcode);
		goods.setSortid(Integer.parseInt(sorts[0]));
		goods.setSort(sorts[1]);
		goods.setBrandid(Integer.parseInt(brands[0]));
		goods.setBrand(brands[1]);
		goods.setMarker(specification);
		goods.setLimitvalue(Integer.parseInt(threshold));
		goods.setGdescription(description);
		goods.setCtime(createTime);
		goods.setState(Integer.parseInt(status));
		if(ServiceFactory.getGoodsService().addGoods(goods)){
			request.setAttribute("msg", "添加成功！");
			
		}else{
			request.setAttribute("msg", "添加失败！");
		}	
		request.getRequestDispatcher("/bim/addProduct.jsp").forward(request, response);	
		
	}	
	
}
