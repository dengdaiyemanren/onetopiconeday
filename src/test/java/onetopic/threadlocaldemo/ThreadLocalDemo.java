package onetopic.threadlocaldemo;

public class ThreadLocalDemo
{
    
    // ͨ�������ڲ��า��ThreadLocal��initialValue()������ָ����ʼֵ
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>()
    {
        public Integer initialValue()
        {
            return 0;
        }
    };
    
    // ��ȡ��һ������ֵ
    public int getNextNum()
    {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }
    
    public static void main(String[] args)
    {
        ThreadLocalDemo tld = new ThreadLocalDemo();
        //3���̹߳���sn�����Բ������к�
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
                // ÿ���̴߳��3������ֵ
                System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn[" + tld.getNextNum() + "]");
            }
        }
        
    }
    
}
