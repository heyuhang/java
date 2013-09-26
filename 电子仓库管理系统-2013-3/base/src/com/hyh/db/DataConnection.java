package com.hyh.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库连接
 */
public class DataConnection {
	private String url="jdbc:mysql://localhost:3306/base";
	private String username="root";
	private String password=""; 
	private Connection conn=null;
	public DataConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			this.conn=DriverManager.getConnection(url,username,password);
			//System.out.println("connect ok");
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
	public static DataConnection getInstance(){
		return new DataConnection();
	}
	public  Connection getConn(){
		return this.conn;
	}
	
	public void close(){
		try{
			this.conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		DataConnection dc = new DataConnection();
		dc.getInstance();
		dc.close();
	}
}
