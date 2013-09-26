package com.hyh.Action;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyh.Beans.qa;
import com.hyh.DAO.QaDAO;
import com.hyh.DAO.filesDAO;
import com.hyh.DAO.userDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class QaUploadAction extends ActionSupport{
	private String label;
	private String text;
	ApplicationContext cxt = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	QaDAO fd = (QaDAO) cxt.getBean("qaService");
	userDAO ss= (userDAO) cxt.getBean("userService"); 
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String execute() throws Exception {
		qa qa=new qa();
		Map m = null;
		m=ActionContext.getContext().getSession();
		long userid=ss.FindId((String)m.get("xiyoulinuxusername"));
		qa.setLabel(label);
		qa.setQuestion(text);
		qa.setUserid(userid);
		fd.addQa(qa);
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		out.print("<script>alert('success,look at linux Q&A!');history.go(-1)</script>");
		out.flush();
		out.close();
		
		return SUCCESS;
	}
}
