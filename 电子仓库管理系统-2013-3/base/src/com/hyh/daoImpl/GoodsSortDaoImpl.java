package com.hyh.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hyh.dao.GoodsSortDao;
import com.hyh.db.ConnectionManager;
import com.hyh.vo.goodssort;
import com.hyh.vo.user;

public class GoodsSortDaoImpl implements GoodsSortDao{

	private Connection conn;
	public GoodsSortDaoImpl(Connection conn){
		this.conn=conn;
	}
	
	public boolean addGoodsSort(goodssort goodssort) {
		PreparedStatement pstm=null;
		try{
			String sql="INSERT INTO goodssort(sortname,sortgrade,sortfather,state) VALUES(?,?,?,?)";
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, goodssort.getSortname());
			pstm.setInt(2, goodssort.getSortgrade());
			pstm.setString(3, goodssort.getSortfather());
			pstm.setInt(4, goodssort.getState());
			if(pstm.executeUpdate()>0)
				return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(null, pstm, this.conn);
		}
		return false;
	}

	public boolean updateGoodsSort(goodssort goodssort) {
		PreparedStatement pstm=null;
		try{
			String sql="UPDATE goodssort SET sortname=?,sortgrade=?,sortfather=?,state=? WHERE id=?";
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, goodssort.getSortname());
			pstm.setInt(2, goodssort.getSortgrade());
			pstm.setString(3, goodssort.getSortfather());
			pstm.setInt(4, goodssort.getState());
			pstm.setInt(5, goodssort.getId());
			if(pstm.executeUpdate()>0)
				return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(null, pstm, this.conn);
		}
		return false;
	}

	public boolean deleteGoodsSort(int id) {
		PreparedStatement pstm=null;
		try{
			String sql="DELETE FROM goodssort WHERE id=?";
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

	public List<goodssort> findGoodsSort(int page, int size) {
		List<goodssort> list=new ArrayList<goodssort>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM goodssort  ORDER BY id LIMIT "+(page*size-size)+","+size;
			pstm=this.conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				goodssort goodssort=new goodssort();
				goodssort.setId(rs.getInt(1));
				goodssort.setSortname(rs.getString(2));
				goodssort.setSortgrade(rs.getInt(3));
				goodssort.setSortfather(rs.getString(4));
				goodssort.setState(rs.getInt(5));
				list.add(goodssort);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return list;
	}

	public List<goodssort> searchGoodsSort(int page, int size, String key) {
		List<goodssort> list=new ArrayList<goodssort>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM goodssort WHERE sortname like '%"+key+"%' ORDER BY id LIMIT "+(page*size-size)+","+size;
			pstm=this.conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				goodssort goodssort=new goodssort();
				goodssort.setId(rs.getInt(1));
				goodssort.setSortname(rs.getString(2));
				goodssort.setSortgrade(rs.getInt(3));
				goodssort.setSortfather(rs.getString(4));
				goodssort.setState(rs.getInt(5));
				list.add(goodssort);
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
			String sql="SELECT COUNT(*)  FROM goodssort WHERE sortname like '%"+key+"%'";
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

	public goodssort findSort(int id) {
		goodssort gsort=new goodssort();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM goodssort WHERE id=? LIMIT 1";
			pstm=this.conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs=pstm.executeQuery();
			if(rs.next()){
				gsort.setId(rs.getInt(1));
				gsort.setSortname(rs.getString(2));
				gsort.setSortgrade(rs.getInt(3));
				gsort.setSortfather(rs.getString(4));
				gsort.setState(rs.getInt(5));
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return gsort;
	}

	public int findCount() {
		int count=0;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT COUNT(*) FROM goodssort";
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

	public List<goodssort> findAll() {
		List<goodssort> list=new ArrayList<goodssort>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM goodssort WHERE state=1";
			pstm=this.conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				goodssort goodssort=new goodssort();
				goodssort.setId(rs.getInt(1));
				goodssort.setSortname(rs.getString(2));
				goodssort.setSortgrade(rs.getInt(3));
				goodssort.setSortfather(rs.getString(4));
				goodssort.setState(rs.getInt(5));
				list.add(goodssort);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return list;
	}

}
