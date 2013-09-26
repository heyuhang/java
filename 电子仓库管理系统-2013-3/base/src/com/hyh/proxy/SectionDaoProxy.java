package com.hyh.proxy;

import java.util.List;

import com.hyh.dao.SectionDao;
import com.hyh.daoImpl.SectionDaoImpl;
import com.hyh.db.ConnectionManager;
import com.hyh.db.DataConnection;
import com.hyh.vo.section;

/*
 * 部门  代理
 */
public class SectionDaoProxy implements SectionDao{
	private SectionDao sdao;
	//private DataConnection dc;
	
	public SectionDaoProxy(){
		//dc=DataConnection.getInstance();
		this.sdao=new SectionDaoImpl(ConnectionManager.getInstance().getConnection());
	}

	public boolean addSection(section section) {
		boolean isSuccess=false;
		try{
			isSuccess=this.sdao.addSection(section);
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}

	public boolean updateSection(section section) {
		boolean isSuccess=false;
		try{
			isSuccess=this.sdao.updateSection(section);
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}

	public boolean deleteSection(int id) {
		boolean isSuccess=false;
		try{
			isSuccess=this.sdao.deleteSection(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}

	public List<section> findSection(int page, int size) {
		List<section> list=null;
		try{
			list=this.sdao.findSection(page, size);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public List<section> searchSection(int page, int size, String key) {
		List<section> list=null;
		try{
			list=this.sdao.searchSection(page, size, key);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public section findSection(int id) {
		section section=null;
		try{
			section=this.sdao.findSection(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return section;
	}

	public int findCount() {
		int count=0;
		try{
			count=this.sdao.findCount();
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

	public int findCount(String key) {
		int count=0;
		try{
			count=this.sdao.findCount(key);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

	public List<section> findAll() {
		List<section> list=null;
		try{
			list=this.sdao.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public boolean checkSection(String section) {
		// TODO Auto-generated method stub
		return false;
	}

}
