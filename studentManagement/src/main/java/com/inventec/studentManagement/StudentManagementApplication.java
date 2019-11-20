package com.inventec.studentManagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@MapperScan("com.inventec.studentManagement.Dao")
@ComponentScan(basePackages = {"com.inventec.*"})
@SpringBootApplication
public class StudentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

}
