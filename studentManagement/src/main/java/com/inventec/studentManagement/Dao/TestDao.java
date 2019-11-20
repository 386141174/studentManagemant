package com.inventec.studentManagement.Dao;

import org.springframework.stereotype.Repository;

import com.inventec.studentManagement.Pojo.Test;

@Repository
public interface TestDao {

	int test(Test test);
	int select();
}
