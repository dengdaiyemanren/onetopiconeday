package onetopic.algorithms.mergesort;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest
{
   @Test
    public void sortString()
    {
        String sortStr = "abc def cfh";
        
        String[] sortArray = sortStr.split(" ");
        MergeSort.sort(sortArray);
        String resultStr = "abc cfh def";
        String[] resultArray = resultStr.split(" ");
        
        assertEquals("111",sortArray,resultArray);
       
    }
    @Test
    public void sortInteger()
    {
       
        Integer[] sortIntegerArray = {9,2,3,4};
       
        MergeSort.sort(sortIntegerArray);
        
        Integer[] resultArray = {2,3,4,9};
       
        Assert.assertArrayEquals(sortIntegerArray, resultArray);
        //assertEquals("111",sortIntegerArray,resultArray);
       
    }
}
