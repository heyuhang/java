package com.hyh.Beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class files { 
    private long id;
	private long userid;
	private String title;//�ļ����⣬50���ַ�
	private String label;//��ǩ��50���ַ�
	private String introduct;//���ܣ�200
	private String uploadtime;//�ϴ�ʱ��
	private String filepath;
	private long approve;//��
	private long commentno;//���۴���
	private String toptime;
	
	public String getToptime() {
		return toptime;
	}
	public void setToptime(String toptime) {
		this.toptime = toptime;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getIntroduct() {
		return introduct;
	}
	public void setIntroduct(String introduct) {
		this.introduct = introduct;
	}
	public String getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public long getApprove() {
		return approve;
	}
	public void setApprove(long approve) {
		this.approve = approve;
	}
	public long getCommentno() {
		return commentno;
	}
	public void setCommentno(long commentno) {
		this.commentno = commentno;
	}
	
}
