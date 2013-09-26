package com.hyh.dao;

import java.util.List;

import com.hyh.vo.stock;
import com.hyh.vo.stockin;

/*
 * 入库  dao
 */
public interface StockInDao {

	//提交入库
	public boolean addStockIn(List<stockin> list);
	//获取库存数量
	public int getStockIn(String product,String shelf);
	//获取库存  商品数量
	public int getStockIn(String product);
	//查询
	public List<stockin> searchIn(int page,int size,String starDate,String endDate,String vendor);
	//查看总记录
	public int findCount();
	//搜索库存
	public List<stock> searchStock(int page,int size,String goods,String shelf);
	
	public int findCount(String goods,String shelf);
	
	public boolean checkNum(String num);
}
