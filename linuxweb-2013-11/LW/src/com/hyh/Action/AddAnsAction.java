package com.hyh.Action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyh.Beans.answer;
import com.hyh.Beans.comment;
import com.hyh.Beans.user;
import com.hyh.DAO.QaDAO;
import com.hyh.DAO.answerDAO;
import com.hyh.DAO.commentDAO;
import com.hyh.DAO.filesDAO;
import com.hyh.DAO.replayDAO;
import com.hyh.DAO.userDAO;
import com.hyh.Util.CommentAndUser;
import com.hyh.Util.TimeUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
public class AddAnsAction extends ActionSupport{
	
	private long fileid;
	private String content;
	private List<CommentAndUser> comments;
	ApplicationContext cxt = new ClassPathXmlApplicationContext(
		    "applicationContext.xml");
	answerDAO cd=(answerDAO)cxt.getBean("answerService");
	userDAO ud=(userDAO)cxt.getBean("userService");
	QaDAO fd=(QaDAO)cxt.getBean("qaService");
	public long getFileid() {
		return fileid;
	}
	public void setFileid(long fileid) {
		this.fileid = fileid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public List<CommentAndUser> getComments() {
		return comments;
	}
	public void setComments(List<CommentAndUser> comments) {
		this.comments = comments;
	}
	

	public String execute() throws Exception {
		Map m;
		m=ActionContext.getContext().getSession();//ȡ��session
		long fromid=ud.FindId((String)m.get("xiyoulinuxusername"));
		cd.addAnswer(fileid, fromid, content);
		fd.updateAn(fileid);
		comments=new LinkedList<CommentAndUser>();
		
		List list=cd.findAnswerByQaid(fileid);
	
			answer c=(answer)list.get(list.size()-1);
			CommentAndUser cau=new CommentAndUser();
			cau.setComid(c.getId());
			cau.setCommentime(TimeUtil.getTime(c.getAnswertime()));
			cau.setContent(c.getAnswer());
			cau.setFileid(c.getQaid());
			cau.setFromid(c.getFromid());
			cau.setCurid(fromid);
			cau.setName( ( (user)ud.FindById(c.getFromid()).get(0) ).getName());
			cau.setHeadpath( ( (user)ud.FindById(c.getFromid()).get(0) ).getHeadpath());
			
			comments.add(cau);
		
		return SUCCESS;
	}
}
