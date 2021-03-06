package com.inventec.studentManagement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.inventec.studentManagement.pojo.Rank;
import com.inventec.studentManagement.pojo.Score;
import com.inventec.studentManagement.pojo.Student;
import com.inventec.studentManagement.pojo.StudentScore;

@Repository
public interface ScoreDao {

	List<StudentScore> studentScore(StudentScore studentScore);
	StudentScore selectStudentScore(@Param("student_sno") String student_sno,@Param("subject_cno") String subject_cno);
	int addStudentScore (Score score);
	int updateStudentScore(Score score);
	int deleteStudentScore(Score score);
	List<Rank> selectStudentTotalScore(@Param("number") int number,@Param("sort") int sort);
//	List<Score> studentTotalScoreByStudentSno(List<Score> list);
//	List<Rank> testStudentRank(@Param("number") int number);
//	List<Rank> testStudentScore(List<Rank> list);
	
	int updateMiddleTable(@Param("student_sno") String student_sno);
	int insertMiddleTable(@Param("student_sno") String student_sno);
	int selectMiddleTable(@Param("student_sno") String student_sno);
}
