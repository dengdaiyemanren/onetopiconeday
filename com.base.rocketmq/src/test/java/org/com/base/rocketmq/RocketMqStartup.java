package org.com.base.rocketmq;

import com.alibaba.rocketmq.broker.BrokerStartup;
import com.alibaba.rocketmq.common.MixAll;
import com.alibaba.rocketmq.namesrv.NamesrvStartup;

public class RocketMqStartup implements Runnable
{
    
    public static void startBroker()
    {
        String args[] = new String[1];
        args[0] = new String("-n 192.168.1.131:9876");
        
        BrokerStartup.start(BrokerStartup.createBrokerController(args));
    }
    
    public static void startNameSvr()
    {
        NamesrvStartup.main0(null);
    }

    public void run()
    {
        System.setProperty(MixAll.ROCKETMQ_HOME_PROPERTY, RocketMqStartup.class.getResource(".").getPath());
        System.setProperty(MixAll.NAMESRV_ADDR_PROPERTY,"192.168.1.131:9876");
        
        RocketMqStartup.startNameSvr();
        RocketMqStartup.startBroker();
        
        
        
        Producer.main(null);
        Consumer.main(null);
        
    }
}
