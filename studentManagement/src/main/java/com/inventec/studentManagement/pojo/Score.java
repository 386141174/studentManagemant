package com.inventec.studentManagement.pojo;

import javax.validation.constraints.NotNull;

public class Score {
	
	
	private String student_sno;
	@NotNull(message = "课程号不能为空")
	private String subject_cno;
	@NotNull(message = "分数不能为空")
	private String score;
	private double totalScore;
	
	public double getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
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
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "student_sno = "+student_sno +" subject_sno = "+subject_cno + " score = "+score;
	}

}
