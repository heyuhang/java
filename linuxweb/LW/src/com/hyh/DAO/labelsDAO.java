package com.hyh.DAO;

import java.util.List;

public interface labelsDAO {

	public void Addlabel(String title);//增加label
	
	public void Deletelabel(String title);//删除
	
	public void Addcount(String title);//增加记录
	
	public void Deletecount(String title);//删除记录
	
	public List FindAll();//查找所有
	
	public String MatchAdd(String label);//根据label匹配，无匹配加入，有则no加一
	
	public boolean MatchUtil(String slabel,String dlabel);//匹配工具
}
