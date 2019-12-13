package com.inventec.studentManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventec.studentManagement.pojo.Rank;
import com.inventec.studentManagement.pojo.Score;
import com.inventec.studentManagement.pojo.Student;
import com.inventec.studentManagement.pojo.StudentScore;
import com.inventec.studentManagement.pojo.Subject;


public interface ScoreService {

	List<StudentScore> selectStudentScores(String student_sno);
	StudentScore selectStudentScore(String student_sno,String subject_cno);
	int addStudentScore(Score score);
	int updateStudentScore(Score score);
	int deleteStudentScore(Score score);
	List<Rank> selectStudentTotalScore(int number,int sort);

	int addStudentScoreV2(Score score);
	int updateStudentScoreV2(Score score);
}
