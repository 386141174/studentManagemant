package com.inventec.studentManagement.utils;


import java.lang.annotation.*;


/**
* 类说明
* @author  Criss.liu
* @version V1.0  创建时间：2019年12月10日 下午3:11:11
*/

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiVersion {
	int value();
}
