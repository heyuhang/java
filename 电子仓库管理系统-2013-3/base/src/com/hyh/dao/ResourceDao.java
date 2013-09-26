package com.hyh.dao;

import java.util.List;

import com.hyh.vo.resource;


/*
 * 资源  dao
 */
public interface ResourceDao {
	//添加
	public boolean addResource(resource resource);
	//修改
	public boolean updateResource(resource resource);
	//删除
	public boolean deleteResource(int id);
	//分页查找
	public List<resource> findResource(int page,int size);
	//资源查询
	public List<resource> searchResource(int page,int size,String key);
	//id查看
	public resource findResource(int id);
	//查看记录
	public int findCount();
}
