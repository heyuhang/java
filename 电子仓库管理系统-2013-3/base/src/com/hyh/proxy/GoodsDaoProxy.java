package com.hyh.proxy;

import java.util.List;

import com.hyh.dao.GoodsDao;
import com.hyh.daoImpl.GoodsDaoImpl;
import com.hyh.db.ConnectionManager;
import com.hyh.db.DataConnection;
import com.hyh.vo.goods;

/**
 * 商品  代理
 */
public class GoodsDaoProxy implements GoodsDao{
	private GoodsDao gdao;
	//private DataConnection dc;
	
	public GoodsDaoProxy(){
		//dc=DataConnection.getInstance();
		this.gdao=new GoodsDaoImpl(ConnectionManager.getInstance().getConnection());
	}

	public boolean addGoods(goods goods) {
		boolean isSuccess=false;
		try{
			isSuccess=this.gdao.addGoods(goods);
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}

	public boolean updateGoods(goods goods) {
		boolean isSuccess=false;
		try{
			isSuccess=this.gdao.updateGoods(goods);
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}

	public boolean deleteGoods(int id) {
		boolean isSuccess=false;
		try{
			isSuccess=this.gdao.deleteGoods(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}

	public List<goods> findGoods(int page, int size) {
		List<goods> list=null;
		try{
			list=this.gdao.findGoods(page, size);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public List<goods> searchGoods(int page, int size, String key) {
		List<goods> list=null;
		try{
			list=this.gdao.searchGoods(page, size, key);
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

	public goods findGoods(int id) {
		goods goods=null;
		try{
			goods=this.gdao.findGoods(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return goods;
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

	public List<goods> findAll() {
		List<goods> list=null;
		try{
			list=this.gdao.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
