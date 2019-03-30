package 蓝桥杯;

import java.util.Scanner;

/** 
* @author 焦祥宇 
* @version 创建时间：2017年3月4日 下午8:15:30 
* @description 
* 问题描述
　　FJ在沙盘上写了这样一些字符串：
　　A1 = “A”
　　A2 = “ABA”
　　A3 = “ABACABA”
　　A4 = “ABACABADABACABA”
　　… …
　　你能找出其中的规律并写所有的数列AN吗？
输入格式
　　仅有一个数：N ≤ 26。
输出格式
　　请输出相应的字符串AN，以一个换行符结束。输出中不得含有多余的空格或换行、回车符。
样例输入
3
样例输出
ABACABA 
*/
public class FJ字符串 {
	public static void main(String[] args) {
		/*char[] s=new char[26];
		for(int i=0;i<26;i++){
			s[i]=(char)('A'+i);
		}*/
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String str="";
		for(int i=0;i<n;i++){
			str=str+(char)('A'+i)+str;
		}
		System.out.println(str);
	}
}
