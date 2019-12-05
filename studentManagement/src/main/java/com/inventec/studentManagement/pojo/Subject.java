package com.inventec.studentManagement.pojo;

import java.io.Serializable;

public class Subject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3846144756866379770L;
	private String subject_cno;
	private String subject_cname;
	public String getSubject_cno() {
		return subject_cno;
	}
	public void setSubject_cno(String subject_cno) {
		this.subject_cno = subject_cno;
	}
	public String getSubject_cname() {
		return subject_cname;
	}
	public void setSubject_cname(String subject_cname) {
		this.subject_cname = subject_cname;
	}


	
	
}
