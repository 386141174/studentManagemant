package com.inventec.studentManagement.pojo;

public class Student {

	private String student_sno;
	private String student_sname;
	private int student_sex;
	private int student_age;
	private String student_time;
	
	
	
	



	public String getStudent_sno() {
		return student_sno;
	}







	public void setStudent_sno(String student_sno) {
		this.student_sno = student_sno;
	}







	public String getStudent_sname() {
		return student_sname;
	}







	public void setStudent_sname(String student_sname) {
		this.student_sname = student_sname;
	}







	public int getStudent_sex() {
		return student_sex;
	}







	public void setStudent_sex(int student_sex) {
		this.student_sex = student_sex;
	}







	public int getStudent_age() {
		return student_age;
	}







	public void setStudent_age(int student_age) {
		this.student_age = student_age;
	}







	public String getStudent_time() {
		return student_time;
	}







	public void setStudent_time(String student_time) {
		this.student_time = student_time;
	}







	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "student_sname = "+student_sname +
				"student_sno = "+ student_sno+
				"student_sex = " + student_sex+
				"student_age = "+student_age+
				"student_time = " + student_time;
	}
	
	
}
