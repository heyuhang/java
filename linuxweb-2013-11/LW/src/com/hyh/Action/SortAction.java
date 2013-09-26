package com.hyh.Action;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyh.Beans.*;
import com.hyh.DAO.filesDAO;
import com.hyh.DAO.labelsDAO;
import com.hyh.DAO.userDAO;
import com.hyh.Util.FileAndUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SortAction extends ActionSupport{
	
	
	private List<FileAndUser> fileu;
	private int PageNow=1;
	private int PageSize=10;
	private int TolePage=0;
	private List<labels> labels;
	private String weaphoto;
	private String weatext;
	private String label;
	ApplicationContext cxt = new ClassPathXmlApplicationContext(
		    "applicationContext.xml");
	filesDAO fd=(filesDAO)cxt.getBean("filesService");
	userDAO ud=(userDAO)cxt.getBean("userService");
	labelsDAO ld=(labelsDAO)cxt.getBean("labelsService");
	public String execute()throws Exception{
		List list=fd.FindByPageLabel(PageNow, PageSize,label);
		fileu=new LinkedList<FileAndUser>();
		labels=new LinkedList<labels>();
		List listl=ld.FindAll();
		for(int i=0;i<listl.size();i++){
			labels label=(labels)listl.get(i);
			labels.add(label);
		}
		for(int i=0;i<list.size();i++){
			files file=(files)list.get(i);
			List list2=ud.FindById(file.getUserid());
			user user=(user)list2.get(0);
			FileAndUser files=new FileAndUser();
			files.setId(file.getId());
			files.setName(user.getName());
			files.setHeadpath(user.getHeadpath());
			files.setInterest(user.getInterest());
			files.setUserintr(user.getIntroduct());
			files.setEmail(user.getEmail());
			files.setIntroduct(file.getIntroduct());
			files.setFilepath(file.getFilepath());
			files.setApprove(file.getApprove());

			files.setCommentno(file.getCommentno());
			files.setUploadtime(file.getUploadtime());
			files.setTitle(file.getTitle());
			files.setUserid(file.getUserid());
			files.setLabel(file.getLabel());
			fileu.add(files);
		}
		if(fd.FindCount(label,"sort")%PageSize>0){
			TolePage=fd.FindCount(label,"sort")/PageSize+1;
		}else TolePage=fd.FindCount(label,"sort")/PageSize;
		
		return SUCCESS;
	}
	
	public String getWeaphoto() {
		return weaphoto;
	}

	public void setWeaphoto(String weaphoto) {
		this.weaphoto = weaphoto;
	}

	public String getWeatext() {
		return weatext;
	}

	public void setWeatext(String weatext) {
		this.weatext = weatext;
	}

	public List<FileAndUser> getFileu() {
		return fileu;
	}
	public void setFileu(List<FileAndUser> fileu) {
		this.fileu = fileu;
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
	public List<labels> getLabels() {
		return labels;
	}
	public void setLabels(List<labels> labels) {
		this.labels = labels;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {

			this.label = label;
	}

}
