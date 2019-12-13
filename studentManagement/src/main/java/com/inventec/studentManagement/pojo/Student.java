package com.inventec.studentManagement.pojo;

import java.io.Serializable;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.junit.experimental.theories.DataPoint;

public class Student implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7841629023468785872L;
	@NotNull(message = "学号不能为空")
	@NotBlank
	@Pattern(regexp = "^[A-Za-z0-9]{15}$",message = "学号长度为15位")
	private String student_sno;
	
	@NotNull(message = "姓名不能为空")
	@NotBlank
	private String student_sname;
	
	@NotNull(message = "性别不能为空")
	@DecimalMax("2")
	@DecimalMin("1")
	private Integer student_sex;
	
	@NotNull(message = "年龄不能为空")
	private Integer student_age;
	
	@NotNull(message = "创建时间不能为空")
	@NotBlank
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
