package com.javaweb.javabean;

import java.io.Serializable;


//�γ�
public class Subject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String subjectNo;//�γ̱��
	private String subjectName;//�γ�����
	
	
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	public void setSubjectNo(String subjectNo) {
		this.subjectNo = subjectNo;
	}
	public String getSubjectNo() {
		return subjectNo;
	}
	
	
	
}
