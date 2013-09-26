package com.hyh.DAO;

import java.util.List;

public interface attentionDAO {

	public void Addattention(long fromid,long toid);//���ӹ�ע
	
	public boolean Deleteattention(long fromid,long toid);//ȡ���ע
	
	public List Findattention(long fromid);//���ҹ�ע
	
	public boolean isAttention(long fromid,long toid);//�Ƿ��Ѿ���ע
	
	
	public boolean IsNew(long fromid);//�Ƿ����¶�̬
	
	public void UpdateNew(long fromid);//����isnewΪ0
}
