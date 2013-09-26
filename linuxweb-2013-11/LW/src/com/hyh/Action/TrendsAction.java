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

public class TrendsAction extends ActionSupport{
	private List<Message> messages;
	private List<Message> dmessages;
	private user user;
	ApplicationContext cxt = new ClassPathXmlApplicationContext(
		    "applicationContext.xml");
	userDAO ud=(userDAO)cxt.getBean("userService");
	attentionDAO ad=(attentionDAO)cxt.getBean("attentionService");
	replayDAO rd=(replayDAO)cxt.getBean("replayService");
	filesDAO fd = (filesDAO) cxt.getBean("filesService");
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public List<Message> getDmessages() {
		return dmessages;
	}

	public void setDmessages(List<Message> dmessages) {
		this.dmessages = dmessages;
	}

	@Override
	public String execute() throws Exception {
		Map m;
		m=ActionContext.getContext().getSession();//取得session
		if( m.get("xiyoulinuxusername") ==null ){
			
			return INPUT;
		}
		List lt=ud.FindByName((String) m.get("xiyoulinuxusername"));
		if(lt.size()>0){
			user=(user)lt.get(0);
		}
		messages=new LinkedList<Message>();
		//根据username  fromid  查找toid消息
		long fromid=ud.FindId((String)m.get("xiyoulinuxusername"));
	
		//查看新回复
		dmessages=new LinkedList<Message>();
		List list2=rd.findRelay(fromid);
		for(int i=list2.size()-1;i>=0;i--){
			replay replay=(replay)list2.get(i);
			Message msg=new Message();
			msg.setId(replay.getId());
			msg.setFileid(replay.getFileid());
			msg.setTitle((String)fd.FindToTitle(replay.getFileid()).get(0));
			msg.setUserid(replay.getFromid());
			msg.setMessage(replay.getContent());
			user user=(user)(ud.FindById(replay.getFromid())).get(0);
			msg.setName(user.getName());
			msg.setHeadpath(user.getHeadpath());
			dmessages.add(msg);
		}
		//rd.delReplay(fromid);
		return SUCCESS;
	}
}
