package onetopic.shortestdistance;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ShortestDistanceTest
{
    
    @Test
    public void getRideOne()
    {
        new ShortestDistance().lineOne.clear();
        new ShortestDistance().lineTwo.clear();
        new ShortestDistance().linesMap.clear();
        
        Map<String, List<String>> linesMap = new HashMap();
        List<String> lineOne = new ArrayList();
        List<String> lineTwo = new ArrayList();
        List<String> lineThree = new ArrayList();
        
        lineOne.add("A");
        lineOne.add("B");
        lineOne.add("C");
        lineOne.add("D");
        lineOne.add("E");
        lineOne.add("H");
        
        lineTwo.add("C");
        lineTwo.add("E");
        lineTwo.add("D");
        lineTwo.add("G");
        lineTwo.add("H");
        lineTwo.add("M");
        
        lineThree.add("D");
        lineThree.add("M");
        lineThree.add("H");
        
        
        linesMap.put("1", lineOne);
        linesMap.put("2", lineTwo);
        linesMap.put("3", lineThree);
        
        new ShortestDistance().linesMap=linesMap;
        
        assertEquals("equal message", 5, new ShortestDistance().getRide("A", "D"));
        
    }
    
}
