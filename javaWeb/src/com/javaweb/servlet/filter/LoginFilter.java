package com.javaweb.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	public void destroy() {
		System.out.println("this is called in Deployed method");

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response= (HttpServletResponse)resp;
		
		HttpSession session= request.getSession();
		Object login = session.getAttribute("login");
		if(login!=null){
			//login success or 
			chain.doFilter(request, response);
		}
		else{//login failure 
			response.sendRedirect("../../login.jsp");//请求重定向-->客服端跳转
			//request.getRequestDispatcher("../../login.jsp").forward(request, response);			
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("this is called in init method");

	}

}
