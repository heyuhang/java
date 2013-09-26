package com.hyh.Action;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyh.Beans.user;
import com.hyh.DAO.attentionDAO;
import com.hyh.DAO.userDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*
 * ȡ���ע
 */
public class CancleattAction extends ActionSupport{
	private long toid;
	private String msg;
	ApplicationContext cxt = new ClassPathXmlApplicationContext(
		    "applicationContext.xml");
	attentionDAO ad=(attentionDAO)cxt.getBean("attentionService");
	userDAO ud=(userDAO)cxt.getBean("userService");	
	public long getToid() {
		return toid;
	}
	public void setToid(long toid) {
		this.toid = toid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}	
	@Override
	public String execute() throws Exception {
		Map m;
		m=ActionContext.getContext().getSession();//ȡ��session
		List list=ud.FindByName((String) m.get("xiyoulinuxusername"));
		if(list.size()>0){

			if(ad.Deleteattention(((user)list.get(0)).getId(), toid)){
				msg="成功取消关注";
			}else{
				msg="取消关注失败";
			}
		}
		return SUCCESS;
	}
}
