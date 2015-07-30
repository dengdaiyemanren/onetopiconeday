package onetopic.binaryonecount;

/**
 * ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ
 * 
 * @author yinlg
 * @created 2015��7��29�� ����9:17:29
 */
public class BinaryOneCount
{
    /**
     * 3��ʾΪ11 2��ʾΪ10 4��ʾ100
     * �����Ĳ��룺����λΪ1������λΪ��������ֵ��ԭ�밴λȡ����Ȼ����������1��
     * 
     * @param n int
     * @return int ��������1�ĸ���
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
