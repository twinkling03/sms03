package com.javaweb.service;

import java.util.List;

import com.javaweb.javabean.Student;

public interface StudentSerice {
	public List<Student> queryAllStudents();

	public void deleteStudent(String id);

	public void saveStudent(Student stu);

	public boolean checkExistForStuNo(String xuehao);
}
