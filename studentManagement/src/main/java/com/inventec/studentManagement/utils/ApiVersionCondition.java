package com.inventec.studentManagement.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

/**
* 类说明
* @author  Criss.liu
* @version V1.0  创建时间：2019年12月10日 下午3:17:17
*/
public class ApiVersionCondition implements RequestCondition<ApiVersionCondition>{
	// 头请求中的版本号规则 这里用 v[1-9]/的形式
    private static final Pattern VERSION_PREFIX_PATTERN = Pattern.compile("v(\\d+)");

    private int apiVersion;

    public ApiVersionCondition(int apiVersion) {
        this.apiVersion = apiVersion;
    }

    public ApiVersionCondition combine(ApiVersionCondition other) {
        // 采用最后定义优先原则，则方法上的定义覆盖类上面的定义
        return new ApiVersionCondition(other.getApiVersion());
    }

    public ApiVersionCondition getMatchingCondition(HttpServletRequest request) {
        // 获取头请求中的版本号;默认是v2;
        String apiVersion = request.getHeader("ApiVersion");  
        if (apiVersion == null) {
            apiVersion = "v2";
        }
        Matcher m = VERSION_PREFIX_PATTERN.matcher(apiVersion);
        if (m.find()) {
            Integer version = Integer.valueOf(m.group(1));
            // 如果请求的版本号大于配置版本号， 则满足
            if (version >= this.apiVersion) {
                return this;
            }
        }
        return null;
    }

    public int compareTo(ApiVersionCondition other, HttpServletRequest request) {
        // 优先匹配最新的版本号
        return other.getApiVersion() - this.apiVersion;
    }

    public int getApiVersion() {
        return apiVersion;
    }


}
