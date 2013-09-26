package com.hyh.Util;

import java.util.Map;

import com.hyh.Action.AddComAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;



/*
 * 权限拦截器
 */
public class powerInter extends AbstractInterceptor  {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Map m = null;
		m=ActionContext.getContext().getSession();
		String username=(String)m.get("xiyoulinuxusername");
		Object action = arg0.getAction();
		if(action instanceof AddComAction && (username==null || username.equals(""))){
			return "LOGIN";
		}else{
			return "LOGINED";
		}
	}
}
