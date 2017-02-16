package org.com.onetopic.cache;

public interface ICacheManager {

	public void init();
	
	public void put(String catalog,String key,Object object);
	public Object get(String catalog,String key);
	
	public void shutdown();
	
}
