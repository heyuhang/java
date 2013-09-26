package com.hyh.dao;

import java.util.List;

import com.hyh.vo.stockout;

/*
 * 出库  数据访问对象
 */
public interface StockOutDao {

	//提交出库
	public boolean addStockOut(List<stockout> list);	
	//获取出库
	public List<stockout> getAll();
	//出库商品  数量
	public int getStockOut(String product);
	
	public int getStockOut(String product,String shelf);
	//查询
	public List<stockout> searchIn(int page,int size,String starDate,String endDate,String vendor);
	//查看总记录
	public int findCount();
	//查找客户
	public String getVendor(String num);
	
	public boolean checkNum(String num);
}
