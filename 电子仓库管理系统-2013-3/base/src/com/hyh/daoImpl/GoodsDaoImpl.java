package com.hyh.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hyh.dao.GoodsDao;
import com.hyh.db.ConnectionManager;
import com.hyh.vo.goods;

public class GoodsDaoImpl implements GoodsDao{

	private Connection conn;
	
	public GoodsDaoImpl(Connection conn){
		this.conn=conn;
	}

	public boolean addGoods(goods goods) {
		PreparedStatement pstm=null;
		try{
			String sql="INSERT INTO goods(gname,gcode,sortid,sort,brandid,brand,marker,limitvalue,gdescription,ctime,state) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, goods.getGname());
			pstm.setString(2, goods.getGcode());
			pstm.setInt(3, goods.getSortid());
			pstm.setString(4, goods.getSort());
			pstm.setInt(5, goods.getBrandid());
			pstm.setString(6, goods.getBrand());
			pstm.setString(7, goods.getMarker());
			pstm.setInt(8, goods.getLimitvalue());
			pstm.setString(9, goods.getGdescription());
			pstm.setString(10, goods.getCtime());
			pstm.setInt(11, goods.getState());
			if(pstm.executeUpdate()>0)
				return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(null, pstm, this.conn);
		}
		return false;
	}

	public boolean updateGoods(goods goods) {
		PreparedStatement pstm=null;
		try{
			String sql="UPDATE goods SET gname=?,gcode=?,sortid=?,sort=?,brandid=?,brand=?,marker=?,limitvalue=?,gdescription=?,ctime=?,state=? WHERE id=?";
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, goods.getGname());
			pstm.setString(2, goods.getGcode());
			pstm.setInt(3, goods.getSortid());
			pstm.setString(4, goods.getSort());
			pstm.setInt(5, goods.getBrandid());
			pstm.setString(6, goods.getBrand());
			pstm.setString(7, goods.getMarker());
			pstm.setInt(8, goods.getLimitvalue());
			pstm.setString(9, goods.getGdescription());
			pstm.setString(10, goods.getCtime());
			pstm.setInt(11, goods.getState());
			pstm.setInt(12, goods.getId());
			if(pstm.executeUpdate()>0)
				return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(null, pstm, this.conn);
		}
		return false;
	}

	public boolean deleteGoods(int id) {
		PreparedStatement pstm=null;
		try{
			String sql="DELETE FROM goods WHERE id=?";
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

	public List<goods> findGoods(int page, int size) {
		List<goods> list=new ArrayList<goods>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM goods ORDER BY id LIMIT "+(page*size-size)+","+size;
			pstm=this.conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				goods goods=new goods();
				goods.setId(rs.getInt(1));
				goods.setGname(rs.getString(2));
				goods.setGcode(rs.getString(3));
				goods.setSortid(rs.getInt(4));
				goods.setSort(rs.getString(5));
				goods.setBrandid(rs.getInt(6));
				goods.setBrand(rs.getString(7));
				goods.setMarker(rs.getString(8));
				goods.setLimitvalue(rs.getInt(9));
				goods.setGdescription(rs.getString(10));
				goods.setCtime(rs.getString(11));
				goods.setState(rs.getInt(12));
				list.add(goods);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return list;
	}

	public List<goods> searchGoods(int page, int size, String key) {
		List<goods> list=new ArrayList<goods>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM goods WHERE gname=? ORDER BY id LIMIT "+(page*size-size)+","+size;
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, key);
			rs=pstm.executeQuery();
			while(rs.next()){
				goods goods=new goods();
				goods.setId(rs.getInt(1));
				goods.setGname(rs.getString(2));
				goods.setGcode(rs.getString(3));
				goods.setSortid(rs.getInt(4));
				goods.setSort(rs.getString(5));
				goods.setBrandid(rs.getInt(6));
				goods.setBrand(rs.getString(7));
				goods.setMarker(rs.getString(8));
				goods.setLimitvalue(rs.getInt(9));
				goods.setGdescription(rs.getString(10));
				goods.setCtime(rs.getString(11));
				goods.setState(rs.getInt(12));
				list.add(goods);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return list;
	}

	public int findCount(String key) {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		int count=0;
		try{
			String sql="SELECT COUNT(*)  FROM goods WHERE sortname like '%"+key+"%'";
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

	public goods findGoods(int id) {
		goods goods=new goods();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM goodsbrand WHERE id=? LIMIT 1";
			pstm=this.conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs=pstm.executeQuery();
			if(rs.next()){
				goods.setId(rs.getInt(1));
				goods.setGname(rs.getString(2));
				goods.setGcode(rs.getString(3));
				goods.setSortid(rs.getInt(4));
				goods.setSort(rs.getString(5));
				goods.setBrandid(rs.getInt(6));
				goods.setBrand(rs.getString(7));
				goods.setMarker(rs.getString(8));
				goods.setLimitvalue(rs.getInt(9));
				goods.setGdescription(rs.getString(10));
				goods.setCtime(rs.getString(11));
				goods.setState(rs.getInt(12));
	
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return goods;
	}

	public int findCount() {
		int count=0;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT COUNT(*) FROM goods";
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

	public List<goods> findAll() {
		List<goods> list=new ArrayList<goods>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM goods WHERE state=1";
			pstm=this.conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				goods goods=new goods();
				goods.setId(rs.getInt(1));
				goods.setGname(rs.getString(2));
				goods.setGcode(rs.getString(3));
				goods.setSortid(rs.getInt(4));
				goods.setSort(rs.getString(5));
				goods.setBrandid(rs.getInt(6));
				goods.setBrand(rs.getString(7));
				goods.setMarker(rs.getString(8));
				goods.setLimitvalue(rs.getInt(9));
				goods.setGdescription(rs.getString(10));
				goods.setCtime(rs.getString(11));
				goods.setState(rs.getInt(12));
				list.add(goods);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return list;
	}

}
