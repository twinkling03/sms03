package com.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaweb.db.dao.ILoginUser;
import com.javaweb.db.dao.impl.LoginUserDAOImpl;
import com.javaweb.javabean.LoginUser;
import com.javaweb.service.LoginService;
import com.javaweb.service.impl.LoginServiceImpl;

public class LoginServlet extends HttpServlet {


	public LoginServlet() {
		super();
	}


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		String name=request.getParameter("name");
		String passwd=request.getParameter("passwd");
		boolean login=login(name,passwd);
		if(login){
			//login success, save loginuser to session
			HttpSession session= request.getSession();
			session.setAttribute("login", login);
			response.sendRedirect("./xx/FindAllStudent?m=query"); //�ͻ�����ת/�������ת
//			response.getWriter().write("<script>alert('success')</script>");
//			response.flushBuffer();
//			response.getWriter().close();
		}else{
			//login failed�� �ͷ�����ת����ַ���
			//response.sendRedirect("../../login.jsp");
			response.getWriter().write("<script>alert('failure');window.history.go(-1);</script>");
			response.flushBuffer();
			response.getWriter().close();
		}
	}

	
	public void init() throws ServletException {
		// Put your code here
		System.out.println("this is code in init method");
	}
	
	/**
	 * �ж��û��Ƿ��½�ɹ�
	 * @param name �û���
	 * @param pwd ����
	 * @return True �ɹ� False ʧ��
	 */
	public boolean login(String name,String pwd){
		boolean rst=false;
		LoginService service=new LoginServiceImpl();
		LoginUser loginuser=service.queryByNameAndPwd(name, pwd);
		if(loginuser!=null){//��¼�ɹ�
			rst=true;
		}
		
		return rst;
	}

}
