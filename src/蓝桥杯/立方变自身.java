package 蓝桥杯;
/** 
* @author 焦祥宇 
* @version 创建时间：2017年3月5日 上午9:34:59 
* @description 
* 
立方变自身

观察下面的现象,某个数字的立方，按位累加仍然等于自身。
1^3 = 1 
8^3  = 512    5+1+2=8
17^3 = 4913   4+9+1+3=17
...

请你计算包括1,8,17在内，符合这个性质的正整数一共有多少个？

请填写该数字，不要填写任何多余的内容或说明性的文字。
 
*/
public class 立方变自身 {
	public static void main(String[] args) {
		int count =0;
		
		String str=null;
		for(int i=1;i<1000;i++){
			long sum=0;
			str=String.valueOf(i*i*i);
			for(int j=0;j<str.length();j++){
				sum=sum+Integer.valueOf(str.charAt(j)-'0');
				
			}
			if(i==sum){
				System.out.println(i+"**"+i*i*i+"**"+sum);
				count ++;
			}
		}
		System.out.println(count);
	}
}
