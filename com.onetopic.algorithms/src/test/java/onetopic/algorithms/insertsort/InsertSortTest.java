package onetopic.algorithms.insertsort;

import static org.junit.Assert.*;
import onetopic.algorithms.selectsort.SelectSort;

import org.junit.Assert;
import org.junit.Test;

public class InsertSortTest
{
    @Test
    public void mysort()
    {
        Integer[] sortIntegerArray = { 1, 2, 5, 4, 3 };
        
        Integer[] resultArray = { 1, 2, 3, 4, 5 };
        
        InsertSort.mysort(sortIntegerArray);
        
        Assert.assertArrayEquals(sortIntegerArray, resultArray);
        
    }
    
    @Test
    public void mysort2()
    {
        Integer[] sortIntegerArray = { 7, 6, 5, 4, 3 };
        
        Integer[] resultArray = { 3, 4, 5, 6, 7 };
        
        InsertSort.mysort(sortIntegerArray);
        
        Assert.assertArrayEquals(sortIntegerArray, resultArray);
        
    }
    
    @Test
    public void sort1()
    {
        Integer[] sortIntegerArray = { 1, 2, 5, 4, 3 };
        
        Integer[] resultArray = { 1, 2, 3, 4, 5 };
        
        InsertSort.sort(sortIntegerArray);
        
        Assert.assertArrayEquals(sortIntegerArray, resultArray);
        
    }
    
    @Test
    public void sort2()
    {
        Integer[] sortIntegerArray = { 7, 6, 5, 4, 3 };
        
        Integer[] resultArray = { 3, 4, 5, 6, 7 };
        
        InsertSort.sort(sortIntegerArray);
        
        Assert.assertArrayEquals(sortIntegerArray, resultArray);
        
    }
    
}
