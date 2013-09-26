package com.hyh.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hyh.dao.ShelfDao;
import com.hyh.db.ConnectionManager;
import com.hyh.vo.client;
import com.hyh.vo.shelf;

public class ShelfDaoImpl implements ShelfDao{
	private Connection conn;
	public ShelfDaoImpl(Connection conn){
		this.conn=conn;
	}

	public boolean addShelf(shelf shelf) {
		PreparedStatement pstm=null;
		try{
			String sql="INSERT INTO shelf(shname,shdescription,state) VALUES(?,?,?)";
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, shelf.getShname());
			pstm.setString(2, shelf.getShdescription());
			pstm.setInt(3, shelf.getState());
			if(pstm.executeUpdate()>0)
				return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(null, pstm, this.conn);
		}
		return false;
	}

	public boolean updateShelf(shelf shelf) {
		PreparedStatement pstm=null;
		try{
			String sql="UPDATE shelf SET shname=?,shdescription=?,state=? WHERE id=?";
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, shelf.getShname());
			pstm.setString(2, shelf.getShdescription());
			pstm.setInt(3, shelf.getState());
			pstm.setInt(4, shelf.getId());
			if(pstm.executeUpdate()>0)
				return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(null, pstm, this.conn);
		}
		return false;
	}

	public boolean deleteShelf(int id) {
		PreparedStatement pstm=null;
		try{
			String sql="DELETE FROM shelf WHERE id=?";
			pstm=this.conn.prepareStatement(sql);
			pstm.setInt(1, id);
			if(pstm.executeUpdate()>0)
				return true;
			
		}catch(Exception e){
			e.printStackTrace();	
		}finally{
			
			ConnectionManager.close(null, pstm, this.conn);
		}
		return false;
	}

	public List<shelf> findShelf(int page, int size) {
		List<shelf> list=new ArrayList<shelf>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM shelf ORDER BY id LIMIT "+(page*size-size)+","+size;
			pstm=this.conn.prepareStatement(sql);
			
			rs=pstm.executeQuery();
			while(rs.next()){
				shelf shelf=new shelf();
				shelf.setId(rs.getInt(1));
				shelf.setShname(rs.getString(2));
				shelf.setShdescription(rs.getString(3));
				shelf.setState(rs.getInt(4));
				list.add(shelf);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return list;
	}

	public List<shelf> searchShelf(int page, int size, String key) {
		List<shelf> list=new ArrayList<shelf>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM shelf WHERE shname like '%"+key+"%' ORDER BY id LIMIT "+(page*size-size)+","+size;
			pstm=this.conn.prepareStatement(sql);
		
			rs=pstm.executeQuery();
			while(rs.next()){
				shelf shelf=new shelf();
				shelf.setId(rs.getInt(1));
				shelf.setShname(rs.getString(2));
				shelf.setShdescription(rs.getString(3));
				shelf.setState(rs.getInt(4));
				list.add(shelf);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return list;
	}

	public int findCount(String key) {
		int count=0;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT COUNT(*)  FROM shelf WHERE shname like '%"+key+"%'";
			pstm=this.conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return count;
	}

	public shelf findShelf(int id) {
		shelf shelf=new shelf();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM shelf WHERE id=? LIMIT 1";
			pstm=this.conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs=pstm.executeQuery();
			if(rs.next()){
				
				shelf.setId(rs.getInt(1));
				shelf.setShname(rs.getString(2));
				shelf.setShdescription(rs.getString(3));
				shelf.setState(rs.getInt(4));
	
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return shelf;
	}

	public int findCount() {
		int count=0;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT COUNT(*) FROM shelf";
			pstm=this.conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return count;
	}

	public List<shelf> findAll() {
		List<shelf> list=new ArrayList<shelf>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM shelf WHERE state=1";
			pstm=this.conn.prepareStatement(sql);
		
			rs=pstm.executeQuery();
			while(rs.next()){
				shelf shelf=new shelf();
				shelf.setId(rs.getInt(1));
				shelf.setShname(rs.getString(2));
				shelf.setShdescription(rs.getString(3));
				shelf.setState(rs.getInt(4));
				list.add(shelf);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return list;
	}

}
