package com.cafe24.memory.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cafe24.memory.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Autowired 
	LoginInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/css/**")
				.excludePathPatterns("/js/**")
				.excludePathPatterns("/images/**")
				.excludePathPatterns("/scss/**")
				.excludePathPatterns("/ajax/**")
				.excludePathPatterns("/plugins/**")
				.excludePathPatterns("/member/**")
				.excludePathPatterns("/board/**")
				.excludePathPatterns("/index");
	}
	
}
