package com.redis.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.redis.dao.JedisClient;

import redis.clients.jedis.JedisCluster;

/**
 * redis集群版客户端
 */
public class JedisClientCluster implements JedisClient {

	@Autowired
	private JedisCluster jedisCluster;
	

	public String get(String key) {
		String string = jedisCluster.get(key);
		return string;
	}


	public String set(String key, String value) {
		String string = jedisCluster.set(key, value);
		return string;
	}


	public long incr(String key) {
		Long result = jedisCluster.incr(key);
		return result;
	}


	public Long hset(String hkey, String key, String value) {
		Long result = jedisCluster.hset(hkey, key, value);
		return result;
	}

	
	public String hget(String hkey, String key) {
		String string = jedisCluster.hget(hkey, key);
		return string;
	}

	
	public Long del(String key) {
		Long result = jedisCluster.del(key);
		return result;
	}


	public Long hdel(String hkey, String key) {
		Long result = jedisCluster.hdel(hkey, key);
		return result;
	}


	public Long expire(String key, int second) {
		Long result = jedisCluster.expire(key, second);
		return result;
	}


	public Long lpush(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}


	public String lindex(String key, long index) {
		// TODO Auto-generated method stub
		return null;
	}


	public Long rpush(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean exist(String key) {
		// TODO Auto-generated method stub
		return false;
	}


	public Long llen(String key) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<String> lrange(String key, long start, long end) {
		// TODO Auto-generated method stub
		return null;
	}

}

