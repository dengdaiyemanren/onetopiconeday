package onetopic.wordreverse;

/**
 * ˵����ÿ����������26����д��СдӢ����ĸ���ɣ���-����Ϊ�������ӷ�ʹ��ʱ����Ϊ���ʵ�һ���֣�
 * ����һ��������ֻ������һ�Σ���������2����-������ʱ��Ϊ�ָ���,�硰aa--bb���еġ�������Ϊ�ָ�����
 * 2������Ϊ��aa���͡�bb�����ǹ��ɵ��ʵ��ַ�����Ϊ���ʼ������Ҫ���ź�ĵ��ʼ�����Կո��ʾ��
 * ԭ�ַ��������ڵ��ʼ��ж�������ʱ������ת����ֻ�������һ���ո�������ÿ�������20����ĸ�� 
 * ʾ���� ����ԭʼ������䣺I am a - student ���ź�ĵ�����䣺student a am I
 * @author yinlg
 * @date 20150712
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class WordReverseTest {
	
	/**
	 * 
	 * @param pInput
	 * @param pOutput
	 * @return
	 */
	@Test
	public void converseOne()
	{
		String srcStr = "-i am --student";
		String expectStr = "student am i";
		
		StringBuffer destSB = new StringBuffer();
		new WordReverse().converse(srcStr, destSB);
		assertEquals("equal message",expectStr,destSB.toString());
		
	}
	

	

}
