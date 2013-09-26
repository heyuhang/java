package com.heyuhang.item;

import java.util.Date;



public class student {
	int id;
	String name;
	String barcode;
	String sex;
	String vocation;
	Date birthday;
	String paperType;
	String paperNO;
	String tel;
	String email;
	Date date;
	Date back;
	String operator;
	int number;
	float price;
	public student()
	{
		id=0;
		name="";
		barcode="";
		sex="";
		vocation="";
		birthday=null;
		paperType="";
		paperNO="";
		tel="";
		email="";
		date=null;
		operator="";
		number=0;
		back=null;
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
	public void setSex(String Sex)
	{
		sex=Sex;
	}
	public String getSex()
	{
		return sex;
	}
	public void setBarcode(String PWD)
	{
		barcode=PWD;
	}
	public String getBarcode()
	{
		return barcode;
	}
	public void setVocation(String Vocation)
	{
		vocation=Vocation;
	}
	public String getVocation()
	{
		return vocation;
	}
	public void setBirthday(Date d)
	{
		birthday=d;
	}
	public Date getBirthday()
	{
		return birthday;
	}
	public void setPaperType(String Type)
	{
		paperType=Type;
	}
	public String getPaperType()
	{
		return paperType;
	}
	public void setpaperNO(String pNo)
	{
		paperNO=pNo;
	}
	public String getpaperNO()
	{
		return paperNO;
	}
	public void setTel(String Tel)
	{
		tel=Tel;
	}
	public String getTel()
	{
		return tel;
	}
	public void setEmail(String Email)
	{
		email=Email;
	}
	public String getEmail()
	{
		return email;
	}
	public void setDate(Date d)
	{
		date=d;
	}
	public Date getDate()
	{
		return date;
	}
	public void setOperator(String op)
	{
		operator=op;
	}
	public String getOperator()
	{
		return operator;
	}
	public void setNumber(int nu)
	{
		number=nu;
	}
	public int getNumber()
	{
		return number;
	}
	public void setbacktime(Date d)
	{
		 back = d;
	}
	public Date getbacktime()
	{
		return back;
	}
	public void setprice(float d)
	{
		 price = d;
	}
	public float getprice()
	{
		return price;
	}
}

