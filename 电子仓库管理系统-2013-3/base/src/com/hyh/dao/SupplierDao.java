package com.hyh.dao;
/*
 * 供应商  dao
 */
import java.util.List;

import com.hyh.vo.goods;
import com.hyh.vo.supplier;


public interface SupplierDao {
	//添加
	public boolean addSupplier(supplier supplier);
	//修改
	public boolean updateSupplier(supplier supplier);
	//删除
	public boolean deleteSupplier(int id);
	//分页查找
	public List<supplier> findSupplier(int page,int size);
	//查询
	public List<supplier> searchSupplier(int page,int size,String key);
	//查询记录
	public  int findCount(String key);
	//id查找
	public supplier findVendor(int id);
	//查看记录
	public int findCount();
	//查看全部
	public List<supplier> findAll();
}
