package com.hyh.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hyh.dao.DeliverDao;
import com.hyh.db.ConnectionManager;
import com.hyh.vo.deliver;

public class DeliverDaoImpl implements DeliverDao{

	private Connection conn;
	
	public DeliverDaoImpl(Connection conn){
		this.conn=conn;
	}
	public boolean addDeliver(List<deliver> list) {
		PreparedStatement pstm=null;
		try{
			this.conn.setAutoCommit(false);//设置事务不自动提交
			this.conn.setTransactionIsolation(this.conn.TRANSACTION_READ_COMMITTED);//防止未提交的数据被读取
			String sql="INSERT INTO deliver(num,createby,city,deliverdate,createtime,state,remark,outid,number,vendor) VALUES(?,?,?,?,?,?,?,?,?,?)";
			pstm=this.conn.prepareStatement(sql);
			for(int i=0;i<list.size();i++){	
				deliver deliver=list.get(i);
				pstm.setString(1, deliver.getNum());
				pstm.setString(2, deliver.getCreateby());
				pstm.setString(3, deliver.getCity());
				pstm.setString(4, deliver.getDeliverdate());
				pstm.setString(5, deliver.getCreatetime());
				pstm.setInt(6, deliver.getState());
				pstm.setString(7, deliver.getRemark());
				pstm.setString(8, deliver.getOutid());
				pstm.setInt(9, deliver.getNumber());
				pstm.setString(10, deliver.getVendor());
				pstm.addBatch();
			}
			int[] commintSQL=pstm.executeBatch();
			this.conn.setAutoCommit(true);
			pstm.close();
			if(commintSQL.length>0){
				return true;
			}
		}catch(Exception e){
			try {
				this.conn.rollback();
			} catch (SQLException e1) {
		
				e1.printStackTrace();
			}//回滚
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(null, pstm, this.conn);
		}
		return false;
	}
	public List<deliver> searchIn(int page, int size, String starDate,
			String endDate, String city) {
		List<deliver> list=new ArrayList<deliver>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM deliver  WHERE city=? AND UNIX_TIMESTAMP(deliverdate) BETWEEN UNIX_TIMESTAMP(?) AND UNIX_TIMESTAMP(?)  ORDER BY id LIMIT "+(page*size-size)+","+size;
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, city);
			pstm.setString(2, starDate);
			pstm.setString(3, endDate);
			rs=pstm.executeQuery();
			while(rs.next()){
				deliver deliver=new deliver();
				deliver.setId(rs.getInt(1));
				deliver.setNum(rs.getString(2));
				deliver.setCreateby(rs.getString(3));
				deliver.setCity(rs.getString(4));
				deliver.setDeliverdate(rs.getString(5));
				deliver.setCreatetime(rs.getString(6));
				deliver.setState(rs.getInt(7));
				deliver.setRemark(rs.getString(8));
				deliver.setOutid(rs.getString(9));
				deliver.setNumber(rs.getInt(10));
				deliver.setVendor(rs.getString(11));
				list.add(deliver);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}	
		return list;
	}
	public int findCount() {
		ResultSet rs=null;
		PreparedStatement pstm=null;
		int count=0;
		try{
			String sql="SELECT COUNT(*) FROM deliver";
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
	public boolean checkNum(String num) {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM deliver  WHERE num=? LIMIT 1";
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, num);
			rs=pstm.executeQuery();
			if(rs.next()){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return false;
	}

}
