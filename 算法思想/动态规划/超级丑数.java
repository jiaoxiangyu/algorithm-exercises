import java.util.Arrays;

/**
 * @ClassName: 超级丑数
 * @Description: 
 * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 *
 * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 *
 * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 *
 *
 * 示例 1：
 *
 * 输入：n = 12, primes = [2,7,13,19]
 * 输出：32 
 * 解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 * 示例 2：
 *
 * 输入：n = 1, primes = [2,3,5]
 * 输出：1
 * 解释：1 不含质因数，因此它的所有质因数都在质数数组 primes = [2,3,5] 中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-ugly-number

 * @Author jiaoxiangyu
 * @Date 2021/8/9
 * @Version 1.0
 * @Since JDK1.8
 */
public class 超级丑数 {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int pLen = primes.length;
        int[] indexes = new int[pLen];

        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            // 因为选最小值，先假设一个最大值
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < pLen; j++) {
                dp[i] = Math.min(dp[i], dp[indexes[j]] * primes[j]);
            }

            // dp[i] 是之前的哪个丑数乘以对应的 primes[j] 选出来的，给它加 1
            for (int j = 0; j < pLen; j++) {
                if (dp[i] == dp[indexes[j]] * primes[j]) {
                    // 注意：这里不止执行一次，例如选出 14 的时候，2 和 7 对应的最小丑数下标都要加 1，大家可以打印 indexes 和 dp 的值加以验证
                    indexes[j]++;
                }
            }
            System.out.println(Arrays.toString(indexes));
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(超级丑数.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
    }
}
