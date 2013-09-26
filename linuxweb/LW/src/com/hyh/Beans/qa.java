package com.hyh.Beans;
/*
 * question and answer
 */
public class qa {
	   private long id;
	   private long userid;
	   private String label;
	   private String question;
	   private String uploadtime;
	   private long approve;
	   private long anserno;
	   private String toptime;
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
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}
	public long getApprove() {
		return approve;
	}
	public void setApprove(long approve) {
		this.approve = approve;
	}
	public long getAnserno() {
		return anserno;
	}
	public void setAnserno(long anserno) {
		this.anserno = anserno;
	}
	public String getToptime() {
		return toptime;
	}
	public void setToptime(String toptime) {
		this.toptime = toptime;
	}
	   
}
