package com.example;

import org.infinispan.Cache;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;

public class CacheExample {
    public static void main(String[] args) {
        // Create cache configuration
        ConfigurationBuilder cacheConfig = new ConfigurationBuilder();
        cacheConfig.expiration().lifespan(60000L); // Set cache timeout in milliseconds

        // Create cache manager and cache
        DefaultCacheManager cacheManager = new DefaultCacheManager();
        cacheManager.defineConfiguration("auth-cache", cacheConfig.build());
        Cache<String, String> authCache = cacheManager.getCache("auth-cache");

        // Use the cache
        authCache.put("key", "value");
        System.out.println("Cached value: " + authCache.get("key"));
        
        // Clean up
        cacheManager.stop();
    }
}