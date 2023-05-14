package com.koreaIT.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
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
		
		InterceptorRegistration ir;

		ir = registry.addInterceptor(beforActionInetereceptor);
		ir.addPathPatterns("/**");
		ir.addPathPatterns("/favicon.ico");
		ir.excludePathPatterns("/resource/**");

		ir = registry.addInterceptor(needLoginInterceptor);
		ir.addPathPatterns("/usr/article/Write");
		ir.addPathPatterns("/usr/article/dowrite");
		ir.addPathPatterns("/usr/article/Modify");
		ir.addPathPatterns("/usr/article/doModify");
		ir.addPathPatterns("/usr/article/doDelete");
		ir.addPathPatterns("/usr/member/doLogout");
		ir.addPathPatterns("/usr/reactionPoint/doInsertReactionPoint");
		ir.addPathPatterns("/usr/reactionPoint/doDeleteReactionPoint");
		ir.addPathPatterns("/usr/reply/dowrite");
		
//		registry.addInterceptor(beforActionInetereceptor).addPathPatterns("/**").excludePathPatterns("/resource/**");
//		
//		registry.addInterceptor(needLoginInterceptor).addPathPatterns("/usr/article/Write")
//		.addPathPatterns("/usr/article/dowrite").addPathPatterns("/usr/article/Modify")
//		.addPathPatterns("/usr/article/doModify").addPathPatterns("/usr/article/doDelete")
//		.addPathPatterns("/usr/member/doLogout");
	}
	
	
}
