package com.inventec.studentManagement.mq;

import java.io.Serializable;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.inventec.studentManagement.pojo.Student;

/**
* 类说明
* @author  Criss.liu
* @version V1.0  创建时间：2019年12月10日 上午11:09:44
*/
@Component
public class Receive {
	@RabbitListener(queues = "student.score")
	public void score(Object string) {
		System.out.println("message---------");
		System.out.println(string.toString());
	}
	
	@RabbitListener(queues = "student.info")
	public void info(Object string) {
		System.out.println("message---------");
		System.out.println(string);
	}
}
