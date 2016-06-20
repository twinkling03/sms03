package com.javaweb.service.impl;

import java.util.List;

import com.javaweb.db.dao.IStudent;
import com.javaweb.db.dao.impl.StudentDAOImpl;
import com.javaweb.javabean.Student;
import com.javaweb.service.StudentSerice;

public class StudentServiceImpl implements StudentSerice {
	private IStudent studao=new StudentDAOImpl();
	
	public List<Student> queryAllStudents() {
		List<Student> list=studao.queryAllStudents();
		return list;
	}

	public void deleteStudent(String id) {
		studao.deleteStudent(Integer.parseInt(id));
	}

	public void saveStudent(Student stu) {
		studao.saveStudent(stu);
	}

	public boolean  checkExistForStuNo(String xuehao) {
		return studao.checkExistForStuNo( xuehao);
		
	}

}
