package com.inventec.studentManagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Pattern;
import javax.xml.ws.ResponseWrapper;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Headers;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventec.studentManagement.pojo.Rank;

import com.inventec.studentManagement.pojo.Score;
import com.inventec.studentManagement.pojo.StudentScore;
import com.inventec.studentManagement.service.ScoreService;
import com.inventec.studentManagement.utils.ApiVersion;
import com.inventec.studentManagement.utils.ApiVersionCondition;
import com.inventec.studentManagement.utils.JsonResult;

@RestController
@RequestMapping("/score")
public class ScoreController {

	@Autowired
	private ScoreService scoreService;

	@Autowired
	private HttpServletResponse response;

	private static String ApiVersion = "ApiVersion";

	/*
	 * 查询学生所有成绩
	 */
	@GetMapping("{student_sno}")
	@ApiVersion(1)
	public JsonResult selectStudentScore(@PathVariable("student_sno") String student_sno) {
		response.addHeader(ApiVersion, "v1");
		List<StudentScore> list = scoreService.selectStudentScores(student_sno);

		return list.size() != 0 ? new JsonResult(1, list) : new JsonResult(0, "fail");
	}

	/*
	 * 查询学生单科成绩
	 */
	@GetMapping("single-subject/{student_sno}/{subject_cno}")
	@ApiVersion(1)
	public JsonResult select(@PathVariable("student_sno") String student_sno,
			@PathVariable("subject_cno") String subject_cno) {

		response.addHeader(ApiVersion, "v1");
		StudentScore score = scoreService.selectStudentScore(student_sno, subject_cno);

		return score != null ? new JsonResult(1, score) : new JsonResult(0, "fail");
	}

	/*
	 * 添加学生单科成绩
	 */
	@PostMapping("{student_sno}")
	@ApiVersion(1)
	public JsonResult addStudentScore(@PathVariable("student_sno") String student_sno,
			@Validated @RequestBody Score score) {

		response.addHeader(ApiVersion, "v1");
		score.setStudent_sno(student_sno);
		int count = scoreService.addStudentScore(score);

		return count == 1 ? new JsonResult(1, "success") : new JsonResult(0, "fail");
	}

	/*
	 * 修改学生单科成绩
	 */
	@PatchMapping("/{student_sno}")
	@ApiVersion(1)
	public JsonResult uodateStudentScore(@PathVariable("student_sno") String student_sno,
			@Validated @RequestBody Score score) {

		response.addHeader(ApiVersion, "v1");
		score.setStudent_sno(student_sno);
		int count = scoreService.updateStudentScore(score);

		return count == 1 ? new JsonResult(1, "success") : new JsonResult(0, "fail");
	}

	/*
	 * 删除一个学生成绩
	 */
	@DeleteMapping("{student_sno}")
	@ApiVersion(1)
	public JsonResult deleteStudent(@PathVariable("student_sno") String student_sno, @RequestBody Score score) {

		response.addHeader(ApiVersion, "v1");
		score.setStudent_sno(student_sno);
		int count = scoreService.deleteStudentScore(score);

		return count == 1 ? new JsonResult(1, "success") : new JsonResult(0, "fail");
	}

	/*
	 * 
	 * 查询前/后几名同学
	 */

	@GetMapping("sequence/{sequence}/top-number/{number}")
	@ApiVersion(1)
	public JsonResult selectStudentTotalScore(@PathVariable("sequence") int sort, @PathVariable("number") int number) {

		response.addHeader(ApiVersion, "v1");
		List<Rank> list = scoreService.selectStudentTotalScore(number, sort);

		return new JsonResult(1, list);

	}

	/**
	 * 增加学生成绩V2
	 * 
	 * @param student_sno
	 * @param score
	 * @return
	 */
	@PostMapping("{student_sno}")
	@ApiVersion(2)
	public JsonResult addStudentScoreV2(@PathVariable("student_sno") String student_sno,
			@Validated @RequestBody Score score) {
		response.addHeader(ApiVersion, "v2");
		score.setStudent_sno(student_sno);
		int count = scoreService.addStudentScoreV2(score);
		return count == 1 ? new JsonResult(1, "success") : new JsonResult(0, "fail");
	}

	/**
	 * @param student_sno
	 * @param score
	 * @return
	 */
	@PatchMapping("/{student_sno}")
	@ApiVersion(2)
	public JsonResult uodateStudentScoreV2(@PathVariable("student_sno") String student_sno,
			@Validated @RequestBody Score score) {
		response.addHeader(ApiVersion, "v2");
		score.setStudent_sno(student_sno);
		int count = scoreService.updateStudentScoreV2(score);
		return count != 0 ? new JsonResult(1, "success") : new JsonResult(0, "fail");
	}
	
	
	@GetMapping("aaaaa")
	public Map<String, String> aaaa() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("fgsdf", "11111");
		map.put("a", "2222");
		map.put("sdadsdv", "333");
		return map;
	}

}
