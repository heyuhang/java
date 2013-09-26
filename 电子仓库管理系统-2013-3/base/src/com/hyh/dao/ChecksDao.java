package com.hyh.dao;

import java.util.List;

import com.hyh.vo.checks;


/*
 * 盘点  数据库对象
 */
public interface ChecksDao {

	//提交盘点
	public boolean addChecks(List<checks> list);
	//查询
	public List<checks> searchIn(int page,int size,String starDate,String endDate,String shelf);
	//查看总记录
	public int findCount();	
	
	public boolean checkNum(String num);
}
