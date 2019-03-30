package 蓝桥杯;

import java.util.Scanner;

/** 
* @author 焦祥宇 
* @version 创建时间：2017年3月2日 上午7:24:44 
* @description
* 问题描述
　　给定一个长度为n的数列，将这个数列按从小到大的顺序排列。1<=n<=200
输入格式
　　第一行为一个整数n。
　　第二行包含n个整数，为待排序的数，每个整数的绝对值小于10000。
输出格式
　　输出一行，按从小到大的顺序输出排序后的数列。
样例输入
5
8 3 6 4 9
样例输出
3 4 6 8 9  
*/
public class 顺序排序 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		int temp=0;
		for(int i=0;i<a.length;i++){
			for(int j=i+1;j<a.length;j++){
				if(a[i]>a[j]){
					temp=a[j];
					a[j]=a[i];
					a[i]=temp;
				}
			}
			System.out.print(a[i]+" ");
		}
	}
}
