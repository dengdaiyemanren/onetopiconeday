package org.com.onetopic.cache;

import org.junit.Test;

import junit.framework.Assert;

public class EhcacheTest {
	@Test
	public void mysort() {

		//System.setProperty("coherence.cacheconfig", "cache-config-cust.xml");
		 
		CacheHelper.getIntance().put("basicCache", "key1", "value1");
		String value = (String) CacheHelper.getIntance().get("basicCache", "key1");
		
		Assert.assertEquals("value1", value);
		
	}
}
