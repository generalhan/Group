package com.sys.realm;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher{

	// ����һ������ӿڣ�����ӿ���Shiro��������һ���֣����ľ���ʵ�ֿ���ͨ���ⲿ����ע��
	 private Cache<String, AtomicInteger> passwordRetryCache;
	 
	 public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
	        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
	    }
	 
	 @Override
	    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		 String username = (String) token.getPrincipal();
	        AtomicInteger retryCount = passwordRetryCache.get(username);
	        if (retryCount == null) {
	            retryCount = new AtomicInteger(0);
	            passwordRetryCache.put(username, retryCount);
	        }
	        // �Զ���һ����֤���̣����û����������������5�����Ͻ�ֹ�û���¼һ��ʱ��
	        if (retryCount.incrementAndGet() > 5) {
	            throw new ExcessiveAttemptsException();
	        }
	        boolean match = super.doCredentialsMatch(token, info);
	        if (match) {
	            passwordRetryCache.remove(username);
	        }
	        return match;
	 }
	
}
