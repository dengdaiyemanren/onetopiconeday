package org.com.onetopic.cache;

public class CacheManager implements ICacheManager{
	
	ICache cache;
	
	public CacheManager(ICache cache)
	{
		this.cache = cache;
	}
	
	public void put(String catalog,String key,Object object)
	{
		cache.put(catalog, key, object, 0);
	}
	
	public Object get(String catalog,String key)
	{
		return cache.get(catalog, key);
	}

	public void init() {
		cache.init();
		
	}

	public void shutdown() {
		cache.shutdown();
		
	}
}
