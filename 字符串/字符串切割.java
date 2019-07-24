package 字符串;

import java.util.Arrays;

/**
 * 给你个字符串source如qwqwqwqw再给串字符target如w让你对source进行分割
 * 比如例子的结果为q q q q
 * 不能使用正则表达式
 */
public class 字符串切割 {
    public static void cut(String source,String target){
        source=source.replace(target, " ");
        System.out.println(source);
    }

    public static void cut2(String source,String target){
        String[] stings=source.split(target);
        System.out.println(Arrays.toString(stings));
    }

    public static void cut3(String source,String target){
        int i=0;
        StringBuffer stringBuffer = new StringBuffer();
        while (i < source.length()) {
            if (source.charAt(i) != target.charAt(0)) {
               stringBuffer.append(source.charAt(i));
            }else {
                if (source.substring(i, i + target.length()).equals(target)) {
                    System.out.println(stringBuffer.toString());
                    stringBuffer.setLength(0);
                    i=+target.length();
                }else {
                    stringBuffer.append(source.charAt(i));
                }
            }
        }
    }

    public static void main(String[] args) {
        cut("qwcqwcqwcqwc","wc");
    }

}
