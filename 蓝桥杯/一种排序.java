package 蓝桥杯;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Administrator
 *描述
现在有很多长方形，每一个长方形都有一个编号，这个编号可以重复；还知道这个长方形的宽和长，编号、长、宽都是整数；现在要求按照一下方式排序（默认排序规则都是从小到大）；

1.按照编号从小到大排序

2.对于编号相等的长方形，按照长方形的长排序；

3.如果编号和长都相同，按照长方形的宽排序；

4.如果编号、长、宽都相同，就只保留一个长方形用于排序,删除多余的长方形；最后排好序按照指定格式显示所有的长方形；
输入
第一行有一个整数 0<n<10000,表示接下来有n组测试数据；
每一组第一行有一个整数 0<m<1000，表示有m个长方形；
接下来的m行，每一行有三个数 ，第一个数表示长方形的编号，

第二个和第三个数值大的表示长，数值小的表示宽，相等
说明这是一个正方形（数据约定长宽与编号都小于10000）；
输出
顺序输出每组数据的所有符合条件的长方形的 编号 长 宽
样例输入
1
8
1 1 1
1 1 1
1 1 2
1 2 1
1 2 2
2 1 1
2 1 2
2 2 1
样例输出
1 1 1
1 2 1
1 2 2
2 1 1
2 2 1
 */
//可自动排序的矩形类
class Rectangle implements Comparable<Rectangle>{

	private int no;
	private int length;
	private int width;
	
	public Rectangle() {
		super();
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public int compareTo(Rectangle o) {
		if(this.no!=o.no)
			return this.no-o.no;
		else if(this.length!=o.length)
			return this.length-o.length;
		else if(this.width!=o.width)
			return this.width-o.width;
		else 
			return 0;
	}

	@Override
	public String toString() {
		return "Rectangle [no=" + no + ", length=" + length + ", width=" + width + "]\r\n";
	}
	
	
}

public class 一种排序 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();//组数
		int m=sc.nextInt();
		List<Rectangle> list=new ArrayList<>();
		
		int len,wid;
		for(int i=1;i<=n*m;i++) {
			Rectangle r=new Rectangle();
			r.setNo(sc.nextInt());
			len=sc.nextInt();
			wid=sc.nextInt();
			if(len>=wid) {
				r.setLength(len);
				r.setWidth(wid);
			}else {
				r.setLength(wid);
				r.setWidth(len);
			}
			list.add(r);
		}
		Collections.sort(list);
		//System.out.println(Arrays.toString(list.toArray()));
		for(int i=list.size()-1;i>0;i--) {
			if(list.get(i).compareTo(list.get(i-1))==0) {
				list.remove(list.get(i));
			}
		}
		for(Rectangle o:list) {
			System.out.println(o.getNo()+" "+o.getLength()+" "+o.getWidth());
		}
		
	}
}
