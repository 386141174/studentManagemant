package com.inventec.studentManagement.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventec.studentManagement.dao.ScoreDao;
import com.inventec.studentManagement.pojo.Score;
import com.inventec.studentManagement.pojo.Student;
import com.inventec.studentManagement.pojo.StudentScore;
import com.inventec.studentManagement.pojo.Subject;
import com.inventec.studentManagement.service.ScoreService;

@Service
public class ScoreServiceImp implements ScoreService{
	
	@Autowired
	private ScoreDao scoreDao;
	
	
	/*
	 * 查询某个学生所有成绩
	 */
	@Override
	public List<StudentScore> selectStudentScores(String student_sno) {
		// TODO Auto-generated method stub
		StudentScore studentScore = new StudentScore();
		studentScore.setStudent_sno(student_sno);
		return scoreDao.studentScore(studentScore);
	}
	
	
	/*
	 * 查询某个学生单科成绩
	 */
	@Override
	public StudentScore selectStudentScore(String student_sno,String subject_cno) {
		// TODO Auto-generated method stub
		return scoreDao.selectStudentScore(student_sno, subject_cno);
	}
	
	
	/*
	 * 添加学生单科成绩
	 */
	@Override
	public int addStudentScore(Score score) {
		// TODO Auto-generated method stub
		
		return scoreDao.addStudentScore(score);
	}
	
	
	/*
	 * 修改一个学生的成绩
	 */
	@Override
	public int updateStudentScore(Score score) {
		// TODO Auto-generated method stub
		
		return scoreDao.updateStudentScore(score);
	}
	
	/*
	 * 删除一个学生成绩
	 */
	@Override
	public int deleteStudentScore(Score score) {
		// TODO Auto-generated method stub
		
		return scoreDao.deleteStudentScore(score);
	}
	
	
	
	@Override
	public List<Score> selectStudentTotalScore(int topNumber, int sort) {
		// TODO Auto-generated method stub
		
		return scoreDao.selectStudentTotalScore(topNumber, sort);
	}

}
