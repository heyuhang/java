package com.hyh.DAO;

import java.util.List;

import com.hyh.Beans.comment;

public interface commentDAO {

	public void Addcomment(long fileid,long fromid,long toid,String content);//��������
	
	public void Deletecomment(long fileid);//ɾ������
	
	public List FindByfileid(long fileid);//����file�ҵ���������������ݺ������û�

}
