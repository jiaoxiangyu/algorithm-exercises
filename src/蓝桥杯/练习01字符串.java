package 蓝桥杯;
/** 
* @author 焦祥宇 
* @version 创建时间：2017年3月2日 下午6:06:47 
* @description  
* 问题描述
对于长度为5位的一个01串，每一位都可能是0或1，一共有32种可能。它们的前几个是：

00000

00001

00010

00011

00100

请按从小到大的顺序输出这32种01串。

输入格式
本试题没有输入。
输出格式
输出32行，按从小到大的顺序每行一个长度为5的01串。
样例输出
00000
00001
00010
00011
<以下部分省略>

本题地址：http://lx.lanqiao.cn/problem.page?gpid=T6
*/
public class 练习01字符串 {
	public static void main(String[] args) {
		for(int i=0;i<32;i++){
			System.out.println(String.format("%05d", Integer.valueOf(Integer.toBinaryString(i))));
		}
	}
}
