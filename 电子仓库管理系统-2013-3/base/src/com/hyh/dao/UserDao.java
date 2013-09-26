package com.hyh.dao;

import java.util.List;

import com.hyh.vo.user;


/*
 * 用户 dao
 */
public interface UserDao {
	//添加
	public boolean addUser(user user);
	//修改
	public boolean updateUser(user user);
	//删除
	public boolean deleteUser(int id);
	//分页查找
	public List<user> findUser(int page,int size);
	//查询
	public List<user> searchUser(int page,int size,String key);
	//查询记录
	public  int findCount(String key);
	//登录
	public String checkUser(String username,String password);
	//id查找
	public user findUser(int id);
	//查看记录
	public int findCount();
	//增加权限
	public boolean addGrant(String grant,int id);
}
