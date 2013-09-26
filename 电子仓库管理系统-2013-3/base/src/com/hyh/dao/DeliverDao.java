package com.hyh.dao;

import java.util.List;

import com.hyh.vo.deliver;

/*
 * 出货  数据库对象接口
 */
public interface DeliverDao {

	//提交出货
	public boolean addDeliver(List<deliver> list);
	//查询
	public List<deliver> searchIn(int page,int size,String starDate,String endDate,String city);
	//查看总记录
	public int findCount();
	
	public boolean checkNum(String num);
}
