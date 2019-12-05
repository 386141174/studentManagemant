package com.inventec.studentManagement.pojo;

import java.io.Serializable;

public class StudentScore implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2948187549987332542L;
	private String subject_cname;
	private String student_sname;
	private Integer student_sex;
	private Integer student_age;
	private String student_time;
	private String student_sno;
	private String subject_cno;
	private String score;
	private double totalScore;
	
	
	

	public double getTotalScore() {
		return totalScore;
	}



	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}



	public String getSubject_cname() {
		return subject_cname;
	}



	public void setSubject_cname(String subject_cname) {
		this.subject_cname = subject_cname;
	}



	public String getStudent_sname() {
		return student_sname;
	}



	public void setStudent_sname(String student_sname) {
		this.student_sname = student_sname;
	}



	public Integer getStudent_sex() {
		return student_sex;
	}



	public void setStudent_sex(Integer student_sex) {
		this.student_sex = student_sex;
	}



	public Integer getStudent_age() {
		return student_age;
	}



	public void setStudent_age(Integer student_age) {
		this.student_age = student_age;
	}



	public String getStudent_time() {
		return student_time;
	}



	public void setStudent_time(String student_time) {
		this.student_time = student_time;
	}



	public String getStudent_sno() {
		return student_sno;
	}



	public void setStudent_sno(String student_sno) {
		this.student_sno = student_sno;
	}



	public String getSubject_cno() {
		return subject_cno;
	}



	public void setSubject_cno(String subject_cno) {
		this.subject_cno = subject_cno;
	}



	public String getScore() {
		return score;
	}



	public void setScore(String score) {
		this.score = score;
	}



	
}
