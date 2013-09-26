package com.hyh.Action;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyh.Beans.labels;
import com.hyh.DAO.labelsDAO;
import com.hyh.DAO.userDAO;
import com.hyh.Util.adminclass;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LandAction extends ActionSupport{
	private String username;//�û���
	private String password;//����
	private String msg;//����ҳ��ķ�����Ϣ
	private List<labels> labels;
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
	
	
	public String execute()throws Exception{
		Map m;
		m=ActionContext.getContext().getSession();//ȡ��session
		if( m.get("xiyoulinuxusername")!=null && ( (String)m.get("xiyoulinuxusername") ).equals(username)){
			msg="您已经登录！";
			return "input";
		}
		if(username.equals("") || username==null || password.equals("") || password==null){
			msg="用户名或密码不能为空！";
			return "input";
		}
		if(this.ss.Check(username, password) && adminclass.getInstance().getProperty("admin").equals(username) && adminclass.getInstance().getProperty("password").equals(password)){
			m.put("xiyoulinuxusername", username);//���û������session
			m.put("xiyou_admin", username);
			ss.SetOnline(ss.FindId(username));
			msg="登录成功";	//admin登陆
			return "success";
		}else if(this.ss.Check(username, password)){
			m.put("xiyoulinuxusername", username);//���û������session
			ss.SetOnline(ss.FindId(username));
			msg="登录成功";

			return "success";
		}else{ 
			msg="用户名或密码错误!";
			
		}

		return "input";
	}

//	public void validate(){//�����֤
//		if(this.getUsername().equals("") || username==null){
//			addFieldError("username","�û�����Ϊ��!");
//		}
//		if(this.getPassword().equals("") || password==null){
//			addFieldError("password","���벻��Ϊ��!");
//		}
//	}
}
