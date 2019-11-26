package com.inventec.studentManagement.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.inventec.studentManagement.pojo.Student;
import com.inventec.studentManagement.service.StudentService;
import com.inventec.studentManagement.utils.JsonResult;
import com.inventec.studentManagement.utils.Result;

@RequestMapping("/students")
@RestController
public class StudentController {

	
	@Autowired
	private StudentService studentService;
	
	/*
	 * 查询所有学生
	 */
	@GetMapping
	public JsonResult selectStudents(){
		return new JsonResult(1,studentService.selectStudents());
	}
	
	
	/*
	 * 根据学号查询某个学生
	 */
	@GetMapping("{student_sno}")
	public JsonResult selectStudent(@PathVariable("student_sno") String student_sno) {
		Student student = studentService.selectStudent(student_sno);
		
		return student != null ? new JsonResult(1,student) : new JsonResult(0,"删除失败");
	}
	
//	@GetMapping("stu")
//	public JsonResult name(){
//		//创建当前时间
//		
//			
//			try {
//				Date date = new Date();
//				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
//				
//				Student student = new Student();
//				student.setStudent_sname("zhanghu");
//				student.setStudent_age(10);
//				student.setStudent_sex(1);
//				student.setStudent_time(formatter.format(date));
//				student.setStudent_sno("1850610509");
////				System.out.println(studentService.addStudent(student));
//				System.out.println(studentService.addStudent(student));
//				return new JsonResult(1,studentService.addStudent(student));
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				System.out.println(studentService.addStudent(student));
//				return new JsonResult(0,"失败");
//			}
//	
//	}
	
	/*
	 * 新增一个学生
	 */
	@PostMapping
	public JsonResult addStudent(@RequestBody Student student) {
		int count = studentService.addStudent(student);
		return count == 1? new JsonResult(1,"新增成功") : new JsonResult(0,"新增失败");
	}
	
	
	/*
	 * 
	 *修改一个学生信息
	 */
	@PatchMapping("{student_sno}")
	public JsonResult updateStudent(@PathVariable("student_sno") String student_sno,@RequestBody Student student) {
		int count = studentService.updateStudent(student_sno,student);
		return count == 1? new JsonResult(1,"修改成功") : new JsonResult(0,"修改失败");
	}
	
	
	/*
	 * 删除一个学生信息
	 */
	@DeleteMapping("{student_sno}")
	public JsonResult deleteStudent(@PathVariable("student_sno") String student_sno) {
 		int count = studentService.deleteStudent(student_sno);
 		return count == 1? new JsonResult(1,"删除成功") : new JsonResult(0,"删除失败");
	}
}
