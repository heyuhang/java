package com.hyh.proxy;
/*
 * 用户  代理
 */
import java.util.List;

import com.hyh.dao.UserDao;
import com.hyh.daoImpl.UserDaoImpl;
import com.hyh.db.ConnectionManager;
import com.hyh.db.DataConnection;
import com.hyh.vo.user;

public class UserDaoProxy implements UserDao {
	private UserDao udao;
	//private DataConnection dc;

	public UserDaoProxy() {
		//dc = DataConnection.getInstance();
		this.udao = new UserDaoImpl(ConnectionManager.getInstance().getConnection());
	}

	public boolean addUser(user user) {
		boolean isSuccess = false;
		try {
			isSuccess = this.udao.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	public boolean updateUser(user user) {
		boolean isSuccess = false;
		try {
			isSuccess = this.udao.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	public boolean deleteUser(int id) {
		boolean isSuccess = false;
		try {
			isSuccess = this.udao.deleteUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	public List<user> findUser(int page, int size) {
		List<user> list = null;
		try {
			list = this.udao.findUser(page, size);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<user> searchUser(int page, int size, String key) {
		List<user> list = null;
		try {
			list = this.udao.searchUser(page, size, key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String checkUser(String username, String password) {
		String type = null;
		try {
			type = this.udao.checkUser(username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return type;
	}

	public user findUser(int id) {
		user user = null;
		try {
			user = this.udao.findUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public int findCount() {
		int count = 0;
		try {
			count = this.udao.findCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public int findCount(String key) {
		int count = 0;
		try {
			count = this.udao.findCount(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;		
	}

	public boolean addGrant(String grant, int id) {
		boolean isSuccess = false;
		try {
			isSuccess = this.udao.addGrant(grant, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

}
