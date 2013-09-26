package com.hyh.Action;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.hyh.DAO.filesDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SetTopAction extends ActionSupport{
	private long fileid;
	ApplicationContext cxt = new ClassPathXmlApplicationContext(
		    "applicationContext.xml");
	filesDAO fd=(filesDAO)cxt.getBean("filesService");
	public long getFileid() {
		return fileid;
	}
	public void setFileid(long fileid) {
		this.fileid = fileid;
	}
	public String settop() throws Exception {//置顶
		fd.setTop(fileid);
		return SUCCESS;
	}
	public String deltop() throws Exception {//取消置顶
		fd.delTop(fileid);	
		return SUCCESS;
	}
}
