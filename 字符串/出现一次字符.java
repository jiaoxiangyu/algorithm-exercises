import java.util.Arrays;

/**
 *  第一个只出现一次的字符
 *
 * 问题描述
 *
 * 在字符串中找出第一个只出现一次的字符。如输入abaccdeff，则输出b，要求时间复杂度为O(n)。
 *
 * 解决思路
 *
 * 这里需要采用 以空间换时间 的思想，也就是创建一个足够大的数组c，这里为256，然后对原始的数组p进行两次遍历：
 *
 * 第一次 从头开始 遍历p，以p的值作为数组c的下标，并将c中对应位置的值加1，也就是说c[Integer.valueOf(i)]的值表示的是字符i在p中出现的次数。这和HashMap的原理有些类似，只不过是将查找的key值直接简化成为了value的整型值。
 * 第二次 从头开始 遍历p，查找数组c对应位置该值是否为1，如果为1，那么就表示它是第一次只出现一次的字符。
 *
 */
public class 出现一次字符 {

    public static void find(String source) {
        int[] counts = new int[256];
        for (int i = 0; i < source.length(); i++) {
            counts[source.charAt(i)] += 1;
        }
        for (int i = 0; i < 256; i++) {
            if (counts[i] == 1) {
                System.out.println((char) i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        find("abaccdeff");
    }
}
