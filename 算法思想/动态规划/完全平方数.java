package 动态规划;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定正整数n，找到若干个完全平方数（比如1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * 题解：
 * 首先初始化长度为 n+1 的数组 dp，每个位置都为 0
 * 如果 n 为 0，则结果为 0
 * 对数组进行遍历，下标为 i，每次都将当前数字先更新为最大的结果，即 dp[i]=i，比如 i=4，最坏结果为 4=1+1+1+1 即为 4 个数字
 * 动态转移方程为：dp[i] = MIN(dp[i], dp[i - j * j] + 1)，i 表示当前数字，j*j 表示平方数
 * 时间复杂度：O(n*sqrt(n))，sqrt 为平方根
 *
 * 示例1：
 *
 * 输入：n = 12
 * 输出：3 
 * 解释：12 = 4 + 4 + 4
 *
 *
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 *
 * @author jiaoxiangyu
 * @date 2021/9/30
 */
public class 完全平方数 {


    /**
     * 动态规划
     * @param n
     * @return  int
     */
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;// 最坏的情况就是每次+1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
