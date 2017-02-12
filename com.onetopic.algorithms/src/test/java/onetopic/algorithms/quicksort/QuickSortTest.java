package onetopic.algorithms.quicksort;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QuickSortTest {
	
	@Test
    public void sortString()
    {
       
        
        String[] sortArray = new String[]{"a","b","c","d","e","f","c","f","h"};
        	
        
        new QuickSort().sort(sortArray);
    
        String[] resultArray =  new String[]{"a","b","c","c","d","e","f","f","h"};
        
        assertEquals("111",sortArray,resultArray);
       
    }

}
