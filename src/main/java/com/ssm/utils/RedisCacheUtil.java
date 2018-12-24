package com.ssm.utils;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;


public class RedisCacheUtil implements Cache{

	private static JedisConnectionFactory jedisConnectionFactory;
	private final String id;
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	public RedisCacheUtil(final String id){
		if(id == null){
			throw new IllegalArgumentException("缓存实例需要ID");
		}
		this.id = id;
	}
	
	@Override
	public void clear() {
		JedisConnection conn = null;
		try {
			conn = jedisConnectionFactory.getConnection();
			conn.flushDb();
			conn.flushAll();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(conn != null){
				conn.close();
			}
		}
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public Object getObject(Object key) {
		Object obj = null;
		JedisConnection conn = null;
		try {
			conn = jedisConnectionFactory.getConnection();
			RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
			obj = serializer.deserialize(conn.get(serializer.serialize(key)));
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(conn != null){
				conn.close();
			}
		}
		return obj;
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		return this.readWriteLock;
	}

	@Override
	public int getSize() {
		int res = 0;
		JedisConnection conn = null;
		try {
			conn = jedisConnectionFactory.getConnection();
			res = Integer.parseInt(conn.dbSize().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(conn != null){
				conn.close();
			}
		}
		return res;
	}

	@Override
	public void putObject(Object key, Object value) {
		JedisConnection conn = null;
		try {
			conn = jedisConnectionFactory.getConnection();
			RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
			conn.set(serializer.serialize(key), serializer.serialize(value));
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(conn != null){
				conn.close();
			}
		}
	}

	@Override
	public Object removeObject(Object key) {
		Object obj = null;
		JedisConnection conn = null;
		try {
			conn = jedisConnectionFactory.getConnection();
			RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
			obj = conn.expireAt(serializer.serialize(key), 0);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(conn != null){
				conn.close();
			}
		}
		return obj;
	}

	public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
		RedisCacheUtil.jedisConnectionFactory = jedisConnectionFactory;
	}
	
	
}
