package com.hyh.Action;

import java.util.LinkedList;
import java.util.List;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyh.Beans.labels;
import com.hyh.DAO.labelsDAO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	
	private List<labels> labels;
	ApplicationContext cxt = new ClassPathXmlApplicationContext(
		    "applicationContext.xml");
	
	labelsDAO ld=(labelsDAO)cxt.getBean("labelsService");

	public List<labels> getLabels() {
		return labels;
	}
	public void setLabels(List<labels> labels) {
		this.labels = labels;
	}	
	
	public String execute()throws Exception{

		labels=new LinkedList<labels>();
		List listl=ld.FindAll();
		for(int i=0;i<listl.size();i++){
			labels label=(labels)listl.get(i);
			labels.add(label);
		}

		return SUCCESS;
	}

}
