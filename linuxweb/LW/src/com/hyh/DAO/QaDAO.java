package com.hyh.DAO;

import java.util.List;

import com.hyh.Beans.files;
import com.hyh.Beans.qa;

public interface QaDAO {

	public void addQa(qa qa);//����files
	
	public boolean delAq(long qaid,long userid);//ɾ��
	
	public boolean delQaAdmin(long qaid);//ɾ��
	
	public void upQa(qa qa);//����
	
	public long approveQa(long qaid);//��
	
	public List findQaById(long qaid);
	
	public void updateAn(long qaid);//��������
	
	public List findQaByLabel(String Label);//ͨ��label����
	
	public List findQaByUser(long userid);//�����û��ļ�
	
	public List findQaByQaid(long id);//���id����userid
	
	public List findQaByPage(int PageNow,int PageSize);//��ҳ��ѯ
	
	public int findQaCount(String str,String sort);//�鿴��¼��
	
	public int findQaCountById(long  userid);//�鿴��¼��
	
	public List findQaByPageId(int PageNow,int PageSize,long id);//��ҳ��ѯ
	
	public List findQaByPageLabel(int PageNow,int PageSize,String label);//��ҳ��ѯ
	
	public void setTop(long qaid);//置顶
	
	public void delTop(long qaid);//取消置顶贴
}
