package com.hyh.dao;

import java.util.List;

import com.hyh.vo.client;
import com.hyh.vo.goods;

/*
 * 客户  数据层
 */
public interface  ClientDao {
	//添加
	public boolean addClient(client client);
	//修改
	public boolean updateClient(client client);
	//删除
	public boolean deleteClient(int id);
	//分页查找
	public List<client> findClient(int page,int size);
	//查询
	public List<client> searchClient(int page,int size,String key);
	//查询记录
	public  int findCount(String key);
	//id查找
	public client findClient(int id);
	//查看记录
	public int findCount();
	//查询所有
	public List<client> findAll();
}
