package onetopic.binaryonecount;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryOneCountTest
{
    @Test
    public void BinaryOneCountOnePositive1 ()
    {
       
        int expectResult = 2;
        int expectN = 3;
        
        assertEquals("equal message", expectResult, new BinaryOneCount().numberOf1(expectN));
    }
    
    @Test
    public void BinaryOneCountOnePositive2 ()
    {
        int expectResult = 2;
        int expectN = 3;
        
        assertEquals("equal message", expectResult, new BinaryOneCount().numberOf1Sec(expectN));
    }
    
    @Test
    public void BinaryOneCountOneNegative2 ()
    {
        //0000011->1111100->1111101 ->11111101
        int expectResult = 31;
        int expectN = -3;//�����Ʊ�ʾΪ��ȡ����+1 ����λΪ1������ʾΪ
        
        assertEquals("equal message", expectResult, new BinaryOneCount().numberOf1Sec(expectN));
    }
    
    
}
