package onetopic.binaryonecount;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
 * 
 * @author yinlg
 * @created 2015年7月29日 下午9:17:29
 */
public class BinaryOneCount
{
    
    final static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
    
    /**
     * 3表示为11 2表示为10 4表示100
     * 负数的补码：符号位为1，其余位为该数绝对值的原码按位取反；然后整个数加1。
     * 
     * @param n int
     * @return int 二进制中1的个数
     */
    public int numberOf1(int n)
    {
        int count = 0;
        if (n < 0)
        {
            n = -1 * n;
            count = 1;
        }
        
        int left = n;
        while (left > 0)
        {
            int modeValue = left % 2;
            if (modeValue == 1)
            {
                count++;
            }
            left = left / 2;
        }
        
        return count;
    }
    
    public int numberOf1Sec(int n)
    {
        String str = Integer.toBinaryString(n);
        return str.replaceAll("0", "").length();
    }
    
    public int numberOf1Third(int n)
    {
        String str = toBinString(n);
        return str.replaceAll("0", "").length();
    }
    
    public String toBinString(int n)
    {
        int shift = 1;
        int val = n;
        
        // assert shift > 0 && shift <=5 : "Illegal shift value";
        int mag = Integer.SIZE - Integer.numberOfLeadingZeros(val);
        int chars = Math.max(((mag + (shift - 1)) / shift), 1);
        char[] buf = new char[chars];
        
        formatUnsignedInt(val, shift, buf, 0, chars);
        
        // Use special constructor which takes over "buf".
        return new String(buf);
        
    }
    
    static int formatUnsignedInt(int val, int shift, char[] buf, int offset, int len)
    {
        int charPos = len;
        int radix = 1 << shift;
        int mask = radix - 1;
        do
        {
            buf[offset + --charPos] = digits[val & mask];
            val >>>= shift;
        }
        while (val != 0 && charPos > 0);
        
        return charPos;
    }
    
    public static void main(String[] args)
    {
         System.out.println(new BinaryOneCount().toBinString(-3));
        //System.out.println(Integer.numberOfLeadingZeros(3));
        
    }
    
}
