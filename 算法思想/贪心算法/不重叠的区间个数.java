package 贪心算法;

import java.util.Arrays;

/**
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals/
 *
 * 题目描述: 计算让一组区间不重叠所需要移除的区间个数。
 * 计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。
 * 在每次选择中，区间的结尾最为重要，选择的区间结尾越小，留给后面的区间的空间越大，那么后面能够选择的区间个数也就越大。
 * 按区间的结尾进行排序，每次选择结尾最小，并且和前一个区间不重叠的区间。
 *
 * 示例 1：
 *
 * 输入： intervals = [[1,2],[2,3],[3,4],[1,3]]
 * 输出： 1
 * 解释： [1,3] 可以被删除，其余的区间是非重叠。
 *
 * 示例 2：
 *
 * 输入： intervals = [[1,2],[1,2],[1,2]]
 * 输出： 2
 * 解释：您需要删除两个 [1,2] 以使其余的区间不重叠。
 *
 * 示例 3：
 *
 * 输入： intervals = [[1,2],[2,3]]
 * 输出： 0
 * 解释：您不需要删除任何间隔，因为它们已经不重叠。
 *
 * https://leetcode-cn.com/problems/non-overlapping-intervals/solution/java-si-lu-qing-xi-dai-ma-jian-ji-by-ven-1mkx/
 *
 * @Author jiaoxiangyu
 * @Date 2021/9/9
 */
public class 不重叠的区间个数 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        int ret=0;
        Arrays.sort(intervals, (o1, o2)-> o1[0]-o2[0]);
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end <= intervals[i][0]) {
                end = intervals[i][1];
            }else {
                ret++;
                end = Math.min(end, intervals[i][1]);
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        //int[][] arr={{1,2},{2,3},{3,4},{1,3}};
        int[][] arr={{1,2},{2,3}};
        //int[][] arr={{1,2},{1,2},{1,2}};
        System.out.println(eraseOverlapIntervals(arr));

    }

}
