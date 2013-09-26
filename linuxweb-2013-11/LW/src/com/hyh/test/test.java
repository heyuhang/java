package com.hyh.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import com.hyh.Beans.files;
import com.hyh.Beans.labels;
import com.hyh.Beans.user;
import com.hyh.DAO.adminuserDAO;
import com.hyh.DAO.filesDAO;
import com.hyh.DAO.labelsDAO;
import com.hyh.DAO.userDAO;



public class test {
	public static void main(String[] args) {

	
			  ApplicationContext cxt = new ClassPathXmlApplicationContext(
			    "applicationContext.xml");
			  userDAO ss= (userDAO) cxt.getBean("userService"); 
			  user user=new user();
			  user.setEmail("546604074@qq.com");
			  user.setHeadpath("/head/linux.jpg");
			  user.setInterest("linux");
			  user.setIntroduct("web开发");
			  user.setName("heyuhang");
			  user.setPassword("heyuhang");
			  user.setUsername("heyuhang");
			  List list2=ss.FindByName("heyuhang");
//			 ss.Adduser(user);
			  filesDAO sf= (filesDAO) cxt.getBean("filesService"); 
//			  files file=new files();
//			  file.setUserid(1);
//			  file.setTitle("web开发");
//			  file.setLabel("web");
//			  file.setIntroduct("java web开发 spring详解");
//			  file.setFilepath("/files/file.xml");
//			  sf.Addfile(file);
//			  	System.out.println(sf.FindCount(""));		  
//
//	
//					List list=sf.FindByAll();
//					for(int i=0;i<list.size();i++){
//						files u=(files)list.get(i);
//						System.out.println(u.getId());
//						List list5=ss.FindById(4);
//						user f=(user)list2.get(0);
//						System.out.println(list.size()+"   "+u.getUserid()+"   "+f.getEmail());
//					}
			  List list=sf.FindByPageTitle(1, 10, "web");
			  System.out.println(list.size());	
					//List list3=sf.FindByPage(1, 2, ( (user)list2.get(0) ).getId());
			  labelsDAO ld=(labelsDAO)cxt.getBean("labelsService");
				List listl=ld.FindAll();
				for(int i=0;i<listl.size();i++){
					labels label=(labels)listl.get(i);
					System.out.println(label.getTitle());
				}
			System.out.println(ss.FindId("heyuhang"));
	}
}
