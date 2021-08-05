/**
 * @ClassName: 爬楼梯
 * @Description:
 *
 * 题目描述: 有 N 阶楼梯，每次可以上一阶或者两阶，求有多少种上楼梯的方法。
 * dp 存储上楼梯的方法数(为了方便讨论，数组下标从 1 开始)，dp[i] 表示走到第 i 个楼梯的方法数目。
 * 第 i 个楼梯可以从第 i-1 和 i-2 个楼梯再走一步到达，走到第 i 个楼梯的方法数为走到第 i-1 和第 i-2 个楼梯的方法数之和。
 *
 * dp[i]=dp[i-1]+dp[i-2]
 *
 * 考虑到 dp[i] 只与 dp[i - 1] 和 dp[i - 2] 有关，因此可以只用两个变量来存储 dp[i - 1] 和 dp[i - 2]，
 * 使得原来的 O(N) 空间复杂度优化为 O(1) 复杂度。
 *
 * @link https://leetcode.com/problems/climbing-stairs/description/
 * @Author jiaoxiangyu
 * @Date 2021/8/4
 * @Version 1.0
 * @Since JDK1.8
 */
public class 爬楼梯 {

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //用「滚动数组思想」把空间复杂度优化成 O(1)O(1)
    public int climbStairs3(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }


    public static void main(String[] args) {
        System.out.println(爬楼梯.climbStairs(4));
    }
}
