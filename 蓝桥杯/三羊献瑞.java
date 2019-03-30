package 蓝桥杯;
/** 
* @author 焦祥宇 
* @version 创建时间：2017年3月5日 上午10:07:51 
* @description 
* 三羊献瑞

观察下面的加法算式：

      祥 瑞 生 辉
  +   三 羊 献 瑞
-------------------
   三 羊 生 瑞 气

(如果有对齐问题，可以参看【图1.jpg】)

其中，相同的汉字代表相同的数字，不同的汉字代表不同的数字。

请你填写“三羊献瑞”所代表的4位数字（答案唯一），不要填写任何多余内容。
 
*/
public class 三羊献瑞 {
	public static void main(String[] args) {
		int sum=0;
		for(int a=0;a<=9;a++){
			for(int b=0;b<=9;b++){
				for(int c=0;c<=9;c++){
					for(int d=0;d<=9;d++){
						for(int e=0;e<=9;e++){
							for(int f=0;f<=9;f++){
								for(int g=0;g<=9;g++){
									for(int h=0;h<=9;h++){
										sum=(a+e)*1000+(b+f)*100+(c+g)*10+d+b;
										if(sum==(e*10000+f*1000+c*100+b*10+h) && a!=b && a!=c && a!=d && a!=e && a!=f && a!=g && a!=h 
												&& b!=c && b!=d && b!=e && b!=f && b!=g && b!=h 
												 && c!=d && c!=e && c!=f && c!=g && c!=h
												  && d!=e && d!=f && d!=g && d!=h
												   && e!=f && e!=g && e!=h
												    && f!=g && f!=h
												     && g!=h
												      && e!=0 && a!=0){
											System.out.println("e="+e+",f="+f+",g="+g+",b="+b);
											
										}
										
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
}
