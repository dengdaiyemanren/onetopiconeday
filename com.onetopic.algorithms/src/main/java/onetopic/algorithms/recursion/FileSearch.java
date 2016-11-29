package onetopic.algorithms.recursion;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author yinlg
 *
 */
public class FileSearch {

	/**
	 * @param fileName 要查找文件名
	 * @param scanFilePath 扫描文件或文件夹
	 * @param outList 结果
	 */
	public void searchByFileName(String fileName, File scanFilePath, List<File> outList) {
		if (scanFilePath.isFile()) {
			if (fileName.equals(scanFilePath.getName())) {
				outList.add(scanFilePath);
				return;
			}
		} else {
			if (scanFilePath.isDirectory()) {
				File[] files = scanFilePath.listFiles();

				for (int i = 0; i < files.length; i++) {
					File oneFile = files[i];
					searchByFileName(fileName, oneFile, outList);
				}

			}

		}
	}

	public static void main(String[] args) {
		String fileName = "aa.txt";
		File scanFilePath = new File("E:\\tooldir");
		List<File> outList = new ArrayList<File>();
		
		new FileSearch().searchByFileName(fileName, scanFilePath, outList);
		

		for(int i =0;i<outList.size();i++)
		{
			System.out.println(outList.get(i).getAbsolutePath());
		}
	}

}
