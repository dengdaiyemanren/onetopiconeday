package org.com.onetopic.cache;

public interface ICache {
	
	public void init();
	
	public void put(String catalog,String key,Object object,int liveTime);
	public Object get(String catalog,String key);
	
	public void shutdown();
}
