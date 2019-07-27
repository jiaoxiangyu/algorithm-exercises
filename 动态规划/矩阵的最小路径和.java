import java.util.Arrays;

/**
 *题目：
 *
 * 给定一个矩阵m，从左上角开始每次只能向右或者向下走，最后达到右下角的位置，
 * 路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
 *
 * 举例：
 *
 * 给定的m如下：
 * 1 3 5 9
 * 8 1 3 4
 * 5 0 6 1
 * 8 8 4 0
 *
 * 路径1，3，1，0，6，1，0是所有路径中路径和最小的，所以返回12。
 * -
 */
public class 矩阵的最小路径和 {

    /**
     * 方法1
     * 使用动态规划把最小值存在辅助M*N数组（若存在当前数组，原始值被覆盖，只知道最小路径值，不知道最小路径）
     * @param data
     */
    public static void minRoute1(int[][] data){
        if (data == null || data.length == 0
                || data[0] == null || data[0].length == 0) {
            return;
        }
        int row=data.length;
        int col = data[0].length;
        int[][] mins = new int[row][col];
        mins[0][0] = data[0][0];

        //初始化第一行与第一列数据
        for (int i = 1; i < row; i++) {
            mins[i][0] = mins[i - 1][0] + data[i][0];
        }
        for (int j = 1; j < col; j++) {
            mins[0][j] = mins[0][j - 1] + data[0][j];
        }

        // 每个节点的值更新为到该节点的最小值
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                mins[i][j] = Math.min(mins[i - 1][j], mins[i][j - 1])+data[i][j];
            }
        }

        //获得最小路径,此方法也是方法2
        int[] route = new int[row + col - 1];
        route[0] = data[0][0];
        int i=0,j=0,k=1;
        while (i < row-1 && j < col-1) {
            if (data[i][j+1]<data[i+1][j]){
                route[k++]=data[i][j+1];
                j++;
            }else {
                route[k++]=data[i+1][j];
                i++;
            }
        }

        System.out.println(Arrays.toString(route));

        System.out.println(mins[row-1][col-1]);

        for (int a = 0; a < row; a++) {
            System.out.println(Arrays.toString(mins[a]));
        }
    }


    public static void main(String[] args) {
        int[][] data = {
            {1, 3, 5, 9},
            {8, 1, 3, 4},
            {5, 0, 6, 1},
            {8, 8, 4, 0}
        };
        minRoute1(data);


    }
}
