package com.hyh.Beans;

public class labels {
   private long id;
   private long number;//文件数量
   private String title;
   
   public labels(){
	   this.number=0;
   }
   public long getId() {
	   return id;
   }
   public void setId(long id) {
	   this.id = id;
   }
   public long getNumber() {
	   return number;
   }
   public void setNumber(long number) {
	   this.number = number;
   }
   public String getTitle() {
	   return title;
   }
   public void setTitle(String title) {
	   this.title = title;
   }
   
}
