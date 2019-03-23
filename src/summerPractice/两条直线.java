/**        
 * @author: 焦祥宇 
 * @date:   createDate：2017年7月2日 下午9:25:26   
 * @Description:  
 * 问题描述
给定平面上n个点。

求两条直线，这两条直线互相垂直，而且它们与x轴的夹角为45度，并且n个点中离这两条直线的曼哈顿距离的最大值最小。

两点之间的曼哈顿距离定义为横坐标的差的绝对值与纵坐标的差的绝对值之和，一个点到两条直线的曼哈顿距离是指该点到两条直线上的所有点的曼哈顿距离中的最小值。

输入格式
第一行包含一个数n。

接下来n行，每行包含两个整数，表示n个点的坐标（横纵坐标的绝对值小于109）。

输出格式
输出一个值，表示最小的最大曼哈顿距离的值，保留一位小数。
样例输入
4
1 0
0 1
2 1
1 2
样例输出
1.0
数据规模与约定
对于30%的数据，n<=100。

对于另外30%的数据，坐标范的绝对值小于100。

对于100%的数据，n<=10的5次方。

 
 */  
package summerPractice;

import java.util.Scanner;

/**
 * @author Administrator
 *
 */
public class 两条直线 {
	//***未解决***
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int point[][] =new int[n][2];
		for(int i=0;i<n;i++){
			int x=sc.nextInt();
			int y=sc.nextInt();
			point[i][0]=x;
			point[i][1]=y;
		}
		double sum=0;
		double a,b,x,y;
		for(int i=0;i<n;i++){
			x=point[i][0];
			y=point[i][1];
			a=Math.abs((x-y)/(Math.sqrt(2)));
			b=Math.abs((x+y)/(Math.sqrt(2)));
			sum=sum+a+b;
		}
		System.out.println( String.format("%.1f",sum));		
	}
}
