package com.inventec.studentManagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.inventec.studentManagement.pojo.Student;

@Repository
public interface StudentDao {

	List<Student> selectStudents();
	Student selectStudent(Student student);
	int addStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(@Param("student_sno") String student_sno);
}
