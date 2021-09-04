package 二分法;

/**
 * @ClassName: 大于给定元素的最小元素
 * @Description:
 * 题目描述: 给定一个有序的字符数组 letters 和一个字符 target，
 * 要求找出 letters 中大于 target 的最小字符，如果找不到就返回第 1 个字符。
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "d"
 * Output: "f"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "k"
 * Output: "c"
 *
 * @Author jiaoxiangyu
 * @Date 2021/9/4
 * @Version 1.0
 * @Since JDK1.8
 */
public class 大于给定元素的最小元素 {
    public static char nextGreatestLetter(char[] letters, char target) {
        if (letters.length == 0) {
            return target;
        }

        int l = 0, r = letters.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (letters[r] <= target) {
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }

        return l < letters.length ? letters[l] : letters[0];
    }

    public static void main(String[] args) {
        char[] chars={'c', 'f', 'j'};
        System.out.println(大于给定元素的最小元素.nextGreatestLetter(chars, 'd'));
    }
}