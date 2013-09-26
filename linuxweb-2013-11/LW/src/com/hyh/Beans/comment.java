package com.hyh.Beans;

public class comment {
   private long id;
   private long fileid;
   private long fromid;
   private long toid;
   private String content;//ÄÚÈÝ£¬100×Ö·û
   private String commentime;
   
   public long getFromid() {
	   return fromid;
   }
   public void setFromid(long fromid) {
	   this.fromid = fromid;
   }
   public long getToid() {
	   return toid;
   }
   public void setToid(long toid) {
	   this.toid = toid;
   }
   public String getCommentime() {
	   return commentime;
   }
   public void setCommentime(String commentime) {
	   this.commentime = commentime;
   }
   public long getId() {
	   return id;
   }
   public void setId(long id) {
	   this.id = id;
   }
   public long getFileid() {
	   return fileid;
   }
   public void setFileid(long fileid) {
	   this.fileid = fileid;
   }
   public String getContent() {
	   return content;
   }
   public void setContent(String content) {
	   this.content = content;
   }
   
}
