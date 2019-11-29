package com.inventec.studentManagement.pojo;

import javax.validation.constraints.NotNull;

public class Student {

	@NotNull(message = "学号不能为空")
	private String student_sno;
	@NotNull(message = "姓名不能为空")
	private String student_sname;
	@NotNull(message = "性别不能为空")
	private int student_sex;
	@NotNull(message = "年龄不能为空")
	private int student_age;
	@NotNull(message = "创建时间不能为空")
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
