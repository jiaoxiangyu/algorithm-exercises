package 蓝桥杯;

import java.util.Scanner;

/**
 * 
 * @author Administrator
 *韩信点兵
描述
相传韩信才智过人，从不直接清点自己军队的人数，只要让士兵先后以三人一排、五人一排、七人一排地变换队形，
而他每次只掠一眼队伍的排尾就知道总人数了。输入3个非负整数a,b,c ，表示每种队形排尾的人数（a<3,b<5,c<7），
输出总人数的最小值（或报告无解）。已知总人数不小于10，不超过100 。

输入
输入3个非负整数a,b,c ，表示每种队形排尾的人数（a<3,b<5,c<7）。例如,输入：2 4 5
输出
输出总人数的最小值（或报告无解，即输出No answer）。实例，输出：89

样例输入
2 1 6
样例输出
41
 */
public class 韩信点兵 {
	public static void functionOne(int a,int b,int c) {
		int n=7;
		while(n<=100) {
			if(n%3==a && n%5==b && n%7==c) {
				System.out.println(n);
				break;
			}
			n++;
		}
	}
	/*
	 *  
		三人同行七十稀, 
		五树梅花甘一枝, 
		七子团圆正半月, 
		除百零五便得知.
		
		用70乘以用3除的余数
		用21乘以用5除的余数
		用15乘以用7除的余数
		然后把这三个乘积相加
		加得的结果如果比105大,就除以105,所得的余数就是满足题目要求的最小正整数解.

		以测试数据 2 3 4 为例:
		70×2+21×3+15×4=263, 
		263=2×105+53,

	    70是5与7的最倍数,且用3除余1；
		21是3与7的倍数,且用5除余1；
		15是3与5的倍数,且用7除余1.
		
		
		70×2是5与7的倍数,用3除余2；
		21×3是3与7的倍数,用5除余3；
		15×4是3与5的倍数,用7除余4.
	 */
	public static void functionTwo(int a,int b,int c) {
		int n=70*a+21*b+15*c;
		if(n>105) {
			n=n%105;
		}
		System.out.println(n);
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		functionOne(a, b, c);
		functionTwo(a, b, c);
	}
}
