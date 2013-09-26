package com.hyh.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hyh.dao.GoodsBrandDao;
import com.hyh.db.ConnectionManager;
import com.hyh.vo.goodsbrand;

public class GoodsBrandDaoImpl implements GoodsBrandDao{
	
	private Connection conn;
	public GoodsBrandDaoImpl(Connection conn){
		this.conn=conn;
	}

	public boolean addGoodsBrand(goodsbrand goodsbrand) {
		PreparedStatement pstm=null;
	
		try{
			String sql="INSERT INTO goodsbrand(brname,brdescription) VALUES(?,?)";
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1,goodsbrand.getBrname() );
			pstm.setString(2, goodsbrand.getBrdescription());
			if(pstm.executeUpdate()>0)
				return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(null, pstm, this.conn);
		}
		return false;
	}

	public boolean updateGoodsBrand(goodsbrand goodsbrand) {
		PreparedStatement pstm=null;

		try{
			String sql="UPDATE goodsbrand SET brname=?,brdescription=? WHERE id=?";
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1,goodsbrand.getBrname() );
			pstm.setString(2, goodsbrand.getBrdescription());
			pstm.setInt(3, goodsbrand.getId());
			if(pstm.executeUpdate()>0)
				return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(null, pstm, this.conn);
		}
		return false;
	}

	public boolean deleteGoodsBrand(int id) {
		PreparedStatement pstm=null;
		try{
			String sql="DELETE FROM goodsbrand WHERE id=?";
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

	public List<goodsbrand> findGoodsBrand(int page, int size) {
		List<goodsbrand> list=new ArrayList<goodsbrand>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM goodsbrand ORDER BY id LIMIT "+(page*size-size)+","+size;
			pstm=this.conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				goodsbrand gb=new goodsbrand();
				gb.setId(rs.getInt(1));
				gb.setBrname(rs.getString(2));
				gb.setBrdescription(rs.getString(3));
				list.add(gb);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}	
		return list;
	}

	public List<goodsbrand> searchGoodsBrand(int page, int size, String key) {
		List<goodsbrand> list=new ArrayList<goodsbrand>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM goodsbrand WHERE  brname like '%"+key+"%' ORDER BY id LIMIT "+(page*size-size)+","+size;
			pstm=this.conn.prepareStatement(sql);
	
			rs=pstm.executeQuery();
			while(rs.next()){
				goodsbrand gb=new goodsbrand();
				gb.setId(rs.getInt(1));
				gb.setBrname(rs.getString(2));
				gb.setBrdescription(rs.getString(3));
				list.add(gb);
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
			String sql="SELECT COUNT(*)  FROM goodsbrand WHERE sortname like '%"+key+"%'";
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

	public goodsbrand findBrand(int id) {
		goodsbrand goodsbrand=new goodsbrand();			
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try{
			String sql="SELECT * FROM goodsbrand WHERE id=? LIMIT 1";
			pstm=this.conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs=pstm.executeQuery();
			if(rs.next()){
				goodsbrand.setId(rs.getInt(1));
				goodsbrand.setBrname(rs.getString(2));
				goodsbrand.setBrdescription(rs.getString(3));
	
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return goodsbrand;
	}

	public int findCount() {
		int count=0;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT COUNT(*) FROM goodsbrand";
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

	public List<goodsbrand> findAll() {
			List<goodsbrand> list=new ArrayList<goodsbrand>();
			PreparedStatement pstm=null;
			ResultSet rs=null;
			try{
				String sql="SELECT * FROM goodsbrand";
				pstm=this.conn.prepareStatement(sql);
				rs=pstm.executeQuery();
				while(rs.next()){
					goodsbrand gb=new goodsbrand();
					gb.setId(rs.getInt(1));
					gb.setBrname(rs.getString(2));
					gb.setBrdescription(rs.getString(3));
					list.add(gb);
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				
				ConnectionManager.close(rs, pstm, this.conn);
			}	
			return list;

	}
}
