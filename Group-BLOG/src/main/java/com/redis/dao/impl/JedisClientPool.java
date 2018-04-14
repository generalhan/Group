package com.redis.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redis.dao.JedisClient;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
/**
 * redis单机版客户端
 */

public class JedisClientPool implements JedisClient{
	
	@Autowired
	private JedisPool jedisPool;


	public String get(String key) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.get(key);
		jedis.close();
		return result;
	}

	
	public String set(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		String string = jedis.set(key, value);
		jedis.close();
		return string;
	}


	public long incr(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.incr(key);
		jedis.close();
		return result;
	}


	public Long hset(String hkey, String key, String value) {
		Jedis jedis = jedisPool.getResource();
		Long hset = jedis.hset(hkey, key, value);
		jedis.close();
		return hset;
	}

	
	public String hget(String hkey, String key) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.hget(hkey, key);
		jedis.close();
		return result;
	}


	public Long del(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.del(key);
		jedis.close();
		return result;
	}

	
	public Long hdel(String hkey, String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hdel(hkey, key);
		jedis.close();
		return result;
	}


	public Long expire(String key, int second) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.expire(key, second);
		return result;
	}


	public Long lpush(String key, String value) {
		 Jedis jedis = jedisPool.getResource();  
	        Long length = jedis.lpush(key, value);  
	        jedis.close();  
	        return length;  
	}


	public String lindex(String key, long index) {
		 Jedis jedis = jedisPool.getResource();  
	        String str = jedis.lindex(key, index);  
	        jedis.close();  
	        return str;  
	}


	public Long rpush(String key, String value) {
		 Jedis jedis = jedisPool.getResource();  
	        Long length = jedis.rpush(key, value);  
	        jedis.close();  
	        return length;  
	}


	public boolean exist(String key) {
		Jedis jedis = jedisPool.getResource(); 
		return jedis.exists(key)?true:false;
	}


	public Long llen(String key) {
		Jedis jedis = jedisPool.getResource();  
        Long length = jedis.llen(key);  
        jedis.close();  
        return length;  
	}


	public List<String> lrange(String key, long start, long end) {
		Jedis jedis = jedisPool.getResource();  
        List<String> list = jedis.lrange(key, start, end);  
        jedis.close();  
        return list; 
	}
	
}
