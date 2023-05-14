package com.koreaIT.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.koreaIT.demo.interceptor.BeforeActionInterceptor;
import com.koreaIT.demo.interceptor.NeedLoginInterceptor;
import com.koreaIT.demo.interceptor.NeedLogoutInterceptor;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

	private BeforeActionInterceptor beforeActionInterceptor;
	private NeedLoginInterceptor needLoginInterceptor;
	private NeedLogoutInterceptor needLogoutInterceptor;

	@Autowired
	public MyWebMvcConfigurer(BeforeActionInterceptor beforeActionInterceptor,
			NeedLoginInterceptor needLoginInterceptor, NeedLogoutInterceptor needLogoutInterceptor) {
		this.beforeActionInterceptor = beforeActionInterceptor;
		this.needLoginInterceptor = needLoginInterceptor;
		this.needLogoutInterceptor = needLogoutInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		InterceptorRegistration ir;
		
		ir = registry.addInterceptor(beforeActionInterceptor);
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
		ir.addPathPatterns("/usr/member/myPage");
		ir.addPathPatterns("/usr/member/checkPassword");
		ir.addPathPatterns("/usr/member/doCheckPassword");
		ir.addPathPatterns("/usr/member/doModify");
		ir.addPathPatterns("/usr/member/passwordModify");
		ir.addPathPatterns("/usr/member/doPasswordModify");
		ir.addPathPatterns("/usr/reactionPoint/getReactionPoint");
		ir.addPathPatterns("/usr/reactionPoint/doInsertReactionPoint");
		ir.addPathPatterns("/usr/reactionPoint/doDeleteReactionPoint");
		ir.addPathPatterns("/usr/reply/dowrite");
		ir.addPathPatterns("/usr/reply/dodelete");
		ir.addPathPatterns("/usr/reply/domodify");
		ir.addPathPatterns("/usr/reply/getreplyContent");
		
		ir = registry.addInterceptor(needLogoutInterceptor);
		ir.addPathPatterns("/usr/member/dojoin");
		ir.addPathPatterns("/usr/member/login");
		ir.addPathPatterns("/usr/member/dologin");
		
//		registry.addInterceptor(beforActionInetereceptor).addPathPatterns("/**").excludePathPatterns("/resource/**");
//		
//		registry.addInterceptor(needLoginInterceptor).addPathPatterns("/usr/article/Write")
//		.addPathPatterns("/usr/article/dowrite").addPathPatterns("/usr/article/Modify")
//		.addPathPatterns("/usr/article/doModify").addPathPatterns("/usr/article/doDelete")
//		.addPathPatterns("/usr/member/doLogout");
	}
	
	
}
