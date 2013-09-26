package com.hyh.Action;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyh.Beans.*;
import com.hyh.DAO.attentionDAO;
import com.hyh.DAO.filesDAO;
import com.hyh.DAO.labelsDAO;
import com.hyh.DAO.replayDAO;
import com.hyh.DAO.userDAO;
import com.hyh.Util.FileAndUser;
import com.hyh.Util.FileComparable;
import com.hyh.Util.Message;
import com.hyh.Util.TimeUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport{
	
	private List<FileAndUser> fileu;
	private int PageNow=1;
	private int PageSize=10;
	private int TolePage=0;
	private List<labels> labels;
	private String weaphoto;
	private String weatext;
	private boolean msg;
	ApplicationContext cxt = new ClassPathXmlApplicationContext(
		    "applicationContext.xml");
	filesDAO fd=(filesDAO)cxt.getBean("filesService");
	userDAO ud=(userDAO)cxt.getBean("userService");
	labelsDAO ld=(labelsDAO)cxt.getBean("labelsService");
	attentionDAO ad=(attentionDAO)cxt.getBean("attentionService");
	replayDAO rd=(replayDAO)cxt.getBean("replayService");
	public String execute()throws Exception{
		List list=fd.FindByPage(PageNow, PageSize);
		
		fileu=new LinkedList<FileAndUser>();
		labels=new LinkedList<labels>();
		List listl=ld.FindAll();
		for(int i=0;i<listl.size();i++){
			labels label=(labels)listl.get(i);
			labels.add(label);
		}
		List<FileAndUser> filetop=new LinkedList<FileAndUser>();
		for(int i=list.size()-1;i>=0;i--){
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
			files.setUploadtime(TimeUtil.getTime(file.getUploadtime()));
			files.setTitle(file.getTitle());
			files.setUserid(file.getUserid());
			files.setLabel(file.getLabel());
			files.setToptime(file.getToptime());
			if(file.getToptime()!=null){
				fileu.add(files);
			}else{
				filetop.add(files);
			}
		}
		//对置顶贴按时间排序
		FileComparable sort=new FileComparable();
		Collections.sort(fileu, sort);
		fileu.addAll(filetop);
		if(fd.FindCount("","index")%PageSize>0){
			TolePage=fd.FindCount("","index")/PageSize+1;
		}else TolePage=fd.FindCount("","index")/PageSize;
		this.isnewMsg();
	
		
		return SUCCESS;
	}
	public void isnewMsg(){//�Ƿ�������Ϣ
		Map m;
		long id;
		m=ActionContext.getContext().getSession();//ȡ��session
		if( m.get("xiyoulinuxusername")!=null){
			id=ud.FindId((String)m.get("xiyoulinuxusername"));
			if(ad.IsNew(id)){
				msg=true;
			}else if( (rd.findRelay(id)).size()>0){
				msg=true;
			}else{
				msg=false;
			}
		}
	}

	public boolean isMsg() {
		return msg;
	}
	public void setMsg(boolean msg) {
		this.msg = msg;
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
}
