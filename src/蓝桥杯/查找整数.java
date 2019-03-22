package 蓝桥杯;

import java.util.Scanner;

/** 
* @author 焦祥宇 
* @version 创建时间：2017年3月2日 下午5:47:08 
* @description  
* 问题描述
给出一个包含n个整数的数列，问整数a在数列中的第一次出现是第几个。

输入格式
第一行包含一个整数n。

第二行包含n个非负整数，为给定的数列，数列中的每个数都不大于10000。

第三行包含一个整数a，为待查找的数。

输出格式
如果a在数列中出现了，输出它第一次出现的位置(位置从1开始编号)，否则输出-1。
样例输入
6
1 9 4 8 3 9
9
样例输出
2
数据规模与约定
1 <= n <= 1000。

本题网址：http://lx.lanqiao.cn/problem.page?gpid=T9
*/
public class 查找整数 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		if(n>0&&n<=1000){
			for(int i=0;i<a.length;i++){
				a[i]=sc.nextInt();
			}
		}
		int m=sc.nextInt();
		int tag=0;
		for(int i=0;i<a.length;i++){
			if(m==a[i]){
				tag=1;
				System.out.println(i+1);
				break;
			}				
		}
		if(tag==0){
			System.out.println(-1);
		}
		
	}
}
