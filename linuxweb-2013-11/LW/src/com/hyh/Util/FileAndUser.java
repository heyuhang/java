package com.hyh.Util;

public class FileAndUser {
	private long id;
	private long userid;
	private String name;
	private String headpath;
	private String interest;
	private String userintr;
	private String email;
	private String title;//�ļ����⣬50���ַ�
	private String label;
	private String introduct;//���ܣ�200
	private String uploadtime;//�ϴ�ʱ��
	private String filepath;
	private long approve;//��
	private long criticism;//�¶�
	private long commentno;//���۴���
	private String toptime;

	public String getToptime() {
		return toptime;
	}
	public void setToptime(String toptime) {
		this.toptime = toptime;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getUserintr() {
		return userintr;
	}
	public void setUserintr(String userintr) {
		this.userintr = userintr;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeadpath() {
		return headpath;
	}
	public void setHeadpath(String headpath) {
		this.headpath = headpath;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public long getCriticism() {
		return criticism;
	}
	public void setCriticism(long criticism) {
		this.criticism = criticism;
	}
	public long getCommentno() {
		return commentno;
	}
	public void setCommentno(long commentno) {
		this.commentno = commentno;
	}
}
