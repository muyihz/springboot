package com.muou.common.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class CommonWebAppConfigurer extends WebMvcConfigurerAdapter{
	@Autowired
	SessionInterceptor interceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//SessionInterceptor interceptor = new SessionInterceptor();
		registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns("/redis");
		//registry.addInterceptor(interceptor).excludePathPatterns("/redis");
		super.addInterceptors(registry);
	}
}
