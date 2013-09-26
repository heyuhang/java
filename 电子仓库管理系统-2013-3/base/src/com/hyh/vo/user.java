package com.hyh.vo;
/*
 * user vo
 */
public class user {
	private int id;//userid
	private String username;//用户名
	private String password;//密码
	/*
	 * 用户类型，0-超级管理员 1-一般管理员 2-一般用户
	 */
	private String usertype;
	private int sectionid;//部门id
	private String sectionname;
	private String email;//电子邮件
	private String ctime;//创建日期
	private int state;//状态
	private String otime;
	private String power;
	
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getSectionname() {
		return sectionname;
	}
	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}
	public String getOtime() {
		return otime;
	}
	public void setOtime(String otime) {
		this.otime = otime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public int getSectionid() {
		return sectionid;
	}
	public void setSectionid(int sectionid) {
		this.sectionid = sectionid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
