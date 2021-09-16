package 二分法;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 *
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 *
 * @Author jiaoxiangyu
 * @Date 2021/9/8
 */
public class 旋转数组的最小数字 {

    public static int minArray(int[] numbers) {
        if (numbers.length == 0) {
            return numbers[0];
        }

        int l = 0, h = numbers.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (numbers[m] < numbers[h]){
                h = m;
            } else if (numbers[m] > numbers[h]) {
                l = m + 1;
            }else {
                h--;
            }
        }

        return numbers[l];
    }

    public static void main(String[] args) {
        int[] num = {2, 2, 2, 0, 1};
        System.out.println(minArray(num));
    }
}
