package com.hyh.DAO;

import com.hyh.Beans.adminuser;

public interface adminuserDAO {
	
	public boolean Check(String username,String password);//����Ա��½����֤
	
	public void Update(String username,String password);//�޸����룬�û���
	
	public void Addadmin(String username, String password);//����
	
	public void Deleteadmin(String username);//ɾ��
}
