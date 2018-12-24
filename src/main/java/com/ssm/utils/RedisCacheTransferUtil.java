package com.ssm.utils;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

public class RedisCacheTransferUtil {

	public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
		RedisCacheUtil.setJedisConnectionFactory(jedisConnectionFactory);
	}
	
}
