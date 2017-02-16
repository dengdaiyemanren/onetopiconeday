package org.com.onetopic.cache;

import org.junit.Test;

import junit.framework.Assert;

public class CoherenceTest {
	@Test
	public void mysort() {

		CacheHelper.getIntance().put("catalog1", "key1", "value1");
		String value = (String) CacheHelper.getIntance().get("catalog1", "key1");
		
		Assert.assertEquals("value1", value);
		
	}
}
