package com.heyuhang.item;

import java.util.Date;

public class item {
	int id;
	String name;
	String pwd;
	Date back;
	Date borrow;
	float price;
	String code;
	public item()
	{
		id=0;
		name="";
		pwd="";
	}
	public item(int ID,String Pname,String Ppwd)
	{
		id=0;
		name=Pname;
		pwd=Ppwd;
	}
	public void setID(int pID)
	{
		id=pID;
	}
	public int getID()
	{
		return id;
	}
	public void setName(String pName)
	{
		name=pName;
	}
	public String getName()
	{
		return name;
	}
	public void setPwd(String PWD)
	{
		pwd=PWD;
	}
	public String getPwd()
	{
		return pwd;
	}
	public void setbacktime(Date d)
	{
		 back = d;
	}
	public Date getbacktime()
	{
		return back;
	}
	public void setbborrow(Date d)
	{
		borrow = d;
	}
	public Date getborrow()
	{
		return borrow;
	}
	public void setprice(float d)
	{
		 price = d;
	}
	public float getprice()
	{
		return price;
	}
	public void setbarcode(String d)
	{
		 code = d;
	}
	public String getbarcode()
	{
		return code;
	}
}
