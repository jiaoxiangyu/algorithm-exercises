package 贪心算法;

import java.util.Collections;

/**
 *
 最优装载：
 有一批集装箱要装上一艘载重量为c的轮船。其中集装箱i的重量为Wi。
 最优装载问题要求确定在装载体积不受限制的情况下，将尽可能多的集装箱装上轮船。

 分析：
 可用贪心算法，先给集装箱重量从小到大排序，然后采用重量最轻者先装的贪心选择策略
 */
public class 最优装载 {

    public static int[] loading(int c,int[] w) {
        int[] result = new int[w.length];
        w = sort(w);
        for (int i = 0; i < w.length; i++) {
            if (w[i] > c) {
                break;
            }
            c -= w[i];
            result[i] = w[i];
        }
        return result;
    }

    /**
     * 冒泡排序 把集装箱按从小到大顺序排列
     * @param w
     * @return
     */
    public static int[] sort(int[] w) {
        int temp;
        for (int i = 0; i < w.length-1; i++) {
            for (int j = i+1; j < w.length; j++) {
                if (w[i] > w[j]) {
                    temp = w[i];
                    w[i] = w[j];
                    w[j] = temp;
                }
            }
        }
        return w;
    }

    public static void main(String[] args) {
        int[] w = {2, 6, 9, 6, 4};
        w = loading(12, w);
        for (int i : w) {
            System.out.print(i+" ");
        }
    }


}
