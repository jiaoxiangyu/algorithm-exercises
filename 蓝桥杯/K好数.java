/**        
 * @author: 焦祥宇 
 * @date:   createDate：2017年3月30日 下午3:43:25   
 * @Description:  
 * 题目：k好数
关键字：算法思想.动态规划
类型：普通试题
问题描述
如果一个自然数N的K进制表示中任意的相邻的两位都不是相邻的数字，那么我们就说这个数是K好数。求L位K进制数中K好数的数目。例如K = 4，L = 2的时候，所有K好数为11、13、20、22、30、31、33 共7个。由于这个数目很大，请你输出它对1000000007取模后的值。

输入格式
输入包含两个正整数，K和L。

输出格式
输出一个整数，表示答案对1000000007取模后的值。
样例输入
4 2
样例输出
7
数据规模与约定
对于30%的数据，KL <= 106；
对于50%的数据，K <= 16， L <= 10；
对于100%的数据，1 <= K,L <= 100。

 */
package 蓝桥杯;

import java.util.Scanner;

/**
 * 未完成
 *
 */
public class K好数 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int L = sc.nextInt();
		int count=0;
		
		for(int i=1;i<=L;i++){
			String str="";
			for(int j=0;j<K;j++){
				str=str+j;
				count=+getCount(str);
			}
		}
			
		System.out.println(count%1000000007);
	}
	public static int getCount(String str){
		return 1;
	}
}
