/**
 * @ClassName: 丑数
 * @Description: 
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 *
 * 丑数 就是只包含质因数2、3 和5的正整数。
 *
 *
 * 示例 1：
 *
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 * 示例 2：
 *
 * 输入：n = 8
 * 输出：true
 * 解释：8 = 2 × 2 × 2
 * 示例 3：
 *
 * 输入：n = 14
 * 输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数7 。
 * 示例 4：
 *
 * 输入：n = 1
 * 输出：true
 * 解释：1 通常被视为丑数。
 * 
 *
 * 提示：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number
 *
 * @Author jiaoxiangyu
 * @Date 2021/8/11
 * @Version 1.0
 * @Since JDK1.8
 */
public class 丑数 {
    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        int[] base = {2, 3, 5};
        for (int e:base){
            while (n % e == 0) {
                n = n / e;
            }
        }

        return n==1;
    }

    public static void main(String[] args) {
        System.out.println(丑数.isUgly(6));
    }
}
