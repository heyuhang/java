package com.hyh.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.transaction.annotation.Transactional;
/*
 * 回答
 */
import com.hyh.Beans.answer;
import com.hyh.Beans.comment;
import com.hyh.DAO.answerDAO;
@Transactional
public class AnswerDaoImpl implements answerDAO{
	private JdbcTemplate jdbcTemplate;   //����ʹ��spring�ṩ��JdbcTemplate����й��?
	 public void setDataSource(DataSource dataSource) {
	  this.jdbcTemplate = new JdbcTemplate(dataSource);
	 }
	public void addAnswer(long qaid, long fromid, String content) {
	    jdbcTemplate.update("insert into answer(qaid,fromid,answer,answertime,approve) values(?,?,?,now(),0)", 
	    		new Object[] {qaid,fromid,content});  
	    
	}

	public void delAnswer(long qaid) {
	    jdbcTemplate.update("delete from answer where qaid=?", 
	    		new Object[] {qaid});	
		
	}

	public List findAnswerByQaid(long qaid) {
		final List list=new ArrayList();
		jdbcTemplate.query("select * from answer where qaid=?", 
				new Object[]{qaid},
				new RowCallbackHandler() {  
                    public void processRow(ResultSet rs) throws SQLException {  
                    	answer com = new answer();
                    	com.setId(rs.getLong("id")); 
                    	com.setQaid(rs.getLong("qaid")); 
                    	com.setFromid(rs.getLong("fromid")); 
                    	com.setAnswer(rs.getString("answer"));  
                    	com.setAnswertime(rs.getString("answertime")); 
                    	com.setApprove(rs.getLong("approve"));
                    	list.add(com);
                    }  
                }); 
		return list;
	}
	public long addApprove(long answerid) {
	    jdbcTemplate.update("update  answer set approve=approve+1 where id="+answerid 
	    		);	
	    return jdbcTemplate.queryForLong("select approve from answer where id="+answerid);
		
	}

}
