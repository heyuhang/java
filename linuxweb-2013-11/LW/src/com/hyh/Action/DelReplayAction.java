package com.hyh.Action;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyh.DAO.replayDAO;
import com.hyh.DAO.userDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/*
 * ɾ��repaly
 */
public class DelReplayAction extends ActionSupport{
	private long id;
	ApplicationContext cxt = new ClassPathXmlApplicationContext(
		    "applicationContext.xml");
	replayDAO rd=(replayDAO)cxt.getBean("replayService");
	userDAO ud=(userDAO)cxt.getBean("userService");
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String execute() throws Exception {
		rd.delReplay(id);
		return SUCCESS;
	}

	public String delall() throws Exception {
		Map m;
		long id;
		m=ActionContext.getContext().getSession();//session
		id=ud.FindId((String)m.get("xiyoulinuxusername"));
		rd.delAll(id);
		return SUCCESS;
	}
}
