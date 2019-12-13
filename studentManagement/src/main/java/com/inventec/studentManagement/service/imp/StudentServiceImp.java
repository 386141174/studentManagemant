package com.inventec.studentManagement.service.imp;

import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.inventec.studentManagement.dao.StudentDao;
import com.inventec.studentManagement.pojo.Student;
import com.inventec.studentManagement.service.StudentService;
import com.inventec.studentManagement.vo.Routing;

/**
 * @author ITC190109
 *
 */
/**
 * @author ITC190109
 *
 */
@Service

public class StudentServiceImp implements StudentService{

	@Autowired
	private StudentDao studentdao;
	
	@Autowired
	private AmqpTemplate amqp;
	
	@Autowired
	private Routing routing;
	
	/**
	 * 查询全部学生信息
	 */
	@Override
	public List<Student> selectStudents() {
		// TODO Auto-generated method stub
		return studentdao.selectStudents();
	}
	
	
	/**
	 * 根据学号查询学生信息
	 */
	@Override
	public Student selectStudent(String student_sno) {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setStudent_sno(student_sno);
		return studentdao.selectStudent(student);
	}
	
//	@Transactional
//	@Override
//	public int addStudent(Student student) {
//		// TODO Auto-generated method stub
//		
//		int count = studentdao.addStudent(student);
//		int a = 10 / 0;
//		return count;
//	}
	
//	@Transactional(rollbackFor = Exception.class)
	
	/*
	 * 新增学生信息
	 */
	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
				int count = studentdao.addStudent(student);
				return count;

	}
	
	/*
	 * 修改学生信息
	 */
	@Override
	public int updateStudent(String student_sno,Student student) throws Exception{
		// TODO Auto-generated method stub
		student.setStudent_sno(student_sno);
		if (student.getStudent_sex() != null) {
			if (student.getStudent_sex() != 1 || student.getStudent_sex() != 2) {
				throw new Exception("1代表男,2代表女");
			}
		}
		int count = studentdao.updateStudent(student);
		return count;
	}

	/*
	 * 删除一个学生信息
	 */
	@Override
	public int deleteStudent(String student_sno) {
		// TODO Auto-generated method stub
		return studentdao.deleteStudent(student_sno);
	}
	
	
	
	
	/**
	 * 新增学生信息V2
	 */
	@Override
	public int addStudentV2(Student student) {
		// TODO Auto-generated method stub
		int count = studentdao.addStudent(student);
		if (count == 1) {
			amqp.convertAndSend(routing.exchange, routing.routing_key_student_info, JSON.toJSON(student));
			return count;
		}
		return count;
	}
	
	
	/**
	 *		更新学生信息V2
	 */
	@Override
	public int updateStudentV2(String student_sno, Student student) throws Exception {
		// TODO Auto-generated method stub
		student.setStudent_sno(student_sno);
		if (student.getStudent_sex() != null) {
			if (student.getStudent_sex() != 1 || student.getStudent_sex() != 2) {
				throw new Exception("1代表男,2代表女");
			}
		}
		int count = studentdao.updateStudent(student);
		if (count == 1) {
			amqp.convertAndSend(routing.exchange, routing.routing_key_student_info, JSON.toJSON(student));
			return count;
		}
		
		return 0;
		
	}
	
	
	
	
	
}
