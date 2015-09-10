package onetopic.binaryonecount;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryOneCountTest
{
    @Test
    public void BinaryOneCountOnePositive1()
    {
        
        int expectResult = 2;
        int expectN = 3;
        
        assertEquals("equal message", expectResult, new BinaryOneCount().numberOf1(expectN));
    }
    
    @Test
    public void BinaryOneCountOnePositive2()
    {
        int expectResult = 2;
        int expectN = 3;
        
        assertEquals("equal message", expectResult, new BinaryOneCount().numberOf1Sec(expectN));
    }
    
    @Test
    public void BinaryOneCountOneNegative2()
    {
        int expectResult = 31;
        int expectN = -3;// 二进制补码计算公式为：取反，+1 ，首位为1，表示为负数
        
        assertEquals("equal message", expectResult, new BinaryOneCount().numberOf1Sec(expectN));
    }
    
    @Test
    public void BinaryOneCountOneNegative3()
    {
        int expectResult = 31;
        int expectN = -3;
        
        assertEquals("equal message", expectResult, new BinaryOneCount().numberOf1Third(expectN));
    }
}
