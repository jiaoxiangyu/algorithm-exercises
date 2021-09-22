package 贪心算法;

/**
 * 给你一个长度为n的整数数组，请你判断在 最多 改变1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的：对于数组中任意的i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 * 
 *
 * 示例 1:
 *
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 *
 * @author jiaoxiangyu
 * @date 2021/9/22
 */
public class 非递减数列 {
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        //标识是否还能修改
        boolean flag = nums[0] > nums[1] ? false : true;
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i] > nums[i + 1]) {
                //存在递减
                if (flag) {
                    if (nums[i + 1] >= nums[i - 1]) {
                        //nums[i] 缩减为 nums[i + 1]
                        nums[i] = nums[i + 1];
                    }else {
                        //nums[i+1] 扩大为 nums[i]
                        nums[i+1] = nums[i];
                    }
                    //使用唯一一次修改机会
                    flag = false;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
