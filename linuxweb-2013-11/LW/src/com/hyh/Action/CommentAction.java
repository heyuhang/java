package com.hyh.Action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyh.Beans.comment;
import com.hyh.Beans.user;
import com.hyh.DAO.commentDAO;
import com.hyh.DAO.userDAO;
import com.hyh.Util.CommentAndUser;
import com.hyh.Util.TimeUtil;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial") 
public class CommentAction extends ActionSupport{
	private long id;
	private List<CommentAndUser> comments;
	ApplicationContext cxt = new ClassPathXmlApplicationContext(
		    "applicationContext.xml");
	commentDAO cd=(commentDAO)cxt.getBean("commentService");
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
		
		List list=cd.FindByfileid(id);
		for(int i=0;i<list.size();i++){
			comment c=(comment)list.get(i);
			CommentAndUser cau=new CommentAndUser();
			cau.setComid(c.getId());
			cau.setCommentime(TimeUtil.getTime(c.getCommentime()));
	
			cau.setContent(c.getContent());
			cau.setFileid(c.getFileid());
			cau.setFromid(c.getFromid());
			cau.setToid(c.getToid());
			cau.setName( ( (user)ud.FindById(c.getFromid()).get(0) ).getName());
			if(c.getToid()!=-1){
				cau.setToname( ( (user)ud.FindById(c.getToid()).get(0) ).getName());
			}else{
				cau.setToname(null);
			}
			cau.setHeadpath( ( (user)ud.FindById(c.getFromid()).get(0) ).getHeadpath());
	
			comments.add(cau);
		}
		return SUCCESS;
	}
}
