package com.hyh.Beans;
/*
 * 回复类，记录新回复
 */
public class replay {
	 private long id;
	 private long fileid;
	 private long fromid;
	 private long toid;
	 private String content;
	 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public long getToid() {
		return toid;
	}
	public void setToid(long toid) {
		this.toid = toid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	} 
}
