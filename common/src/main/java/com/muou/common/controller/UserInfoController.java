package com.muou.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.muou.common.dao.UserInfoDao;
import com.muou.common.entity.UserInfo;
import com.muou.common.support.CommonParamConfig;
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
		return "1111111111111111";
	}
	@RequestMapping(value="/userinfo")
	@ResponseBody
	public String userInfo() throws Exception{
		UserInfo userInfo = userInfoDao.getUserInfo(1L);
		String jsonStr = JsonUtil.obj2Json(userInfo).toJSONString();
		logger.info(JsonUtil.obj2Json(userInfoDao.getUserInfo(1L)).toJSONString());
		return jsonStr;
	}
	
	@RequestMapping(value="/redis")
	@ResponseBody
	public String redis(){
		stringRedisTemplate.opsForValue().set("testRedis", "dadasdsadasdasdadadasdadasddadasadaadaa");
		String testRedis = stringRedisTemplate.opsForValue().get("testRedis");
		logger.info(testRedis);
		return testRedis;
	}
	
	@RequestMapping(value="/publish")
	@ResponseBody
	public String publish(@RequestParam(value = "message", required = true) String message){
		logger.info("发布信息 ====== " + message);
		stringRedisTemplate.convertAndSend(CommonParamConfig.COMMMON_TEST_CHANNEL, message);
		return message;
	}
	
}
