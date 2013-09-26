package com.hyh.Action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport{

	private String fileName;
	private final static String DOWNLOADFILEPATH="/upload/";
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	} 
	
    public InputStream getDownloadFile() {  
        return   ServletActionContext.getServletContext().getResourceAsStream(DOWNLOADFILEPATH+fileName);  
    }  
    //如果下载文件名为中文，进行字符编码转换  
    public String getDownloadChineseFileName() {  
        String downloadChineseFileName = fileName;  
  
        try {  
            downloadChineseFileName = new String(downloadChineseFileName.getBytes(), "ISO8859-1");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
  
        return downloadChineseFileName;  
    }  
  
    public String execute() {  
        return SUCCESS;  
    } 	
}
