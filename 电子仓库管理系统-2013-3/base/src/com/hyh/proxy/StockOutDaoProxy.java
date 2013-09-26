package com.hyh.proxy;

import java.util.List;

import com.hyh.dao.StockOutDao;
import com.hyh.daoImpl.StockOutDaoImpl;
import com.hyh.db.ConnectionManager;
import com.hyh.db.DataConnection;
import com.hyh.vo.stockout;
/*
 * 出库  代理
 */
public class StockOutDaoProxy implements StockOutDao{
	private StockOutDao outdao;
	//private DataConnection dc;
	
	public StockOutDaoProxy(){
		//dc=DataConnection.getInstance();
		
		this.outdao=new StockOutDaoImpl(ConnectionManager.getInstance().getConnection()); 
	}
	
	public boolean addStockOut(List<stockout> list) {
		try{
			this.outdao.addStockOut(list);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;		
	}

	public List<stockout> getAll() {
		List<stockout> list=null;
		try{
			list=this.outdao.getAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public int getStockOut(String product) {
		int count=0;
		try{
			count=this.outdao.getStockOut(product);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

	public List<stockout> searchIn(int page, int size, String starDate,
			String endDate, String vendor) {
		List<stockout> list=null;
		try{
			list=this.outdao.searchIn(page, size, starDate, endDate, vendor);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public int findCount() {
		int count = 0;
		try {
			count = this.outdao.findCount();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return count;
	}

	public String getVendor(String num) {
		String vendor =null;
		try {
			vendor = this.outdao.getVendor(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vendor;
	}

	public boolean checkNum(String num) {
		boolean count = false;
		try {
			count = this.outdao.checkNum(num);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return count;
	}

	public int getStockOut(String product, String shelf) {
		int count = 0;
		try {
			count = this.outdao.getStockOut(product, shelf);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return count;
	}

}
