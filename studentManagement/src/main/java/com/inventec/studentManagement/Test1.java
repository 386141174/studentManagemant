package com.inventec.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventec.studentManagement.Dao.TestDao;
import com.inventec.studentManagement.Pojo.Test;

@RestController
public class Test1 {

	@Autowired
	TestDao testdap;
	
	
	@GetMapping("/test")
	public String test() {
//		Test test = new Test();
//		test.setStudent_saddress("1111");
//		test.setStudent_ssex(1);
//		test.setStudent_sname("2222");
//		testdap.test(test);
		
		int count = testdap.select();
		System.out.println(count);
		return "hello";
	}
}
