package com.inventec.studentManagement.vo;

import org.springframework.stereotype.Component;

/**
* 类说明
* @author  Criss.liu
* @version V1.0  创建时间：2019年12月12日 上午10:06:16
*/
@Component
public class Routing {

	public String routing_key_student_info = "studnet.info";
	public String routing_key_student_score = "student.score";
	public String exchange = "studentManagement";
}
