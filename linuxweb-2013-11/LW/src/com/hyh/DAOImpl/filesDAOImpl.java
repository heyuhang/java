package com.hyh.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.transaction.annotation.Transactional;

import com.hyh.Beans.files;
import com.hyh.DAO.filesDAO;

@Transactional
public class filesDAOImpl implements filesDAO{
	private JdbcTemplate jdbcTemplate;   //����ʹ��spring�ṩ��JdbcTemplate����й��?
	 public void setDataSource(DataSource dataSource) {
	  this.jdbcTemplate = new JdbcTemplate(dataSource);
	 }
	public void Addfile(files file) {
	    jdbcTemplate.update("insert into files(userid,title,label,introduct,uploadtime,filepath,approve,commentno)"
		          +" values(?,?,?,?,now(),?,0,0)", 
	    		new Object[] {file.getUserid(),file.getTitle(),file.getLabel(),file.getIntroduct(),file.getFilepath()});  	
	}
	public boolean Deletefile(long fileid,long userid) {
	    jdbcTemplate.update("delete from files where id=? and userid=?", 
	    		new Object[] {fileid,userid});
	    List list=jdbcTemplate.queryForList("select * from files where id=? LIMIT 1",
	    		new Object[]{fileid});
	    if(list.size()>0){
	    	return false;
	    }
		return true;		
	}
	public boolean DeletefileAdmin(long fileid) {
	    jdbcTemplate.update("delete from files where id=?", 
	    		new Object[] {fileid});
	    List list=jdbcTemplate.queryForList("select * from files where id=? LIMIT 1",
	    		new Object[]{fileid});
	    if(list.size()>0){
	    	return false;
	    }
		return true;
	}
	public void Updatefile(files file) {
	    jdbcTemplate.update("update  files set userid=?,title=?,label=?,introduct=?,filepath=?", 
	    		new Object[] {file.getUserid(),file.getTitle(),file.getLabel(),file.getIntroduct(),file.getFilepath()});	
	}
	public long ApproveFile(long fileid) {
	    jdbcTemplate.update("update  files set approve=approve+1 where id="+fileid
	    		);
	    return jdbcTemplate.queryForLong("select approve from files where id="+fileid);
	}
	public void UpdateCom(long fileid) {
	    jdbcTemplate.update("update  files set commentno=commentno+1 where id="+fileid 
	    		);	
	}
	public List FindByLabel(String Label) {
		final List list=new ArrayList();

	
		jdbcTemplate.query("select * from files where label=?",new String[]{Label},
				new RowCallbackHandler() {  
            public void processRow(ResultSet rs) throws SQLException {  
            	files file=new files();
            	file.setApprove(rs.getLong("approve"));  
  
            	file.setCommentno(rs.getLong("commentno")); 
            	file.setTitle(rs.getString("title"));  
            	file.setFilepath(rs.getString("filepath"));        	
            	file.setIntroduct(rs.getString("introduct")); 
            	file.setUploadtime(rs.getString("uploadtime"));
            	file.setId(rs.getLong("id"));
            	file.setLabel(rs.getString("label"));
            	file.setUserid(rs.getLong("userid"));
            	list.add(file);
            }  
        });
		return list;
	}
	public List FindByUser(long userid) {
		final List list=new ArrayList();

		jdbcTemplate.query("select * from files where userid=?",new Object[]{userid},
				new RowCallbackHandler() {  
            public void processRow(ResultSet rs) throws SQLException {  
            	files file=new files();
            	file.setApprove(rs.getLong("approve"));  
          
            	file.setCommentno(rs.getLong("commentno")); 
            	file.setTitle(rs.getString("title"));  
            	file.setFilepath(rs.getString("filepath"));        	
            	file.setIntroduct(rs.getString("introduct")); 
            	file.setUploadtime(rs.getString("uploadtime"));
            	file.setId(rs.getLong("id"));
            	file.setLabel(rs.getString("label"));
            	file.setUserid(rs.getLong("userid"));
            	list.add(file);
            }  
        });
		return list;
	}
	public List FindByHot() {
		final List list=new ArrayList();
		jdbcTemplate.query("select * from files where commentno>10",
				new RowCallbackHandler() {  
            public void processRow(ResultSet rs) throws SQLException { 
            	files file=new files();
            	file.setApprove(rs.getLong("approve"));  
            
            	file.setCommentno(rs.getLong("commentno")); 
            	file.setTitle(rs.getString("title"));  
            	file.setFilepath(rs.getString("filepath"));        	
            	file.setIntroduct(rs.getString("introduct")); 
            	file.setUploadtime(rs.getString("uploadtime"));
            	file.setId(rs.getLong("id"));
            	file.setLabel(rs.getString("label"));
            	file.setUserid(rs.getLong("userid"));
            	list.add(file);
            }  
        });
		return list;
	}
	public List FindByNew() {
		/*
		 * findall һ�����·�����ļ�����������ʱ�Ӻ���ǰ���
		 */
		return null;
	}
	public List FindByPage(int PageNow,int PageSize) {
		final List list=new ArrayList();
		jdbcTemplate.query("select * from files order by id limit "+(PageNow*PageSize-PageSize)+","+PageSize,
				new RowCallbackHandler() {  
            public void processRow(ResultSet rs) throws SQLException { 
            	files file=new files();
            	file.setApprove(rs.getLong("approve"));  
          
            	file.setCommentno(rs.getLong("commentno")); 
            	file.setTitle(rs.getString("title"));  
            	file.setFilepath(rs.getString("filepath"));        	
            	file.setIntroduct(rs.getString("introduct")); 
            	file.setUploadtime(rs.getString("uploadtime"));
            	file.setId(rs.getLong("id"));
            	file.setLabel(rs.getString("label"));
            	file.setUserid(rs.getLong("userid"));
            	file.setToptime(rs.getString("toptime"));
            	list.add(file);
            }  
        });
		return list;
	}
	public int FindCount(String str,String sort) {
		String sql;
		int size=0;
		if(sort.equals("index")){
			size=jdbcTemplate.queryForInt("select count(*) from files where title like '%"+str+"%' or introduct like '%"+str+"%'"
					);
		}else if(sort.equals("sort")){
			size=jdbcTemplate.queryForInt("select count(*) from files where label= '"+str+"'"
					);			
		}else if(sort.equals("search")){
			size=jdbcTemplate.queryForInt("select count(*) from files where title like '%"+str+"%' or introduct like '%"+str+"%'"
					);			
		}

		return size;
	}
	public List FindByPageId(int PageNow, int PageSize, long id) {
		final List list=new ArrayList();
		jdbcTemplate.query("select * from files where userid=? order by userid limit "+(PageNow*PageSize-PageSize)+","+PageSize,
				new Object[]{id},new RowCallbackHandler() {  
            public void processRow(ResultSet rs) throws SQLException { 
            	files file=new files();
            	file.setApprove(rs.getLong("approve"));  
           
            	file.setCommentno(rs.getLong("commentno")); 
            	file.setTitle(rs.getString("title"));  
            	file.setFilepath(rs.getString("filepath"));        	
            	file.setIntroduct(rs.getString("introduct")); 
            	file.setUploadtime(rs.getString("uploadtime"));
            	file.setId(rs.getLong("id"));
            	file.setUserid(rs.getLong("userid"));
            	file.setLabel(rs.getString("label"));
            	list.add(file);
            }  
        });
		return list;
	}
	public List FindById(long filedid) {
		final List<files> list=new ArrayList<files>();
		jdbcTemplate.query("select * from files where id=? LIMIT 1",
				new Object[]{filedid},new RowCallbackHandler() {  
            public void processRow(ResultSet rs) throws SQLException { 
            	files file=new files();
            	file.setApprove(rs.getLong("approve"));  
           
            	file.setCommentno(rs.getLong("commentno")); 
            	file.setTitle(rs.getString("title"));  
            	file.setFilepath(rs.getString("filepath"));        	
            	file.setIntroduct(rs.getString("introduct")); 
            	file.setUploadtime(rs.getString("uploadtime"));
            	file.setId(rs.getLong("id"));
            	file.setUserid(rs.getLong("userid"));
            	file.setLabel(rs.getString("label"));
            	list.add(file);
            }  
        });
		return list;
	}
	public int FindCountById(long userid) {
		int size=jdbcTemplate.queryForInt("select count(*) from files where userid="+userid
				);
		return size;
	}
	public List FindByPageLabel(int PageNow, int PageSize, String label) {
		final List list=new ArrayList();
		jdbcTemplate.query("select * from files where label=? order by label limit "+(PageNow*PageSize-PageSize)+","+PageSize,
				new Object[]{label},new RowCallbackHandler() {  
            public void processRow(ResultSet rs) throws SQLException { 
            	files file=new files();
            	file.setApprove(rs.getLong("approve"));  
 
            	file.setCommentno(rs.getLong("commentno")); 
            	file.setTitle(rs.getString("title"));  
            	file.setFilepath(rs.getString("filepath"));        	
            	file.setIntroduct(rs.getString("introduct")); 
            	file.setUploadtime(rs.getString("uploadtime"));
            	file.setId(rs.getLong("id"));
            	file.setUserid(rs.getLong("userid"));
            	file.setLabel(rs.getString("label"));
            	list.add(file);
            }  
        });
		return list;
	}
	public List FindByPageTitle(int PageNow, int PageSize, String title) {
		final List list=new ArrayList();
		jdbcTemplate.query("select * from files where title like '%"+title+"%' order by id limit "+(PageNow*PageSize-PageSize)+","+PageSize,
				new RowCallbackHandler() {  
            public void processRow(ResultSet rs) throws SQLException { 
            	files file=new files();
            	file.setApprove(rs.getLong("approve"));  
           
            	file.setCommentno(rs.getLong("commentno")); 
            	file.setTitle(rs.getString("title"));  
            	file.setFilepath(rs.getString("filepath"));        	
            	file.setIntroduct(rs.getString("introduct")); 
            	file.setUploadtime(rs.getString("uploadtime"));
            	file.setId(rs.getLong("id"));
            	file.setUserid(rs.getLong("userid"));
            	file.setLabel(rs.getString("label"));
            	list.add(file);
            }  
        });
		return list;
	}
	public List FindByfileid(long id) {
		List lit=jdbcTemplate.queryForList("select userid from files where id="+id+" LIMIT 1");
		List<Long> list=new ArrayList<Long>();
		for(int i=0;i<lit.size();i++){
			Map m=(Map)lit.get(i);
			list.add((Long)m.get("userid"));
		}
		return list;
	}
	public List FindToTitle(long id) {
		List lit=jdbcTemplate.queryForList("select title from files where id="+id+" LIMIT 1");
		List<String> list=new ArrayList<String>();
		for(int i=0;i<lit.size();i++){
			Map m=(Map)lit.get(i);
			list.add((String)m.get("title"));
		}
		return list;
	}
	public void setTop(long fileid) {
		SimpleDateFormat mf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=mf.format(new Date());
//		int date2=Integer.parseInt(date);
	    jdbcTemplate.update("update  files set toptime=? where id=?",new Object[]{date,fileid}
	    		);
		
	}
	public void delTop(long fileid) {
	    jdbcTemplate.update("update  files set toptime=null where id=?",new Object[]{fileid}
	    		);
		
	}
	public String findFileName(long fileid) {
		List list=jdbcTemplate.queryForList("select filepath from files where id="+fileid);
		Map m=(Map)list.get(0);
		String filename=(String)m.get("filepath");
		return filename;
	}
}
