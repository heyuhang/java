package com.hyh.Action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyh.DAO.answerDAO;
import com.hyh.DAO.filesDAO;
import com.opensymphony.xwork2.ActionSupport;

public class SupportAction extends ActionSupport{

	private long id;
	private long approve;
	ApplicationContext cxt = new ClassPathXmlApplicationContext(
		    "applicationContext.xml");
	answerDAO fd=(answerDAO)cxt.getBean("answerService");
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public long getApprove() {
		return approve;
	}
	public void setApprove(long approve) {
		this.approve = approve;
	}
	@Override
	public String execute() throws Exception {
		approve=fd.addApprove(id);
		return SUCCESS;
	}
}

