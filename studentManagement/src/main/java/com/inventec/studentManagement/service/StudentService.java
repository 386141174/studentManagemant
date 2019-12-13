package com.inventec.studentManagement.service;

import java.util.List;



import com.inventec.studentManagement.pojo.Student;


public interface StudentService {

	List<Student> selectStudents();
	Student selectStudent(String student_sno);
	int addStudent(Student student) ;
	int updateStudent(String student_sno,Student student) throws Exception;
	int deleteStudent(String student_sno);
	
	int addStudentV2(Student student) ;
	int updateStudentV2(String student_sno,Student student) throws Exception;
}
