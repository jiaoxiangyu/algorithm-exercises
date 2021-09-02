package 算法思想.动态规划;

/**
 0-1 背包问题：
 给定 n 种物品和一个容量为 C 的背包，物品 i 的重量是 wi，其价值为 vi 。
 问：应该如何选择装入背包的物品，使得装入背包中的物品的总价值最大？

 分析：
 面对每个物品，我们只有选择拿取或者不拿两种选择，不能选择装入某物品的一部分，也不能装入同一物品多次。

 解决办法：
 声明一个大小为 m[n][c]的二维数组，m[ i ][ j ]表示在面对第 i 件物品，且背包容量为 j 时所能获得的最大价值 ，
 那么我们可以很容易分析得出 m[i][j] 的计算方法，

 if (j<w[i]) {
    m[i][j] = m[i-1][j ];
 } else {
    m[i][j] = Math.max(m[i - 1][j], m[i - 1][j - w[i]] + v[i]);
 }

 获得最优解后，还不知道该取出哪些物品，要根据最优解追踪该取出哪些物品
 if (m[i][c] == m[i - 1][c]) {
    t[i] = 0;
 } else {
    t[i] = 1;
    c -= w[i];
 }
 t[1] = (m[1][c] > 0) ? 1 : 0;


 */
public class _0_1背包问题 {
    public static void main(String[] args) {
        int[] v = {0 , 8, 10, 6, 3, 7, 2};
        int[] w = {0 , 4, 6, 2, 2, 5, 1};
        int[][] m=knapsack(7, 12, v, w);
        int[] t = traceBack(7, 12, m, w);

        for (int i=0;i<7;i++) {
            for (int j=0;j<13;j++) {
                System.out.print(m[i][j]+"  ");
            }
            System.out.println();
        }
        for (int i=0;i<t.length;i++) {
            System.out.print(t[i]+" ");
        }

    }


    /**
     * 动态规划最优解
     * @param n 物品数量 下标0位置存0，无意义
     * @param c 背包容量
     * @param v 物品价值 下标为0位置不存有效数据
     * @param w 物品重量 下标为0位置不存有效数据
     * @return m[i][j] 前i件中若干个物品放入体积为j的背包中的最大价值
     */
    public static int[][] knapsack(int n,int c,int[] v,int[] w) { // knapsack [ˈnæpsæk] 背包
        int[][] m = new int[n][c+1];
        for (int i=1;i<n; i++){
            for (int j=1;j<=c;j++) {
                if (j<w[i]) {
                    m[i][j] = m[i-1][j ];
                } else {
                    m[i][j] = Math.max(m[i - 1][j], m[i - 1][j - w[i]] + v[i]);
                }
            }
        }
        return m;
    }

    /**
     *  追踪取出哪些物品
     * @param n 物品数量 下标0位置存0，无意义
     * @param c 背包容量
     * @param m  m[i][j] 前i件中若干个物品放入体积为j的背包中的最大价值
     * @param w 物品重量 下标为0位置不存有效数据
     * @return t 下标0位置存0，无意义,从1开始表示该物品是否取出，1表示取出，0表示不取出
     */
    public static int[] traceBack(int n,int c,int[][] m,int[] w) { // traceBack 追踪
        int[] t = new int[n];
        for (int i = n -1; i > 1; i--) {
            if (m[i][c] == m[i - 1][c]) {
                t[i] = 0;
            } else {
                t[i] = 1;
                c -= w[i];
            }
        }
        t[1] = (m[1][c] > 0) ? 1 : 0;
        return t;
    }



}
