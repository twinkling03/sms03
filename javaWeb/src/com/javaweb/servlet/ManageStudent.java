package com.javaweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaweb.db.dao.IStudent;
import com.javaweb.db.dao.impl.StudentDAOImpl;
import com.javaweb.javabean.Student;
import com.javaweb.service.StudentSerice;
import com.javaweb.service.impl.StudentServiceImpl;

public class ManageStudent extends HttpServlet {

	private StudentSerice service=new StudentServiceImpl();

	public ManageStudent() {
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
			String m=request.getParameter("m");
			if("query".equals(m)){
				queryAllStudents(request, response);
			}
			if("delete".equals(m)){
				String id=request.getParameter("id");
				deleteStudent(id);
				response.sendRedirect("./FindAllStudent?m=query");
			}
			if("update".equals(m)){
				
				updateStudent(request, response);
				//response.sendRedirect("./FindAllStudent?m=query");
			}
			if("save".equals(m)){
				
				saveStudent(request, response);
				//response.sendRedirect("./FindAllStudent?m=query");
			}
			if("checkExistForStuNo".equals(m)){
				
				checkExistForStuNo(request,response);
			}
	}

	/**
	 * ���ѧ���Ƿ��Ѿ�����
	 * @param request
	 * @param response
	 */
	private void checkExistForStuNo(HttpServletRequest request, HttpServletResponse response) {
		String xuehao=request.getParameter("xh");
		boolean ifExist=service.checkExistForStuNo(xuehao);
		
		try {
			PrintWriter writer=response.getWriter();
			writer.write("{'value':'"+ifExist+"'}");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void saveStudent(HttpServletRequest request,
			HttpServletResponse response) {
		//��ȡ�޸ĺ������
		String id=request.getParameter("id");
		String xuehao=request.getParameter("xuehao");
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		
		Student stu=new Student();
		stu.setId(Integer.parseInt(id));
		stu.setXuehao(xuehao);
		stu.setName(name);
		stu.setAge(Integer.valueOf(age));
		
		service.saveStudent(stu);
		
		try {
			request.getRequestDispatcher("FindAllStudent?m=query").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void queryAllStudents(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//retrieve loginuser from session
		
//		HttpSession session= request.getSession();
//		Object login = session.getAttribute("login");
//		if(login!=null){
		
		
		//List<Student> list=service.queryAllStudents();
		
		//scope: page, request,session,application
		request.getSession().setAttribute("stuList", service.queryAllStudents());
		//��������ҳ����ת����ַ�����
		request.getRequestDispatcher("../../index.jsp").forward(request, response);
//		}else{// means not login or session is expired
//			PrintWriter out=response.getWriter();
//			out.flush();
//			out.write("<script>alert('Can not find your info!');window.open('http://localhost:8080/javaWeb/login.jsp');</script>");
//			out.flush();
//			out.close();
//			response.sendRedirect("../../login.jsp");
//		}
	}
	
	//remove student
	public void deleteStudent(String id){
		service.deleteStudent(id);
	}
	
	//updateStudent
	public void updateStudent(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String id=request.getParameter("id");//��ȡҳ�洫�ݵ�ѧ��id
		//�ӻỰsession�л�ȡ����ѧ���б�stulist��ע����Ҫ�޸�ǰ�汣�����ݵ�requestΪrequest.getSession()
		List<Student> stus=(List<Student>)request.getSession().getAttribute("stuList");
		if(stus!=null){//���list���ڲ�Ϊ��
			for (Student student : stus) {
				if(Integer.parseInt(id)==student.getId()){//���ID�ҵ���ѧ��������ҵ�
					request.getSession().setAttribute("stu", student);//���ҵ���ѧ�����󱣴��ڻỰ��
					break;//��ֹ����ѭ��
				}
			}
		}
		//ҳ����ת�������ض��򣬷������ת��
		//response.sendRedirect("../../updateStudent.jsp");
		request.getRequestDispatcher("../../updateStudent.jsp").forward(request, response);
	}
	

	public void init() throws ServletException {
		// Put your code here
	}

}
