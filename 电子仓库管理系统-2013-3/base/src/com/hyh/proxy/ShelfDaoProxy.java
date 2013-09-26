package com.hyh.proxy;

import java.util.List;

import com.hyh.dao.ShelfDao;
import com.hyh.daoImpl.ShelfDaoImpl;
import com.hyh.db.ConnectionManager;
import com.hyh.db.DataConnection;
import com.hyh.vo.shelf;

/*
 * 货架  代理
 */
public class ShelfDaoProxy implements ShelfDao{
	private ShelfDao shdao;
	//private DataConnection dc;
	
	public ShelfDaoProxy(){
		//dc=DataConnection.getInstance();
		this.shdao=new ShelfDaoImpl(ConnectionManager.getInstance().getConnection());
	}
	public boolean addShelf(shelf shelf) {
		boolean isSuccess=false;
		try{
			isSuccess=this.shdao.addShelf(shelf);
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}
	public boolean updateShelf(shelf shelf) {
		boolean isSuccess=false;
		try{
			isSuccess=this.shdao.updateShelf(shelf);
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}
	public boolean deleteShelf(int id) {
		boolean isSuccess=false;
		try{
			isSuccess=this.shdao.deleteShelf(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}
	public List<shelf> findShelf(int page, int size) {
		List<shelf> list=null;
		try{
			list=this.shdao.findShelf(page, size);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public List<shelf> searchShelf(int page, int size, String key) {
		List<shelf> list=null;
		try{
			list=this.shdao.searchShelf(page, size, key);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public int findCount(String key) {
		int count=0;
		try{
			count=this.shdao.findCount(key);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	public shelf findShelf(int id) {
		shelf shelf=null;
		try{
			shelf=this.shdao.findShelf(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return shelf;
	}
	public int findCount() {
		int count=0;
		try{
			count=this.shdao.findCount();
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	public List<shelf> findAll() {
		List<shelf> list=null;
		try{
			list=this.shdao.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
