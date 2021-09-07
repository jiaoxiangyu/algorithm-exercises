package 二分法;

/**
 * @ClassName: 有序数组的唯一元素
 * @Description:
 * 链接：https://www.pdai.tech/md/algorithm/alg-core-devide-two.html
 *
 * 题目描述: 一个有序数组只有一个数不出现两次，找出这个数。要求以 O(logN) 时间复杂度进行求解。
 *
 * 令 index 为 Single Element 在数组中的位置。如果 m 为偶数，并且 m + 1 < index，
 * 那么 nums[m] == nums[m + 1]；m + 1 >= index，那么 nums[m] != nums[m + 1]。
 * 从上面的规律可以知道，如果 nums[m] == nums[m + 1]，那么 index 所在的数组位置为 [m + 2, h]，此时令 l = m + 2；
 * 如果 nums[m] != nums[m + 1]，那么 index 所在的数组位置为 [l, m]，此时令 h = m。
 *
 * 因为 h 的赋值表达式为 h = m，那么循环条件也就只能使用 l < h 这种形式。
 *
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 *
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 *
 * @Author jiaoxiangyu
 * @Date 2021/9/5
 * @Version 1.0
 * @Since JDK1.8
 */
public class 有序数组的唯一元素 {
    public static int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (m % 2 == 1) {
                m--; // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
            }
            if (nums[m] == nums[m + 1]) {
                l = m + 2;
            }else {
                h = m;
            }
        }

        return nums[l];
    }

    public static void main(String[] args) {
        int[] arr = {3,3,7,7,10,11,11};
        System.out.println(有序数组的唯一元素.singleNonDuplicate(arr));
    }

}
