package 排序;

import java.util.Arrays;

/** 
* @author 焦祥宇 
* @version 创建时间：2017年3月20日 下午8:22:00 
* @description  
*/
public class 全排 {

	 public static void main(String[] args) {
	        char[] s = {'a','b','c'};//,'d','e','f','g'
	        sort(s, 0);
	    }
	    static void sort(char[] s,int start){
	    	char temp;
	    	if(s.length==start){
	    		System.out.println(Arrays.toString(s));
	    	}else{
	    		for(int i=start;i<s.length;i++){
	    			temp=s[i];
	    			/*System.out.println("start"+Arrays.toString(s));*/
	    			s[i]=s[start];
	    			s[start]=temp;
	    			
	    			sort(s,start+1);
	    			
	    			temp=s[i];
	    			s[i]=s[start];
	    			s[start]=temp;
	    			/*System.out.println("end"+Arrays.toString(s));*/
	    		}
	    	}
	    }
}
