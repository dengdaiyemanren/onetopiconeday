package onetopic.wordreverse;

/**
 * ˵����ÿ����������26����д��СдӢ����ĸ���ɣ���-����Ϊ�������ӷ�ʹ��ʱ����Ϊ���ʵ�һ���֣�
 * ����һ��������ֻ������һ�Σ���������2����-������ʱ��Ϊ�ָ���,�硰aa--bb���еġ�������Ϊ�ָ�����
 * 2������Ϊ��aa���͡�bb�����ǹ��ɵ��ʵ��ַ�����Ϊ���ʼ������Ҫ���ź�ĵ��ʼ�����Կո��ʾ��
 * ԭ�ַ��������ڵ��ʼ��ж�������ʱ������ת����ֻ�������һ���ո�������ÿ�������20����ĸ�� 
 * ʾ���� ����ԭʼ������䣺I am a - student ���ź�ĵ�����䣺student a am I
 * @author yinlg
 * @date 20150712
 *
 */
public class WordReverse {
	
	/**
	 * 
	 * @param pInput
	 * @param pOutput
	 * @return
	 */
	public int converse(String pInput, StringBuffer pOutput)
	{
		String regex ="(?!(?<=[a-zA-Z]+)-(?=[a-zA-Z]+))[^a-zA-Z]+";
		String repStr = pInput.replaceAll(regex, " ");
		String [] splitWord = repStr.trim().split(" ");
		
		if(splitWord.length==0)
		{
			return 0;
		}
		
		for(int i = splitWord.length-1;i>=0;i--)
		{
			if (splitWord[i].length() > 20) 
			{
				return -1;
			}
			
			if(i==0)
			{
				pOutput.append(splitWord[i]);
			}
			else
			{
				pOutput.append(splitWord[i]).append(" ");
			}
		}
		
		return 0;
	}
	

	public static void main(String[] args) {
		
		String sourceStr= "I am a - student";
		StringBuffer destStr = new StringBuffer();
		new WordReverse().converse(sourceStr, destStr);
		System.out.println(destStr);

	}

}
