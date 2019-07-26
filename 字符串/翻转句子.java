
import java.util.Arrays;

/**
 * 问题描述
 *
 * 翻转句子中单词的顺序，但单词内字符的顺序不变，句子中单词以空格符隔开。例如I am a original string翻转后的结果为string original a am I。
 *
 * 解决思路
 *
 * 实现过程分为两步：
 *
 * 第一步，将整个句子中的所有字符都翻转
 * 第二步，遍历翻转后的句子，对于句子内的每一个单词，将其字符再翻转一次，就能保证单词内字符的顺序不变。翻转单词的时候，通过pStart和pEnd记录每次遇到单词的起止下标，并使用子方法reverseSub对单词中的字符进行翻转。
 *
 */
public class 翻转句子 {

    public static void reverseSub(char[] chars, int start, int end){
        char temp;
        int i = start;
        int j = end;
        while (i < j) {
            temp=chars[i];
            chars[i]=chars[j];
            chars[j]=temp;
            i++;
            j--;
        }
    }

    public static void reverseSentence(String source) {
        char[] chars=source.toCharArray();
        reverseSub(chars, 0, chars.length - 1);
        System.out.println(Arrays.toString(chars));
        int start=0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]==' '){
                reverseSub(chars, start, i-1);
                start = i + 1;
            }
        }
        System.out.println(Arrays.toString(chars));
    }

    public static void main(String[] args) {
        reverseSentence("I am a original string");
    }





}
