package com.heyuhang.item;

import java.util.Date;

public class book {
	String barcode;
	String booknsme;
	int typeid;
	String suthor;
	String translator;
	String ISBN;
	float price;
	int page;
	int bookcase;
	int storage;
	Date inTime;
	String operator;
	int ID;
	public void setID(int id)
	{
		ID=id;
	}
	public int getID()
	{
		return ID;
	}
	public void setBarcode(String code)
	{
		barcode=code;
	}
	public String getBarcode()
	{
		return barcode;
	}
	public void setbooknsme(String code)
	{
		booknsme=code;
	}
	public String getbooknsme()
	{
		return booknsme;
	}
	public void settypeid(int code)
	{
		typeid=code;
	}
	public int gettypeid()
	{
		return typeid;
	}
	public void setauthor(String code)
	{
		suthor=code;
	}
	public String getauthor()
	{
		return suthor;
	}
	public void settranslator(String code)
	{
		translator=code;
	}
	public String gettranslator()
	{
		return translator;
	}
	public void setISBN(String code)
	{
		ISBN=code;
	}
	public String getISBN()
	{
		return ISBN;
	}
	public void setprice(float code)
	{
		price=code;
	}
	public float getprice()
	{
		return price;
	}
	public void setpage(int code)
	{
		page=code;
	}
	public int getpage()
	{
		return page;
	}
	public void setbookcase(int code)
	{
		bookcase=code;
	}
	public int getbookcase()
	{
		return bookcase;
	}
	public void setinTime(Date code)
	{
		inTime=code;
	}
	public Date getinTime()
	{
		return inTime;
	}
	public void setoperator(String code)
	{
		operator=code;
	}
	public String getoperator()
	{
		return operator;
	}
	public void setstorage(int code)
	{
		storage=code;
	}
	public int getstorage()
	{
		return storage;
	}
}
