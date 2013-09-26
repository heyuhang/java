package com.hyh.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hyh.dao.StockInDao;
import com.hyh.db.ConnectionManager;
import com.hyh.vo.stock;
import com.hyh.vo.stockin;
import com.mysql.jdbc.Statement;

/*
 * 入库  实现
 */
public class StockInDaoImpl implements StockInDao{
	private Connection conn;
	
	public StockInDaoImpl(Connection conn){
		this.conn=conn;
	}
	public boolean addStockIn(List<stockin> list) {
		PreparedStatement pstm=null;
		try{
			this.conn.setAutoCommit(false);//设置事务不自动提交
			this.conn.setTransactionIsolation(this.conn.TRANSACTION_READ_COMMITTED);//防止未提交的数据被读取
			String sql="INSERT INTO stockin(stockindate,stockintype,batchno,createby,createtime,vendor,state,goods,shelf,number,remark,num) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			pstm=this.conn.prepareStatement(sql);
			for(int i=0;i<list.size();i++){				
				stockin s=list.get(i);
				pstm.setString(1, s.getStockindate());
				pstm.setString(2, s.getStockintype());
				pstm.setInt(3, s.getBatchno());
				pstm.setString(4, s.getCreateby());
				pstm.setString(5, s.getCreatetime());
				pstm.setString(6, s.getVendor());
				pstm.setInt(7, s.getState());
				pstm.setString(8, s.getGoods());
				pstm.setString(9, s.getShelf());
				pstm.setInt(10, s.getNumber());
				pstm.setString(11, s.getRemark());
				pstm.setString(12, s.getNum());
				pstm.addBatch();//添加到批chuli
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
	public int getStockIn(String product, String shelf) {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		int count=0;
		try{
			String sql="SELECT number FROM stockin WHERE goods=? AND shelf=? AND state=1";
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, product);
			pstm.setString(2, shelf);
			rs=pstm.executeQuery();
			while(rs.next()){
				count+=rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return count;
	}
	public int getStockIn(String product) {
		int count=0;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT number FROM stockin WHERE goods=? AND state=1";
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, product);
			rs=pstm.executeQuery();
			while(rs.next()){
				count+=rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return count;
	}
	public List<stockin> searchIn(int page,int size,String starDate,String endDate,String vendor) {
		List<stockin> list=new ArrayList<stockin>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT * FROM stockin  WHERE vendor=? AND UNIX_TIMESTAMP(stockindate) BETWEEN UNIX_TIMESTAMP(?) AND UNIX_TIMESTAMP(?)  ORDER BY id LIMIT "+(page*size-size)+","+size;
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, vendor);
			pstm.setString(2, starDate);
			pstm.setString(3, endDate);
			rs=pstm.executeQuery();
			while(rs.next()){
				stockin in=new stockin();
				in.setId(rs.getInt(1));
				in.setNum(rs.getString(2));
				in.setStockindate(rs.getString(3));
				in.setStockintype(rs.getString(4));
				in.setBatchno(rs.getInt(5));
				in.setCreateby(rs.getString(6));
				in.setCreatetime(rs.getString(7));
				in.setVendor(rs.getString(8));
				in.setState(rs.getInt(9));
				in.setGoods(rs.getString(10));
				in.setShelf(rs.getString(11));
				in.setNumber(rs.getInt(12));
				in.setRemark(rs.getString(13));
				list.add(in);
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
			String sql="SELECT COUNT(*) FROM stockin";
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
	public List<stock> searchStock(int page, int size, String goods,
			String shelf) {
		List<stock> list=new ArrayList<stock>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT goods,sort,brand,shelf,number FROM stockin,goods  WHERE stockin.goods=goods.gname  AND stockin.goods=? AND stockin.shelf=? ORDER BY goods LIMIT "+(page*size-size)+","+size;
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, goods);
			pstm.setString(2, shelf);
			rs=pstm.executeQuery();
			while(rs.next()){
				stock stock=new stock();
				stock.setGoods(rs.getString(1));
				stock.setGoodssort(rs.getString(2));
				stock.setGoodsbrand(rs.getString(3));
				stock.setShelf(rs.getString(4));
				stock.setNum(rs.getInt(5));
				list.add(stock);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			ConnectionManager.close(rs, pstm, this.conn);
		}
		return list;
	}
	public int findCount(String goods, String shelf) {
		int count=0;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			String sql="SELECT COUNT(*) FROM stockin,goods  WHERE stockin.goods=goods.gname  AND stockin.goods=? AND stockin.shelf=?";
			pstm=this.conn.prepareStatement(sql);
			pstm.setString(1, goods);
			pstm.setString(2, shelf);
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
			String sql="SELECT * FROM stockin  WHERE num=? LIMIT 1";
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
