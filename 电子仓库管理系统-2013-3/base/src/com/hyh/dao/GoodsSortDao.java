package com.hyh.dao;

import java.util.List;

import com.hyh.vo.goodssort;
import com.hyh.vo.user;


/*
 * 商品分类  dao
 */
public interface GoodsSortDao {
	//添加
	public boolean addGoodsSort(goodssort goodssort);
	//修改
	public boolean updateGoodsSort(goodssort goodssort);
	//删除
	public boolean deleteGoodsSort(int id);
	//分页查找
	public List<goodssort> findGoodsSort(int page,int size);
	//查询记录
	public  int findCount(String key);
	//查询
	public List<goodssort> searchGoodsSort(int page,int size,String key);
	//id查找
	public goodssort findSort(int id);
	//查看记录
	public int findCount();
	//查看所有
	public List<goodssort> findAll();
}
