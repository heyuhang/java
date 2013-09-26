package com.hyh.DAO;

import java.util.List;

public interface replayDAO {

	public void addReplay(long fileid,long fromid,long toid,String content);
	
	public void delReplay(long toid);
	
	public List findRelay(long toid);
	
	public void delAll(long toid);
}
