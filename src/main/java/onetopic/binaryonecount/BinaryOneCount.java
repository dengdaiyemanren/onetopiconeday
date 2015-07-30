package onetopic.binaryonecount;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
 * 
 * @author yinlg
 * @created 2015年7月29日 下午9:17:29
 */
public class BinaryOneCount
{
    /**
     * 3表示为11 2表示为10 4表示100
     * 负数的补码：符号位为1，其余位为该数绝对值的原码按位取反；然后整个数加1。
     * 
     * @param n int
     * @return int 二进制中1的个数
     */
    public int numberOf1(int n)
    {
        int count=0;
        if(n<0)
        {
            n=-1*n;
            count =1;
        }
        
        int left = n;
        while (left > 0)
        {
            int modeValue = left % 2;
            if (modeValue == 1)
            {
                count++; 
            }
            left = left/2;
        }
        
        
        return count;
    }
    
    public int numberOf1Sec(int n)
    {
<<<<<<< HEAD
        String str = Integer.toBinaryString(n);
        return str.replaceAll("0", "").length();
    }
    
    public static void main(String[] args)
    {
        System.out.println(new BinaryOneCount().numberOf1Sec(-3));
=======
        return Integer.toBinaryString(n).replaceAll("0", "").length();
    }
    
    
    
    public static void main(String[] args)
    {
        System.out.println(new BinaryOneCount().numberOf1(-3));
>>>>>>> a269c2570f4a44c573d51fd99355c9625d1f8c83
        
    }
    
}
