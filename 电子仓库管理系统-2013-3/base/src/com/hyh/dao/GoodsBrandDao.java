package com.hyh.dao;
/*
 * 品牌  dao
 */
import java.util.List;

import com.hyh.vo.goodsbrand;
import com.hyh.vo.user;

public interface GoodsBrandDao {
	//添加
	public boolean addGoodsBrand(goodsbrand goodsbrand);
	//修改
	public boolean updateGoodsBrand(goodsbrand goodsbrand);
	//删除
	public boolean deleteGoodsBrand(int id);
	//分页查找
	public List<goodsbrand> findGoodsBrand(int page,int size);
	//查询
	public List<goodsbrand> searchGoodsBrand(int page,int size,String key);
	//查询记录
	public  int findCount(String key);
	//id查找
	public goodsbrand findBrand(int id);
	//查看记录
	public int findCount();
	//查看所有
	public List<goodsbrand> findAll();
}
