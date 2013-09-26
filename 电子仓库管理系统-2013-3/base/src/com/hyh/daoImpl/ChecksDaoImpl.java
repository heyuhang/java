package com.hyh.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hyh.dao.ChecksDao;
import com.hyh.db.ConnectionManager;
import com.hyh.vo.checks;

public class ChecksDaoImpl implements ChecksDao{
	private Connection conn;
	public ChecksDaoImpl(Connection conn){
		this.conn=conn;
	}
	public boolean addChecks(List<checks> list) {
		PreparedStatement pstm=null;
		try{
			this.conn.setAutoCommit(false);//设置事务不自动提交
			this.conn.setTransactionIsolation(this.conn.TRANSACTION_READ_COMMITTED);//防止未提交的数据被读取
			String sql="INSERT INTO checks(num,createby,shelfname,checkdate,createtime,state,remark,goods,number,realnum) VALUES(?,?,?,?,?,?,?,?,?,?)";
			pstm=this.conn.prepareStatement(sql);
			for(int i=0;i<list.size();i++){	
				checks cc=list.get(i);
				pstm.setString(1, cc.getNum());
				pstm.setString(2, cc.getCreateby());
				pstm.setString(3, cc.getShelfname());
				pstm.setString(4, cc.getCheckdate());
				pstm.setString(5, cc.getCreatetime());
				pstm.setInt(6, cc.getState());
				pstm.setString(7,cc.getRemark());
				pstm.setString(8, cc.getGoods());
				pstm.setInt(9, cc.getNumber());
				pstm.setInt(10, cc.getRealnum());
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
	public List<checks> searchIn(int page, int size, String starDate,
			String endDate, String shelf) {
		List<checks> list=new ArrayList<checks>();
		PreparedStatement pstm=null;
		try{
			String sql="SELECT * FROM checks  WHERE shelfname=? AND UNIX_TIMESTAMP(checkdate) BETWEEN UNIX_TIMESTAMP(?) AND UNIX_TIMESTAMP(?)  ORDER BY id LIMIT "+(page*size-size)+","+size;
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, shelf);
			pstm.setString(2, starDate);
			pstm.setString(3, endDate);
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				checks checks=new checks();
				checks.setId(rs.getInt(1));
				checks.setNum(rs.getString(2));
				checks.setCreateby(rs.getString(3));
				checks.setShelfname(rs.getString(4));
				checks.setCheckdate(rs.getString(5));
				checks.setCreatetime(rs.getString(6));
				checks.setState(rs.getInt(7));				
				checks.setRemark(rs.getString(8));
				checks.setGoods(rs.getString(9));
				checks.setNumber(rs.getInt(10));
				checks.setRealnum(rs.getInt(11));
				list.add(checks);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(null, pstm, this.conn);
		}
		return list;
	}
	public int findCount() {
		int count=0;
		PreparedStatement pstm=null;
		try{
			String sql="SELECT COUNT(*) FROM checks";
			pstm=this.conn.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			ConnectionManager.getInstance().close(null, pstm, this.conn);
		}
		return count;
	}
	public boolean checkNum(String num) {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM checks  WHERE num=? LIMIT 1";
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
