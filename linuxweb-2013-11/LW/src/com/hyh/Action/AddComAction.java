package com.hyh.Action;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyh.Beans.comment;
import com.hyh.Beans.user;
import com.hyh.DAO.commentDAO;
import com.hyh.DAO.filesDAO;
import com.hyh.DAO.replayDAO;
import com.hyh.DAO.userDAO;
import com.hyh.Util.CommentAndUser;
import com.hyh.Util.TimeUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
public class AddComAction extends ActionSupport{
	
	private long fileid;
	private long toid;
	private String content;
	private String msg;
	private List<CommentAndUser> comments;
	ApplicationContext cxt = new ClassPathXmlApplicationContext(
		    "applicationContext.xml");
	commentDAO cd=(commentDAO)cxt.getBean("commentService");
	userDAO ud=(userDAO)cxt.getBean("userService");
	filesDAO fd=(filesDAO)cxt.getBean("filesService");
	replayDAO rd=(replayDAO)cxt.getBean("replayService");
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
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
	
	public long getToid() {
		return toid;
	}
	public void setToid(long toid) {
		this.toid = toid;
	}
	public String execute() throws Exception {
		Map m;
		m=ActionContext.getContext().getSession();//ȡ��session
	
		long fromid=ud.FindId((String)m.get("xiyoulinuxusername"));
		if(fromid==0){
			msg="";
			return INPUT;			
		}
		cd.Addcomment(fileid, fromid, toid, content);
		fd.UpdateCom(fileid);
		if(toid==-1){
			List fileids=fd.FindByfileid(fileid);
			
			rd.addReplay(fileid,fromid,(Long)fileids.get(0) , content);
		}else{
			rd.addReplay(fileid,fromid,toid , content);
		}

		comments=new LinkedList<CommentAndUser>();
		
		List list=cd.FindByfileid(fileid);
	
			comment c=(comment)list.get(list.size()-1);
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
		
		return SUCCESS;
	}
}
