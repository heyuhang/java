package com.hyh.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hyh.dao.ClientDao;
import com.hyh.db.ConnectionManager;
import com.hyh.vo.client;

/*
 * 客户  接口 实现
 */
public class ClientDaoImpl implements ClientDao {

	private Connection conn;
	
	public ClientDaoImpl(Connection conn){
		this.conn=conn;
	}
	@SuppressWarnings("finally")
	public boolean addClient(client client) {
		PreparedStatement pstm=null;
		try{
			String sql="INSERT INTO client(cname,ccity,caddress,cpost,cphone,clpeople,state) VALUES(?,?,?,?,?,?,?)";
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, client.getCname());
			pstm.setString(2, client.getCcity());
			pstm.setString(3, client.getCaddress());
			pstm.setString(4, client.getCpost());
			pstm.setString(5, client.getCphone());
			pstm.setString(6, client.getClpeople());
			pstm.setInt(7, client.getState());
			if(pstm.executeUpdate()>0)
				return true;
			
		}catch(Exception e){
			e.printStackTrace();	
		}finally{
			
			ConnectionManager.close(null, pstm, this.conn);
		}
		return false;
	}

	public boolean updateClient(client client) {
		PreparedStatement pstm=null;
		try{
			String sql="UPDATE  client SET cname=?,ccity=?,caddress=?,cpost=?,cphone=?,clpeople=?,state=? WHERE id=?";
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, client.getCname());
			pstm.setString(2, client.getCcity());
			pstm.setString(3, client.getCaddress());
			pstm.setString(4, client.getCpost());
			pstm.setString(5, client.getCphone());
			pstm.setString(6, client.getClpeople());
			pstm.setInt(7, client.getState());
			pstm.setInt(8, client.getId());
			if(pstm.executeUpdate()>0)
				return true;
			
		}catch(Exception e){
			e.printStackTrace();	
		}finally{
			
			ConnectionManager.close(null, pstm, this.conn);
		}
		return false;
	}
	@SuppressWarnings("finally")
	public boolean deleteClient(int id) {
		PreparedStatement pstm=null;
		try{
			String sql="DELETE FROM client WHERE id=?";
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

	public List<client> findClient(int page, int size) {
		List<client> list=new ArrayList<client>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM client  ORDER BY id LIMIT "+(page*size-size)+","+size;
			pstm=this.conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				client client=new client();
				client.setId(rs.getInt(1));
				client.setCname(rs.getString(2));
				client.setCcity(rs.getString(3));
				client.setCaddress(rs.getString(4));
				client.setCpost(rs.getString(5));
				client.setCphone(rs.getString(6));
				client.setClpeople(rs.getString(7));
				client.setState(rs.getInt(8));
				list.add(client);
			}
			
		}catch(Exception e){
			e.printStackTrace();	
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return list;
	}

	public List<client> searchClient(int page, int size, String key) {
		List<client> list=new ArrayList<client>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM client WHERE cname like '%"+key+"%' ORDER BY id LIMIT "+(page*size-size)+","+size;
			pstm=this.conn.prepareStatement(sql);

			rs=pstm.executeQuery();
			while(rs.next()){
				client client=new client();
				client.setId(rs.getInt(1));
				client.setCname(rs.getString(2));
				client.setCcity(rs.getString(3));
				client.setCaddress(rs.getString(4));
				client.setCpost(rs.getString(5));
				client.setCphone(rs.getString(6));
				client.setClpeople(rs.getString(7));
				client.setState(rs.getInt(8));
				list.add(client);
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
			String sql="SELECT COUNT(*)  FROM client WHERE cname like '%"+key+"%'";
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

	public client findClient(int id) {
		client client=new client();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM client WHERE id=? LIMIT 1";
			pstm=this.conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs=pstm.executeQuery();
			if(rs.next()){
				
				client.setId(rs.getInt(1));
				client.setCname(rs.getString(2));
				client.setCcity(rs.getString(3));
				client.setCaddress(rs.getString(4));
				client.setCpost(rs.getString(5));
				client.setCphone(rs.getString(6));
				client.setClpeople(rs.getString(7));
				client.setState(rs.getInt(8));
	
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return client;
	}

	public int findCount() {
		int count=0;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT COUNT(*) FROM client";
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

	public List<client> findAll() {
		List<client> list=new ArrayList<client>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM client WHERE state=1";
			pstm=this.conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				client client=new client();
				client.setId(rs.getInt(1));
				client.setCname(rs.getString(2));
				client.setCcity(rs.getString(3));
				client.setCaddress(rs.getString(4));
				client.setCpost(rs.getString(5));
				client.setCphone(rs.getString(6));
				client.setClpeople(rs.getString(7));
				client.setState(rs.getInt(8));
				list.add(client);
			}
			
		}catch(Exception e){
			e.printStackTrace();	
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return list;
	}

}
