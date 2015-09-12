package com.onetopic.concurrency;

//继承自Thread,还是要写run方法。
public class SimpleThread2 implements Runnable
{
    private int countDown = 5;
    private static int threadCount = 0;
    
   public SimpleThread2()
    {
        // Store the thread name:
       Thread.currentThread().setName(Integer.toString(++threadCount));
    }
    
    public String toString()
    {
        return "#" + Thread.currentThread().getName()+ "("+ countDown + "),";
    }
    public void run()
    {
        while (true)
        {
            // System.out.print(this);
            if (--countDown == 0)
                return;
        }
    }
    
    public static void main(String[] args)
    {
        for (int i = 0; i < 5; i++)
            System.out.println(new SimpleThread().getName());
    }
}
