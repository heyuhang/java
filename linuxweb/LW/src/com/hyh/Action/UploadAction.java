package com.hyh.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyh.Beans.files;
import com.hyh.DAO.attentionDAO;
import com.hyh.DAO.filesDAO;
import com.hyh.DAO.labelsDAO;
import com.hyh.Util.IPTimeStamp;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {

	private String text;
	private String title;
	private File myFile;
	private String checkcode;
	private String label;
	private String msg;
	private String myFileContentType;
	private String myFileFileName;
	private long id;
	ApplicationContext cxt = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	filesDAO fd = (filesDAO) cxt.getBean("filesService");
	labelsDAO ld = (labelsDAO) cxt.getBean("labelsService");
	attentionDAO ad=(attentionDAO)cxt.getBean("attentionService");

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String execute() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		Map m = null;
		m=ActionContext.getContext().getSession();
		String rand=(String)m.get("rand");
		if(!checkcode.equals(rand)){
			out.print("<script>alert('check code error!');history.go(-1)</script>");
			out.flush();
			out.close();
			return SUCCESS;
		}
		if(myFile!=null){
			FileInputStream  is = new FileInputStream(myFile);
			if(is.available()>10240000){
				out.print("<script>alert('big file error！');history.go(-1)</script>");
				out.flush();
				out.close();
				is.close();
				return SUCCESS;			
			}
			is.close();
		}
		files file = new files();
		file.setTitle(title);
		file.setIntroduct(text);
		if(myFile!=null && label!=null){
			String filename=this.upload(myFile, "/upload");
			file.setFilepath(filename);//正确的path
			String label2=ld.MatchAdd(label);
			if(!label2.equals("")){
				file.setLabel(label2);
			}else{
				file.setLabel(label);
			}
		}
		else{
			file.setFilepath("false");
			String label2=ld.MatchAdd(label);
			if(!label2.equals("")){
				file.setLabel(label2);
			}else{
				file.setLabel(label);
			}
		}		
		file.setUserid(id);
		fd.Addfile(file);
		msg = "上传成功";

		return SUCCESS;
	}
	public String upload(File myFile,String path) throws Exception{

		FileInputStream  is = new FileInputStream(myFile);
		String uploadPath = ServletActionContext.getServletContext()
			.getRealPath(path);
	
		IPTimeStamp its = new IPTimeStamp();
		String filename = its.getIPTimeStampRand() + "." + this.getExt();
		File toFile = new File(uploadPath, filename);

		FileOutputStream  os = new FileOutputStream(toFile);

		
		FileChannel chin=is.getChannel();
		FileChannel chout=os.getChannel();
		ByteBuffer buff=ByteBuffer.allocate(1024);
		while(chin.read(buff)!=-1){
			buff.flip();
			chout.write(buff);
			buff.clear();			
		}
		is.close();
		os.close();
		return filename;
	}
	public String getExt() {
		int i = myFileFileName.lastIndexOf('.');

		if ((i > -1) && (i < (myFileFileName.length() - 1))) {
			return myFileFileName.substring(i + 1);
		}
		return "doc";
	}
}
