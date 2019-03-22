package 蓝桥杯;

import java.util.Scanner;

/** 
* @author 焦祥宇 
* @version 创建时间：2017年2月28日 下午10:37:44 
* @description  问题描述
Fibonacci数列的递推公式为：Fn=Fn-1+Fn-2，其中F1=F2=1。

当n比较大时，Fn也非常大，现在我们想知道，Fn除以10007的余数是多少。

输入格式
输入包含一个整数n。
输出格式
输出一行，包含一个整数，表示Fn除以10007的余数。
说明：在本题中，答案是要求Fn除以10007的余数，因此我们只要能算出这个余数即可，
而不需要先计算出Fn的准确值，再将计算的结果除以10007取余数，直接计算余数往往比先算出原数再取余简单。

样例输入
10
样例输出
55
样例输入
22
样例输出
7704
数据规模与约定
1 <= n <= 1,000,000。



本题网址：http://lx.lanqiao.cn/problem.page?gpid=T4
*/
public class Fibonacci数列 {
	long F(long n){
		long sum=0;
		if(n==1){
			sum=1;
		}else if(n==2){
			sum=1;
		}else{
			sum=(F(n-1)+F(n-2))%10007;
		}
		
		return sum;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[] F=new int[1000000];
		F[1]=F[2]=1;
		for(int i=3;i<=n;i++){
			F[i]=(F[i-1]+F[i-2])%1007;
		}
		System.out.println(F[n]);
	}
}
