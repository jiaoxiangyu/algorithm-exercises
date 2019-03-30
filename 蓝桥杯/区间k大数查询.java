/**        
 * @author: 焦祥宇 
 * @date:   createDate：2017年3月27日 下午9:38:46   
 * @Description:  
 * 题目：区间k大数查询 
关键字：排序 查找
类型：普通试题
问题描述
给定一个序列，每次询问序列中第l个数到第r个数中第K大的数是哪个。

输入格式
第一行包含一个数n，表示序列长度。
第二行包含n个正整数，表示给定的序列。
第三个包含一个正整数m，表示询问个数。
接下来m行，每行三个数l,r,K，表示询问序列从左往右第l个数到第r个数中，从大往小第K大的数是哪个。序列元素从1开始标号。

输出格式
总共输出m行，每行一个数，表示询问的答案。
样例输入
5
1 2 3 4 5
2
1 5 2
2 3 2
样例输出
4
2
数据规模与约定
对于30%的数据，n,m<=100；
对于100%的数据，n,m<=1000；
保证k<=(r-l+1)，序列中的数<=1000000。
 */  
package 蓝桥杯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 区间k大数查询 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] data =new int[n];
		for(int i=0;i<n;i++){
			data[i]=sc.nextInt();
		}
		/*System.out.println(Arrays.toString(data));*/
		int m=sc.nextInt();
		int[] out=new int[m];
		for(int i=0;i<m;i++){
			int l=sc.nextInt();
			int r=sc.nextInt();
			int k=sc.nextInt();
			List<Integer> list=new ArrayList<>();
			for(int j=l-1;j<=r-1;j++){
				list.add(data[j]);
			}
			Collections.reverse(list);
			out[i]=list.get(k-1);
		}
		for(int o:out)
			System.out.println(o);
	}
}
