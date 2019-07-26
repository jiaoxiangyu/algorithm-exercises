import java.util.Arrays;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 例如输入字符串abc，则输出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
 */
public class 全排 {

    public static void sort(char[] chars, int start) {
        if (chars.length < 1) {
            return;
        }
        if (start == chars.length) {
            System.out.println(Arrays.toString(chars));
        }else {
            for (int i = start; i < chars.length; i++) {
                swap(chars, i, start);
                sort(chars, start + 1);
                swap(chars, start, i);
            }
        }
    }

    public static void swap(char[] chars, int from, int to) {
        char temp = chars[from];
        chars[from] = chars[to];
        chars[to] = temp;
    }

    public static void main(String[] args) {
        char[] chars = "abcd".toCharArray();
        sort(chars,0);
    }
}
