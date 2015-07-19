package onetopic.fibonacci;

/**
 * 0��1��1��2��3��5��8��13��21
 * ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n�
 * 
 * @author yinlg
 * @created 2015��7��19�� ����4:28:39
 */
public class Fibonacci
{
    
    public int Fibonacci(int n) {
        
        if(n==0)
            return 0;
        if(n <=2)
            return 1;
        int a =1,b=1,c=0;
        
        while(n-2>0)
        {
            c = a+b;
            a = b;
            b =c;
            n--;
        }
        return c;
    }
    
    public static void main(String[] args)
    {
        System.out.println(new Fibonacci().Fibonacci(8));
        
    }
    
}
