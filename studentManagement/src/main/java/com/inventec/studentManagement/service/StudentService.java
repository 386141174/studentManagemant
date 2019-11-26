package com.inventec.studentManagement.service;

import java.util.List;



import com.inventec.studentManagement.pojo.Student;


public interface StudentService {

	List<Student> selectStudents();
	Student selectStudent(String student_sno);
	int addStudent(Student student);
	int updateStudent(String student_sno,Student student);
	int deleteStudent(String student_sno);
}
