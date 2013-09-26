package com.hyh.DAO;

import java.util.List;

import com.hyh.Beans.files;

public interface filesDAO {

	public void Addfile(files file);//����files
	
	public boolean Deletefile(long fileid,long userid);//ɾ��
	
	public String findFileName(long fileid);
	
	public boolean DeletefileAdmin(long fileid);//ɾ��
	
	public void Updatefile(files file);//����
	
	public long ApproveFile(long fileid);//��
	
	public List FindById(long filedid);
	
	public void UpdateCom(long fileid);//��������
	
	public List FindByLabel(String Label);//ͨ��label����
	
	public List FindByUser(long userid);//�����û��ļ�
	
	public List FindByfileid(long id);//���id����userid
	
	public List FindToTitle(long id);//���id����Title
	
	public List FindByHot();//���������ļ�
	
	public List FindByNew();//�����ϴ�
	
	public List FindByPage(int PageNow,int PageSize);//��ҳ��ѯ
	
	public int FindCount(String str,String sort);//�鿴��¼��
	
	public int FindCountById(long  userid);//�鿴��¼��
	
	public List FindByPageId(int PageNow,int PageSize,long id);//��ҳ��ѯ
	
	public List FindByPageLabel(int PageNow,int PageSize,String label);//��ҳ��ѯ
	
	public List FindByPageTitle(int PageNow,int PageSize,String title);//��ҳ��ѯ
	
	public void setTop(long fileid);//置顶
	
	public void delTop(long fileid);//取消置顶贴
}
