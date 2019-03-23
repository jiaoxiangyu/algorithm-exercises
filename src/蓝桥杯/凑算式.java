package 蓝桥杯;
/*凑算式

	 B      DEF
A + --- + ------- = 10
	 C      GHI

（如果显示有问题，可以参见【图1.jpg】）


这个算式中A~I代表1~9的数字，不同的字母代表不同的数字。

比如：
6+8/3+952/714 就是一种解法，
5+3/1+972/486 是另一种解法。
这个算式一共有多少种解法？

注意：你提交应该是个整数，不要填写任何多余的内容或说明性文字。

*/
public class 凑算式 {
	public static void main(String[] args) {
		int count=0;
		for(int a=1;a<=9;a++){
			for(int b=1;b<=9;b++){
				for(int c=1;c<=9;c++){
					for(int d=1;d<=9;d++){					
						for(int e=1;e<=9;e++){
							for(int f=1;f<=9;f++){
								for(int g=1;g<=9;g++){
									for(int h=1;h<=9;h++){
										for(int i=1;i<=9;i++){
											if((a+b/(c*1.0)+(d*100+e*10+f)/((g*100+h*10+i)*1.0))==10&&a!=b&&a!=c&&a!=d&&a!=e&&a!=f&&a!=g&&a!=h&&a!=i&&  
													b!=c&&b!=d&&b!=e&&b!=f&&b!=g&&b!=h&&b!=i&&  
													c!=d&&c!=e&&c!=f&&c!=g&&c!=h&&c!=i&&  
													d!=e&&d!=f&&d!=g&&d!=h&&d!=i&&  
													e!=f&&e!=g&&e!=h&&e!=i&&  
													f!=g&&f!=h&&f!=i&&  
													g!=h&&g!=i&&i!=h){
												count++;
												System.out.println(a+"*"+b+"*"+c+"*"+d+"*"+e+"*"+f+"*"+g+"*"+h+"*"+i);
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
		System.out.println(count);
	}	
}
