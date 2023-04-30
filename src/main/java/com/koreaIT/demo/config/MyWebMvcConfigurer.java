package com.koreaIT.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.koreaIT.demo.interceptor.BeforeActionInterceptor;
import com.koreaIT.demo.interceptor.NeedLoginInterceptor;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer{
	private BeforeActionInterceptor beforActionInetereceptor;
	private NeedLoginInterceptor needLoginInterceptor;

	@Autowired
	public MyWebMvcConfigurer(BeforeActionInterceptor beforActionInetereceptor,NeedLoginInterceptor needLoginInterceptor) {
		
		this.beforActionInetereceptor = beforActionInetereceptor;
		this.needLoginInterceptor = needLoginInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(beforActionInetereceptor).addPathPatterns("/**").excludePathPatterns("/resource/**");
		
		registry.addInterceptor(needLoginInterceptor).addPathPatterns("/usr/article/Write")
		.addPathPatterns("/usr/article/dowrite").addPathPatterns("/usr/article/Modify")
		.addPathPatterns("/usr/article/doModify").addPathPatterns("/usr/article/doDelete")
		.addPathPatterns("/usr/member/doLogout");
	}
	
	
}
