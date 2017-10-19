package com.muou.common.controller;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.muou.common.dao.UserInfoDao;
import com.muou.common.util.JsonUtil;

@Controller
@EnableAutoConfiguration
public class UserInfoController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserInfoDao userInfoDao;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@RequestMapping(value="/test")
	@ResponseBody
	public String test(){
		logger.info("=======================");
		testss();
		return "1111111111111111";
	}
	public void testss(){
		logger.info("========wwweeweq===========");
	}
	@RequestMapping(value="/userinfo")
	@ResponseBody
	public String userInfo() throws Exception{
		logger.info("睡眠20s");
		Thread.sleep(20000);
		logger.info(JsonUtil.obj2Json(userInfoDao.getUserInfo(1L)).toJSONString());
		return "1111111111111111";
	}
	
	@RequestMapping(value="/redis")
	@ResponseBody
	public String redis(){
		stringRedisTemplate.opsForValue().set("testRedis", "dadasdsadasdasdadadasdadasddadasadaadaa");
		String testRedis = stringRedisTemplate.opsForValue().get("testRedis");
		logger.info(testRedis);
		return testRedis;
	}
	
}
