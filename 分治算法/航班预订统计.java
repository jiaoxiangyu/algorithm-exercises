package 分治算法;

import java.util.Arrays;

/**
 * @ClassName: 航班预订统计
 * @Description: 这里有n个航班，它们分别从 1 到 n 进行编号。
 *
 * 有一份航班预订表bookings ，表中第i条预订记录bookings[i] = [firsti, lasti, seatsi]意味着在从 firsti到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi个座位。
 *
 * 请你返回一个长度为 n 的数组answer，其中 answer[i] 是航班 i 上预订的座位总数。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * 解释：
 * 航班编号        1   2   3   4   5
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       20  20
 * 预订记录 3 ：       25  25  25  25
 * 总座位数：      10  55  45  25  25
 * 因此，answer = [10,55,45,25,25]
 * 示例 2：
 *
 * 输入：bookings = [[1,2,10],[2,2,15]], n = 2
 * 输出：[10,25]
 * 解释：
 * 航班编号        1   2
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       15
 * 总座位数：      10  25
 * 因此，answer = [10,25]
 * 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/corporate-flight-bookings
 *
 * @Author jiaoxiangyu
 * @Date 2021/8/31
 * @Version 1.0
 * @Since JDK1.8
 */
public class 航班预订统计 {
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        if (n == 0 || bookings.length == 0) {
            return new int[0];
        }

        int[] result = new int[n];

        for (int i = 0; i < bookings.length; i++) {
            for (int j = bookings[i][0]; j <= bookings[i][1]; j++) {
                result[j - 1] += bookings[i][2];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr= {{1,2,10},{2,3,20},{2,5,25}};
        System.out.println(Arrays.toString(航班预订统计.corpFlightBookings(arr, 5)));
    }
}
