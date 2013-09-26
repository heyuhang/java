package com.hyh.DAOImpl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.transaction.annotation.Transactional;

import com.hyh.Beans.comment;
import com.hyh.DAO.commentDAO;


@Transactional
public class commentDAOImpl implements commentDAO {
	private JdbcTemplate jdbcTemplate;   //����ʹ��spring�ṩ��JdbcTemplate����й��?
	 public void setDataSource(DataSource dataSource) {
	  this.jdbcTemplate = new JdbcTemplate(dataSource);
	 }
	public void Addcomment(long fileid, long fromid, long toid, String content) {
	    jdbcTemplate.update("insert into comment(fileid,fromid,toid,content,commentime) values(?,?,?,?,now())", 
	    		new Object[] {fileid,fromid,toid,content});  
		
	}
	public void Deletecomment(long fileid) {
	    jdbcTemplate.update("delete from comment where fileid=?", 
	    		new Object[] {fileid});		
	}
	public List FindByfileid(long fileid) {
		
		final List list=new ArrayList();
		jdbcTemplate.query("select * from comment where fileid=?", 
				new Object[]{fileid},
				new RowCallbackHandler() {  
                    public void processRow(ResultSet rs) throws SQLException {  
                    	comment com = new comment();
                    	com.setId(rs.getLong("id")); 
                    	com.setFileid(rs.getLong("fileid")); 
                    	com.setFromid(rs.getLong("fromid"));  
                    	com.setToid(rs.getLong("toid"));  
                    	com.setContent(rs.getString("content"));  
                    	com.setCommentime(rs.getString("commentime")); 
                    	list.add(com);
                    }  
                }); 
		return list;
	}
}
