package 排序;

/**
 * @author  jiaoxiangyu
 * @date 2019-3-30 20:55
 *
 * 基本思想
 * 分析归并排序之前，我们先来了解一下分治算法。
 *
 * 分治算法的基本思想是将一个规模为N的问题分解为K个规模较小的子问题，这些子问题相互独立且与原问题性质相同。求出子问题的解，就可得到原问题的解。
 *
 * 分治算法的一般步骤：
 *
 * （1）分解，将要解决的问题划分成若干规模较小的同类问题；
 *
 * （2）求解，当子问题划分得足够小时，用较简单的方法解决；
 *
 * （3）合并，按原问题的要求，将子问题的解逐层合并构成原问题的解。
 *
 *  
 *
 * 归并排序是分治算法的典型应用。
 *
 * 归并排序先将一个无序的N长数组切成N个有序子序列（只有一个数据的序列认为是有序序列），
 * 然后两两合并，再将合并后的N/2（或者N/2 + 1）个子序列继续进行两两合并，
 * 以此类推得到一个完整的有序数组。
 */
public class 归并排序 {

    private int [] array;  //待排序的数组

    public 归并排序(int [] array){
        this.array= array;
    }

    //按顺序打印数组中的元素
    public void display(){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+"\t");
        }
        System.out.println();
    }

    //归并排序
    public void mergeSort(){

        int[] workSpace = new int [array.length]; //用于辅助排序的数组
        recursiveMergeSort(workSpace,0,workSpace.length-1);
    }

    /**
     * 递归的归并排序
     * @param workSpace  辅助排序的数组
     * @param lowerBound 欲归并数组段的最小下标
     * @param upperBound 欲归并数组段的最大下标
     */
    private void recursiveMergeSort(int [] workSpace,int lowerBound,int upperBound){

        if(lowerBound== upperBound){  //该段只有一个元素，不用排序
            return;
        }else{
            int mid = (lowerBound+upperBound)/2;
            recursiveMergeSort(workSpace,lowerBound,mid);    //对低位段归并排序
            recursiveMergeSort(workSpace,mid+1,upperBound);  //对高位段归并排序
            merge(workSpace,lowerBound,mid,upperBound);
            display();
        }
    }

    /**
     * 对数组array中的两段进行合并，lowerBound~mid为低位段，mid+1~upperBound为高位段
     * @param workSpace 辅助归并的数组，容纳归并后的元素
     * @param lowerBound 合并段的起始下标
     * @param mid 合并段的中点下标
     * @param upperBound 合并段的结束下标
     */
    private void merge(int [] workSpace,int lowerBound,int mid,int upperBound){

        int lowBegin = lowerBound;  //低位段的起始下标
        int lowEnd = mid;           //低位段的结束下标
        int highBegin = mid+1;  //高位段的起始下标
        int highEnd = upperBound;  //高位段的结束下标
        int j = 0; //workSpace的下标指针
        int n = upperBound-lowerBound+1;  //归并的元素总数

        while(lowBegin<=lowEnd && highBegin<=highEnd){
            if(array[lowBegin]<array[highBegin]){//将两者较小的那个放到workSpace中
                workSpace[j++]= array[lowBegin++];
            }else{
                workSpace[j++]= array[highBegin++];
            }
        }

        while(lowBegin<=lowEnd){
            workSpace[j++]= array[lowBegin++];
        }

        while(highBegin<=highEnd){
            workSpace[j++]= array[highBegin++];
        }

        for(j=0;j<n;j++){  //将归并好的元素复制到array中
            array[lowerBound++]= workSpace[j];
        }

    }

    public static void main(String[] args) {
        int [] a ={6,2,7,4,8,1,5,3};
        归并排序 sort = new 归并排序(a);
        sort.mergeSort();
    }

}