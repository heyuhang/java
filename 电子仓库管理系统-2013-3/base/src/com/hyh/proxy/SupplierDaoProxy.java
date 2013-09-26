package com.hyh.proxy;

import java.util.List;

import com.hyh.dao.SupplierDao;
import com.hyh.daoImpl.SupplierDaoImpl;
import com.hyh.db.ConnectionManager;
import com.hyh.db.DataConnection;
import com.hyh.vo.supplier;

public class SupplierDaoProxy implements SupplierDao{
	private SupplierDao sudao;
	//private DataConnection dc;

	public SupplierDaoProxy(){
		//dc=DataConnection.getInstance();
		this.sudao=new SupplierDaoImpl(ConnectionManager.getInstance().getConnection());
	}
	public boolean addSupplier(supplier supplier) {
		boolean isSuccess=false;
		try{
			isSuccess=this.sudao.addSupplier(supplier);
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}

	public boolean updateSupplier(supplier supplier) {
		boolean isSuccess=false;
		try{
			isSuccess=this.sudao.updateSupplier(supplier);
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}

	public boolean deleteSupplier(int id) {
		boolean isSuccess=false;
		try{
			isSuccess=this.sudao.deleteSupplier(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}

	public List<supplier> findSupplier(int page, int size) {
		List<supplier> list=null;
		try{
			list=this.sudao.findSupplier(page, size);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public List<supplier> searchSupplier(int page, int size, String key) {
		List<supplier> list=null;
		try{
			list=this.sudao.searchSupplier(page, size, key);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public int findCount(String key) {
		int count=0;
		try{
			count=this.sudao.findCount(key);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	public supplier findVendor(int id) {
		supplier supplier=null;
		try{
			supplier=this.sudao.findVendor(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return supplier;
	}
	public int findCount() {
		int count=0;
		try{
			count=this.sudao.findCount();
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	public List<supplier> findAll() {
		List<supplier> list=null;
		try{
			list=this.sudao.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

}
