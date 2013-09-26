package com.hyh.dao;

import java.util.List;

import com.hyh.vo.client;
import com.hyh.vo.shelf;


/*
 * 货架  Dao
 */
public interface ShelfDao {
	//添加
	public boolean addShelf(shelf shelf);
	//修改
	public boolean updateShelf(shelf shelf);
	//删除
	public boolean deleteShelf(int id);
	//分页查找
	public List<shelf> findShelf(int page,int size);
	//查询
	public List<shelf> searchShelf(int page,int size,String key);
	//查询记录
	public  int findCount(String key);
	//id查找
	public shelf findShelf(int id);
	//查看记录
	public int findCount();
	//查看所有
	public List<shelf> findAll();
}
