package com.hyh.Action;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyh.DAO.userDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/*
 * ��ȫ�˳�
 */
public class ExitAction extends ActionSupport{
	ApplicationContext cxt = new ClassPathXmlApplicationContext(
		    "applicationContext.xml");
	userDAO ss= (userDAO) cxt.getBean("userService"); 	
	@Override
	public String execute() throws Exception {
		Map m;
		m=ActionContext.getContext().getSession();//ȡ��session
		ss.ExitOnline(ss.FindId((String)m.get("xiyoulinuxusername")));//设置退出状态
		m.clear();
	    HttpServletResponse response = ServletActionContext.getResponse();
    	response.setHeader("Cache-Control","no-cache");
    	response.setHeader("Cache-Control","no-store"); 
    	response.setDateHeader("Expires", 0); 
    	response.setHeader("Pragma","no-cache");

		return SUCCESS;
	}
}
