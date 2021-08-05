/**
 * @ClassName: 强盗抢劫
 * @Description:
 * 题目描述: 抢劫一排住户，但是不能抢邻近的住户，求最大抢劫量。
 * 定义 dp 数组用来存储最大的抢劫量，其中 dp[i] 表示抢到第 i 个住户时的最大抢劫量。
 * 由于不能抢劫邻近住户，因此如果抢劫了第 i 个住户那么只能抢劫 i - 1 或者 i - 2 的住户
 *
 * dp[i]=max(dp[i-1], dp[i-2] + nums[i-1] )
 *
 * 例：[2,7,9,3,1] 12
 *
 * @link: https://leetcode-cn.com/problems/house-robber/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 * @Author jiaoxiangyu
 * @Date 2021/8/4
 * @Version 1.0
 * @Since JDK1.8
 */
public class 强盗抢劫 {
    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int[] dp = new int[len + 1];
        dp[0]=0;
        dp[1]=nums[0];
        for (int i = 2; i <=  len; i++) {
            dp[i]=Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }

        return dp[len];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};

        System.out.println(rob(nums));
    }
}
