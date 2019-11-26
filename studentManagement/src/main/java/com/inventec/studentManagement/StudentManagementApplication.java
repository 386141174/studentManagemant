package com.inventec.studentManagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@MapperScan("com.inventec.studentManagement.dao")
@ComponentScan(basePackages = {"com.inventec.*"})
@SpringBootApplication
@EnableTransactionManagement //开启事务管理
public class StudentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

}
