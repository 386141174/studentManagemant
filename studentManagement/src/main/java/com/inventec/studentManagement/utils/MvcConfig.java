package com.inventec.studentManagement.utils;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@SpringBootConfiguration
public class MvcConfig implements WebMvcRegistrations {
 
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer.setUseSuffixPatternMatch(false);//可以让URL路径中带小数点 '.' 后面的值不被忽略 
//    }
    
//    @Override
//    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
//        return new CustomRequestMappingHandlerMapping();
//    }
	public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new CustomRequestMappingHandlerMapping();
    }


 
}
