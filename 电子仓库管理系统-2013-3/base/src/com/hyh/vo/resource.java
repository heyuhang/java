package com.hyh.vo;
/*
 * 资源 vo
 */
public class resource {
	private int id;
	private String resname;
	private String redescription;//描述
	private String ctime;
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResname() {
		return resname;
	}
	public void setResname(String resname) {
		this.resname = resname;
	}
	public String getRedescription() {
		return redescription;
	}
	public void setRedescription(String redescription) {
		this.redescription = redescription;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}
