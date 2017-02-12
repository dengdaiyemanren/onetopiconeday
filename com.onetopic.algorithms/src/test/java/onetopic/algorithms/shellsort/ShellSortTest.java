package onetopic.algorithms.shellsort;

import org.junit.Assert;
import org.junit.Test;

public class ShellSortTest {

	@Test
    public void sort()
    {
        Integer[] sortIntegerArray = { 1, 2, 5, 4, 3 };
        
        Integer[] resultArray = { 1, 2, 3, 4, 5 };
        
        ShellSort.sort(sortIntegerArray);
        
        Assert.assertArrayEquals(sortIntegerArray, resultArray);
        
    }
      
}
