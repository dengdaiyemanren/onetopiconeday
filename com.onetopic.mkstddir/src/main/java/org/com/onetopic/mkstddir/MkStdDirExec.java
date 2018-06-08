package org.com.onetopic.mkstddir;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yinlg
 * 一.
 *需求
 *1.按照#号的格式,标记层次关系 ,层级#为顶级,依次增加，支持任意层次增加。
 *2.每个硬盘根目录下执行后建立目录,已经有的目录不会删除。
 *
 *二.
 *输入:txt文本的格式，内容类似于
 *# 编程 #
 *## java ##
 *输出:
 *建立目录
 *
 *三.
 *设计
 *1.读取文件内容，识别文件内容，解析
 *2.根据解析结果，从上到下建立目录
 * 
 *
 */
public class MkStdDirExec {

	Map<Integer, String> lineNoAndLine = new HashMap<Integer, String>();

	MenuInfo  menuInfo = new MenuInfo();
	

	
	/**
	 * 读取文件内容
	 * @param filePath
	 * @throws IOException
	 */
	public void readDirInfo(String filePath) throws IOException {
		
		File file = new File(filePath);
		BufferedReader in = new BufferedReader(new FileReader(file));

		try {
			Integer lineNo = new Integer(0);
			String lineStr = null;

			while ((lineStr = in.readLine()) != null) {
				if (lineStr.trim() == null || lineStr.trim().length() == 0) {
					continue;
				}
				lineNoAndLine.put(lineNo++, lineStr);
			}

		} finally {
			in.close();
			file = null;
		}

	}

	/**
	 * 
	 * MenuInfo数据结构
	 * 识别文件内容并解析,解析出来的结果为
	 * 一级目录->二级目录->三级目录
	 *        -> 二级目录
	 * 一级目录->二级目录
	 *         ->二级目录
	 *         ->二级目录->三级目录->四级目录
	 * 
	 * 
	 * @param fistIndex 开始行
	 * @param dot 分割符号 #
	 * @param firstDot 
	 */
	public void parseLines(Integer fistIndex,String dot,int level,MenuInfo parentMenu) {
		
		String line = lineNoAndLine.get(fistIndex++);
		
		if(null == line)
		{
			return;
		}
		
		
		//如果属于上一级，则记录为next,继续望下追溯
		if(null!=line&& line.contains(dot+"#"))
		{
			MenuInfo nextMenu = new MenuInfo();
			
			nextMenu.setLevel(level+1);
			nextMenu.setName(parseLineContent(dot+"#",line));
			nextMenu.setParent(parentMenu);
			
			parentMenu.addNext(nextMenu);
			
			dot = dot +"#";
			level = level + 1;
			
			parseLines(fistIndex,dot,level,nextMenu);
		}
		//如果属于同级,则加入同级的父亲结点下面,继续往下回溯
		else if(null!=line &&line.contains(dot) && parentMenu != null)
		{
			
			MenuInfo nextMenu = new MenuInfo();
			nextMenu.setLevel(level);
			nextMenu.setName(parseLineContent(dot,line));
			nextMenu.setParent(parentMenu.getParent());
			parentMenu.getParent().addNext(nextMenu);
			
		
			parseLines(fistIndex,dot,level,nextMenu);
		}
		//如果不属于上一级,也不属于同级，则查看属于哪一级别，向上回溯，加入其父节点下
		else
		{
			int size = (line.length() - line.replaceAll("#", "").length())/2;
			
			boolean notfindParent = true;
			while(parentMenu!= null  && null != parentMenu.getParent())
			{
				//如果找到父亲结点则加入
				if(size-1 ==parentMenu.getParent().getLevel())
				{
					
					MenuInfo nextMenu = new MenuInfo();
					nextMenu.setLevel(size);
					nextMenu.setName(parseLineContent(pow("#",size),line));
					nextMenu.setParent(parentMenu.getParent());
					parentMenu.getParent().addNext(nextMenu);
					
					
					dot = pow("#",size);
					level = size;
					
					parseLines(fistIndex,dot,level,nextMenu);
					
					notfindParent = false;
					break;
				}
				
				parentMenu = parentMenu.getParent();
			}
					
			//如果找不到父亲结点，直接加在根节点下
			if(notfindParent)
			{
				
				MenuInfo nextMenu = new MenuInfo();
				nextMenu.setLevel(size);
				nextMenu.setName(parseLineContent(pow("#",size),line));
				nextMenu.setParent(menuInfo);
	
				menuInfo.addNext(nextMenu);
				
				dot = pow("#",size);
				level = size ;
				
				parseLines(fistIndex,dot,level,nextMenu);
			}
			
		}
		
	}
	
	public String pow(String doc,int size)
	{
		StringBuilder result = new StringBuilder();
		while(size!=0)
		{
			result.append("#");
			size=size -1;
		}
		
		return result.toString();
	}
	
	public String parseLineContent(String dot,String line)
	{
		String [] lineContent = line.split(dot);
		
		return lineContent[1].trim();
	}


	public void mkdir(String rootPath,MenuInfo menuInfo) {
		
		List<MenuInfo> menuInfos = menuInfo.getNexts();
	
		for(int i = 0; i<menuInfos.size();i++)
		{
			MenuInfo oneMenu =  menuInfos.get(i);
			String path = rootPath+"\\"+oneMenu.getName()+"\\";
			
			
			File file = new File(path);
			
			file.mkdir();
			
			if(null != oneMenu.getNexts())
			{
				mkdir(path,oneMenu);
			}
	
		}

	}

	public static void main(String[] args) throws IOException {

		
		
		MkStdDirExec dirExec = new MkStdDirExec();
		String filePath = dirExec.getClass().getResource("/dirinfo/").getPath() + "dirstdinfo.txt";
		
		
		dirExec.readDirInfo(filePath);
		dirExec.parseLines(0, "#", 1, null);
		
		
		dirExec.mkdir("d:\\", dirExec.menuInfo);
	}

}
