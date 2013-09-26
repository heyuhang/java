package com.hyh.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

/**
 * 观点调查 接口
 * @author heyuhang
 *
 */
public interface OpinionInterface extends Remote{
	
	public void acceptOpinion(String opinion) throws RemoteException;//接收观众观点投票
	
	public String getOpinionCount()  throws RemoteException;//返回投票数
}
