package com.hyh.DAO;

import java.util.List;

public interface labelsDAO {

	public void Addlabel(String title);//����label
	
	public void Deletelabel(String title);//ɾ��
	
	public void Addcount(String title);//���Ӽ�¼
	
	public void Deletecount(String title);//ɾ����¼
	
	public List FindAll();//��������
	
	public String MatchAdd(String label);//����labelƥ�䣬��ƥ����룬����no��һ
	
	public boolean MatchUtil(String slabel,String dlabel);//ƥ�乤��
}
