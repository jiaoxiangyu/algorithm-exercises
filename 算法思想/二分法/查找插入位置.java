package 二分法;

/**
 * 给定一个排序的整数数组 nums和一个整数目标值 target ，请在数组中找到target，并返回其下标。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 
 *
 * 示例 1:
 *
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例2:
 *
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/N6YdxV
 *
 * @Author jiaoxiangyu
 * @Date 2021/9/8
 */
public class 查找插入位置 {

    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            }else {
                h = m;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(查找插入位置.searchInsert(nums, 5));
    }
}
