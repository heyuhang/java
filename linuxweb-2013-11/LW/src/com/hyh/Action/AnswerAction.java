package com.hyh.Action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyh.Beans.answer;
import com.hyh.Beans.comment;
import com.hyh.Beans.user;
import com.hyh.DAO.answerDAO;
import com.hyh.DAO.commentDAO;
import com.hyh.DAO.userDAO;
import com.hyh.Util.CommentAndUser;
import com.hyh.Util.TimeUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial") 
public class AnswerAction extends ActionSupport{
	private long id;
	private List<CommentAndUser> comments;
	ApplicationContext cxt = new ClassPathXmlApplicationContext(
		    "applicationContext.xml");
	answerDAO cd=(answerDAO)cxt.getBean("answerService");
	userDAO ud=(userDAO)cxt.getBean("userService");
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	} 	
	public List<CommentAndUser> getComments() {
		return comments;
	}
	public void setComments(List<CommentAndUser> comments) {
		this.comments = comments;
	}
	public String execute() throws Exception{
		comments=new LinkedList<CommentAndUser>();
		Map m;
		m=ActionContext.getContext().getSession();//取得session
		long userid=ud.FindId((String)m.get("xiyoulinuxusername"));
		List list=cd.findAnswerByQaid(id);
		for(int i=0;i<list.size();i++){
			answer c=(answer)list.get(i);
			CommentAndUser cau=new CommentAndUser();
			cau.setCurid(userid);
			cau.setComid(c.getId());
			cau.setCommentime(TimeUtil.getTime(c.getAnswertime()));
			cau.setApprovano(c.getApprove());
			cau.setContent(c.getAnswer());
			cau.setFileid(c.getQaid());
			cau.setFromid(c.getFromid());
			cau.setName( ( (user)ud.FindById(c.getFromid()).get(0) ).getName());
			cau.setHeadpath( ( (user)ud.FindById(c.getFromid()).get(0) ).getHeadpath());
	
			comments.add(cau);
		}
		return SUCCESS;
	}
}
