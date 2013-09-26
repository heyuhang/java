package com.hyh.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * 字符乱码  过滤器
 */
public class CharsetFilter implements Filter{
	protected String encoding = null;
	protected FilterConfig filterConfig = null;
	public void destroy() {
		System.out.println("过滤器销毁!");
		this.encoding = null;
		this.filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String encoding = this.encoding;
		if (encoding != null) {
			request.setCharacterEncoding(encoding);
			response.setCharacterEncoding(encoding);
			response.setContentType("text/html;charset=GBK");
		}else {
			 request.setCharacterEncoding("GBK");
		}
		 chain.doFilter(request, response);// 传递过滤链
	}

	public void init(FilterConfig config) throws ServletException {
		System.out.println("过滤器初始化!");
		this.filterConfig = config;
		this.encoding = filterConfig.getInitParameter("encoding");// 获取传递过来的初使化编码
	}

}
