package com.inventec.studentManagement;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.databind.ObjectMapper;


@MapperScan("com.inventec.studentManagement.dao")
@ComponentScan(basePackages = {"com.inventec.*"})
@SpringBootApplication
@EnableTransactionManagement //开启事务管理
public class StudentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}
	
	@Bean 
	public MessageConverter jsonMessageConverter(ObjectMapper objectMapper) {
	return new Jackson2JsonMessageConverter(objectMapper);
	}
	
	



}
