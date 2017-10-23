package com.muou.common.support;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;
@Component
public class CommonListener implements ServletContextListener{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	//@Autowired
	//private RedisTemplate redisTemplate;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private ChannelTopic channelTopic;
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("CommonListener ============= ");
		//String testRedis = stringRedisTemplate.opsForValue().get("testRedis");
		//redisTemplate.
		//stringRedisTemplate.
		String testRedis = channelTopic.getTopic();
		logger.info("CommonListener =============111111 ");
		logger.info(testRedis);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
