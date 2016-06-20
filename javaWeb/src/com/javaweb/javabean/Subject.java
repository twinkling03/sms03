package com.javaweb.javabean;

import java.io.Serializable;


//諺最
public class Subject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String subjectNo;//諺最晤瘍
	private String subjectName;//諺最靡備
	
	
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
