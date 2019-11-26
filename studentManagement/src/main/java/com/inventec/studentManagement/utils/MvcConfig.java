package com.inventec.studentManagement.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
 
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);//可以让URL路径中带小数点 '.' 后面的值不被忽略 
    }
 
}
