package 蓝桥杯;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 焦祥宇
 * @version 创建时间：2017年3月3日 下午7:51:34
 * @description 问题描述 给定n个十六进制正整数，输出它们对应的八进制数。
 * 
 *              输入格式 输入的第一行为一个正整数n （1<=n<=10）。
 *              接下来n行，每行一个由0~9、大写字母A~F组成的字符串，表示要转换的十六进制正整数，每个十六进制数长度不超过100000。
 * 
 *              输出格式 输出n行，每行为输入对应的八进制正整数。
 * 
 *              【注意】 输入的十六进制数不会有前导0，比如012A。 输出的八进制数也不能有前导0。
 * 
 *              样例输入 2 39 123ABC
 * 
 *              样例输出 71 4435274
 * 
 *              【提示】 先将十六进制数转换成某进制数，再由某进制数转换成八进制。
 */
public class 十六进制转八进制 {
	/*
	 * 16进制转成2进制，再转8进制 16--》2 每个位上的数字都可以转化为4个位的2进制
	 * 每三个为上的2进制组合转化为8进制上的每个位上的数字，不够就补0
	 */

	/*public void convert16from2to8(String num16) {
		char[] chArr = num16.toCharArray();
		int tmp = 0;
		StringBuffer sbSum = new StringBuffer();
		for (int x = 0; x < chArr.length; x++) {
			switch (chArr[x]) {
			// 字符对应的整数
			case 'A':
			case 'B':
			case 'C':
			case 'D':
			case 'E':
			case 'F':
				tmp = chArr[x] - '0' - 7;
				break;
			default:
				tmp = chArr[x] - '0';
				break;

			}
			StringBuffer sb = new StringBuffer(); // 转化为二进制
			while (tmp >= 2) {
				sb.insert(0, tmp % 2);
				tmp /= 2;
			}
			sb.insert(0, tmp); //
			System.out.println(sb.length());
			int len = 4 - sb.length();
			// 假如直接写在for循环里面sb在变化，导致len会变化
			for (int y = 0; y < len; y++)
				sb.insert(0, 0); // System.out.println(sb.toString());
			sbSum.append(sb);
		}

		// System.out.println(sbSum.toString());
		StringBuffer sbSum8 = new StringBuffer();// 记录最终的结果
		int tmp8item = 0;
		// 每3个一组，不够尽兴高位补0，即最左边补0，采用421，
		// 或者用一个3做循环，进行划分区域，有1,就根据421的方式进行相加
		char[] chArr2 = sbSum.toString().toCharArray(); // 1001
		for (int z = chArr2.length - 1, num3 = 0; z >= 0; z--) {
			if (chArr2[z] - '0' == 1) {
				switch (num3) {
				case 0:
					tmp8item += 1;
					break;
				case 1:
					tmp8item += 2;
					break;
				case 2:
					tmp8item += 4;
					break;
				}
			}
			if ((num3 + 1) % 3 == 0) {
				sbSum8.insert(0, tmp8item);
				tmp8item = 0;
			}
			num3 = (num3 + 1) % 3;
		}
		if (sbSum8.substring(0, 1).equals("0"))// 输出的八进制数也不能有前导0的判断
			System.out.println(sbSum8.substring(1, sbSum8.length()));
		else
			System.out.println(sbSum8.toString());
	}
*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n > 0 && n <= 10) {
			List<String> list = new ArrayList<>();
			String str = null;
			for (int i = 0; i < n; i++) {
				str = sc.next();
				list.add(str);
			}
			十六进制转八进制 l = new 十六进制转八进制();
			for (String s : list) {
				l.tranform(s.toCharArray(), s.length());
			}
		}
	}


	/*
	 * 3位16进制等价于4位8进制
	 */
	int[] stack = new int[40000];

	public void tranform(char[] str, int length) {
		char[] buff = new char[4];
		int top = -1;
		for (int i = length - 1; i >= 0; i -= 3) {
			int sum = 0;
			for (int j = 0; j < 3 && i - j >= 0; j++) {// i-j>=0防止不够三个的情况
				int tmp = str[i - j] >= '0' && str[i - j] <= '9' ? str[i - j] - '0' : str[i - j] - 'A' + 10;// 区分是数字，还是字符，进行对应转换
				sum += (tmp << (4 * j));// 这句很重要，通过这句就可以从16变成10进制了，不过，不知道为什么？是如何得出的呢？
			}
			stack[++top] = sum;// sum的结果是16进制转化10进制的结果，每3个16进制变成10进制，再变8进制
		}
		while (stack[top] == 0) {// 排除前导为0的判断
			top--;
		}
		// for(int i=top;i>=0;i--){//直接输出会丢失前导0，因为此转化成8进制并不是最左边的情况，应该保留0
		// System.out.print(Integer.toOctalString(stack[i]));//从10进制转化成8进制
		// }
		for (int i = top; i >= 0; i--) {
			String str1 = Integer.toOctalString(stack[i]);// 从10进制转化成8进制
			if (i != top && str1.length() < 4) {
				// 不是最左边的一个，就不用去掉前导0,而默认是去掉0的，所以要进行补会
				for (int y = 0; y < 4 - str1.length(); y++)
					System.out.print("0");
			}
			System.out.print(str1);
		}
		System.out.println();

	}

}
