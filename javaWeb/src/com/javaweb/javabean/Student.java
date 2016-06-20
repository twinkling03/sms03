package com.javaweb.javabean;

import java.io.Serializable;


//ѧ��
public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String xuehao;//ѧ��
	private String name;//����
	private int age;//����
	Subject[] subjects=new Subject[1];//ѧ����ѧ�γ�
	//Field �ֶΣ���
	
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
		String rest="ѧ�ţ�"+this.getXuehao()+",������"+this.getName()+"";
		for (int i = 0; i < subjects.length; i++) {
			rest+=",�γ����ƣ�"+subjects[i].getSubjectName()+"���ɼ�:";
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
