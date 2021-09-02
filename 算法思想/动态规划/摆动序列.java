package 算法思想.动态规划;

/**
 问题描述：
 　　如果一个序列满足下面的性质，我们就将它称为摆动序列：
 　　1. 序列中的所有数都是不大于k的正整数；
 　　2. 序列中至少有两个数。
 　　3. 序列中的数两两不相等；
 　　4. 如果第i – 1个数比第i – 2个数大，则第i个数比第i – 2个数小；如果第i – 1个数比第i – 2个数小，则第i个数比第i – 2个数大。
 　　比如，当k = 3时，有下面几个这样的序列：
 　　1 2
 　　1 3
 　　2 1
 　　2 1 3
 　　2 3
 　　2 3 1
 　　3 1
 　　3 2
 　　一共有8种，给定k，请求出满足上面要求的序列的个数。
 输入格式
 　　输入包含了一个整数k。（k<=20）
 输出格式
 　　输出一个整数，表示满足要求的序列个数。
 样例输入
 3
 样例输出
 8

 分析：

 */
public class 摆动序列 {
    private static int[] a = new int[100];
    private static int[] c = new int[100];
    private static int n,ans;//序列个数

    public static int fun(int num, int k)
    {
        if (k == 1 || k == 2)return 1;//边界条件
        if (c[k - 1]>c[k - 2] && num<c[k - 2]) return 1;
        if (c[k - 1]<c[k - 2] && num>c[k - 2]) return 1;
        return 0;
    }

    //深度优先遍历
    public static void dfs(int x) { //x是记录c数组下标
        if (x > n) { //越界
            return;
        }
        for (int i = 1; i <= n; i++)
        {
            if (a[i] == 0 && fun(i, x) > 0) {//满足条件（没有使用过且满足摆动条件）
                a[i] = 1;//标记为已经用过
                c[x] = i;//记录序列
                if (x >= 2) {
                    ans++; //4个条件都满足，序列的个数加一
                }
                dfs(x + 1);//继续向下寻找
                a[i] = 0;//取消标记
            }
        }

    }

    public static void main(String[] args) {
        n = 3;
        ans = 0;
        dfs(1);
        System.out.println(ans);
    }


}
