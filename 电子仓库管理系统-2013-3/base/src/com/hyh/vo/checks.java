package com.hyh.vo;
/*
 * 盘点  vo
 */
public class checks {

	private int id;
	private String num;
	private String createby;
	private int shelfid;
	private String shelfname;
	private String checkdate;
	private String createtime;
	private int state;
	private String remark;
	private String goods;
	private int number;
	private int realnum;
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getRealnum() {
		return realnum;
	}
	public void setRealnum(int realnum) {
		this.realnum = realnum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCreateby() {
		return createby;
	}
	public void setCreateby(String createby) {
		this.createby = createby;
	}
	public int getShelfid() {
		return shelfid;
	}
	public void setShelfid(int shelfid) {
		this.shelfid = shelfid;
	}
	public String getShelfname() {
		return shelfname;
	}
	public void setShelfname(String shelfname) {
		this.shelfname = shelfname;
	}
	public String getCheckdate() {
		return checkdate;
	}
	public void setCheckdate(String checkdate) {
		this.checkdate = checkdate;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
