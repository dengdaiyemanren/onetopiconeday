package org.com.onetopic.cache;

import org.junit.Test;

import junit.framework.Assert;

public class CoherenceTest {
	@Test
	public void mysort() {

		System.setProperty("coherence.cacheconfig", "cache-config-cust.xml");
		 
		CacheHelper.getIntance().put("com.onepic.near.catalog1", "key1", "value1");
		String value = (String) CacheHelper.getIntance().get("com.onepic.near.catalog1", "key1");
		
		Assert.assertEquals("value1", value);
		
	}
}
