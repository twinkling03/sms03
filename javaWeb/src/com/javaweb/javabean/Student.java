package com.javaweb.javabean;

import java.io.Serializable;


//学生
public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String xuehao;//学号
	private String name;//姓名
	private int age;//年龄
	Subject[] subjects=new Subject[1];//学生所学课程
	//Field 字段，域
	
	public Student(){}
	
	public Student(String xuehao, int age) {
		this.xuehao=xuehao;
		this.age=age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Subject[] getSubjects() {
		return subjects;
	}

	public void setSubjects(Subject[] subjects) {
		this.subjects = subjects;
	}

	public void setXuehao(String xuehao){
		this.xuehao=xuehao;
	}
	
	public String getXuehao(){
		return xuehao;
	}

	
	
	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String rest="学号："+this.getXuehao()+",姓名："+this.getName()+"";
		for (int i = 0; i < subjects.length; i++) {
			rest+=",课程名称："+subjects[i].getSubjectName()+"，成绩:";
		}
		return rest;
		
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
