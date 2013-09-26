package com.hyh.DAOImpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.RowMapper;
import com.hyh.Beans.adminuser;
import com.hyh.DAO.adminuserDAO;

@Transactional
public class adminuserDAOImpl implements adminuserDAO{
	private JdbcTemplate jdbcTemplate;   //����ʹ��spring�ṩ��JdbcTemplate����й��?
	 public void setDataSource(DataSource dataSource) {
	  this.jdbcTemplate = new JdbcTemplate(dataSource);
	 }
	 @Transactional(rollbackFor=Exception.class)
	public boolean Check(String username, String password) {
		boolean judge=false;
		List list=(List)jdbcTemplate.queryForList("select * from adminuser where username=? and password=?  LIMIT 1",
				    new Object[]{username,password});
		if(list.size()>0){
			judge=true;
		}
		
		return judge;
	}
	 @SuppressWarnings("unchecked")
	public void Addadmin(String username, String password){
	    jdbcTemplate.update("insert into adminuser(username,password) values(?,?)", 
	    		new Object[] {username,password});  	
	}

	public void Update(String username, String password) {	
	    jdbcTemplate.update("update  adminuser set username=?,password=?", 
	    		new Object[] {username,password});		
	}
	
	public void Deleteadmin(String username) {
	    jdbcTemplate.update("delete from adminuser where username=?", 
	    		new Object[] {username});
	}
}
