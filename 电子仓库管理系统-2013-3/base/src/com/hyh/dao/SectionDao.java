package com.hyh.dao;

import java.util.List;

import com.hyh.vo.section;


/*
 * 部门  dao
 */
public interface SectionDao {
	//添加
	public boolean addSection(section section);
	//修改
	public boolean updateSection(section section);
	//删除
	public boolean deleteSection(int id);
	//分页查找
	public List<section> findSection(int page,int size);
	//部门查询
	public List<section> searchSection(int page,int size,String key);
	//查询记录
	public  int findCount(String key);
	//根据id查找
	public section findSection(int id);
	//查看总数
	public int findCount();
	//查看全部
	public List<section> findAll();
	//检查
	public boolean checkSection(String section);
}
