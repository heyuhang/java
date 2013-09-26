package com.hyh.Action;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyh.DAO.attentionDAO;
import com.hyh.DAO.userDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*
 * �ӹ�עAction
 */
public class AttentionAction extends ActionSupport{
	private long toid;//����ע�˵�id
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
		if(( (String)m.get("xiyoulinuxusername") )!=null || !( (String)m.get("xiyoulinuxusername") ).equals("")){
			long fromid=ud.FindId((String)m.get("xiyoulinuxusername"));
			if(fromid==toid){
				msg="不能加自己关注！";
			}else if(ad.isAttention(fromid, toid)){
				msg="您已经加了关注！";
			}else{
				ad.Addattention(fromid, toid);
				msg="关注成功！";
			}
		}else{
			msg="请先登录！";
		}
		return SUCCESS;
	}
}
