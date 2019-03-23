package test;

import java.util.Scanner;
/**
 * 最佳调度问题
 */
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n , k;
		System.out.println("输入任务数量n：");
		n = sc.nextInt();
		System.out.println("输入完成任务的k值：");
		k = sc.nextInt();
		int t[] = new int[n];
		int T[] = new int[k];
		for(int i=0; i<n; i++){
			System.out.println("请输入第"+(i+1)+"个任务的时间：");
			t[i] = sc.nextInt();
		}
		for(int i=0; i<k; i++){
			T[i] = 0;
		}
		
		int temp;
		for(int i=0; i<n-1; i++){
			for(int j=0; j<n-1; j++){
				if(t[j]<t[j+1]){
					temp = t[j];
					t[j] = t[j+1];
					t[j+1] = temp;
				}
			}
		}
		for(int i=0; i<n; i++){
			T[findRationalPos(T,k)]+=t[i];
		}
		int pos = 0;
		if(k==0){
			System.out.println("没有执行任务的资源");
			return;
		}
		for(int i=0; i<k; i++){
			if(T[pos]<T[i])
				pos = i;
		}
		System.out.println("最快完成任务需要的时间为"+T[pos]);
	}
	
	/**
	 * 
	 */
	private static int findRationalPos(int[] T, int len) {
		int pos = 0;
		for(int i=0; i<len; i++){
			if(T[i]==0)
				return i;
			if(T[pos]>T[i])
				pos = i;
		}
		return pos;
	}
}
