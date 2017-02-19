package org.com.onetopic.cache.ehcache;

import java.net.URL;

import org.com.onetopic.cache.ICache;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.Configuration;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;

public class EhcacheImpl implements ICache {

	private static CacheManager cacheManager;

	private static Configuration xmlConfig;
	private static final String path = "/ehcache.xml";

	public void init() {

		final URL myUrl = this.getClass().getResource(path);
		xmlConfig = new XmlConfiguration(myUrl);

		cacheManager = CacheManagerBuilder.newCacheManager(xmlConfig);
		cacheManager.init();

	}

	public void put(String catalog, String key, Object object, int liveTime) {

		Cache cache = cacheManager.getCache(catalog, String.class, String.class);

		cache.put(key, object);

	}

	public Object get(String catalog, String key) {
		Cache cache = cacheManager.getCache(catalog, String.class, String.class);
		Object value = cache.get(key);

		return value;
	}

	public void shutdown() {
		cacheManager.close();

	}

}
