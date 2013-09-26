package com.hyh.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.transaction.annotation.Transactional;

import com.hyh.Beans.replay;
import com.hyh.Beans.user;
import com.hyh.DAO.replayDAO;

@Transactional
public class replayDAOImpl implements replayDAO{
	private JdbcTemplate jdbcTemplate;   //我们使用spring提供的JdbcTemplate类进行管理，
	 public void setDataSource(DataSource dataSource) {
	  this.jdbcTemplate = new JdbcTemplate(dataSource);
	 }
	public void addReplay(long fileid,long fromid, long toid, String content) {
		jdbcTemplate.update("insert into replay(fileid,fromid,toid,content) values(?,?,?,?)", 
				new Object[]{fileid,fromid,toid,content});
		
	}
	public void delReplay(long toid) {//根据id删除
		
		jdbcTemplate.update("delete from replay where id=? LIMIT 1",
				new Object[]{toid});
	}
	public List findRelay(long toid) {
		final List list=new ArrayList();
		jdbcTemplate.query("select * from replay where toid=?",new Object[]{toid},
			     new RowCallbackHandler() {  
            public void processRow(ResultSet rs) throws SQLException {  
            	replay r=new replay();
            	r.setId(rs.getLong("id"));
            	r.setFileid(rs.getLong("fileid"));
            	r.setFromid(rs.getLong("fromid"));
            	r.setToid(rs.getLong("toid"));
            	r.setContent(rs.getString("content"));
            	list.add(r);
            }
            
        }); 		
		return list;
	}
	public void delAll(long toid) {
		jdbcTemplate.update("delete from replay where toid=?",
				new Object[]{toid});
		
	}
}
