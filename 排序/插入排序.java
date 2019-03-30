package 排序;

import java.util.Arrays;

/**
 * @date 2019-3-22 14:23
 * @author jiaoxiangyu
 *
 * 插入排序
 *
 * 基本思想：
 * 在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排好顺序的，现在要把第n个数找到相应位置并插入，
 * 使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
 *
 * 时间复杂度：O(N^2)
 *
 */

public class 插入排序 {

    /**
     * 方法1：基本思想
     * @param a
     * @return
     */
    public static int[] insertionSort1(int[] a) {
        int len = a.length;
        int temp;
        int insertPoint;
        for (int i = 1; i < len; i++) {
            temp=a[i]; //存储待排序的元素值
            insertPoint=i-1;//与待排序元素值作比较的元素的下标

            while (insertPoint>=0 && a[insertPoint]>temp){//当前元素比待排序元素大
                a[insertPoint + 1] = a[insertPoint];//当前元素后移一位
                insertPoint--;
            }
            a[insertPoint+1]=temp;//找到了插入位置，插入待排序元素

        }
        return a;
    }

    /**
     * 方法2：改进-二分插入排序
     * 在插入某个元素之前需要先确定该元素在有序数组中的位置，上例的做法是对有序数组中的元素逐个扫描，当数据量比较大的时候，这是一个很耗时间的过程，
     * 可以采用二分查找法改进，这种排序也被称为二分插入排序。
     *
     * @param a
     * @return
     */
    public static int[] insertionSort2(int[] a) {
        int len=a.length;
        int temp;
        int insertPoint;
        for (int i = 1; i < len; i++) {
            temp = a[i];
            if(a[i-1]>temp) {  //比有序数组的最后一个元素要小
                insertPoint = binarySerch(a, 0, i-1, temp);//获取应插入位置的下标
                for (int j = i; j > insertPoint; j--) {//将有序数组中，插入点之后的元素后移一位
                    a[j] = a[j-1];
                }
                a[insertPoint] = temp;//插入待排序元素到正确的位置
            }
        }
        return a;
    }

    /**
     * 二分查找
     * @param a
     * @param lower
     * @param upper
     * @param target
     * @return
     */
    private static int binarySerch(int[] a, int lower, int upper, int target) {
        int cutIndex;
        while (lower < upper) {
            cutIndex = (lower + upper) / 2;
            if (a[cutIndex] > target) {
                upper = cutIndex - 1;
            } else {
                lower = cutIndex + 1;
            }
        }
        return lower;
    }

    public static void main(String[] args) {
        int[] a = {3, 6, 4, 2, 11, 10, 5};
        System.out.println(Arrays.toString(a));
        a = insertionSort2(a);
        System.out.println(Arrays.toString(a));
    }
}
