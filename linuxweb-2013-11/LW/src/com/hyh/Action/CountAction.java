package com.hyh.Action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyh.DAO.userDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CountAction extends ActionSupport{
	private String oldpassword;
	private String newpassword;
    private long id;
    private String msg;
	ApplicationContext cxt = new ClassPathXmlApplicationContext(
		    "applicationContext.xml");
	userDAO ud=(userDAO)cxt.getBean("userService");
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String execute()throws Exception{

		if(ud.CheckPassword(id, oldpassword)){
			ud.UpdateUP(id, newpassword);
			msg="修改成功！";
		}else{
			msg="修改失败！";
		}
		return SUCCESS;
	}
}
