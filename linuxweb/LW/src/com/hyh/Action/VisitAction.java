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
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class VisitAction extends ActionSupport{
	private long toid;
	private List<files> filel;
	private int PageNow=1;
	private int PageSize=8;
	private int TolePage=0;
	private user user;
	private int filesize;
	private int atteno;//��ע����
	private int guanzhu=0;//�Ƿ��ע
	ApplicationContext cxt = new ClassPathXmlApplicationContext(
		    "applicationContext.xml");
	filesDAO fd=(filesDAO)cxt.getBean("filesService");
	userDAO ud=(userDAO)cxt.getBean("userService");	
	attentionDAO ad=(attentionDAO)cxt.getBean("attentionService");	
	public String execute()throws Exception{

		user=(user)(ud.FindById(toid)).get(0);
		filel=new LinkedList<files>();
		
		List list2=fd.FindByPageId(PageNow, PageSize,toid);
		filesize=fd.FindCountById(toid);
		if(list2.size()==0){
			return SUCCESS;
		}
		for(int i=0;i<list2.size();i++){
			
			files file=(files)list2.get(i);
			filel.add(file);
		}
		if(filesize%PageSize>0){
			TolePage=filesize/PageSize+1;
		}else TolePage=filesize/PageSize;
		//���ҹ�ע����
		List attention=ad.Findattention(user.getId());
		atteno=attention.size();
		
		//�ӹ�ע
		Map m;
		m=ActionContext.getContext().getSession();//ȡ��session
		if(( (String)m.get("xiyoulinuxusername") )!=null ){
			long fromid=ud.FindId((String)m.get("xiyoulinuxusername"));
			if(fromid==toid){
				guanzhu=0;//���ܼ��Լ���ע
			}else if(ad.isAttention(fromid, toid)){
				guanzhu=1;//�Ѿ���ע
			}else{
				guanzhu=2;//û�й�ע
			}
		}else{
			guanzhu=0;//û�е�¼���ܼӹ�ע
		}
		return SUCCESS;
	}
	
	public int isGuanzhu() {
		return guanzhu;
	}

	public void setGuanzhu(int guanzhu) {
		this.guanzhu = guanzhu;
	}

	public long getToid() {
		return toid;
	}

	public void setToid(long toid) {
		this.toid = toid;
	}

	public int getAtteno() {
		return atteno;
	}

	public void setAtteno(int atteno) {
		this.atteno = atteno;
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
