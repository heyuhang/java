package com.hyh.proxy;

import java.util.List;

import com.hyh.dao.DeliverDao;
import com.hyh.daoImpl.DeliverDaoImpl;
import com.hyh.db.ConnectionManager;
import com.hyh.db.DataConnection;
import com.hyh.vo.deliver;

public class DeliverDaoProxy implements DeliverDao{
	private DeliverDao deliverdao;
	//private DataConnection dc;
	
	public DeliverDaoProxy(){
		//dc=DataConnection.getInstance();
		this.deliverdao=new DeliverDaoImpl(ConnectionManager.getInstance().getConnection());
	}
	public boolean addDeliver(List<deliver> list) {
		try{
			this.deliverdao.addDeliver(list);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	public List<deliver> searchIn(int page, int size, String starDate,
			String endDate, String city) {
		List<deliver> list=null;
		try{
			list=this.deliverdao.searchIn(page, size, starDate, endDate, city);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public int findCount() {
		int count = 0;
		try {
			count = this.deliverdao.findCount();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return count;
	}
	public boolean checkNum(String num) {
		boolean count = false;
		try {
			count = this.deliverdao.checkNum(num);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return count;
	}

}
