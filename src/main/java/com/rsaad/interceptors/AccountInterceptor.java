package com.rsaad.interceptors;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class AccountInterceptor implements HandlerInterceptor{
    private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		//pre handle code goes here
		System.out.println("Pre Handle method is Calling");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
	{
		//post handle code goes here
		System.out.println("Post Handle method is Calling");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception
	{
		//after completion code goes here
		System.out.println("Request and Response is completed");
	}

    private void logRequest(HttpServletRequest request) throws IOException 
    {
//        if (log.isDebugEnabled()) 
//        {
//            log.debug("===========================request begin================================================");
//            log.debug("URI         : {}", request.getRequestURI());
//            log.debug("Method      : {}", request.getMethod());
//            log.debug("Headers     : {}", request.getHeaderNames());
//            log.debug("Request body: {}", request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
//            log.debug("==========================request end================================================");
//        }
    }
  
//    private void logResponse(HttpServletResponse response) throws IOException 
//    {
//    	  String text = "";
//    	  response.setContentType("application/json; charset=UTF-8");
//    	  response.setCharacterEncoding("UTF-8");
//    	  response.getWriter().write(text);
//
//        if (log.isDebugEnabled()) 
//        {
//            log.debug("============================response begin==========================================");
//            log.debug("Status code  : {}", response.getStatus());
//            log.debug("Status text  : {}", response.getStatusText());
//            log.debug("Headers      : {}", response.getHeaderNames());
//            log.debug("Response body: {}", StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
//            log.debug("=======================response end=================================================");
//        }
//    }

}
