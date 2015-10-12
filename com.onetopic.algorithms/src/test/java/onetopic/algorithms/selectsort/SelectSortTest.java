package onetopic.algorithms.selectsort;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class SelectSortTest
{
    @Test
    public void mysort()
    {
        Integer[] sortIntegerArray = {7,6,5,4,3};
        
        Integer[] resultArray = {3,4,5,6,7};
        
        SelectSort.mysort(sortIntegerArray);
        
        Assert.assertArrayEquals(sortIntegerArray, resultArray);
        
    }
    
    @Test
    public void sort()
    {
        Integer[] sortIntegerArray = {7,6,5,4,3};
        
        Integer[] resultArray = {3,4,5,6,7};
        
        SelectSort.sort(sortIntegerArray);
        
        Assert.assertArrayEquals(sortIntegerArray, resultArray);
        
    }
    
}
