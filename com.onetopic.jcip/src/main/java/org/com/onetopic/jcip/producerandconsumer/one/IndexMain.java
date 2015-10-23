package org.com.onetopic.jcip.producerandconsumer.one;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class IndexMain
{
    private static final int BOUND = 50;
    private static final int N_CONSUMERS = 8;
    
    public static void startIndexing(File[] roots)
    {
        BlockingQueue<File> queue = new LinkedBlockingQueue<File>(BOUND);
        FileFilter filter = new FileFilter()
        {
            public boolean accept(File file)
            {
                return true;
            }
        };
        
        for (File root : roots)
        {
            new Thread(new FileCrawler(queue, filter, root)).start();
        }
        
        for (int i = 0; i < N_CONSUMERS; i++)
        {
            new Thread(new Indexer(queue)).start();
        }
    }
    
}
