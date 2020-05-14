package com.inventec.studentManagement.vo;

import org.springframework.stereotype.Component;


/**
* 类说明
* @author  Criss.liu
* @version V1.0  创建时间：2019年12月12日 上午10:06:16
*/
@Component

public class Routing {

	public String student_info = "student.info.collect";
	public String student_female_disqualified_score = "student.female.score.collect";
	public String student_male_disqualified_score ="student.male.score.collect";
	
	public String routing_score_table = "student.score.table";
	public String routing_insert_table = "student.insert.table";
	public String routing_update_table = "student.update.table";
	
	public String scoreExchange = "topicStudent";
	public String middleExchang = "topicMiddle";
	
}
