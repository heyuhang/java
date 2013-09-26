package com.hyh.DAO;

import com.hyh.Beans.adminuser;

public interface adminuserDAO {
	
	public boolean Check(String username,String password);//管理员登陆，验证
	
	public void Update(String username,String password);//修改密码，用户名
	
	public void Addadmin(String username, String password);//增加
	
	public void Deleteadmin(String username);//删除
}
