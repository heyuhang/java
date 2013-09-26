package com.hyh.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hyh.dao.StockOutDao;
import com.hyh.db.ConnectionManager;
import com.hyh.vo.stockout;
/*
 * 提交  出库
 */
public class StockOutDaoImpl implements StockOutDao{
	private Connection conn;
	
	public StockOutDaoImpl(Connection conn){
		this.conn=conn;
	}
	public boolean addStockOut(List<stockout> list) {
		PreparedStatement pstm=null;
		try{
			this.conn.setAutoCommit(false);//设置事务不自动提交
			this.conn.setTransactionIsolation(this.conn.TRANSACTION_READ_COMMITTED);//防止未提交的数据被读取
			String sql="INSERT INTO stockout(stockouttype,createby,createtime,stockoutdate,vendor,remark,state,goods,shelf,number,outnum,num) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			pstm=this.conn.prepareStatement(sql);
			for(int i=0;i<list.size();i++){	
				stockout out=list.get(i);
				pstm.setString(1,out.getStockouttype());
				pstm.setString(2,out.getCreateby());
				pstm.setString(3,out.getCreatetime());
				pstm.setString(4,out.getStockoutdate());
				pstm.setString(5,out.getVendor());
				pstm.setString(6,out.getRemark());
				pstm.setInt(7,out.getState());
				pstm.setString(8,out.getGoods());
				pstm.setString(9,out.getShelf());
				pstm.setInt(10,out.getNumber());
				pstm.setInt(11,out.getOutnum());
				pstm.setString(12, out.getNum());
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
	
	public List<stockout> getAll() {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		List<stockout> list=new ArrayList<stockout>();
		try{
			String sql="SELECT * FROM stockout WHERE state=1";
			pstm=this.conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){	
				stockout out=new stockout();
				out.setId(rs.getInt(1));
				out.setNum(rs.getString(2));
				out.setStockouttype(rs.getString(3));
				out.setCreateby(rs.getString(4));
				out.setCreatetime(rs.getString(5));
				out.setStockoutdate(rs.getString(6));
				out.setVendor(rs.getString(7));
				out.setRemark(rs.getString(8));
				out.setState(rs.getInt(9));
				out.setGoods(rs.getString(10));
				out.setShelf(rs.getString(11));
				out.setNumber(rs.getInt(12));
				out.setOutnum(rs.getInt(13));
				list.add(out);
			}
			
		}catch(Exception e){
			e.printStackTrace();	
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return list;
	}
	public int getStockOut(String product) {
		int count=0;
		boolean jud=false;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT outnum FROM stockout WHERE goods=? AND state=1";
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, product);
			rs=pstm.executeQuery();
			while(rs.next()){
				count+=rs.getInt(1);
				jud=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		if(jud==false)
			return -1;
		return count;
	}
	public List<stockout> searchIn(int page, int size, String starDate,
			String endDate, String vendor) {
		List<stockout> list=new ArrayList<stockout>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM stockout  WHERE vendor=? AND UNIX_TIMESTAMP(stockoutdate) BETWEEN UNIX_TIMESTAMP(?) AND UNIX_TIMESTAMP(?)  ORDER BY id LIMIT "+(page*size-size)+","+size;
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, vendor);
			pstm.setString(2, starDate);
			pstm.setString(3, endDate);
			rs=pstm.executeQuery();
			while(rs.next()){	
				stockout out=new stockout();
				out.setId(rs.getInt(1));
				out.setNum(rs.getString(2));
				out.setStockouttype(rs.getString(3));
				out.setCreateby(rs.getString(4));
				out.setCreatetime(rs.getString(5));
				out.setStockoutdate(rs.getString(6));
				out.setVendor(rs.getString(7));
				out.setRemark(rs.getString(8));
				out.setState(rs.getInt(9));
				out.setGoods(rs.getString(10));
				out.setShelf(rs.getString(11));
				out.setNumber(rs.getInt(12));
				out.setOutnum(rs.getInt(13));
				list.add(out);				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}	
		return list;
	}
	public int findCount() {
		int count=0;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT COUNT(*) FROM stockout";
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
	public String getVendor(String num) {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT vendor FROM stockout WHERE num=? LIMIT 1";
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, num);
			rs=pstm.executeQuery();
			if(rs.next()){
				return rs.getString(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return null;
	}
	public boolean checkNum(String num) {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM stockout  WHERE num=? LIMIT 1";
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
	public int getStockOut(String product, String shelf) {
		int count=0;
		boolean jud=false;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT number FROM stockout WHERE goods=? AND shelf=? AND state=1";
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, product);
			pstm.setString(2, shelf);
			rs=pstm.executeQuery();
			while(rs.next()){
				count+=rs.getInt(1);
				jud=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		if(jud==false)
			return -1;
		return count;
	}

}
