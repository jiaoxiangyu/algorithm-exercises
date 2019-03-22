package 蓝桥杯;

import java.util.Scanner;

/** 
* @author 焦祥宇 
* @version 创建时间：2017年3月10日 下午5:26:37 
* @description
*问题描述
　　见计算机程序设计基础（乔林）P50第5题。
　　接受两个数，一个是用户一年期定期存款金额，一个是按照百分比格式表示的利率，计算一年期满后的本金与利息总额。说明：(1) 存款金额以人民币元为单位，精确到分；(2) 输入利率时不输入百分号，例如利率为3.87%，用户直接输入3.87；(3) 按照国家法律，存储利息所得需缴纳5%的所得税，计算结果时应当扣除所得税。(4) 显示的结果精确到人民币分。
　　注意：数据须用float表示；计算结果须保存到一个float变量中，再用printf输出。
输入格式
　　一行，以一个空格隔开的两个浮点数。
输出格式
　　一个浮点数。
样例输入
5000.00 5.00
样例输出
5237.50
数据规模和约定
　　输入数据中每一个数的范围。本金<100000000，利息<100
http://lx.lanqiao.cn/problem.page?gpid=T386   
*/
public class 求存款 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		float n=sc.nextFloat();
		float a=sc.nextFloat();
		float sum=(float) (n*(1+a/100.0)-n*(a/100.0)*0.05);
		System.out.println(String.format("%.2f", sum));
		
	}
}
