package com.hyh.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.transaction.annotation.Transactional;

import com.hyh.Beans.files;
import com.hyh.Beans.qa;
import com.hyh.DAO.QaDAO;
@Transactional
public class QaDaoImpl implements QaDAO{
	private JdbcTemplate jdbcTemplate;   //����ʹ��spring�ṩ��JdbcTemplate����й��?
	 public void setDataSource(DataSource dataSource) {
	  this.jdbcTemplate = new JdbcTemplate(dataSource);
	 }
	public void addQa(qa qa) {
	    jdbcTemplate.update("insert into qa(userid,label,question,uploadtime,approve,anserno)"
		          +" values(?,?,?,now(),0,0)", 
	    		new Object[] {qa.getUserid(),qa.getLabel(),qa.getQuestion()}); 
		
	}

	public boolean delAq(long qaid, long userid) {
	    jdbcTemplate.update("delete from qa where id=? and userid=?", 
	    		new Object[] {qaid,userid});
	    List list=jdbcTemplate.queryForList("select * from qa where id=? LIMIT 1",
	    		new Object[]{qaid});
	    if(list.size()>0){
	    	return false;
	    }
		return true;
	}

	public boolean delQaAdmin(long qaid) {
	    jdbcTemplate.update("delete from qa where id=?", 
	    		new Object[] {qaid});
	    List list=jdbcTemplate.queryForList("select * from qa where id=? LIMIT 1",
	    		new Object[]{qaid});
	    if(list.size()>0){
	    	return false;
	    }
		return true;
	}

	public void upQa(qa qa) {
	    jdbcTemplate.update("update  qa set userid=?,label=?,question=?", 
	    		new Object[] {qa.getUserid(),qa.getLabel(),qa.getQuestion()});
		
	}

	public long approveQa(long qaid) {
	    jdbcTemplate.update("update  qa set approve=approve+1 where id="+qaid
	    		);
	    return jdbcTemplate.queryForLong("select approve from qa where id="+qaid);
	}

	public List findQaById(long qaid) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateAn(long qaid) {
	    jdbcTemplate.update("update  qa set anserno=anserno+1 where id="+qaid 
	    		);
		
	}

	public List findQaByLabel(String Label) {
		final List list=new ArrayList();

		
		jdbcTemplate.query("select * from qa where label=?",new String[]{Label},
				new RowCallbackHandler() {  
            public void processRow(ResultSet rs) throws SQLException {  
            	qa file=new qa();
            	file.setApprove(rs.getLong("approve"));  
  
            	file.setAnserno(rs.getLong("anserno"));        	
            	file.setQuestion(rs.getString("question")); 
            	file.setUploadtime(rs.getString("uploadtime"));
            	file.setId(rs.getLong("id"));
            	file.setLabel(rs.getString("label"));
            	file.setUserid(rs.getLong("userid"));
            	list.add(file);
            }  
        });
		return list;
	}

	public List findQaByUser(long userid) {
		final List list=new ArrayList();

		jdbcTemplate.query("select * from qa where userid=?",new Object[]{userid},
				new RowCallbackHandler() {  
            public void processRow(ResultSet rs) throws SQLException {  
            	qa file=new qa();
            	file.setApprove(rs.getLong("approve"));  
            	  
            	file.setAnserno(rs.getLong("anserno"));        	
            	file.setQuestion(rs.getString("question")); 
            	file.setUploadtime(rs.getString("uploadtime"));
            	file.setId(rs.getLong("id"));
            	file.setLabel(rs.getString("label"));
            	file.setUserid(rs.getLong("userid"));
            	list.add(file);
            }  
        });
		return list;
	}

	public List findQaByQaid(long id) {
		final List list=new ArrayList();
		jdbcTemplate.query("select * from qa where id=? LIMIT 1",
				new Object[]{id},new RowCallbackHandler() {  
            public void processRow(ResultSet rs) throws SQLException { 
            	qa file=new qa();
            	file.setApprove(rs.getLong("approve"));  
            	  
            	file.setAnserno(rs.getLong("anserno"));        	
            	file.setQuestion(rs.getString("question")); 
            	file.setUploadtime(rs.getString("uploadtime"));
            	file.setId(rs.getLong("id"));
            	file.setLabel(rs.getString("label"));
            	file.setUserid(rs.getLong("userid"));
            	list.add(file);
            }  
        });
		return list;
	}

	public List findQaByPage(int PageNow, int PageSize) {
		final List list=new ArrayList();
		jdbcTemplate.query("select * from qa order by id limit "+(PageNow*PageSize-PageSize)+","+PageSize,
				new RowCallbackHandler() {  
            public void processRow(ResultSet rs) throws SQLException { 
            	qa file=new qa();
            	file.setApprove(rs.getLong("approve"));  
            	  
            	file.setAnserno(rs.getLong("anserno"));        	
            	file.setQuestion(rs.getString("question")); 
            	file.setUploadtime(rs.getString("uploadtime"));
            	file.setId(rs.getLong("id"));
            	file.setLabel(rs.getString("label"));
            	file.setUserid(rs.getLong("userid"));
            	list.add(file);
            }  
        });
		return list;
	}

	public int findQaCount(String str, String sort) {
		String sql;
		int size=0;
		if(sort.equals("index")){
			size=jdbcTemplate.queryForInt("select count(*) from qa where question like '%"+str+"%'"
					);
		}else if(sort.equals("sort")){
			size=jdbcTemplate.queryForInt("select count(*) from qa where label= '"+str+"'"
					);			
		}else if(sort.equals("search")){
			size=jdbcTemplate.queryForInt("select count(*) from qa where question like '%"+str+"%'"
					);			
		}

		return size;
	}

	public int findQaCountById(long userid) {
		int size=jdbcTemplate.queryForInt("select count(*) from qa where userid="+userid
				);
		return size;
	}

	public List findQaByPageId(int PageNow, int PageSize, long id) {
		final List list=new ArrayList();
		jdbcTemplate.query("select * from qa where userid=? order by userid limit "+(PageNow*PageSize-PageSize)+","+PageSize,
				new Object[]{id},new RowCallbackHandler() {  
            public void processRow(ResultSet rs) throws SQLException { 
               	qa file=new qa();
            	file.setApprove(rs.getLong("approve"));  
            	  
            	file.setAnserno(rs.getLong("anserno"));        	
            	file.setQuestion(rs.getString("question")); 
            	file.setUploadtime(rs.getString("uploadtime"));
            	file.setId(rs.getLong("id"));
            	file.setLabel(rs.getString("label"));
            	file.setUserid(rs.getLong("userid"));
            	list.add(file);
            }  
        });
		return list;
	}

	public List findQaByPageLabel(int PageNow, int PageSize, String label) {
		final List list=new ArrayList();
		jdbcTemplate.query("select * from qa where label=? order by label limit "+(PageNow*PageSize-PageSize)+","+PageSize,
				new Object[]{label},new RowCallbackHandler() {  
            public void processRow(ResultSet rs) throws SQLException { 
               	qa file=new qa();
            	file.setApprove(rs.getLong("approve"));  
            	  
            	file.setAnserno(rs.getLong("anserno"));        	
            	file.setQuestion(rs.getString("question")); 
            	file.setUploadtime(rs.getString("uploadtime"));
            	file.setId(rs.getLong("id"));
            	file.setLabel(rs.getString("label"));
            	file.setUserid(rs.getLong("userid"));
            	list.add(file);
            }  
        });
		return list;
	}

	public void setTop(long qaid) {
		SimpleDateFormat mf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=mf.format(new Date());
//		int date2=Integer.parseInt(date);
	    jdbcTemplate.update("update  qa set toptime=? where id=?",new Object[]{date,qaid}
	    		);
		
	}

	public void delTop(long qaid) {
	    jdbcTemplate.update("update  qa set toptime=null where id=?",new Object[]{qaid}
	    		);
		
	}

}
