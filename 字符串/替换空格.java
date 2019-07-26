/**
 * 替换字符串中的空格
 *
 * 实现一个函数，将字符串p中的所有空格都替换成为指定的字符串r。
 */
public class 替换空格 {
    public static void replace(String source, String target) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i)!=' '){
                stringBuilder.append(source.charAt(i));
            }else {
                stringBuilder.append(target);
            }
        }
        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) {
        replace("I am sentence with space","%20");
    }
}
