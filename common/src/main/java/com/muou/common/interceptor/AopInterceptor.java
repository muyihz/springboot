package com.muou.common.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopInterceptor {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("execution(* com.muou.common.controller.*.*(..))")
	public void classPointCut(){};
	
	//@Pointcut("excution (*com.muou.common.comntroller.*.*(..)) and @annotation(org.springframework.web.bind.annotation.RequestMapping)")
	//public void classMethodPointCut(){};
	
	@Around("classPointCut()")
	public Object interceptor(ProceedingJoinPoint pjp) throws Throwable{
		//String testkey = request.getParameter("testkey");
		logger.info("瞎搞 aop配置====");
		Object obj = pjp.proceed();
		return obj;
	}
}
