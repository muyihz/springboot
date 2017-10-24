package com.muou.common.support;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
public class CommonListener implements ServletContextListener{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("CommonListener ============= contextInitialized");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.info("CommonListener ============= contextDestroyed");
	}

}
