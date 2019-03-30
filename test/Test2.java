package test;

import java.util.Scanner;

public class Test2 {
	public static int n=0,k=0,best=66666;  //n任务量、k可并行工作的机器数量、best最佳作业调度完成时间
	public static int[] len=null;//存储一组空间解  
	public static int[] t=null;//任务所需时间  2 14 4 16 6 5 3 
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//输入n和k的值
		System.out.println("输入任务数量n：");
		n = sc.nextInt();
		System.out.println("输入完成任务的k值：");
		k = sc.nextInt();
		
		//初始化len和t数组
		len = new int[k];
		t = new int[n];
		System.out.println("请输入"+n+"个任务所需时间：");
		for(int i=0; i<n; i++){			
			t[i] = sc.nextInt();
		}
		
	    search(0,len,t);  
	    System.out.println("最快完成任务需要的时间为:"+best);  
	    
	}
	
	//计算一个完整调度的完成时间 
	public static int comp(){  
	    int tmp=0;  
	    for(int i=0; i<k; i++)  
	        if(len[i]>tmp)  
	            tmp=len[i];  
	    return tmp;  
	}  
	
	//搜索
	public static void search(int dep,int[] len,int[] t){  
	    if(dep==n) {  
	        int tmp=comp();  
	        if(tmp<best)  
	            best=tmp;  
	        return;  
	    }  
	    for(int i=0; i<k; i++) {  
	        len[i]+=t[dep];  
	        if(len[i]<best)  
	            search(dep+1,len,t);  
	        len[i]-=t[dep];  
	    }  
	}  
	
}
