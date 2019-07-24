package 数组;

import java.util.Arrays;

/**
 *删除数组 如数组 (1 3 6 9 2 5 2 1 4 9) 删除所有的2，删除后数组中的剩余数字的顺序不能变
 * 如例子 删除后应为(1 3 6 9 5 1 4 9)
 * 只允许在原数组操作，不能在建立一个新的数组或集合
 */
public class 删除数组 {

    public static void deleteArray(int[] array, int target) {
        int count=0;
        int end=array.length-1;
        for(int i=array.length-1;i>=0;i--){
            if (array[i]==target){
                for (int j = i; j < end; j++) {
                    array[j] = array[j + 1];
                }
                count++;
                end--;
            }
        }
        System.out.println(count);
        array=Arrays.copyOf(array, array.length - count);
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array={1,3,6,9,2,5,2,1,4,9};
        deleteArray(array, 2);
    }
}
