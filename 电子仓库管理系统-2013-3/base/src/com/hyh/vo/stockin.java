package com.hyh.vo;
/*
 * 入库  vo
 */
public class stockin {
	private int id;
	private String num;
	private String stockindate;
	private String stockintype;
	private int batchno;
	private String createby;
	private String createtime;
	private String vendor;
	private int vendorid;
	private int state;
	private String remark;
	private String goods;
	private String shelf;
	private int number;
	

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public String getShelf() {
		return shelf;
	}
	public void setShelf(String shelf) {
		this.shelf = shelf;
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
	public String getStockindate() {
		return stockindate;
	}
	public void setStockindate(String stockindate) {
		this.stockindate = stockindate;
	}
	public String getStockintype() {
		return stockintype;
	}
	public void setStockintype(String stockintype) {
		this.stockintype = stockintype;
	}
	public int getBatchno() {
		return batchno;
	}
	public void setBatchno(int batchno) {
		this.batchno = batchno;
	}
	public String getCreateby() {
		return createby;
	}
	public void setCreateby(String createby) {
		this.createby = createby;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public int getVendorid() {
		return vendorid;
	}
	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
}
