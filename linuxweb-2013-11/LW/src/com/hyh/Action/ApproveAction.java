package com.hyh.Action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyh.DAO.QaDAO;
import com.hyh.DAO.filesDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ApproveAction extends ActionSupport{

	private long id;
	private long approve;
	ApplicationContext cxt = new ClassPathXmlApplicationContext(
		    "applicationContext.xml");
	filesDAO fd=(filesDAO)cxt.getBean("filesService");
	QaDAO qa=(QaDAO)cxt.getBean("qaService");
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
		approve=fd.ApproveFile(id);
		return SUCCESS;
	}
	public String support() throws Exception {
		approve=qa.approveQa(id);
		return SUCCESS;
	}
}

