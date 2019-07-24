package 字符串;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 *查找字符串中出现最多的字符,如果有两个字符串出现的次数相同，则取第一次出现的
 */
public class 查找最多字符 {



    public static void findChar(String string){
        Map<Character, Integer> chars = new LinkedHashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char temp = string.charAt(i);
            if (chars.containsKey(temp)) {
                chars.put(temp, chars.get(temp) + 1);
            }else {
                chars.put(temp, 1);
            }
        }

        AtomicReference<Character> maxChar = new AtomicReference<>((char) 0);
        AtomicInteger max= new AtomicInteger();
        chars.forEach((e,v)->{
            if (v> max.get()){
                max.set(v);
                maxChar.set(e);
            }
        });
        System.out.println(maxChar+" "+max);
    }

    public static void main(String[] args) {
        findChar("aassccsccssscc");
    }
}
