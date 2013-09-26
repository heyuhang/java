package com.hyh.vo;
/*
 * 产品  分类  vo
 */
public class goodssort {

	private int id;
	private String sortname;
	private int sortgrade;
	private String sortfather;
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSortname() {
		return sortname;
	}
	public void setSortname(String sortname) {
		this.sortname = sortname;
	}
	public int getSortgrade() {
		return sortgrade;
	}
	public void setSortgrade(int sortgrade) {
		this.sortgrade = sortgrade;
	}
	public String getSortfather() {
		return sortfather;
	}
	public void setSortfather(String sortfather) {
		this.sortfather = sortfather;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}
