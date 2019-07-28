package 排序;
/** 
* @author 焦祥宇 
* @version 创建时间：2017年3月20日 下午8:24:40 
* @description  
*/
public class 快速排序 {
    private int [] array;  //待排序的数组

    public 快速排序(int [] array){
        this.array= array;
    }

    //按顺序打印数组中的元素
    public void display(){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+"\t");
        }
        System.out.println();
    }

    //快速排序
    public void quikSort(){
        recursiveQuikSort(0,array.length-1);
    }

    /**
     * 递归的快速排序
     *@param low  数组的最小下标
     *@param high  数组的最大下标
     */
    private void recursiveQuikSort(int low,int high){
        if(low>=high){
            return;
        }else{
            int pivot = array[low];  //以第一个元素为基准
            int partition =partition(low,high,pivot);  //对数组进行划分，比pivot小的元素在低位段，比pivot大的元素在高位段

            display();

            recursiveQuikSort(low,partition-1);  //对划分后的低位段进行快速排序
            recursiveQuikSort(partition+1,high);  //对划分后的高位段进行快速排序
        }
    }

    /**
     * 以pivot为基准对下标low到high的数组进行划分
     *@param low 数组段的最小下标
     *@param high 数组段的最大下标
     *@param pivot 划分的基准元素
     *@return 划分完成后基准元素所在位置的下标
     */
    private int partition(int low,int high,int pivot){

        while(low<high){

            while (low<high &&array[high]>=pivot){  //从右端开始扫描，定位到第一个比pivot小的元素
                high--;
            }
            swap(low,high);

            while (low<high &&array[low]<=pivot){  //从左端开始扫描，定位到第一个比pivot大的元素
                low++;
            }
            swap(low,high);

        }
        return low;

    }
    /**
     * 交换数组中两个元素的数据
     *@param low 欲交换元素的低位下标
     *@param high 欲交换元素的高位下标
     */
    private void swap(int low,int high){
        int temp = array[high];
        array[high] = array[low];
        array[low] = temp;
    }

    public static void main(String[] args) {
        int [] a ={6,2,7,4,8,1,5,3};
        快速排序 sort = new 快速排序(a);
        sort.display();
        sort.quikSort();
    }

}
