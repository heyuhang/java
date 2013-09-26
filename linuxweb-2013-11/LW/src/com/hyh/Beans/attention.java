package com.hyh.Beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class attention {
	private long id;
	private long fromid;//自己id
	private long toid;//关注人的id
	private String message;
	private String ationtime;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getAtiontime() {
		return ationtime;
	}
	public void setAtiontime(String ationtime) {
		this.ationtime = ationtime;
	}
	
}
