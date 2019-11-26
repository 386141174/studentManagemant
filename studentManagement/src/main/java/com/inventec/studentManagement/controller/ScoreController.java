package com.inventec.studentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventec.studentManagement.pojo.Score;
import com.inventec.studentManagement.pojo.StudentScore;
import com.inventec.studentManagement.service.ScoreService;
import com.inventec.studentManagement.utils.JsonResult;

@RestController
@RequestMapping("/score")
public class ScoreController {

	@Autowired
	private ScoreService scoreService;
	
	/*
	 * 查询学生所有成绩
	 */
	@GetMapping("{student_sno}")
	public JsonResult selectStudentScore(@PathVariable("student_sno") String student_sno) {
		
		List<StudentScore> list = scoreService.selectStudentScores(student_sno);
		
		return list.size() != 0 ? new JsonResult(1,list) : new JsonResult(0,"查询失败");
	}
	
	
	/*
	 * 查询学生单科成绩
	 */
	@GetMapping("/{student_sno}/{subject_cno}")
	public JsonResult select(@PathVariable("student_sno") String student_sno,@PathVariable("subject_cno") String subject_cno) {
		StudentScore studentScore = new StudentScore();
		studentScore = scoreService.selectStudentScore(student_sno, subject_cno);
		return studentScore != null ? new JsonResult(1,studentScore) : new JsonResult(0,"查询失败");
	}
	
	/*
	 * 添加学生单科成绩
	 */
	@PostMapping("{student_sno}")
	public JsonResult addStudentScore(@PathVariable("student_sno") String student_sno,@RequestBody Score score) {
		score.setScore(student_sno);
		int count = scoreService.addStudentScore(score);
		return count == 1? new JsonResult(1,"添加成功") : new JsonResult(0,"添加失败");
	}
	
	
	/*
	 * 修改学生单科成绩
	 */
	@PatchMapping("/{student_sno}")
	public JsonResult uodateStudentScore(@PathVariable("student_sno") String student_sno,@RequestBody Score score) {
		score.setSubject_cno(student_sno);
		int count = scoreService.updateStudentScore(score);
		return count == 1? new JsonResult(1,"修改成功") : new JsonResult(0,"修改失败");
	}
	
	/*
	 * 删除一个学生成绩
	 */
	@DeleteMapping("{student_sno}")
	public JsonResult deleteStudent(@PathVariable("student_sno") String student_sno,@RequestBody Score score) {
		score.setStudent_sno(student_sno);
		int count = scoreService.deleteStudentScore(score);
		return count == 1? new JsonResult(1,"删除成功") : new JsonResult(0,"删除失败");
	}
}
