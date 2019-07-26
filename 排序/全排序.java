import java.util.Arrays;

public class 全排序 {
    static char temp ;
    public static void sort(char[] s, int start) {
        if (s.length<=1)
            return;
        if (start == s.length) {
            System.out.println(Arrays.toString(s));
        } else {
            for (int i=start;i<s.length;i++) {
                swap(s,i,start); //交换前缀，使其产生下一个前缀
                sort(s, start + 1);
                swap(s, start, i);//将前缀换回，继续做上一个前缀的排列
            }
        }
    }

    public static void swap(char[] s, int i, int j) {
        temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        char[] s = {'a', 'b', 'c'};
        sort(s, 0);
    }

}
