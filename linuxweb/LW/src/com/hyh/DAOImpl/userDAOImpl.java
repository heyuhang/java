package com.hyh.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.transaction.annotation.Transactional;

import com.hyh.Beans.user;
import com.hyh.DAO.userDAO;

@Transactional
public class userDAOImpl implements userDAO{
	private JdbcTemplate jdbcTemplate;   
	 public void setDataSource(DataSource dataSource) {
	  this.jdbcTemplate = new JdbcTemplate(dataSource);
	 }
	public void Adduser(user user) {
	    jdbcTemplate.update("insert into user(name,username,password,email,interest,introduct,state) values(?,?,?,?,?,?,0)", 
	    		new Object[] {user.getName(),user.getUsername(),user.getPassword(),user.getEmail()
	    		,user.getInterest(),user.getIntroduct()});  
	}
	public void Updateuser(String name,String interest, String introduct,String headpath, long userid) {
		if(headpath==null){
			jdbcTemplate.update("update  user set name=?,interest=?,introduct=? where id="+userid, 
		    		new Object[] {name,interest,introduct});  			
		}else{
			jdbcTemplate.update("update  user set name=?,interest=?,introduct=?,headpath=? where id="+userid, 
	    		new Object[] {name,interest,introduct,headpath});  
		}
	}
	public void UpdateUP(long userid, String password) {
	    jdbcTemplate.update("update  user set password=? where id="+userid, 
	    		new Object[] {password});  	
	}
	public void Deleteuser(long userid) {
	    jdbcTemplate.update("delete from user where id=? LIMIT 1", 
	    		new Object[] {userid});  
	}
	public boolean Check(String username, String password) {
		boolean judge=false;
		List list=(List)jdbcTemplate.queryForList("select * from user where username=? and password=? LIMIT 1",
				    new Object[]{username,password});
		if(list.size()>0){
			judge=true;
		}
		
		return judge;
	}
	public List FindById(long id) {
		final List list=new ArrayList();
		jdbcTemplate.query("select * from user where id=?",new Object[]{id},
		new RowCallbackHandler() {  
            public void processRow(ResultSet rs) throws SQLException { 
            	user user=new user();
            	user.setName(rs.getString("name"));
            	user.setEmail(rs.getString("email"));
            	user.setHeadpath(rs.getString("headpath"));
            	user.setId(rs.getLong("id"));
            	user.setInterest(rs.getString("interest"));
            	user.setIntroduct(rs.getString("introduct"));
            	user.setState(rs.getInt("state"));
            	list.add(user);
            }  
        });
		return list;
	}
	public List FindByName(String username) {
		final List list=new ArrayList();
		jdbcTemplate.query("select * from user where username=?",new Object[]{username},
		new RowCallbackHandler() {  
            public void processRow(ResultSet rs) throws SQLException { 
            	user user=new user();
            	user.setName(rs.getString("name"));
            	user.setEmail(rs.getString("email"));
            	user.setHeadpath(rs.getString("headpath"));
            	user.setId(rs.getLong("id"));
            	user.setPassword(rs.getString("password"));
            	user.setUsername(rs.getString("username"));
            	user.setInterest(rs.getString("interest"));
            	user.setIntroduct(rs.getString("introduct"));
            	user.setState(rs.getInt("state"));
            	list.add(user);
            }  
        });
		return list;
	}
	public long FindId(String username) {
		
		List list=jdbcTemplate.queryForList("select id from user where username='"+username+"'");
		if(list.size()>0){
			Map m=(Map)list.get(0);
			return (Long) m.get("id");
		}
		return 0;
	}
	public boolean CheckPassword(long id,String password) {
		boolean judge=false;
		List list=(List)jdbcTemplate.queryForList("select * from user where id="+id+" and password=?",
				    new Object[]{password});
		if(list.size()>0){
			judge=true;
		}
		
		return judge;
	}
	public boolean CheckUsername(String username) {
		boolean judge=false;
		List list=(List)jdbcTemplate.queryForList("select * from user where username=?",
				    new Object[]{username});
		if(list.size()>0){
			judge=true;
		}
		
		return judge;
	}
	public void SetOnline(long userid) {
		jdbcTemplate.update("update  user set state=1 where id="+userid); 
		
	}
	public void ExitOnline(long userid) {
		jdbcTemplate.update("update  user set state=0 where id="+userid); 
		
	}
}
