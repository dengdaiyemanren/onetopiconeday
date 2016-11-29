package onetopic.algorithms.recursion;
import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
public class FileSearchTest {

	@Test
	public void searchManyFile()
	{
		String fileName = "aa.txt";
		
		File scanFilePath = new File(this.getClass().getResource("file/").getPath());
		  
		List<File> outList = new ArrayList<File>();
		
		new FileSearch().searchByFileName(fileName, scanFilePath, outList);
		

		for(int i =0;i<outList.size();i++)
		{
			Assert.assertEquals("equal", "aa.txt", outList.get(i).getName());
			System.out.println(outList.get(i).getAbsolutePath());
		}
	}
}
