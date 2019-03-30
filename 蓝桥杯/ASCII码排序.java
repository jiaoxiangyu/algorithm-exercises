package 蓝桥杯;


import java.util.Scanner;

/**
 * 
 * @author Administrator
 *ASCII码排序
描述
输入三个字符（可以重复）后，按各字符的ASCII码从小到大的顺序输出这三个字符。
输入
第一行输入一个数N,表示有N组测试数据。后面的N行输入多组数据，每组输入数据都是占一行，有三个字符组成，之间无空格。
输出
对于每组输入数据，输出一行，字符中间用一个空格分开。
样例输入
2
qwe
asd
样例输出
e q w
a d s
 */

public class ASCII码排序 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		char[][] c=new char[n][3];
		String str="";
		for(int i=0;i<n;i++) {
			str=sc.nextLine();
			for(int j=0;j<3;j++) {
				c[i][j]=str.charAt(j);
			}
		}
		
		char temp=' ';
		for(int i=0;i<n;i++) {
			for(int j=0;j<3;j++) {
				for(int k=0;k<3;k++) {
					if(c[i][j]<c[i][k]) {
						temp=c[i][j];
						c[i][j]=c[i][k];
						c[i][k]=temp;						
					}
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			
			System.out.print(c[i][0]+" "+c[i][1]+" "+c[i][2]);			
			System.out.println();
		}
	}
}
