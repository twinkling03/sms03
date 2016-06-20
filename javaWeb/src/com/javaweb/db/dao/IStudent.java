package com.javaweb.db.dao;

import java.util.List;
import com.javaweb.javabean.Student;

public interface IStudent {

	public List<Student> queryAllStudents();

	public void deleteStudent(int id);

	public void saveStudent(Student stu);

	public boolean checkExistForStuNo(String xuehao);
	
}
