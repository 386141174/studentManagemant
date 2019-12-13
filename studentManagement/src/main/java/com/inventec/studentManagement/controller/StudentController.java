package com.inventec.studentManagement.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.inventec.studentManagement.pojo.Student;
import com.inventec.studentManagement.service.StudentService;
import com.inventec.studentManagement.utils.ApiVersion;
import com.inventec.studentManagement.utils.JsonResult;

/**
 * @author ITC190109
 *
 */
@RequestMapping("/students")
@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private HttpServletResponse response;
	private static String ApiVersion = "ApiVersion";

	/*
	 * 查询所有学生
	 */
	@GetMapping
	@ApiVersion(1)
	public JsonResult selectStudents() {
		response.addHeader(ApiVersion, "v1");
		return new JsonResult(1, studentService.selectStudents());
	}

	/*
	 * 根据学号查询某个学生
	 */
	@GetMapping("{student_sno}")
	@ApiVersion(1)
	public JsonResult selectStudent(@PathVariable("student_sno") String student_sno) {
		response.addHeader(ApiVersion, "v1");
		Student student = studentService.selectStudent(student_sno);

		return student != null ? new JsonResult(1, student) : new JsonResult(0, "fail");
	}
	

	/*
	 * 新增一个学生
	 */
	@PostMapping
	@ApiVersion(1)
	public JsonResult addStudent(@Validated @RequestBody Student student) {
		response.addHeader(ApiVersion, "v1");

		int count = studentService.addStudent(student);
		return count == 1 ? new JsonResult(1, "success") : new JsonResult(0, "fail");
	}

	/*
	 * 
	 * 修改一个学生信息
	 */
	@PatchMapping("{student_sno}")
	@ApiVersion(1)
	public JsonResult updateStudent(@PathVariable("student_sno") String student_sno, @RequestBody Student student)
			throws Exception {
		response.addHeader(ApiVersion, "v1");
		int count = studentService.updateStudent(student_sno, student);
		return count == 1 ? new JsonResult(1, "success") : new JsonResult(0, "fail");
	}

	/*
	 * 删除一个学生信息
	 */
	@DeleteMapping("{student_sno}")
	@ApiVersion(1)
	public JsonResult deleteStudent(@PathVariable("student_sno") String student_sno) {
		response.addHeader(ApiVersion, "v1");
		int count = studentService.deleteStudent(student_sno);
		return count == 1 ? new JsonResult(1, "success") : new JsonResult(0, "fail");
	}

	/**
	 * 新增学生信息 V2
	 * 
	 * @param student
	 * @return
	 */
	@PostMapping
	@ApiVersion(2)
	public JsonResult addStudentV2(@Validated @RequestBody Student student) {
		response.addHeader(ApiVersion, "v2");
		int count = studentService.addStudentV2(student);
		return count == 1 ? new JsonResult(1, "success") : new JsonResult(0, "fail");
	}

	/**
	 * 
	 * 更新学生信息V2
	 * 
	 * @param student_sno
	 * @param student
	 * @return
	 * @throws Exception
	 */
	@PatchMapping("{student_sno}")
	@ApiVersion(2)
	public JsonResult updateStudentV2(@PathVariable("student_sno") String student_sno, @RequestBody Student student)
			throws Exception {
		response.addHeader(ApiVersion, "v2");
		int count = studentService.updateStudentV2(student_sno, student);
		return count == 1 ? new JsonResult(1, "success") : new JsonResult(0, "fail");
	}

}
