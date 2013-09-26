package com.hyh.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.transaction.annotation.Transactional;

import com.hyh.Beans.files;
import com.hyh.Beans.labels;
import com.hyh.DAO.labelsDAO;


@Transactional
public class labelsDAOImpl implements labelsDAO{
	private JdbcTemplate jdbcTemplate;   //����ʹ��spring�ṩ��JdbcTemplate����й��?
	 public void setDataSource(DataSource dataSource) {
	  this.jdbcTemplate = new JdbcTemplate(dataSource);
	 }
	public void Addlabel(String title) {
	    jdbcTemplate.update("insert into labels(number,title) values(0,?)", 
	    		new Object[] {title});  		
	}
	public void Deletelabel(String title) {
	    jdbcTemplate.update("delete from labels where title=?", 
	    		new Object[] {title});  	
	}
	public void Addcount(String title) {
	    jdbcTemplate.update("update  labels set number=number+1 where title=?", 
	    		new Object[] {title});  
	}
	public void Deletecount(String title) {
	    jdbcTemplate.update("update  labels set number=number-1 where title=?", 
	    		new Object[] {title});  
	}
	public List<labels> FindAll() {
		final List<labels> list=new ArrayList<labels>();

		jdbcTemplate.query("select * from labels",
				new RowCallbackHandler() {  
            public void processRow(ResultSet rs) throws SQLException {  
            	labels label=new labels();
            	label.setId(rs.getLong("id"));  
            	label.setNumber(rs.getLong("number"));  
            	label.setTitle(rs.getString("title")); 
            	list.add(label);
            }  
        }); 
		return list;
	}
	public String MatchAdd(String label) {
		String rlabel="";
		List labelids=jdbcTemplate.queryForList("select title from labels" 
				);
		if(labelids.size()==0){
			this.Addlabel(label);
			this.Addcount(label);
			return "";
		}else{
			for(int i=0;i<labelids.size();i++){
				Map m=(Map)labelids.get(i);
				String slabel=(String)m.get("title");
				if(this.MatchUtil(slabel, label)){
					this.Addcount(label);
					rlabel=slabel;
					break;
				}
			}
		}
		if(rlabel.equals("")){
			this.Addlabel(label);
			this.Addcount(label);
		}
		return rlabel;
	}
	public boolean MatchUtil(String slabel,String dlabel){
		boolean judge=false;
		String regEx=slabel+"*";
		judge=Pattern.compile(regEx).matcher(dlabel).find();
		
		return judge;
	}
}

