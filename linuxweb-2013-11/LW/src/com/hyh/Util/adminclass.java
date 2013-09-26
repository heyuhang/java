package com.hyh.Util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class adminclass extends Properties{
	 private static  adminclass instance;
	
	public adminclass(){
		InputStream is = getClass().getResourceAsStream("/admin.properties");
		try {
			load(is);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	public static adminclass getInstance () {
		if(instance!=null) {
			return instance;
		} else {
			makeInstance();
			return instance;
		}
	}
    private static synchronized void makeInstance() {
	    if(instance == null) {
            instance = new adminclass();
	    }
    }
	
}
