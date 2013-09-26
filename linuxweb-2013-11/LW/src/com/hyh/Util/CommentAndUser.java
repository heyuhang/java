package com.hyh.Util;

public class CommentAndUser {
	   private long comid;
	   private long fileid;
	   private long fromid;
	   private String content;//���ݣ�100�ַ�
	   private String commentime;
	   private String name;//user name
	   private String headpath;//ͷ��
	   private String toname;
	   private long   approvano;
	   private long toid;
	   private long curid;//当前登录
	 
	public long getCurid() {
		return curid;
	}
	public void setCurid(long curid) {
		this.curid = curid;
	}
	public long getToid() {
		return toid;
	}
	public void setToid(long toid) {
		this.toid = toid;
	}
	public long getApprovano() {
		return approvano;
	}
	public void setApprovano(long approvano) {
		this.approvano = approvano;
	}
	public String getToname() {
		return toname;
	}
	public void setToname(String toname) {
		this.toname = toname;
	}
	public long getComid() {
		return comid;
	}
	public void setComid(long comid) {
		this.comid = comid;
	}
	public long getFileid() {
		return fileid;
	}
	public void setFileid(long fileid) {
		this.fileid = fileid;
	}
	public long getFromid() {
		return fromid;
	}
	public void setFromid(long fromid) {
		this.fromid = fromid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCommentime() {
		return commentime;
	}
	public void setCommentime(String commentime) {
		this.commentime = commentime;
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
	  
}
