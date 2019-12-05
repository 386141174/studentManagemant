package com.inventec.studentManagement.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventec.studentManagement.dao.ScoreDao;
import com.inventec.studentManagement.pojo.Rank;
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
		if(scoreDao.addStudentScore(score) == 1) {
			return scoreDao.updateMiddleTable(score.getStudent_sno());
		}
		return 0;
	}
	
	
	/*
	 * 修改一个学生的成绩
	 */
	@Override
	public int updateStudentScore(Score score) {
		// TODO Auto-generated method stub
		if(scoreDao.updateStudentScore(score) == 1) {
			return scoreDao.updateMiddleTable(score.getStudent_sno());
		}
		return 0;
	}
	
	/*
	 * 删除一个学生成绩
	 */
	@Override
	public int deleteStudentScore(Score score) {
		// TODO Auto-generated method stub
		if(scoreDao.deleteStudentScore(score) == 1) {
			return scoreDao.updateMiddleTable(score.getStudent_sno());
		}
		return 0;
	}
	
	
	
	/*
	 * 
	 * 查询学生总分前10/后10名学生信息和成绩信息
	 */
	@Override
	public List<Rank> selectStudentTotalScore(int number, int sort) {
		// TODO Auto-generated method stub
		
		return scoreDao.selectStudentTotalScore(number, sort);
	}
	
	
//	@Override
//	public List<Rank> testStudentRank(int number) {
//		// TODO Auto-generated method stub
//		
//		List<Rank> list = scoreDao.testStudentRank(number);
//		list = scoreDao.testStudentScore(list);
//		return list;
//	}

	
	
	
}
