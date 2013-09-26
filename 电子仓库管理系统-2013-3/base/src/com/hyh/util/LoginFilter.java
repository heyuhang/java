package com.hyh.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter
{
    private FilterConfig filterConfig=null;

    public LoginFilter()
    {
        super();
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse res=(HttpServletResponse) response;
        String username=(String) req.getSession().getAttribute("username");
        System.out.println("==================>enter bim directory: " + username);
        if(username != null && !username.equals(""))
        {
            chain.doFilter(req, res);
        }
        else
        {
           RequestDispatcher rd=req.getRequestDispatcher("/loginerror.jsp");
            req.setAttribute("error", "请登录！");
            rd.forward(req, res);

        }

    }

    public void init(FilterConfig config) throws ServletException
    {
        filterConfig=config;
    }

    public void destroy()
    {}
}