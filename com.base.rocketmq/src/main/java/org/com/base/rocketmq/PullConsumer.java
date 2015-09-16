package org.com.base.rocketmq;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.rocketmq.client.consumer.DefaultMQPullConsumer;
import com.alibaba.rocketmq.client.consumer.PullResult;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.common.message.MessageQueue;

/**
 * PullConsumer，订阅消息
 */
public class PullConsumer
{
    // Java缓存
    private static final Map<MessageQueue, Long> offseTable = new HashMap<MessageQueue, Long>();
    
    public static void main(String[] args) throws MQClientException
    {
        DefaultMQPullConsumer consumer = new DefaultMQPullConsumer("PullConsumerGroup");
        consumer.setNamesrvAddr("127.0.0.1:9876");
        consumer.start();
        // 拉取订阅主题的队列，默认队列大小是4
        Set<MessageQueue> mqs = consumer.fetchSubscribeMessageQueues("PullTopic");
        for (MessageQueue mq : mqs)
        {
            System.out.println("Consume from the queue: " + mq);
            SINGLE_MQ:
            while (true)
            {
                try
                {
                    
                    PullResult pullResult = consumer.pullBlockIfNotFound(mq, null, getMessageQueueOffset(mq), 32);
                    List<MessageExt> list = pullResult.getMsgFoundList();
                    if (list != null && list.size() < 100)
                    {
                        for (MessageExt msg : list)
                        {
                            System.out.println(new String((msg.getBody())));
                        }
                    }
                    System.out.println(pullResult.getNextBeginOffset());
                    putMessageQueueOffset(mq, pullResult.getNextBeginOffset());
                    
                    switch (pullResult.getPullStatus())
                    {
                        case FOUND:
                            // TODO
                            break;
                        case NO_MATCHED_MSG:
                            break;
                        case NO_NEW_MSG:
                            break SINGLE_MQ;
                        case OFFSET_ILLEGAL:
                            break;
                        default:
                            break;
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        
        consumer.shutdown();
    }
    
    private static void putMessageQueueOffset(MessageQueue mq, long offset)
    {
        offseTable.put(mq, offset);
    }
    
    private static long getMessageQueueOffset(MessageQueue mq)
    {
        Long offset = offseTable.get(mq);
        if (offset != null)
        {
            System.out.println(offset);
            return offset;
        }
        return 0;
    }
}