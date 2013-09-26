package com.hyh.proxy;

import java.util.List;

import com.hyh.dao.StockInDao;
import com.hyh.daoImpl.StockInDaoImpl;
import com.hyh.db.ConnectionManager;
import com.hyh.db.DataConnection;
import com.hyh.vo.stock;
import com.hyh.vo.stockin;

/*
 * 入库代理
 */
public class StockInDaoProxy implements StockInDao{

	private StockInDao stockdao;
	//private DataConnection dc;
	
	public StockInDaoProxy(){
		//dc=DataConnection.getInstance();
	
		this.stockdao=new StockInDaoImpl(ConnectionManager.getInstance().getConnection());
	}
	
	public boolean addStockIn(List<stockin> list) {
		try{
			this.stockdao.addStockIn(list);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public int getStockIn(String product, String shelf) {
		int count=0;
		try{
			count=this.stockdao.getStockIn(product, shelf);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

	public int getStockIn(String product) {
		int count=0;
		try{
			count=this.stockdao.getStockIn(product);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

	public List<stockin> searchIn(int page, int size, String starDate,
			String endDate, String vendor) {
		List<stockin> list=null;
		try{
			list=this.stockdao.searchIn(page, size, starDate, endDate, vendor);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public int findCount() {
		int count = 0;
		try {
			count = this.stockdao.findCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<stock> searchStock(int page, int size, String goods,
			String shelf) {
		List<stock> list=null;
		try{
			list=this.stockdao.searchStock(page, size, goods, shelf);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public int findCount(String goods, String shelf) {
		int count = 0;
		try {
			count = this.stockdao.findCount(goods,shelf);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public boolean checkNum(String num) {
		boolean count = false;
		try {
			count = this.stockdao.checkNum(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	
}
