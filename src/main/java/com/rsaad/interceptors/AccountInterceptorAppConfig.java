package com.rsaad.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class AccountInterceptorAppConfig extends WebMvcConfigurerAdapter {
	@Autowired
	AccountInterceptor accountInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		registry.addInterceptor(accountInterceptor);
	}

}
