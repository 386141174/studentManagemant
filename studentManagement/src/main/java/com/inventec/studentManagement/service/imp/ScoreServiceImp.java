package com.inventec.studentManagement.service.imp;

import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessagePostProcessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.inventec.studentManagement.dao.ScoreDao;
import com.inventec.studentManagement.pojo.Rank;
import com.inventec.studentManagement.pojo.Score;
import com.inventec.studentManagement.pojo.Student;
import com.inventec.studentManagement.pojo.StudentScore;
import com.inventec.studentManagement.pojo.Subject;
import com.inventec.studentManagement.service.ScoreService;
import com.inventec.studentManagement.vo.Routing;

/**
 * @author ITC190109
 *
 */
@Service
@Transactional
public class ScoreServiceImp implements ScoreService {

	@Autowired
	private ScoreDao scoreDao;

	@Autowired
	private AmqpTemplate amp;
	@Autowired
	private Routing routing;

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
	public StudentScore selectStudentScore(String student_sno, String subject_cno) {
		// TODO Auto-generated method stub
		return scoreDao.selectStudentScore(student_sno, subject_cno);
	}

	/*
	 * 添加学生单科成绩
	 */
	@Override
	public int addStudentScore(Score score) {
		// TODO Auto-generated method stub
		int count = scoreDao.addStudentScore(score);
		if (count != 0) {
			amp.convertAndSend(routing.scoreExchange, routing.routing_insert_table, JSON.toJSON(score));
		}
		return count;
	}

	/*
	 * 修改一个学生的成绩
	 */
	@Override
	public int updateStudentScore(Score score) {
		// TODO Auto-generated method stub
		int count = scoreDao.updateStudentScore(score);
		if (count != 0) {
			amp.convertAndSend(routing.scoreExchange, routing.routing_update_table, JSON.toJSON(score));
		}
		return count;
	}

	/*
	 * 删除一个学生成绩
	 */
	@Override
	public int deleteStudentScore(Score score) {
		// TODO Auto-generated method stub
		int count = scoreDao.deleteStudentScore(score);
		if (count != 0) {
			amp.convertAndSend(routing.scoreExchange, routing.routing_update_table, JSON.toJSON(score));
		}
		return count;
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

	
		
	/**
	 *增加学生成绩V2
	 */
	@Override
	public int addStudentScoreV2(Score score) {
		// TODO Auto-generated method stub
		int count = scoreDao.addStudentScore(score);
		if (count == 1) {
			//放入队列去更新Middle_Table
			amp.convertAndSend(routing.middleExchang, routing.routing_insert_table, JSON.toJSON(score));
			//放入队列去查询男/女
			amp.convertAndSend(routing.scoreExchange, routing.routing_score_table, JSON.toJSON(score));
		}
		return count;
	}

	
	/**
	 *修改学生成绩V2
	 */
	@Override
	public int updateStudentScoreV2(Score score) {
		// TODO Auto-generated method stub
		int count = scoreDao.updateStudentScore(score);
		if (count != 0) {
			//放入队列去查询男/女
			amp.convertAndSend(routing.middleExchang, routing.routing_score_table, JSON.toJSON(score));
			//放入队列去更新Middle_Table
			amp.convertAndSend(routing.scoreExchange, routing.routing_update_table, JSON.toJSON(score));
		}
		return count;
	}
	
	

}
