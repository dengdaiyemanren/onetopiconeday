package onetopic.algorithms.binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {
	@Test
	public void sortInteger() {

		Integer[] keys = new Integer[] { 9, 2, 3, 4 };
		String[] vals = new String[] { "A", "B", "C", "D" };
		
		BinarySearchST bsst = new BinarySearchST();

		for (int i = 0; i < keys.length; i++) {
			bsst.put(keys[i], vals[i]);
		}

		Assert.assertEquals(null, bsst.get(1));
		Assert.assertEquals("A", bsst.get(9));
	
		Assert.assertEquals(3, bsst.rank(9));

	}
}
