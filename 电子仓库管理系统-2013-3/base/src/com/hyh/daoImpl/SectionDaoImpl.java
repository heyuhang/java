package com.hyh.daoImpl;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hyh.dao.SectionDao;
import com.hyh.db.ConnectionManager;
import com.hyh.vo.section;

public class SectionDaoImpl implements SectionDao{

	private Connection conn;
	public SectionDaoImpl(Connection conn){
		this.conn=conn;
	}

	public boolean addSection(section section) {
		PreparedStatement pstm=null;
		try{
			System.out.println( section.getSeleader());
			String sql="INSERT INTO section(sename,seleader,sedescription,state) VALUES(?,?,?,?)";
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, section.getSename());
			pstm.setString(2, section.getSeleader());
			pstm.setString(3, section.getSedescription());
			pstm.setInt(4, section.getState());
			if(pstm.executeUpdate()>0)
				return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(null, pstm, this.conn);
		}
		return false;
	}

	public boolean updateSection(section section) {
		PreparedStatement pstm=null;
		try{
			String sql="UPDATE section SET sename=?,seleader=?,sedescription=?,state=? WHERE id=?";
			pstm=this.conn.prepareStatement(sql);
			
			pstm.setString(1, section.getSename());
			pstm.setString(2, section.getSeleader());
			pstm.setString(3, section.getSedescription());
			pstm.setInt(4, section.getState());
			pstm.setInt(5, section.getId());
			if(pstm.executeUpdate()>0)
				return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(null, pstm, this.conn);
		}
		return false;
	}

	public boolean deleteSection(int id) {
		PreparedStatement pstm=null;
		try{
			String sql="DELETE FROM section WHERE id=?";
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

	public List<section> findSection(int page, int size) {
		List<section> list=new ArrayList<section>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM section ORDER BY id LIMIT "+(page*size-size)+","+size;
			pstm=this.conn.prepareStatement(sql);
			
			rs=pstm.executeQuery();
			while(rs.next()){
				section section=new section();
				section.setId(rs.getInt(1));
				section.setSename(rs.getString(2));
				section.setSeleader(rs.getString(3));
				section.setSedescription(rs.getString(4));
				section.setState(rs.getInt(5));
				list.add(section);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return list;
	}

	public List<section> searchSection(int page, int size, String key) {
		List<section> list=new ArrayList<section>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM section WHERE  sename like '%"+key+"%' ORDER BY id LIMIT "+(page*size-size)+","+size;
			pstm=this.conn.prepareStatement(sql);

			rs=pstm.executeQuery();
			while(rs.next()){
				section section=new section();
				section.setId(rs.getInt(1));
				section.setSename(rs.getString(2));
				section.setSeleader(rs.getString(3));
				section.setSedescription(rs.getString(4));
				section.setState(rs.getInt(5));
				list.add(section);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return list;
	}

	public section findSection(int id) {
		section section=new section();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM section WHERE id=? LIMIT 1";
			pstm=this.conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs=pstm.executeQuery();
			if(rs.next()){
				section.setId(rs.getInt(1));
				section.setSename(rs.getString(2));
				section.setSeleader(rs.getString(3));
				section.setSedescription(rs.getString(4));
				section.setState(rs.getInt(5));
				return section;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return null;
	}

	public int findCount() {
		int count=0;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT COUNT(*) FROM section";
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

	public int findCount(String key) {
		int count=0;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT COUNT(*)  FROM section WHERE sename like '%"+key+"%'";
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

	public List<section> findAll() {
		List<section> list=new ArrayList<section>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM section WHERE state=1";
			pstm=this.conn.prepareStatement(sql);
		
			rs=pstm.executeQuery();
			while(rs.next()){
				section section=new section();
				section.setId(rs.getInt(1));
				section.setSename(rs.getString(2));
				section.setSeleader(rs.getString(3));
				section.setSedescription(rs.getString(4));
				section.setState(rs.getInt(5));
				list.add(section);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return list;
	}

	public boolean checkSection(String section) {
		// TODO Auto-generated method stub
		return false;
	}

}
