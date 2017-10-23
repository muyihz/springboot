package com.muou.common.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class CommonWebAppConfigurer extends WebMvcConfigurerAdapter{
	@Autowired
	SessionInterceptor interceptor;
	@Autowired
	CommonListener commonListener; 
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns("/redis");
		super.addInterceptors(registry);
	}
	
	@Bean
	public ServletListenerRegistrationBean servletListenerRegistrationBean(){
		ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
		servletListenerRegistrationBean.setListener(commonListener);
		return servletListenerRegistrationBean;
	}
	@Bean
	public ChannelTopic channelTopic(){
		return new ChannelTopic("TEST_CHANNEL");
	}
}
