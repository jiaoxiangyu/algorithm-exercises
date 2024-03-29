package 二分法;

/**
 * @ClassName: 求开方
 * @Description:
 *
 * 一个数 x 的开方 sqrt 一定在 0 ~ x 之间，并且满足 sqrt == x / sqrt。可以利用二分查找在 0 ~ x 之间查找 sqrt。
 *
 * 对于 x = 8，它的开方是 2.82842…，最后应该返回 2 而不是 3。在循环条件为 l <= h 并且循环退出时，h 总是比 l 小 1，也就是说 h = 2，l = 3，因此最后的返回值应该为 h 而不是 l。
 * ————————————————
 * 原文链接：https://blog.csdn.net/qq_20885597/article/details/92409825
 *
 * @Author jiaoxiangyu
 * @Date 2021/9/4
 * @Version 1.0
 * @Since JDK1.8
 */
public class 求开方 {

    public static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int l = 1, r = x;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int sqrt = x / m;
            if (sqrt == m) {
                return sqrt;
            } else if (sqrt < m) {
                r = m - 1;
            }else {
                l = m + 1;
            }
        }

        return r;
    }

    public static void main(String[] args) {
        System.out.println(求开方.mySqrt(8));
    }
}
