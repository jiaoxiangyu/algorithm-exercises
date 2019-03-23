package 蓝桥杯;

import java.util.Scanner;

/** 
* @author 焦祥宇 
* @version 创建时间：2017年3月20日 下午4:49:08 
* @description 
* http://lx.lanqiao.cn/problem.page?gpid=T26
问题描述
100 可以表示为带分数的形式：100 = 3 + 69258 / 714。

还可以表示为：100 = 82 + 3546 / 197。

注意特征：带分数中，数字1~9分别出现且只出现一次（不包含0）。

类似这样的带分数，100 有 11 种表示法。

输入格式
从标准输入读入一个正整数N (N<1000*1000)

输出格式
程序输出该数字用数码1~9不重复不遗漏地组成带分数表示的全部种数。

注意：不要求输出每个表示，只统计有多少表示法！

样例输入1
100
样例输出1
11
样例输入2
105
样例输出2
6
  
*/
public class 带分数 {
	static int n, result;  
	  
    public static void main(String[] args) {  
  
        Scanner sc = new Scanner(System.in);  
        n = sc.nextInt();  
        sc.close();  
          
        int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };  
        allsort(data, 0);  
        System.out.println(result);  
    }  
  
    private static int split(int[] data, int j, int k) {  
  
        int num = 0;  
        for (int i = j; i < k; i++) {  
            num = data[i] + num * 10;  
        }  
        return num;  
    }  
  
    public static void allsort(int[] data, int i) {  
  
        if (i == data.length) {  
  
            for (int j = 1; j < data.length; j++) {  
                for (int k = j + 1; k < data.length; k++) {  
                    int pre = split(data, 0, j);  
                    int mid = split(data, j, k);  
                    int fon = split(data, k, 9);  
                    if (mid % fon != 0)  
                        continue;  
                    if (pre + mid / fon == n)  
                        result++;  
                }  
            }  
            return;  
        }  
  
        for (int j = i; j < data.length; j++) {  
  
            int temp = data[j];  
            data[j] = data[i];  
            data[i] = temp;  
  
            allsort(data, i + 1);  
  
            temp = data[j];  
            data[j] = data[i];  
            data[i] = temp;  
        }  
    }  
}
