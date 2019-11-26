package com.inventec.studentManagement.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.inventec.studentManagement.pojo.Score;
import com.inventec.studentManagement.pojo.Student;
import com.inventec.studentManagement.pojo.StudentScore;

@Repository
public interface ScoreDao {

	List<StudentScore> studentScore(StudentScore studentScore);
	int addStudentScore (Score score);
	int updateStudentScore(Score score);
	int deleteStudentScore(Score score);
}
