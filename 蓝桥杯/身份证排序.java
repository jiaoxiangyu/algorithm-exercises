package 蓝桥杯;

import java.util.Scanner;

/** 
* @author 焦祥宇 
* @version 创建时间：2017年3月10日 下午5:37:39 
* @description  
* 问题描述
　　安全局搜索到了一批(n个)身份证号码，希望按出生日期对它们进行从大到小排序，如果有相同日期，则按身份证号码大小进行排序。身份证号码为18位的数字组成，出生日期为第7到第14位
输入格式
　　第一行一个整数n，表示有n个身份证号码
　　余下的n行，每行一个身份证号码。
输出格式
　　按出生日期从大到小排序后的身份证号，每行一条
样例输入
5
466272307503271156
215856472207097978
234804580401078365
404475727700034980
710351408803093165
样例输出
404475727700034980
234804580401078365
215856472207097978
710351408803093165
466272307503271156
数据规模和约定
　　n<=100000
http://lx.lanqiao.cn/problem.page?gpid=T326
*/
public class 身份证排序 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String[] strs=new String[n];
		for(int i=0;i<n;i++){
			strs[i]=sc.next();
		}
		strs=new 身份证排序().quickSort(strs,n);
		for(int i=strs.length-1;i>=0;i--){
			System.out.println(strs[i]);
		}
	}
	//快速排序
	public String[] quickSort(String[] arrays,int length){		
		quickSort(arrays, 0, length-1);
		return arrays;
	}
	public String[] quickSort(String[] arrays,int start,int end){
		if(start>=end){
            return arrays;
        }
		int i=start;
		int j=end;
		String value=arrays[i];
		boolean flag=true;
		while(i!=j){
			if(flag){				
				if(Long.valueOf(value.substring(6, 14))>Long.valueOf(arrays[j].substring(6, 14))){					
					chanage(arrays, i, j);
					flag=false;
				}else{
					j--;
				}
			}else{
				if(Long.valueOf(value.substring(6, 14))<Long.valueOf(arrays[i].substring(6, 14))){					
					chanage(arrays, i, j);
					flag=true;
				}else{
					i++;
				}
			}
		}
		arrays=quickSort(arrays,start,j-1);
		arrays=quickSort(arrays,i+1,end);
		return arrays;
	}
	
	public String[] chanage(String[] arrays,int i,int j){
		String temp=arrays[i];
		arrays[i]=arrays[j];
		arrays[j]=temp;
		return arrays;
	}
	
	
    /**
     * 方法二
     * */
	public void quick_sort(int[] arrays, int lenght) {
        if (null == arrays || lenght < 1) {
            System.out.println("input error!");
            return;
        }
        _quick_sort(arrays, 0, lenght - 1);
    }

    public void _quick_sort(int[] arrays, int start, int end) {
        if(start>=end){
            return;
        }
        
        int i = start;
        int j = end;
        int value = arrays[i];
        boolean flag = true;
        while (i != j) {
            if (flag) {
                if (value > arrays[j]) {
                    swap(arrays, i, j);
                    flag=false;

                } else {
                    j--;
                }
            }else{
                if(value<arrays[i]){
                    swap(arrays, i, j);
                    flag=true;
                }else{
                    i++;
                }
            }
        }
        snp(arrays);
        _quick_sort(arrays, start, j-1);
        _quick_sort(arrays, i+1, end);
        
    }

    public void snp(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i] + " ");
        }
        System.out.println();
    }

    private void swap(int[] arrays, int i, int j) {
        int temp;
        temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }
}
