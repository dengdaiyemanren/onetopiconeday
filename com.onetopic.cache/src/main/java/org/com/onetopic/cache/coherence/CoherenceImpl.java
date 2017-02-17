package org.com.onetopic.cache.coherence;

import org.com.onetopic.cache.ICache;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

public class CoherenceImpl implements ICache {

	private static String  DEFAULT_CATLOG ="defaultCatalog";
	
	public void init() {
		
	    System.setProperty("coherence.cacheconfig", "cache-config-cust.xml");
	    CacheFactory.ensureCluster();
	}

	public void put(String catalog, String key, Object object, int liveTime) {
		
		//获取catalog
		if(null == CacheFactory.getCache(DEFAULT_CATLOG).get(catalog))
		{
			CacheFactory.getCache(DEFAULT_CATLOG).put(catalog, catalog,0);
		}
		
		//设置缓存
		NamedCache nameCache = CacheFactory.getCache(catalog);  
		
		nameCache.put(key, object,0);
		
	}

	public Object get(String catalog, String key) {
		
		NamedCache nameCache = CacheFactory.getCache(catalog); 
		
		if(null != nameCache)
		{
			return nameCache.get(key);
		}
		
		return null;
		
		
	}
	
	public void remove(String catalog, String key)
	{
	
		NamedCache nameCache = CacheFactory.getCache(catalog);  
		
		if(null != nameCache)
		{
			nameCache.remove(key);
		}
		 
	}

	public void shutdown() {
		
		CacheFactory.shutdown();
	}

}
