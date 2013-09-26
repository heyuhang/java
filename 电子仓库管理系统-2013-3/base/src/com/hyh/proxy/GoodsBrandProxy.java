package com.hyh.proxy;

import java.util.List;

import com.hyh.dao.GoodsBrandDao;
import com.hyh.daoImpl.GoodsBrandDaoImpl;
import com.hyh.db.ConnectionManager;
import com.hyh.db.DataConnection;
import com.hyh.vo.goodsbrand;

/*
 * 品牌  代理
 */
public class GoodsBrandProxy implements GoodsBrandDao{
	
	private GoodsBrandDao gdao;
	//private DataConnection dc;
	
	public GoodsBrandProxy(){
		//dc=DataConnection.getInstance();
		this.gdao=new GoodsBrandDaoImpl(ConnectionManager.getInstance().getConnection());
	}
	
	public boolean addGoodsBrand(goodsbrand goodsbrand) {
		boolean isSuccess=false;
		try{
			isSuccess=this.gdao.addGoodsBrand(goodsbrand);
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}

	public boolean updateGoodsBrand(goodsbrand goodsbrand) {
		boolean isSuccess=false;
		try{
			isSuccess=this.gdao.updateGoodsBrand(goodsbrand);
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}

	public boolean deleteGoodsBrand(int id) {
		boolean isSuccess=false;
		try{
			isSuccess=this.gdao.deleteGoodsBrand(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}

	public List<goodsbrand> findGoodsBrand(int page, int size) {
		List<goodsbrand> list=null;
		try{
			list=this.gdao.findGoodsBrand(page, size);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public List<goodsbrand> searchGoodsBrand(int page, int size, String key) {
		List<goodsbrand> list=null;
		try{
			list=this.gdao.searchGoodsBrand(page, size, key);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public int findCount(String key) {
		int count=0;
		try{
			count=this.gdao.findCount(key);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

	public goodsbrand findBrand(int id) {
		goodsbrand goodsbrand=null;
		try{
			goodsbrand=this.gdao.findBrand(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return goodsbrand;
	}

	public int findCount() {
		int count=0;
		try{
			count=this.gdao.findCount();
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

	public List<goodsbrand> findAll() {
		List<goodsbrand> list=null;
		try{
			list=this.gdao.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

}
