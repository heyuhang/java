package com.hyh.vo;
/*
 * 送货管理
 */
public class deliver {
	
	private int id;
	private String num;
	private String createby;
	private String city;
	private String deliverdate;
	private String createtime;
	private int state;
	private String remark;
	private String outid;
	private int number;
	private String vendor;

	
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getOutid() {
		return outid;
	}
	public void setOutid(String outid) {
		this.outid = outid;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDeliverdate() {
		return deliverdate;
	}
	public void setDeliverdate(String deliverdate) {
		this.deliverdate = deliverdate;
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
