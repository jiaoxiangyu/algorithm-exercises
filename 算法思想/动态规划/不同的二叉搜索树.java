/**
 * @ClassName: 不同的二叉搜索树
 * @Description:
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：5
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 *
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 *
 * @Author jiaoxiangyu
 * @Date 2021/8/12
 * @Version 1.0
 * @Since JDK1.8
 */
public class 不同的二叉搜索树 {
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[i - j] * dp[j - 1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(不同的二叉搜索树.numTrees(3));
    }
}
