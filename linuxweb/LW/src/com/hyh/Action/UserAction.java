package com.hyh.Action;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyh.Beans.files;
import com.hyh.Beans.user;
import com.hyh.DAO.attentionDAO;
import com.hyh.DAO.filesDAO;
import com.hyh.DAO.userDAO;
import com.hyh.Util.FileAndUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private List<files> filel;
	private int PageNow=1;
	private int PageSize=5;
	private int TolePage=0;
	private user user;
	private int filesize;
	private int atteno;//��ע����
	private List<user> attention;//��ע����
	ApplicationContext cxt = new ClassPathXmlApplicationContext(
		    "applicationContext.xml");
	filesDAO fd=(filesDAO)cxt.getBean("filesService");
	userDAO ud=(userDAO)cxt.getBean("userService");	
	attentionDAO ad=(attentionDAO)cxt.getBean("attentionService");	
	public String execute()throws Exception{
		Map m;
		m=ActionContext.getContext().getSession();//ȡ��session
		if( m.get("xiyoulinuxusername") ==null ){
			
			return INPUT;
		}
		List list=ud.FindByName((String) m.get("xiyoulinuxusername"));
		if(list.size()>0){
			user=(user)list.get(0);
		}
		//���ҹ�ע
		attention=ad.Findattention(user.getId());
		atteno=attention.size();
		filel=new LinkedList<files>();
		List list2=null;
		if(m.get("xiyou_admin")!=null){
			list2=fd.FindByPage(PageNow, PageSize);
			filesize=fd.FindCount("","index");
		}else{
			list2=fd.FindByPageId(PageNow, PageSize,user.getId());
			filesize=fd.FindCountById(user.getId());
		}
		
		if(list2.size()==0){
			return SUCCESS;
		}
		System.out.println(list2.size());
		for(int i=0;i<list2.size();i++){
			
			files file=(files)list2.get(i);
			filel.add(file);
		}
		if(filesize%PageSize>0){
			TolePage=filesize/PageSize+1;
		}else TolePage=filesize/PageSize;

		return SUCCESS;
	}
	
	public int getAtteno() {
		return atteno;
	}

	public void setAtteno(int atteno) {
		this.atteno = atteno;
	}

	public List<user> getAttention() {
		return attention;
	}

	public void setAttention(List<user> attention) {
		this.attention = attention;
	}

	public List<files> getFilel() {
		return filel;
	}
	public void setFilel(List<files> filel) {
		this.filel = filel;
	}
	public int getPageNow() {
		return PageNow;
	}
	public void setPageNow(int pageNow) {
		PageNow = pageNow;
	}
	public int getPageSize() {
		return PageSize;
	}
	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}
	public int getTolePage() {
		return TolePage;
	}
	public void setTolePage(int tolePage) {
		TolePage = tolePage;
	}
	public user getUser() {
		return user;
	}
	public void setUser(user user) {
		this.user = user;
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}

}
