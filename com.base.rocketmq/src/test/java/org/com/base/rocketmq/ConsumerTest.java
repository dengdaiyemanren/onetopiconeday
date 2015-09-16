package org.com.base.rocketmq;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.alibaba.rocketmq.common.MixAll;

public class ConsumerTest
{
    
    @BeforeClass
    public static void init()
    {
      // RocketMqStartup  startup =  new RocketMqStartup();
       //Thread thread = new Thread(startup);
       //thread.setDaemon(true);
       //thread.run();
    
      
    }
    @Test
    public void testOne()
    {
       Consumer.main(null);
    }
    
    @Test
    public void testTwo()
    {
        Producer.main(null);
    }
    @Test
    public void end()
    {
        
    }
}
