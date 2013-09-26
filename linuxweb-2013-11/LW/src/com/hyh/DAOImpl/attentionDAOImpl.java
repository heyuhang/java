package com.hyh.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.transaction.annotation.Transactional;

import com.hyh.Beans.attention;
import com.hyh.Beans.user;
import com.hyh.DAO.attentionDAO;

@Transactional
public class attentionDAOImpl implements attentionDAO{
	private JdbcTemplate jdbcTemplate;   //����ʹ��spring�ṩ��JdbcTemplate����й��?
	 public void setDataSource(DataSource dataSource) {
	  this.jdbcTemplate = new JdbcTemplate(dataSource);
	 }
	 @Transactional(rollbackFor=Exception.class)
	public void Addattention(long fromid, long toid) {
		 jdbcTemplate.update("insert into attention(fromid,toid,ationtime,isnew) values(?,?,curdate(),0)", 
		    	new Object[] {fromid,toid}); 		
	}
	public boolean Deleteattention(long fromid, long toid) {
		boolean judge=this.isAttention(fromid, toid);
		if(judge==false){
			return judge;
		}
	    jdbcTemplate.update("delete from attention where fromid=? and toid=?", 
	    		new Object[] {fromid,toid});
	    return judge;
	}
	public List Findattention(long fromid) {
		final List users=new ArrayList();
		List rows=jdbcTemplate.queryForList("select toid from attention where fromid="+fromid);
		for(int i=0;i<rows.size();i++){
			Map m=(Map)rows.get(i);
			long id=(Long)m.get("toid");
			
			jdbcTemplate.query("select * from user where id = ? LIMIT 1",  
                    new Object[] {id},  
                    new RowCallbackHandler() {  
                        public void processRow(ResultSet rs) throws SQLException {  
                        	user u=new user();
                        	u.setId(rs.getLong("id"));
                            u.setName(rs.getString("name"));  
                            u.setHeadpath(rs.getString("headpath"));  
                            u.setUsername(rs.getString("username"));  
                            users.add(u);
                        }
                        
                    }); 		
		}
		return users;
	}
	public boolean isAttention(long fromid, long toid) {
		boolean judge=false;
		long list=jdbcTemplate.queryForLong("select count(*) from attention where fromid = ? and toid=?",
				new Object[]{fromid,toid});
		if(list>0){
			judge=true;
		}
		return judge;
	}


	public boolean IsNew(long fromid) {
		boolean judge=false;
		long list=jdbcTemplate.queryForLong("select count(*) from attention where fromid=? and isnew=1",
				new Object[]{fromid});
		if(list>0){
			judge=true;
		}
		return judge;
	}
	public void UpdateNew(long fromid) {
		jdbcTemplate.update("update attention set isnew=0 where fromid=?",
				new Object[]{fromid});	
	}	 
}

