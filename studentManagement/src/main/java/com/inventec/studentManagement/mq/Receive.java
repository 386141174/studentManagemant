package com.inventec.studentManagement.mq;

import java.io.Serializable;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.inventec.studentManagement.dao.ScoreDao;
import com.inventec.studentManagement.dao.StudentDao;
import com.inventec.studentManagement.pojo.Score;
import com.inventec.studentManagement.pojo.Student;
import com.inventec.studentManagement.pojo.StudentScore;
import com.inventec.studentManagement.vo.Routing;
import com.rabbitmq.client.Delivery;

/**
 * 类说明
 * 
 * @author Criss.liu
 * @version V1.0 创建时间：2019年12月10日 上午11:09:44
 */
@Component
public class Receive {
	@Autowired
	private ScoreDao scoredao;
	@Autowired
	private AmqpTemplate amq;
	@Autowired
	private Routing routing;
	@Autowired
	private StudentDao studentdao;
	
	

//	@RabbitListener(queues = "student.info")
//	public void score(Object string) {
//		System.out.println("message---------");
//		System.out.println(string.toString());
//	}
//
	
//	@RabbitListener(queues = "student.info.collect")
//	public void info(Message string) {
//		System.out.println("message---------");
//		System.out.println(string);
//		System.out.println("routing-key:" + string.getMessageProperties().getReceivedRoutingKey());
//		System.out.println("message:" + JSON.parseObject(string.getBody(), StudentScore.class));
//	}

	
	@RabbitListener(queues = "student.middle.table")
	public void middle(Message object) {
		String routingkey = object.getMessageProperties().getReceivedRoutingKey();
		Score score = JSON.parseObject(object.getBody(), Score.class);
		switch (routingkey) {
		case "student.score.table":
			System.out.println("student.score.table");
				StudentScore studentScore = selectSex(object);
				if (studentScore.getStudent_sex() == 1) {
					amq.convertAndSend(routing.scoreExchange, routing.student_male_disqualified_score, JSON.toJSON(studentScore));
				}else if (studentScore.getStudent_sex() == 2) {
					amq.convertAndSend(routing.scoreExchange, routing.student_female_disqualified_score, JSON.toJSON(studentScore));
				}
			break;
		case "student.insert.table":
//			System.out.println("student.insert.table");
			if (scoredao.selectMiddleTable(score.getStudent_sno()) == 1) {
				scoredao.updateMiddleTable(score.getStudent_sno());
			} else {
				scoredao.insertMiddleTable(score.getStudent_sno());
			}
			break;
		case "student.update.table":
			System.out.println("student.update.table");
			scoredao.updateMiddleTable(score.getStudent_sno());
			break;		
		default:
			break;
		}
	}
	
	
	
	public StudentScore selectSex(Message object) {
		StudentScore score = JSON.parseObject(object.getBody(), StudentScore.class);
		Student student = new Student();
		student.setStudent_sno(score.getStudent_sno());
		student = studentdao.selectStudent(student);
		score.setStudent_sex(student.getStudent_sex());
		score.setStudent_sname(student.getStudent_sname());
		return score;
	}
}
