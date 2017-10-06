package com.muou.common.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.muou.common.interceptor.SessionInterceptor;
@Configuration
public class CommonWebAppConfigurer extends WebMvcConfigurerAdapter{
	@Autowired
	SessionInterceptor interceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns("/redis");
		super.addInterceptors(registry);
	}
}
