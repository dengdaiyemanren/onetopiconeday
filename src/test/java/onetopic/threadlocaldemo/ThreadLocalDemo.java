package onetopic.threadlocaldemo;

public class ThreadLocalDemo
{
    
    // 通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>()
    {
        public Integer initialValue()
        {
            return 0;
        }
    };
    
    // 获取下一个序列值
    public int getNextNum()
    {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }
    
    public static void main(String[] args)
    {
        ThreadLocalDemo tld = new ThreadLocalDemo();
        //3个线程共享sn，各自产生序列号
        TestClient t1 = new TestClient(tld);
        TestClient t2 = new TestClient(tld);
        TestClient t3 = new TestClient(tld);
        t1.start();
        t2.start();
        t3.start();
        
    }
    
    private static class TestClient extends Thread
    {
        private ThreadLocalDemo tld;
        
        public TestClient(ThreadLocalDemo tld)
        {
            this.tld = tld;
        }
        
        public void run()
        {
            for (int i = 0; i < 3; i++)
            {
                // 每个线程打出3个序列值
                System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn[" + tld.getNextNum() + "]");
            }
        }
        
    }
    
}
