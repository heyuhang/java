package com.hyh.Action;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyh.Beans.attention;
import com.hyh.Beans.replay;
import com.hyh.Beans.user;
import com.hyh.DAO.attentionDAO;
import com.hyh.DAO.filesDAO;
import com.hyh.DAO.replayDAO;
import com.hyh.DAO.userDAO;
import com.hyh.Util.Message;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/*
 * 关注动态
 */
public class MessageAction extends ActionSupport{
	private List<Message> messages;
	private int size;
	ApplicationContext cxt = new ClassPathXmlApplicationContext(
		    "applicationContext.xml");
	userDAO ud=(userDAO)cxt.getBean("userService");
	attentionDAO ad=(attentionDAO)cxt.getBean("attentionService");
	replayDAO rd=(replayDAO)cxt.getBean("replayService");
	filesDAO fd = (filesDAO) cxt.getBean("filesService");
	public List<Message> getMessages() {
		return messages;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	@Override
	public String execute() throws Exception {
		Map m;
		m=ActionContext.getContext().getSession();//取得session
		messages=new LinkedList<Message>();
		//根据username  fromid  查找toid消息
		long fromid=ud.FindId((String)m.get("xiyoulinuxusername"));
		//查看新回复
		List list2=rd.findRelay(fromid);
		for(int i=0;i<list2.size()&&i<6;i++){
			replay replay=(replay)list2.get(i);
			Message msg=new Message();
			msg.setUserid(replay.getToid());
			msg.setMessage(replay.getContent());
			user user=(user)(ud.FindById(replay.getFromid())).get(0);
			msg.setName(user.getName());
			msg.setHeadpath(user.getHeadpath());
			messages.add(msg);
		}
		//rd.delReplay(fromid);
		size=list2.size();
		return SUCCESS;
	}
}
