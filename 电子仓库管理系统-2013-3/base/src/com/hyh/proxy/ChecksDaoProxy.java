package com.hyh.proxy;

import java.util.List;

import com.hyh.dao.ChecksDao;
import com.hyh.daoImpl.ChecksDaoImpl;
import com.hyh.db.ConnectionManager;
import com.hyh.db.DataConnection;
import com.hyh.vo.checks;

public class ChecksDaoProxy implements ChecksDao{

	private ChecksDao checkdao;
	//private DataConnection dc;
	
	public ChecksDaoProxy(){
		//dc=DataConnection.getInstance();
		this.checkdao=new ChecksDaoImpl(ConnectionManager.getInstance().getConnection());
	}
	public boolean addChecks(List<checks> list) {
		try{
			this.checkdao.addChecks(list);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	public List<checks> searchIn(int page, int size, String starDate,
			String endDate, String shelf) {
		List<checks> list=null;
		try{
			list=this.checkdao.searchIn(page, size, starDate, endDate, shelf);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public int findCount() {
		int count = 0;
		try {
			count = this.checkdao.findCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public boolean checkNum(String num) {
		boolean count = false;
		try {
			count = this.checkdao.checkNum(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}
