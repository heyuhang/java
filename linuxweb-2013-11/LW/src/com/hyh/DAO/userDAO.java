package com.hyh.DAO;

import java.util.List;

import com.hyh.Beans.user;

public interface userDAO {

	public void Adduser(user user);//ע��
	
	public boolean Check(String username,String password);//�û���½����֤
	
	public boolean CheckUsername(String username);//��ѯ�û����Ƿ����
	
	public boolean CheckPassword(long id,String password);//��֤����
	
	public void Updateuser(String name,String interest,String introduct,String headpath,long userid);//�޸���Ϣ
	
	public void UpdateUP(long userid, String password);//�޸��˻�
	
	public void Deleteuser(long userid);//ɾ��
	
	public List FindById(long id);
	
	public List FindByName(String username);//��ѯid
	
	public long FindId(String username);
	
	public void SetOnline(long userid);
	
	public void ExitOnline(long userid);

}
