package com.hyh.vo;
/*
 * 产品  vo
 */
public class goods {

	private int id;
	private String gname;
	private String gcode;
	private int sortid;
	private String sort;
	private int brandid;
	private String brand;
	private String marker;
	private int limitvalue;
	private String gdescription;
	private String ctime;
	private int state;
	
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
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGcode() {
		return gcode;
	}
	public void setGcode(String gcode) {
		this.gcode = gcode;
	}
	public int getSortid() {
		return sortid;
	}
	public void setSortid(int sortid) {
		this.sortid = sortid;
	}
	public int getBrandid() {
		return brandid;
	}
	public void setBrandid(int brandid) {
		this.brandid = brandid;
	}
	public String getMarker() {
		return marker;
	}
	public void setMarker(String marker) {
		this.marker = marker;
	}
	public int getLimitvalue() {
		return limitvalue;
	}
	public void setLimitvalue(int limitvalue) {
		this.limitvalue = limitvalue;
	}
	public String getGdescription() {
		return gdescription;
	}
	public void setGdescription(String gdescription) {
		this.gdescription = gdescription;
	}
	
	
}
