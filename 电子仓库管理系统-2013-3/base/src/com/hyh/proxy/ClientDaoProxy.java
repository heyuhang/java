package com.hyh.proxy;

import java.sql.Connection;
import java.util.List;

import com.hyh.dao.ClientDao;
import com.hyh.daoImpl.ClientDaoImpl;
import com.hyh.db.ConnectionManager;
import com.hyh.db.DataConnection;
import com.hyh.vo.client;

/*
 * 客户  代理类
 */
public class ClientDaoProxy implements ClientDao{

	private ClientDao clientdao;
	//private DataConnection dc;
	
	public ClientDaoProxy(){
		//dc=DataConnection.getInstance();
	
		this.clientdao=new ClientDaoImpl(ConnectionManager.getInstance().getConnection());
	}
	public boolean addClient(client client) {
		boolean isSuccess=false;
		try{
			isSuccess=this.clientdao.addClient(client);
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}

	public boolean updateClient(client client) {
		boolean isSuccess=false;
		try{
			isSuccess=this.clientdao.updateClient(client);
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}

	public boolean deleteClient(int id) {
		boolean isSuccess=false;
		try{
			isSuccess=this.clientdao.deleteClient(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccess;
	}

	public List<client> findClient(int page, int size) {
		List<client> list=null;
		try{
			list=this.clientdao.findClient(page, size);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public List<client> searchClient(int page, int size, String key) {
		List<client> list=null;
		try{
			list=this.clientdao.searchClient(page, size, key);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public int findCount(String key) {
		int count=0;
		try{
			count=this.clientdao.findCount(key);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	public client findClient(int id) {
		client client=null;
		try{
			client=this.clientdao.findClient(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return client;
	}
	public int findCount() {
		int count=0;
		try{
			count=this.clientdao.findCount();
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	public List<client> findAll() {
		List<client> list=null;
		try{
			list=this.clientdao.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

}
