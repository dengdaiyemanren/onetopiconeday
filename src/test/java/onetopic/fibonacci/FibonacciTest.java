package onetopic.fibonacci;

import static org.junit.Assert.*;
import onetopic.shortestdistance.ShortestDistance;

import org.junit.Test;

public class FibonacciTest
{
    @Test
    public void FibonacciOne()
    {
        //0,1,1,2,3,5,8,13,21
        int expectResult = 8;
        int expectN = 6;
        
        assertEquals("equal message", 8, new Fibonacci().Fibonacci(6));
    }
}
