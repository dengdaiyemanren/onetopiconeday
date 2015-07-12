package onetopic.shortestdistance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 	说明：公交线路乘车方案查询。
 * 给定N条公交线路，线路中包括站点名称。
 * 请实现查询任意两个站的乘车方案。 
 * 按线路最短，即所经过站点最少。 
 * 编程要求 请编写程序分析busline.txt，该文件包括线路信息。
 * 格式如下。站点名称以空格分割，名称相同为可换乘站点。
 * 每行表示一条线路。 A B C D E C F G H I 
 * 实现查询方法， 
 * 1.getRide: 输入两个地点，查找两点之间的最短线路。返回乘车所需最少站点个数（包括起始、到达两个站点本身。例如A－C，返回3）。
 * 2.换乘算两个站(例如A-F，返回5)。换乘只考虑一次，不考虑多次换乘。 3.没有乘车方案、异常返回-1； 4.反方向不算异常。即可以C-A，返回
 * 3 public int getRide(String filePath, String pointA, String pointB)
 * @author hp
 *
 */

/**
 *參考實現1、
根据 公 交 线路的实际，可以认为两次之内的转车是比较合理的，超过两次的转车是无
意义的，不予考虑。笔者提出公交转车最短路径算法的步骤，如下所示。
(1)输 入 乘车始点A、终点B
(2)求 经 过A或其附近的线路 s(I)(I=1,2 ,⋯,。)(m为正整数)，及经过B或
其附近的线路t (J) (J=1, 2,⋯,n) (n为正整数)。
(3) 有 s (I) =t(J)吗?
若有 ， 满 足此条件的线路s(I)也即t(J)为A到B的直达车线路，输出结果，结束
运算。
若没 有 ， 往下执行。

(4) 求 线 路s(I)的站点E(I,U)(U=l,2 .⋯,P,P 为正整数)，及线路t(J)的
站点F(J, V) (V=1, 2,⋯，9, 9为正整数)。
(5)有 E(I,U)= F (J,V)吗?
若有 ,满 足此条件的线路:(I),t(J)(可能不止一种)即为一次转车的线路，
计算各种一次转车方法的乘车路程，乘车路程最短转车线路，再求转车地点，输出结果，结束运算
 * @author yinlg
 */
public class ShortestDistance {
	
	 static Map<String,List<String>> linesMap = new HashMap();
	 static List<String> lineOne = new ArrayList();
	 static List<String> lineTwo = new ArrayList();
	 static
	 {
		 lineOne.add("A"); 
		 lineOne.add("B"); 
		 lineOne.add("C"); 
		 lineOne.add("D"); 
		 lineOne.add("E"); 
		 lineOne.add("H"); 
		 
		 lineTwo.add("C"); 
		 lineTwo.add("E"); 
		 lineTwo.add("D"); 
		 lineTwo.add("G"); 
		 lineTwo.add("H"); 
		 lineTwo.add("M"); 
		 
		 linesMap.put("1", lineOne);
		 linesMap.put("2", lineTwo);
		 
	 }
	 
	int getRide(String pointA, String pointB)
	{
		Map<String,List<String>> onceMap = new HashMap();
		
		//1、求得直达线路
		for(Entry entry:linesMap.entrySet())
		{
			String key = (String) entry.getKey();
			List<String> list = (List<String>) entry.getValue();
			
			if(list.contains(pointA)&&list.contains(pointB))
			{
				if(list.indexOf(pointA)<list.indexOf(pointB))
				{
					onceMap.put(key, list.subList(list.indexOf(pointA), list.indexOf(pointB)));
				}
				else
				{
					List subList = list.subList(list.indexOf(pointA), list.indexOf(pointB));
					Collections.reverse(subList);
					onceMap.put(key,subList);
				}
			}
		}
		
		
		Map<String,List<String>> twiceMap = new HashMap();
		
		//2、求得专车一次线路
		for(Entry entryA:linesMap.entrySet())
		{
			String keyA = (String) entryA.getKey();
			List<String> keyAList = (List<String>) entryA.getValue();
			
			if(!keyAList.contains(pointA))
			{
				continue;
			}
			
			for(Entry entryB:linesMap.entrySet())
			{
				String keyB = (String) entryB.getKey();
				
				if(keyA.equals(keyB))
				{
					continue;
				}
				
				List<String> keyBList = (List<String>) entryB.getValue();
				
				if(!keyBList.contains(pointB))
				{
					continue;
				}
				
				
				for(String point : keyBList)
				{
					if(keyBList.contains(point))
					{
						List<String> subAList = new ArrayList();
						
						if(keyAList.indexOf(pointA)<keyAList.indexOf(point))
						{
							
							if(keyBList.indexOf(point)<keyBList.indexOf(pointB))
							{
								subAList.addAll(keyAList.subList(keyAList.indexOf(pointA),keyAList.indexOf(point)));
								subAList.addAll(keyAList.subList(keyBList.indexOf(point),keyAList.indexOf(pointB)));
								
							}
							else
							{
								subAList.addAll(keyAList.subList(keyAList.indexOf(pointA),keyAList.indexOf(point)));
								subAList.addAll(keyAList.subList(keyBList.indexOf(pointB),keyAList.indexOf(point)));
							}
							twiceMap.put(keyA+"->"+keyB,subAList);
						}
						else
						{
							if(keyBList.indexOf(point)<keyBList.indexOf(pointB))
							{
								subAList.addAll(keyAList.subList(keyAList.indexOf(point),keyAList.indexOf(pointA)));
								subAList.addAll(keyAList.subList(keyBList.indexOf(point),keyAList.indexOf(pointB)));
								
							}
							else
							{
								subAList.addAll(keyAList.subList(keyAList.indexOf(point),keyAList.indexOf(pointA)));
								subAList.addAll(keyAList.subList(keyBList.indexOf(pointB),keyAList.indexOf(point)));
							}
							twiceMap.put(keyA+"->"+keyB,subAList);
						}
					}
				}
				
			}
		}
		
		//3、得出最优线路
		
		Map<String,Integer> resultMap = new HashMap();
		
		//Collections.min(arg0, arg1);
		for(Entry result:onceMap.entrySet())
		{
			resultMap.put((String) result.getKey(), ((List)result.getValue()).size());
			
			System.out.println((String)result.getKey()+"|"+((List)result.getValue()).size());
		}
		for(Entry result:twiceMap.entrySet())
		{
			resultMap.put((String) result.getKey(), ((List)result.getValue()).size());
			System.out.println((String)result.getKey()+"|"+((List)result.getValue()).size());
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		
		new ShortestDistance().getRide("B", "C");

	}

}
