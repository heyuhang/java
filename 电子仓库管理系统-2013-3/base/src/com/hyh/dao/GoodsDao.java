package com.hyh.dao;

import java.util.List;
import com.hyh.vo.goods;
import com.hyh.vo.goodsbrand;

/*
 * 产品 dao
 */
public interface GoodsDao {
	//添加
	public boolean addGoods(goods goods);
	//修改
	public boolean updateGoods(goods goods);
	//删除
	public boolean deleteGoods(int id);
	//分页查找
	public List<goods> findGoods(int page,int size);
	//查询
	public List<goods> searchGoods(int page,int size,String key);
	//查询记录
	public  int findCount(String key);
	//id查找
	public goods findGoods(int id);
	//查看记录
	public int findCount();
	//查看所有
	public List<goods> findAll();
}
