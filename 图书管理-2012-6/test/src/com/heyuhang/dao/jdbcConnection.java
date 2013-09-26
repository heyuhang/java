package com.heyuhang.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcConnection {

	/**
	 * 获得数据库的链接
	 * @return
	 */
	public static int stuId=0;
	public static  Connection getConnection(){
		Connection  conn=null;
		try {

			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/library", "root", "heyuhang");
				System.out.print("success!!!");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.print("unsuccess!!!");
			e.printStackTrace();
		}
		return conn;

	}
	public static  void insert(String sql){

		Connection conn=getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.executeUpdate();
			System.out.print("成功");
		} catch (SQLException e) {
			System.out.print("失败");
			e.printStackTrace();
		}
		
	}
	public  static void delete(String sql){

		Connection conn=getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.executeUpdate();
			System.out.print("删除成功");
		} catch (SQLException e) {
			System.out.print("删除失败");
			e.printStackTrace();
		}
	}
	public  static void update(String sql){

		Connection conn=getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.executeUpdate();
			System.out.print("修改成功");
		} catch (SQLException e) {
			System.out.print("修改失败");
			e.printStackTrace();
		}
	}
	
	public static ResultSet  getResult(String sql){
		ResultSet  rs=null;
		Connection conn=getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return rs;	
	}
	
	public static int findID(String table)
	{
		int id = 0 ;
		ResultSet  rs=null;
		Connection conn=getConnection();
		
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("select ID from "+table);
			rs=ps.executeQuery();
			while(rs.next())
			{
				id=rs.getInt("ID");
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return id;		
	}
	public static int findBarcode(String table)
	{
		String id ="0" ;
		ResultSet  rs=null;
		Connection conn=getConnection();
		
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("select Barcode from "+table);
			rs=ps.executeQuery();
			while(rs.next())
			{
				id=rs.getString("ID");
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return Integer.valueOf(id);		
	}
}


