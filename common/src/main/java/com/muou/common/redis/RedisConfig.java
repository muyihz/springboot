package com.muou.common.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import com.muou.common.support.CommonParamConfig;

@Configuration
public class RedisConfig {
	@Bean
	public RedisMessageListenerContainer messageListenerContainer(RedisConnectionFactory connectionFactory,
            MessageListenerAdapter listenerAdapter){
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.addMessageListener(listenerAdapter, new PatternTopic(CommonParamConfig.COMMMON_TEST_CHANNEL));
		return container;
	}
	@Bean
	public MessageListenerAdapter messageListenerAdapter(MessageReceiver receiver){
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}
}
