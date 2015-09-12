package com.onetopic.concurrency;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleThreadTest
{
    @Test
    public void testSimpleThread()
    {
        for (int i = 0; i < 5; i++)
        {
            SimpleThread thread = new SimpleThread();
            assertEquals("equal message", "#" + (i + 1) + "(5),", thread.toString());
            assertEquals("equal message", Integer.toString(i + 1), thread.getName());
        }
        
    }
    
   
}
