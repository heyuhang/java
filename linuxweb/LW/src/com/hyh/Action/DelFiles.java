package com.hyh.Action;

import java.io.File;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyh.DAO.filesDAO;
import com.hyh.DAO.userDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DelFiles extends ActionSupport{
	private long fileid;
	private String msg;
	ApplicationContext cxt = new ClassPathXmlApplicationContext(
		    "applicationContext.xml");
	filesDAO fd=(filesDAO)cxt.getBean("filesService");
	userDAO ud=(userDAO)cxt.getBean("userService");
	public long getFileid() {
		return fileid;
	}
	public void setFileid(long fileid) {
		this.fileid = fileid;
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
		long userid=ud.FindId((String)m.get("xiyoulinuxusername"));
		String old=fd.findFileName(fileid);
		if( m.get("xiyou_admin")!=null ){
			if(fd.DeletefileAdmin(fileid)){
				if(!old.equals("false")){
					String uploadPath = ServletActionContext.getServletContext()
						.getRealPath("/upload");
					File oldfile=new File(uploadPath+"/"+old);
					oldfile.delete();
				}
				msg="删除成功！";
			}else{
				msg="删除失败！";
			}
		}else if(fd.Deletefile(fileid, userid)){
		
			if(!old.equals("false")){
				String uploadPath = ServletActionContext.getServletContext()
					.getRealPath("/upload");
				File oldfile=new File(uploadPath+old);
				oldfile.delete();
			}
			msg="删除成功！";
		}else{
			msg="删除失败！";
		}
		return SUCCESS;
	}
}
