package com.onetopic.concurrency;

//继承自Thread,还是要写run方法。
public class SimpleThread extends Thread
{
    private int countDown = 5;
    private static int threadCount = 0;
    
    public SimpleThread()
    {
        // Store the thread name:
        super(Integer.toString(++threadCount));
        start();
        
    }
    
    public String toString()
    {
        return "#" + getName() + "("+countDown+"),";
    }
    
    public void run()
    {
        while (true)
        {
            //System.out.print(this);
            if (--countDown == 0)
                return;
        }
    }
    
    public static void main(String[] args)
    {
        for (int i = 0; i < 5; i++)
            System.out.println(new SimpleThread().toString());
    }
}