/**        
 * @author: 焦祥宇 
 * @date:   createDate：2017年3月27日 下午10:25:18   
 * @Description:  
 * 1到n最小公倍数公式
 */  
package 蓝桥杯;

import java.util.Scanner;


public class 最大最小公倍数 {
	public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in);  
        long n = sc.nextInt();  
          
        long result1 = n*(n-1)*(n-2);  
        long result2 = n*(n-1)*(n-3);  
        long result3 = (n-3)*(n-1)*(n-2);  
        if(n==1){System.out.println(1);}  
        else{  
            if(n==2){System.out.println(2);}  
            else{  
                if(n%2 != 0){  
                    System.out.println(result1);  
                }  
                else{  
                    if(n%3 != 0){  
                        System.out.println(result2);  
                    }else{  
                        System.out.println(result3);  
                    }  
                }  
            }  
        }  
    }  
}
