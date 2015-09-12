package com.onetopic.concurrency;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleThread2Test
{
    @Test
    public void testSimpleThread2()
    {
        for (int i = 0; i < 5; i++)
        {
            SimpleThread2 thread = new SimpleThread2();
            assertEquals("equal message", "#" + (i + 1) + "(5),", thread.toString());
            assertEquals("equal message", Integer.toString(i + 1), Thread.currentThread().getName());
        }
        
    }
}
