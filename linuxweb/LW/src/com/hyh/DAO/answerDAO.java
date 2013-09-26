package com.hyh.DAO;

import java.util.List;

import com.hyh.Beans.comment;

public interface answerDAO {

	public void addAnswer(long qaid,long fromid,String content);//��������
	
	public void delAnswer(long qaid);//ɾ������
	
	public List findAnswerByQaid(long qaid);//���file�ҵ��������������ݺ������û�

	public long addApprove(long answerid);//支持一下
}
