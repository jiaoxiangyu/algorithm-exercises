package 算法思想.二分法;

/**
 * @ClassName: 二分查找
 * @Description:
 *
 * 时间复杂度
 * 二分查找也称为折半查找，每次都能将查找区间减半，这种折半特性的算法时间复杂度为 O(logN)。
 *
 * m 计算
 *
 * 有两种计算中值 m 的方式：
 *
 * m = (l + h) / 2
 * m = l + (h - l) / 2
 * l + h 可能出现加法溢出，也就是说加法的结果大于整型能够表示的范围。但是 l 和 h 都为正数，因此 h - l 不会出现加法溢出问题。所以，最好使用第二种计算法方法。
 *
 * 未成功查找的返回值
 *
 * 循环退出时如果仍然没有查找到 key，那么表示查找失败。可以有两种返回值：
 *
 * -1：以一个错误码表示没有查找到 key
 * l：将 key 插入到 nums 中的正确位置
 *
 *
 * https://blog.csdn.net/qq_20885597/article/details/92409825
 *
 * @Author jiaoxiangyu
 * @Date 2021/9/2
 * @Version 1.0
 * @Since JDK1.8
 */
public class 二分查找 {

    public static int binarySearch(int[] nums, int key) {
        if (nums.length == 0) {
            return -1;
        }

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (key == nums[m]) {
                return m;
            } else if (key > nums[m]) {
                l = m + 1;
            }else {
                r = m - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
       int[] arr={0,1,2,3,4,5};
       //System.out.println(arr);
        System.out.println(二分查找.binarySearch(arr, 3));

    }
}
