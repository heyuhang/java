package com.hyh.DAO;

import java.util.List;

import com.hyh.Beans.comment;

public interface commentDAO {

	public void Addcomment(long fileid,long fromid,long toid,String content);//增加评论
	
	public void Deletecomment(long fileid);//删除评论
	
	public List FindByfileid(long fileid);//根据file找到他的相关评论内容和评论用户

}
