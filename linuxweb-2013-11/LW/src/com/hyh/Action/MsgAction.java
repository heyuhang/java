package com.hyh.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;


import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyh.DAO.userDAO;
import com.hyh.Util.IPTimeStamp;
import com.opensymphony.xwork2.ActionSupport;

public class MsgAction extends ActionSupport{
	private String name;
    private String interest;
    private String oldhead;
    private String introduct;
    private File headphoto;
    private String headphotoFileName;
    private long id;
	ApplicationContext cxt = new ClassPathXmlApplicationContext(
		    "applicationContext.xml");
	userDAO ud=(userDAO)cxt.getBean("userService");
	
	public String getOldhead() {
		return oldhead;
	}
	public void setOldhead(String oldhead) {
		this.oldhead = oldhead;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getIntroduct() {
		return introduct;
	}
	public void setIntroduct(String introduct) {
		this.introduct = introduct;
	}
	public File getHeadphoto() {
		return headphoto;
	}
	public void setHeadphoto(File headphoto) {
		this.headphoto = headphoto;
	}	
	
	public String getHeadphotoFileName() {
		return headphotoFileName;
	}
	public void setHeadphotoFileName(String headphotoFileName) {
		this.headphotoFileName = headphotoFileName;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String execute()throws Exception{
		if(headphoto!=null){
			InputStream head=new FileInputStream(headphoto);
			String uploadPath = ServletActionContext.getServletContext()  
					.getRealPath("/head"); 
			File oldfile=new File(uploadPath+oldhead.substring(5));
			oldfile.delete();
			IPTimeStamp its = new IPTimeStamp() ; 
			String filename=its.getIPTimeStampRand()+"."+this.getExt();
			File toFile = new File(uploadPath, filename);
			OutputStream os = new FileOutputStream(toFile);
			byte[] buffer = new byte[1024];  	  
			int length = 0;   
			while ((length = head.read(buffer)) > 0) {  
				os.write(buffer, 0, length);  
			}  
			head.close();  
			os.close();
			ud.Updateuser(name, interest, introduct, "/head/"+filename, id);
		}else{
			ud.Updateuser(name, interest, introduct, null, id);
		}
		
		return SUCCESS;
	}
	public String getExt(){
		int i = headphotoFileName.lastIndexOf('.');   
		  
        if ((i >-1) && (i < (headphotoFileName.length() - 1))) {   
            return headphotoFileName.substring(i + 1);   
        } 
        return "jpg";
	}
}
