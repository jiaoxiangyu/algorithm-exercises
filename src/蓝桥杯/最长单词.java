package 蓝桥杯;

import java.util.Scanner;

/** 
* @author 焦祥宇 
* @version 创建时间：2017年3月19日 上午9:44:50 
* @description
* 编写一个函数，输入一行字符，将此字符串中最长的单词输出。
　　输入仅一行，多个单词，每个单词间用一个空格隔开。单词仅由小写字母组成。所有单词的长度和不超过100000。如有多个最长单词，输出最先出现的。
样例输入
I am a student
样例输出
student
本地网址：http://lx.lanqiao.cn/problem.page?gpid=T181  
*/
public class 最长单词 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		System.out.println(str);
		int count=0, count1=0,flag=0,start=0,start1=0;
		for(int i=0;i<str.length();i++){
			if(i==0 && str.charAt(0)!=' '&& flag==0){
				flag=1;
				start1=0;
			}
			if(str.charAt(0)==' '&& flag==0){
				flag=1;
				start1=i+1;
			}
			if(flag==1&& str.charAt(i)!=' '){
				count1++;				
			}
			if(str.charAt(i)==' '&& flag==1){
				
				/*System.out.println("start="+start);
				System.out.println("count="+count);
				System.out.println("start1="+start1);
				System.out.println("count1="+count1);*/
				if(count1>count){
					start=start1;
					count=count1;
				}
				count1=0;
				start1=i+1;
				
			}
			
			
		}
		System.out.println(str.substring(start, start+count));
	}
}
