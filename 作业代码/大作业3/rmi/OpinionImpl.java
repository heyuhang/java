package com.hyh.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 观点调查接口实现
 * @author heyuhang
 *
 */
public class OpinionImpl extends UnicastRemoteObject implements OpinionInterface{
	
	public   int yes;
	public   int no;
	public   int dcare;
	protected OpinionImpl() throws RemoteException {
		super();
		this.yes=0;
		this.no=0;
		this.dcare=0;
	}

	public void acceptOpinion(String opinion) {
		
		if(opinion.equals("yes")){
			this.yes++;
		}else if(opinion.equals("no")){
			this.no++;
		}else if(opinion.equals("don't care")){
			this.dcare++;
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	public String getOpinionCount() {
		
		StringBuffer count=new StringBuffer();
		count.append("yes :");
		count.append(String.valueOf(this.yes));
		count.append("no :");
		count.append(String.valueOf(this.no));
		count.append("don't care :");
		count.append(String.valueOf(this.dcare));
		return count.toString();
		
	}

}
