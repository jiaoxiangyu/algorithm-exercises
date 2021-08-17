/**
 * @ClassName: 最大存水量问题
 * @Description: 给出一个数组代表围柱的高度，求能围柱的最大的水量，例如数组{ 5，2，3，2，4 }，最大水量为5。
 *
 * https://blog.csdn.net/wonengguwozai/article/details/109176722
 *
 * @Author jiaoxiangyu
 * @Date 2021/8/17
 * @Version 1.0
 * @Since JDK1.8
 */
public class 最大存水量问题 {

    public static int maxStorage(int[] arr) {
        int len = arr.length;
        if (len == 0) {
            return 0;
        }
        //右边最高高度
        int[] right = new int[len];
        right[len-1] = arr[len - 1];
        for (int i = len-2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }
        //左边最高高度
        int left=0;
        int max=0;
        for (int i = 0; i < len; i++) {
            left = Math.max(left, arr[i]);
            max += arr[i] >= right[i] && arr[i] >= left
                    ? 0
                    : Math.min(right[i], left) - arr[i];
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 2, 4};
        System.out.println(最大存水量问题.maxStorage(arr));
    }
}
