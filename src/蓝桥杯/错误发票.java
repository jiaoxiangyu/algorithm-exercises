/**        
 * @author: 焦祥宇 
 * @date:   createDate：2017年3月25日 下午4:29:24   
 * @Description:  
 * 
 */  
package 蓝桥杯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 错误发票 {
	 public static void main(String args[]) { 
		 Scanner sc=new Scanner(System.in);
		 int n=sc.nextInt();		 
		 String[] s=new String[n];
		 String[][] ss=new String[n][];
		 sc.nextLine();
		 for(int i=0;i<n;i++){
			 s[i]=sc.nextLine();			
			 ss[i]=s[i].split(" ");			 
		 }		
		 List<Integer> list=new ArrayList<>();
		 for(int i=0;i<n;i++){
			 for(int j=0;j<ss[i].length;j++){
				 list.add(Integer.valueOf(ss[i][j]));
			 }
		 }
		 Collections.sort(list);
		 int dh=-1,cf=-1,temp;
		 for(int i=0;i<list.size()-1;i++){
			 if(list.get(i)==list.get(i+1)){				 
				 cf=list.get(i);
				 list.remove(i);
				 break;
			 }
		 }
		 for(int i=0;i<list.size()-1;i++){
			 if(list.get(i)+1!=list.get(i+1)){
				 dh=list.get(i)+1;				 
			 }
		 }
		 System.out.println(dh+" "+cf);
		 
	 }	        
}
