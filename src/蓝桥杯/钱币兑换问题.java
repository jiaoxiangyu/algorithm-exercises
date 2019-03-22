package 蓝桥杯;

import java.util.Scanner;

/*
 * 钱币兑换问题
在一个国家仅有1分，2分，3分硬币，将钱N兑换成硬币有很多种兑法。请你编程序计算出共有多少种兑法。 
Input 每行只有一个正整数N，N小于32768。 
Output 对应每个输入，输出兑换方法数。
 
Sample Input
2934
12553

Sample Output
718831
13137761

 */
public class 钱币兑换问题 {
	/*
	 * 思路：n分钱分成零钱符合x1+2*x2+3*x3的公式，随着x1,x2,x3取不同值就有不同的分法。

那么，先确定x3的值就可以确定x1与x2的值，确定x2的值那x1的值一定是定值，不需要求。

所以，先定x3的值，假设x3=k，那么x1+2*x2=n-3*k，重点来了，此时只要知道x2的取值范围就可以

得到当x3等于k时有多少种分法了。x2的范围并不难求，假设没有x1，那么2*x2<=n-3*k，则0<=x2<=(n-3*k)/2，

即x2一共有(n-3*k)/2+1种可能，也就是当k3取某个值时一共有(n-3*k)/2+1种分法。

所以，将k3的所有值(k3*3<=n)取完，每取一次值就加一次(n-3*k)/2+1，最终得到分n分钱所有的可能性！
	 */
	public static void functionOne(int n) {
		int sum=0;
		for(int i=0;i<=n/3;i++) {
			sum+=(n-i*3)/2+1;
		}
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		functionOne(n);
	}
}
