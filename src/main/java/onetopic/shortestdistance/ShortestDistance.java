package onetopic.shortestdistance;

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
public class ShortestDistance {

	public int getRide(String filePath, String pointA, String pointB)
	{
		
		return 0;
	}
	
	public static void main(String[] args) {

	}

}
