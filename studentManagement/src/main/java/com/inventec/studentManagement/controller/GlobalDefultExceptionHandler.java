package com.inventec.studentManagement.controller;



import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.inventec.studentManagement.utils.BizException;
import com.inventec.studentManagement.utils.CommonEnum;
import com.inventec.studentManagement.utils.JsonResult;
import com.inventec.studentManagement.utils.ResultBody;

@RestControllerAdvice
public class GlobalDefultExceptionHandler {
	
//	//声明要捕获的异常
//	@ExceptionHandler(value = BizException.class)  
//    @ResponseBody  
//    public  ResultBody bizExceptionHandler(HttpServletRequest req, BizException e){
//        return ResultBody.error(e.getErrorCode(),e.getErrorMsg());
//    }
//	
//	 /**
//     * 处理空指针的异常
//     * @param req
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(value =NullPointerException.class)
//    @ResponseBody
//    public ResultBody exceptionHandler(HttpServletRequest req, NullPointerException e){
//        
//        return ResultBody.error(CommonEnum.BODY_NOT_MATCH);
//    }
//
//
//    /**
//        * 处理其他异常
//     * @param req
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(value =Exception.class)
//    @ResponseBody
//    public ResultBody exceptionHandler(HttpServletRequest req, Exception e){
//        
//        return ResultBody.error(CommonEnum.INTERNAL_SERVER_ERROR);
//    }
	
	
		@ResponseBody
	    @ExceptionHandler(value = Exception.class)
	    public Map errorHandler(Exception ex) {
	        Map map = new HashMap();
	        map.put("state", 40001);
	        map.put("msg", ex.getMessage());
	        return map;
	    }
	 	
	 	

	//json格式
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Map errorHandler(MethodArgumentNotValidException ex) {
        StringBuilder errorMsg = new StringBuilder();
        BindingResult re = ex.getBindingResult();
        for (ObjectError error : re.getAllErrors()) {
            errorMsg.append(error.getDefaultMessage()).append(",");
        }
        errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
        Map map = new HashMap();
        map.put("state", 40002);
        map.put("msg", errorMsg.toString());
        return map;
    }
    
    
//  //表单格式
//    @ExceptionHandler(value = BindException.class)
//    public Map errorHandler(BindException ex) {
//        BindingResult result = ex.getBindingResult();
//        StringBuilder errorMsg = new StringBuilder();
//        for (ObjectError error : result.getAllErrors()) {
//            errorMsg.append(error.getDefaultMessage()).append(",");
//        }
//        errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
//        Map map = new HashMap();
//        map.put("state", 40003);
//        map.put("msg", errorMsg.toString());
//        return map;
//    }




}

