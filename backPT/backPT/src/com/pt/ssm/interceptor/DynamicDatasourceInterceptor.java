package com.pt.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class DynamicDatasourceInterceptor extends HandlerInterceptorAdapter {
	private static Logger log = LogManager.getLogger(DynamicDatasourceInterceptor.class.getName());
	

    @Override  
    public boolean preHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler) throws Exception {  
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
      
        log.info("requestUri:"+requestUri);  
        log.info("contextPath:"+contextPath);  
        log.info("url:"+url); 
        
        try {
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }  
    

}
