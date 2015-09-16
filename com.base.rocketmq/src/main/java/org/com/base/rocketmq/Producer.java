package org.com.base.rocketmq;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

public class Producer
{
    public static void main(String[] args)
    {
        DefaultMQProducer producer = new DefaultMQProducer("Producer");
        producer.setNamesrvAddr("192.168.1.131:9876");
       
        try
        {
            producer.start();
            
            Message msg = new Message("PushTopic", "push", "7", "Just for test.".getBytes());
            
            SendResult result = producer.send(msg);
            System.out.println("id:" + result.getMsgId() + " result:" + result.getSendStatus());
            
            msg = new Message("PushTopic", "push", "4", "Just for test.".getBytes());
            
            result = producer.send(msg);
            System.out.println("id:" + result.getMsgId() + " result:" + result.getSendStatus());
            
            msg = new Message("PullTopic", "pull", "2", "Just for test.".getBytes());
            
            result = producer.send(msg);
            System.out.println("id:" + result.getMsgId() + " result:" + result.getSendStatus());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            producer.shutdown();
        }
    }
}
