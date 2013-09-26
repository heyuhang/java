package com.hyh.vo;
/*
 * 出库  vo
 */
public class stockout {

	private int id;
	private String num;
	private String stockouttype;
	private String createby;
	private String createtime;
	private String stockoutdate;
	private String vendor;
	private int vendorid;
	private int state;
	private String goods;
	private String shelf;
	private int number;
	private int outnum;
	private String remark;
	
	
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
	public int getOutnum() {
		return outnum;
	}
	public void setOutnum(int outnum) {
		this.outnum = outnum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStockouttype() {
		return stockouttype;
	}
	public void setStockouttype(String stockouttype) {
		this.stockouttype = stockouttype;
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
	public String getStockoutdate() {
		return stockoutdate;
	}
	public void setStockoutdate(String stockoutdate) {
		this.stockoutdate = stockoutdate;
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
