package 蓝桥杯;
/** 
* @author 焦祥宇 
* @version 创建时间：2017年3月4日 下午9:03:10 
* @description
* 标题：分机号

X老板脾气古怪，他们公司的电话分机号都是3位数，老板规定，所有号码必须是降序排列，且不能有重复的数位。比如：

751,520,321 都满足要求，而，
766,918,201 就不符合要求。

现在请你计算一下，按照这样的规定，一共有多少个可用的3位分机号码？

请直接提交该数字，不要填写任何多余的内容。
  
*/
public class 电话分机号 {
	public static void main(String[] args) {
		int sum=0;
		for(int i=9;i>=0;i--){
			for(int j=i-1;j>=0;j--){
				for(int k=i-1;k>=0;k--){
					if(i>j&&i>k&&j>k){
						sum++;
					}
				}
			}
		}
		System.out.println(sum);
		/*优化后*/
		int i,j,k,c=0;  
	    for (i=9;i>1;i--)  
	    for (j=9;j>0;j--)  
	    for (k=9;k>=0;k--)  
	    {  
	        if (i>j&&i>k&&j>k)  
	        {  
	        c++;  
	        }  
	    }  	   		
		System.out.println(c);
	}
}
