package 排序;

import java.util.Arrays;

/**
 * @date 2019-3-22 14:23
 * @author jiaoxiangyu
 *
 * 选择排序
 *
 * 基本思想
 * 冒泡排序中有一个缺点，比如，我们比较第一个数a1与第二个数a2的时候，只要a1比a2大就会交换位置，但是我们并不能确定a2是最小的元素，假如后面还有比它更小的，该元素还会与a2再次进行交换，而且这种交换有可能发生多次才能确定a2的最终位置。
 *
 * 选择排序可以避免这种耗费时间的交换操作，从第一个元素开始，扫描整个待排数组，找到最小的元素放之后再与第一个元素交换位置，然后再从第二个元素开始，继续寻找最小的元素与第二个元素交换位置，依次类推。
 *
 *
 * 时间复杂度：O(N^2)
 */
public class 选择排序 {

    /**
     * 方法1：基本思想
     * @param a
     * @return
     */
    public static int[] selectionSort1(int[] a) {
        int minPoint;
        int temp;
        for (int i = 0; i < a.length-1; i++) {
            minPoint=i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j]<a[minPoint]){
                    minPoint=j;
                }
            }
            if (minPoint!=i){  //如果发现了更小的元素，交换位置
                temp=a[i];
                a[i]=a[minPoint];
                a[minPoint] = temp;
            }
        }
        return a;
    }

    /**
     *
     * 方法2：改进
     * 传统的选择排序每次只确定最小值，根据改进冒泡算法的经验，我们可以对排序算法进行如下改进：每趟排序确定两个最值——最大值与最小值，
     * 这样就可以将排序趟数缩减一半。
     *
     * 其实循环次数并没有减少，只是外层循环次数减少，内存循环次数多了一倍
     * @param a
     * @return
     */
    public static int[] selectionSort2(int[] a) {
        int minPoint;
        int maxPoint;
        int temp;
        int len=a.length;

        for (int i = 0; i < len/2+1; i++) {
            minPoint=i;
            maxPoint=i;
            for (int j = i+1; j <len-i; j++) {
                if (a[j]<a[minPoint]){
                    minPoint=j;
                    continue;
                } else if (a[j]>a[maxPoint]) {
                    maxPoint=j;
                }
            }
            if (minPoint!=i){  //如果发现了更小的元素，交换位置
                if (minPoint == len - i - 1) {
                    minPoint = maxPoint;
                }
                temp=a[i];
                a[i]=a[minPoint];
                a[minPoint] = temp;

                //原来的第一个元素已经与下标为minPoint的元素交换了位置
                //如果之前maxPoint指向的是第一个元素，那么需要将maxPoint重新指向array[minPoint]
                //因为现在array[minPoint]存放的才是之前第一个元素中的数据
                if (maxPoint==i) {
                    maxPoint = minPoint;
                }
            }

            if (maxPoint!=i){
                temp=a[len-i-1];
                a[len-i-1]=a[maxPoint];
                a[maxPoint] = temp;
            }
        }
        return a;
    }


    public static void main(String[] args) {
        int[] a = {3, 6, 4, 2, 11, 10, 5};
        System.out.println(Arrays.toString(a));
        a = selectionSort2(a);
        System.out.println(Arrays.toString(a));
    }


}
