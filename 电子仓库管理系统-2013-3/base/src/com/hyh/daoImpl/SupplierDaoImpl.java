package com.hyh.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hyh.dao.SupplierDao;
import com.hyh.db.ConnectionManager;
import com.hyh.vo.supplier;

public class SupplierDaoImpl implements SupplierDao{

	private Connection conn;
	public SupplierDaoImpl(Connection conn){
		this.conn=conn;
	}
	
	public boolean addSupplier(supplier supplier) {
		PreparedStatement pstm=null;
	
		try{
			String sql="INSERT INTO supplier(suname,sucity,saddress,spost,sphone,slpeople,state) VALUES(?,?,?,?,?,?,?)";
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, supplier.getSuname());
			pstm.setString(2, supplier.getSucity());
			pstm.setString(3, supplier.getAddress());
			pstm.setString(4, supplier.getSpost());
			pstm.setString(5, supplier.getSphone());
			pstm.setString(6, supplier.getSlpeople());
			pstm.setInt(7, supplier.getState());
			if(pstm.executeUpdate()>0)
				return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(null, pstm, this.conn);
		}
		return false;
	}

	public boolean updateSupplier(supplier supplier) {
		PreparedStatement pstm=null;
	
		try{
			String sql="UPDATE supplier SET suname=?,sucity=?,saddress=?,spost=?,sphone=?,slpeople=?,state=? WHERE id=?";
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, supplier.getSuname());
			pstm.setString(2, supplier.getSucity());
			pstm.setString(3, supplier.getAddress());
			pstm.setString(4, supplier.getSpost());
			pstm.setString(5, supplier.getSphone());
			pstm.setString(6, supplier.getSlpeople());
			pstm.setInt(7, supplier.getState());
			pstm.setInt(8, supplier.getId());
			if(pstm.executeUpdate()>0)
				return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(null, pstm, this.conn);
		}
		return false;
	}

	public boolean deleteSupplier(int id) {
		PreparedStatement pstm=null;
		try{
			String sql="DELETE FROM supplier WHERE id=?";
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

	public List<supplier> findSupplier(int page, int size) {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		List<supplier> list=new ArrayList<supplier>();
		try{
			String sql="SELECT * FROM supplier  ORDER BY id LIMIT "+(page*size-size)+","+size;
			pstm=this.conn.prepareStatement(sql);
			
			rs=pstm.executeQuery();
			while(rs.next()){
				supplier supplier=new supplier();
				supplier.setId(rs.getInt(1));
				supplier.setSuname(rs.getString(2));
				supplier.setSucity(rs.getString(3));
				supplier.setAddress(rs.getString(4));
				supplier.setSpost(rs.getString(5));
				supplier.setSphone(rs.getString(6));
				supplier.setSlpeople(rs.getString(7));
				supplier.setState(rs.getInt(8));
				list.add(supplier);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return list;
	}

	public List<supplier> searchSupplier(int page, int size, String key) {
		List<supplier> list=new ArrayList<supplier>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM supplier WHERE suname like '%"+key+"%' ORDER BY id LIMIT "+(page*size-size)+","+size;
			pstm=this.conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				supplier supplier=new supplier();
				supplier.setId(rs.getInt(1));
				supplier.setSuname(rs.getString(2));
				supplier.setSucity(rs.getString(3));
				supplier.setAddress(rs.getString(4));
				supplier.setSpost(rs.getString(5));
				supplier.setSphone(rs.getString(6));
				supplier.setSlpeople(rs.getString(7));
				supplier.setState(rs.getInt(8));
				list.add(supplier);
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
			String sql="SELECT COUNT(*)  FROM supplier WHERE suname like '%"+key+"%'";
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

	public supplier findVendor(int id) {
		supplier supplier=new supplier();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM supplier WHERE id=? LIMIT 1";
			pstm=this.conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs=pstm.executeQuery();
			if(rs.next()){
				
				supplier.setId(rs.getInt(1));
				supplier.setSuname(rs.getString(2));
				supplier.setSucity(rs.getString(3));
				supplier.setAddress(rs.getString(4));
				supplier.setSpost(rs.getString(5));
				supplier.setSphone(rs.getString(6));
				supplier.setSlpeople(rs.getString(7));
				supplier.setState(rs.getInt(8));
	
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return supplier;
	}

	public int findCount() {
		int count=0;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT COUNT(*) FROM supplier";
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

	public List<supplier> findAll() {
		List<supplier> list=new ArrayList<supplier>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM supplier WHERE state=1";
			pstm=this.conn.prepareStatement(sql);
			
			rs=pstm.executeQuery();
			while(rs.next()){
				supplier supplier=new supplier();
				supplier.setId(rs.getInt(1));
				supplier.setSuname(rs.getString(2));
				supplier.setSucity(rs.getString(3));
				supplier.setAddress(rs.getString(4));
				supplier.setSpost(rs.getString(5));
				supplier.setSphone(rs.getString(6));
				supplier.setSlpeople(rs.getString(7));
				supplier.setState(rs.getInt(8));
				list.add(supplier);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return list;
	}

}
