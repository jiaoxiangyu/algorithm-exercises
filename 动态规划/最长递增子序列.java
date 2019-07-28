import java.util.Arrays;

/**
 * 题目描述
 * 给定一个长度为n的整数序列S，求这个序列中最长的严格递增子序列的长度。
 *
 * 输入
 * 4 0 5 8 7 8
 * 输出
 * 4
 *
 * 样例解释 子序列为 0 5 7 8
 */
public class 最长递增子序列 {

    /**
     * 方法1
     * 动态规划，时间复杂度O(n^2)，空间复杂度1
     * @param str
     */
    public static void maxStrNum1(String str){
        //处理数据
        int len = str.length();
        int[] dp=new int[len];
        for (int i = 0; i < len; i++) {
            dp[i]=1;
            for (int j = 0;j < i; j++) {
                if (str.charAt(i) > str.charAt(j)) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));

        //获得最大序列长度和下标
        int maxLen=0;
        int index=0;
        for (int i = 0; i < len; i++) {
            if (dp[i] > maxLen) {
                maxLen=dp[i];
                index = i;
            }
        }
        System.out.println(maxLen+","+index);

        //获得最大序列
        int[] maxStrs = new int[maxLen];
        maxStrs[--maxLen] = Integer.valueOf(String.valueOf(str.charAt(index)));
        for (int i = index; i >= 0; i--) {
            if (str.charAt(i) < str.charAt(index) && dp[i] == dp[index] - 1) {
                maxStrs[--maxLen] = Integer.valueOf(String.valueOf(str.charAt(i)));
                index=i;
            }
        }

        System.out.println(Arrays.toString(maxStrs));
    }

    public static void main(String[] args) {
        maxStrNum1("215364897");
    }
}
