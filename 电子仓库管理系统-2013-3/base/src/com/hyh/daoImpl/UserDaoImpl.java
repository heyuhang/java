package com.hyh.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hyh.dao.UserDao;
import com.hyh.db.ConnectionManager;
import com.hyh.vo.user;

public class UserDaoImpl implements UserDao{

	private Connection conn;
	public UserDaoImpl(Connection conn){
		this.conn=conn;
	}

	public boolean addUser(user user) {
		PreparedStatement pstm=null;
		try{
			String sql="INSERT INTO buser(username,password,usertype,sectionid,sectionname,email,ctime,otime,state,power) VALUES(?,?,?,?,?,?,?,?,?,?)";
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, user.getUsername());
			pstm.setString(2, user.getPassword());
			pstm.setString(3, user.getUsertype());
			pstm.setInt(4, user.getSectionid());
			pstm.setString(5, user.getSectionname());
			pstm.setString(6, user.getEmail());
			pstm.setString(7, user.getCtime());
			pstm.setString(8, user.getOtime());
			pstm.setInt(9, user.getState());
			pstm.setString(10, user.getPower());
			if(pstm.executeUpdate()>0)
				return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(null, pstm, this.conn);
		}
		return false;
	}

	public boolean updateUser(user user) {
		PreparedStatement pstm=null;
	
		try{
			String sql="UPDATE buser SET username=?,password=?,usertype=?,sectionid=?,sectionname=?,email=?,ctime=?,state=? WHERE id=?";
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, user.getUsername());
			pstm.setString(2, user.getPassword());
			pstm.setString(3, user.getUsertype());
			pstm.setInt(4, user.getSectionid());
			pstm.setString(5, user.getSectionname());
			pstm.setString(6, user.getEmail());
			pstm.setString(7, user.getCtime());
			pstm.setInt(8, user.getState());
			pstm.setInt(9, user.getId());
			if(pstm.executeUpdate()>0)
				return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(null, pstm, this.conn);
		}
		return false;
	}

	public boolean deleteUser(int id) {
		PreparedStatement pstm=null;

		try{
			String sql="DELETE FROM buser WHERE id=?";
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

	public List<user> findUser(int page, int size) {
		List<user> list=new ArrayList<user>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM buser  ORDER BY id LIMIT "+(page*size-size)+","+size;
			pstm=this.conn.prepareStatement(sql);
			
			rs=pstm.executeQuery();
			while(rs.next()){
				user user=new user();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setUsertype(rs.getString(4));
				user.setSectionid(rs.getInt(5));
				user.setSectionname(rs.getString(6));
				user.setEmail(rs.getString(7));
				user.setCtime(rs.getString(8));
				user.setOtime(rs.getString(9));
				user.setState(rs.getInt(10));
				
				list.add(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return list;
	}

	public List<user> searchUser(int page, int size, String key) {
		List<user> list=new ArrayList<user>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM buser WHERE username like '%"+key+"%' ORDER BY id LIMIT "+(page*size-size)+","+size;
			pstm=this.conn.prepareStatement(sql);
	
			rs=pstm.executeQuery();
			while(rs.next()){
				user user=new user();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setUsertype(rs.getString(4));
				user.setSectionid(rs.getInt(5));
				user.setSectionname(rs.getString(6));
				user.setEmail(rs.getString(7));
				user.setCtime(rs.getString(8));
				user.setOtime(rs.getString(9));
				user.setState(rs.getInt(10));
				list.add(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return list;
	}

	public String checkUser(String username, String password) {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT power FROM buser WHERE username=? AND password=? AND state=1 LIMIT 1";
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);
			rs=pstm.executeQuery();
			if(rs.next()){
				String type=rs.getString(1);
				
				return type;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return null;
	}

	public user findUser(int id) {
		user user=new user();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM buser WHERE id=? LIMIT 1";
			pstm=this.conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs=pstm.executeQuery();
			if(rs.next()){
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setUsertype(rs.getString(4));
				user.setSectionid(rs.getInt(5));
				user.setSectionname(rs.getString(6));
				user.setEmail(rs.getString(7));
				user.setCtime(rs.getString(8));
				user.setOtime(rs.getString(9));
				user.setState(rs.getInt(10));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return user;
	}

	public int findCount() {
		int count=0;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT COUNT(*) FROM buser";
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
			String sql="SELECT COUNT(*)  FROM buser WHERE username like '%"+key+"%'";
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

	public boolean addGrant(String grant,int id) {
		PreparedStatement pstm=null;
		
		try{
			String sql="UPDATE buser SET power=?  WHERE id=?";
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, grant);
			pstm.setInt(2, id);

			if(pstm.executeUpdate()>0)
				return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(null, pstm, this.conn);
		}
		return false;
		
	}

}
