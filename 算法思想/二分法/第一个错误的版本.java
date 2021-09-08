package 二分法;

/**
 * @ClassName: 第一个错误的版本
 * @Description: 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用bool isBadVersion(version)接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 
 * 示例 1：
 *
 * 输入：n = 5, bad = 4
 * 输出：4
 * 解释：
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5)-> true
 * 调用 isBadVersion(4)-> true
 * 所以，4 是第一个错误的版本。
 * 示例 2：
 *
 * 输入：n = 1, bad = 1
 * 输出：1
 *
 * 著作权归https://pdai.tech所有。
 * 链接：https://www.pdai.tech/md/algorithm/alg-core-devide-two.html
 *
 * 如果第 m 个版本出错，则表示第一个错误的版本在 [l, m] 之间，令 h = m；
 * 否则第一个错误的版本在 [m + 1, h] 之间，令 l = m + 1。
 * 因为 h 的赋值表达式为 h = m，因此循环条件为 l < h。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-bad-version
 *
 * @Author jiaoxiangyu
 * @Date 2021/9/8
 * @Version 1.0
 * @Since JDK1.8
 */
public class 第一个错误的版本 {


    public static int firstBadVersion(int n) {
        int l = 1, h = n;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (isBadVersion(m)) {
                h = m;
            }else {
                l = m + 1;
            }
        }
        return l;
    }


    public static Boolean isBadVersion(int v) {
        if (4==v){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(第一个错误的版本.firstBadVersion(5));
    }
}
