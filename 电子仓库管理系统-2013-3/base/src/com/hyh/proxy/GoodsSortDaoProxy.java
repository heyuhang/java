package com.hyh.proxy;

import java.util.List;

import com.hyh.dao.GoodsSortDao;
import com.hyh.daoImpl.GoodsSortDaoImpl;
import com.hyh.db.ConnectionManager;
import com.hyh.db.DataConnection;
import com.hyh.vo.goodssort;

public class GoodsSortDaoProxy implements GoodsSortDao{
	private GoodsSortDao gsdao;
	//private DataConnection dc;
	
	public GoodsSortDaoProxy(){
		//dc=DataConnection.getInstance();
		this.gsdao=new GoodsSortDaoImpl(ConnectionManager.getInstance().getConnection());
	}
	public boolean addGoodsSort(goodssort goodssort) {
		boolean isSuccess=false;
		try{
			isSuccess=this.gsdao.addGoodsSort(goodssort);
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}

	public boolean updateGoodsSort(goodssort goodssort) {
		boolean isSuccess=false;
		try{
			isSuccess=this.gsdao.updateGoodsSort(goodssort);
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}

	public boolean deleteGoodsSort(int id) {
		boolean isSuccess=false;
		try{
			isSuccess=this.gsdao.deleteGoodsSort(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}

	public List<goodssort> findGoodsSort(int page, int size) {
		List<goodssort> list=null;
		try{
			list=this.gsdao.findGoodsSort(page, size);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public List<goodssort> searchGoodsSort(int page, int size, String key) {
		List<goodssort> list=null;
		try{
			list=this.gsdao.searchGoodsSort(page, size, key);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public int findCount(String key) {
		int count=0;
		try{
			count=this.gsdao.findCount(key);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	public goodssort findSort(int id) {
		goodssort goodssort=null;
		try{
			goodssort=this.gsdao.findSort(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return goodssort;
	}
	public int findCount() {
		int count=0;
		try{
			count=this.gsdao.findCount();
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	public List<goodssort> findAll() {
		List<goodssort> list=null;
		try{
			list=this.gsdao.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

}
