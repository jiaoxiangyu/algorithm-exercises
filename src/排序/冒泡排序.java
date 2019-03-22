package 排序;

import java.util.Arrays;

/**
 * @date 2019-3-21 16:02
 * @jiaoxiangyu
 *
 * 冒泡排序
 *
 * 基本思想：
 * 对当前还未排好序的范围内的全部数，自上而下对相邻的俩个数依次进行比较和调整，让较大的数下沉，较小的数往上冒。
 * 即：每当俩相邻的数比较后发现他们的排序与排序的要求相反时，就将他们交换。每次遍历都可确定一个最大值放到待排数组的末尾，下次遍历，对该最大值以及它之后的元素不再排序（已经排好）。
 *
 *
 *
 */

public class 冒泡排序 {

    /**
     * 方法一：普通方法
     * 时间复杂度=(N-1)+ (N-2)+ (N-3)+ ...1=N*(N-1)/2=O(N^2)
     * @param a
     * @return
     */
    public static int[] bubbleSort1(int[] a){
        int temp;
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length - i -1; j++) {
                if (a[j+1]<a[j]){
                    temp=a[j+1];
                    a[j+1]=a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }

    /**
     * 方法2：改进1
     * 最简单的改进方法是加入一标志性变量exchange，用于标志某一趟排序过程中是否有数据交换，
     * 如果进行某一趟排序时并没有进行数据交换，则说明数据已经按要求排列好，可立即结束排序，避免不必要的比较过程
     * @param a
     * @return
     */
    public static int[] bubbleSort2(int[] a){
        int temp;
        boolean exchange=false;
        for (int i = 0; i < a.length-1; i++) {
            for (int j=0;j<a.length-i-1;j++){
                if (a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    if (!exchange){
                        exchange = true;//发生交换
                    }
                }
            }
            if (!exchange)
                break; //如果没有发生交换，说明已经完成排序
        }
        return a;
    }

    /**
     * 方法3：改进2
     * 上面的改进方法，是根据上一轮排序有没有发生数据交换作为标识，进一步思考，如果上一轮排序中，只有后一段的几个元素没有发生数据交换，是不是可以判定这一段不用在进行比较了呢？答案是肯定的。
     *
     * 例如上面的例子中，前四轮的排序结果为：
     *
     * 未排序时的结果：1   5  4  11 2  20 18
     *
     * 第1轮排序结果：1  4  5  2  11 18 20
     *
     * 第2轮排序结果：1  4  2  5  11 18 20
     *
     * 第3轮排序结果：1  2  4  5  11 18 20
     *
     * 第4轮排序结果：1  2  4  5  11 18 20
     *
     * 第1轮排序之后，11、18、20已经是有序的了，后面的几次排序后它们的位置都没有变化，但是根据冒泡算法，18依然会在第2轮参与比较，11依然会在第2轮、第3轮参与比较，其实都是无用功。
     *
     *
     * 我们可以对算法进一步改进：设置一个pos指针，pos后面的数据在上一轮排序中没有发生交换，下一轮排序时，就对pos之后的数据不再比较。
     *
     * @param a
     * @return
     */
    public static int[] bubbleSort3(int[] a) {
        int temp;
        int endPoint = a.length-1;
        while (endPoint>0){
            int point=1;
            for (int j = 0; j <endPoint; j++) {
                if (a[j]>a[j+1]){
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    point=j+1;
                }
            }
            System.out.println(point);
            endPoint=point-1;
        }
        return a;
    }

    /**
     * 方法4：改进3
     * 对的算法来说，没有最好，只有更好。上面的两种改进方法其实治标不治本，是一种“扬汤止沸”的改进，下面我们来一次“釜底抽薪”的改进。
     *
     * 传统的冒泡算法每次排序只确定了最大值，我们可以在每次循环之中进行正反两次冒泡，分别找到最大值和最小值，如此可使排序的轮数减少一半。
     *
     * 排序趟数减少了,但是做的循环比较次数并没有减少
     * @param a
     * @return
     */
    public static int[] bubbleSort4(int[] a){
        int temp;
        int low = 0;
        int high=a.length-1;
        int counter=1;
        while (low < high) {
            //正向冒泡，确定最大值
            for (int i = 0; i < high; i++) {
                if (a[i]>a[i+1]){
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
            high--;

            //反向冒泡，确定最小值
            for (int j = high; j > low; j--) {
                if (a[j]<a[j-1]){
                    temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
            low++;

            counter++;
        }
        System.out.println(counter);
        return a;
    }

    public static void main(String[] args) {
        int[] a = {3, 6, 4, 2, 11, 10, 5};
        //int[] a = {1, 2, 4, 3, 11, 13, 15};
        System.out.println(Arrays.toString(a));
        a = bubbleSort3(a);
        System.out.println(Arrays.toString(a));
    }
}
