package org.com.onetopic.jcip.producerandconsumer.one;

import java.io.File;
import java.util.concurrent.BlockingQueue;

public class Indexer implements Runnable
{
    private final BlockingQueue<File> queue;
    
    public Indexer(BlockingQueue<File> queue)
    {
        this.queue = queue;
    }
    
    public void run()
    {
        try
        {
            indexFile(queue.take());
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }
    
    public void indexFile(File file)
    {
        System.out.println(Thread.currentThread() + ": " + file);
    }
    
}
