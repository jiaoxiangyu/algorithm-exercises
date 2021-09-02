package 分治算法;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: 多数元素
 * @Description: 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例1：
 *
 * 输入：[3,2,3]
 * 输出：3
 * 示例2：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * 
 * 进阶：
 *
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * @Author jiaoxiangyu
 * @Date 2021/8/23
 * @Version 1.0
 * @Since JDK1.8
 */
public class 多数元素 {

    //用哈希表来快速统计每个元素出现的次数。时间复杂度：O(n), 空间复杂度：O(n)
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer e = null;
        for (int n : nums) {
            e = map.get(n);
            if (e != null) {
                map.put(n, e++);
            } else {
                map.put(n, 1);
            }
        }

        for (int n : nums) {
            e = map.get(n);
            if (e >= n / 2) {
                return n;
            }
        }

        return 0;
    }

    //bit  时间复杂度：O(n), 空间复杂度：O(n)
    public static int majorityElement2(int[] nums) {

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(多数元素.majorityElement(nums));
    }
}
