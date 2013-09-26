package com.hyh.Action;
/*
 * 加入新用户Action
 */
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyh.Beans.labels;
import com.hyh.Beans.user;
import com.hyh.DAO.labelsDAO;
import com.hyh.DAO.userDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdduserAction extends ActionSupport{
	private String name;
	private String username;
	private String password;
	private String email;
	private String interest;
	private String introduct;
	private String checkcode;
	private String msg;//传给页面的反馈消息
	private boolean judge;
	ApplicationContext cxt = new ClassPathXmlApplicationContext(
		    "applicationContext.xml");
	userDAO ss= (userDAO) cxt.getBean("userService");
	labelsDAO ld=(labelsDAO)cxt.getBean("labelsService");
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getCheckcode() {
		return checkcode;
	}
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getIntroduct() {
		return introduct;
	}
	public void setIntroduct(String introduct) {
		this.introduct = introduct;
	}
	
	public boolean getJudge() {
		return judge;
	}
	public void setJudge(boolean judge) {
		this.judge = judge;
	}
	public String execute()throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		Map m;
		m=ActionContext.getContext().getSession();//取得session
		String rand=(String)m.get("rand");
		if(!checkcode.equals(rand)){
			out.print("<script>alert('Check Code faild!');history.go(-1)</script>");
			out.flush();
			out.close();
			return INPUT;
		}
		user user=new user();
		user.setName("xiyou_linux");
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setInterest(interest);
		user.setIntroduct(introduct);
		msg="注册成功，可以登录！";
		ss.Adduser(user);

		return SUCCESS;
	}
	public String check(){
		if(ss.CheckUsername(username)){
			judge=false;
		}else{
			judge=true;
		}
		return SUCCESS;
	}
}
