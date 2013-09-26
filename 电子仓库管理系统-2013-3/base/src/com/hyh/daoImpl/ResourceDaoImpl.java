package com.hyh.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hyh.dao.ResourceDao;
import com.hyh.db.ConnectionManager;
import com.hyh.vo.resource;

public class ResourceDaoImpl implements ResourceDao{
	
	private Connection conn;
	public ResourceDaoImpl(Connection conn){
		this.conn=conn;
	}

	public boolean addResource(resource resource) {
		PreparedStatement pstm=null;
		try{
			String sql="INSERT INTO resource(resname,redescription,ctime,state) VALUES(?,?,?,?)";
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, resource.getResname());
			pstm.setString(2, resource.getRedescription());
			pstm.setString(3, resource.getCtime());
			pstm.setInt(4, resource.getState());
			if(pstm.executeUpdate()>0)
				return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(null, pstm, this.conn);
		}
		return false;
	}

	public boolean updateResource(resource resource) {
		PreparedStatement pstm=null;
		try{
			String sql="UPDATE resource SET resname=?,redescription=?,ctime=?,state=? WHERE id=?";
			pstm=this.conn.prepareStatement(sql);
			
			pstm.setString(1, resource.getResname());
			pstm.setString(2, resource.getRedescription());
			pstm.setString(3, resource.getCtime());
			pstm.setInt(4, resource.getState());
			pstm.setInt(5, resource.getId());
			if(pstm.executeUpdate()>0)
				return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(null, pstm, this.conn);
		}
		return false;
	}

	public boolean deleteResource(int id) {
		PreparedStatement pstm=null;
		try{
			String sql="DELETE FROM resource WHERE id=?";
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

	public List<resource> findResource(int page, int size) {
		List<resource> list=new ArrayList<resource>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM resource ORDER BY id LIMIT "+(page*size-size)+","+size;
			pstm=this.conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				resource resource=new resource();
				resource.setId(rs.getInt(1));
				resource.setResname(rs.getString(2));
				resource.setRedescription(rs.getString(3));
				resource.setCtime(rs.getString(4));
				resource.setState(rs.getInt(5));
				list.add(resource);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return list;
	}

	public List<resource> searchResource(int page, int size, String key) {
		List<resource> list=new ArrayList<resource>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM resource WHERE resname=? ORDER BY id LIMIT "+(page*size-size)+","+size;
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, key);
			rs=pstm.executeQuery();
			while(rs.next()){
				resource resource=new resource();
				resource.setId(rs.getInt(1));
				resource.setResname(rs.getString(2));
				resource.setRedescription(rs.getString(3));
				resource.setCtime(rs.getString(4));
				resource.setState(rs.getInt(5));
				list.add(resource);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return list;
	}

	public resource findResource(int id) {
		resource resource=new resource();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM resource WHERE id=? LIMIT 1";
			pstm=this.conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs=pstm.executeQuery();
			if(rs.next()){	
				resource.setId(rs.getInt(1));
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return resource;
	}

	public int findCount() {
		int count=0;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT COUNT(*) FROM resource";
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

}
