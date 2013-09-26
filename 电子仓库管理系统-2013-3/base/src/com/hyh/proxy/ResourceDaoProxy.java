package com.hyh.proxy;

import java.util.List;

import com.hyh.dao.ResourceDao;
import com.hyh.daoImpl.ResourceDaoImpl;
import com.hyh.db.ConnectionManager;
import com.hyh.db.DataConnection;
import com.hyh.vo.resource;

/*
 * 资源  代理
 */
public class ResourceDaoProxy implements ResourceDao{

	private ResourceDao rdao;
	//private DataConnection dc;
	
	public ResourceDaoProxy(){
		//dc=DataConnection.getInstance();
		this.rdao=new ResourceDaoImpl(ConnectionManager.getInstance().getConnection());
	}
	public boolean addResource(resource resource) {
		boolean isSuccess=false;
		try{
			isSuccess=this.rdao.addResource(resource);
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}
	public boolean updateResource(resource resource) {
		boolean isSuccess=false;
		try{
			isSuccess=this.rdao.updateResource(resource);
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}
	public boolean deleteResource(int id) {
		boolean isSuccess=false;
		try{
			isSuccess=this.rdao.deleteResource(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}
	public List<resource> findResource(int page, int size) {
		List<resource> list=null;
		try{
			list=this.rdao.findResource(page, size);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public List<resource> searchResource(int page, int size, String key) {
		List<resource> list=null;
		try{
			list=this.rdao.searchResource(page, size, key);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public resource findResource(int id) {
		resource resource=null;
		try{
			resource=this.rdao.findResource(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return resource;
	}
	public int findCount() {
		int count=0;
		try{
			count=this.rdao.findCount();
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
}
