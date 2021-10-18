package 搜索算法;

import java.util.*;

/**
 * 给定正整数n，找到若干个完全平方数（比如1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * 题解：
 * 可以将每个整数看成图中的一个节点，如果两个整数之差为一个平方数，那么这两个整数所在的节点就有一条边。
 *
 * 要求解最小的平方数数量，就是求解从节点 n 到节点 0 的最短路径。
 *
 * 示例1：
 *
 * 输入：n = 12
 * 输出：3 
 * 解释：12 = 4 + 4 + 4
 *
 *
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 *
 * @author jiaoxiangyu
 * @date 2021/9/30
 */
public class 完全平方数 {


    /**
     * 广度搜索法
     * @param n
     * @return  int
     */
    public static int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        boolean[] marked = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        marked[n] = true;
        int level=0;
        while (!queue.isEmpty()){
            int size = queue.size();
            level++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int s : squares) {
                    int next = cur - s;
                    if (next < 0) {
                        break;
                    }
                    if (next == 0) {
                        return level;
                    }
                    if (marked[next]) {
                        continue;
                    }
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }

        return n;
    }

    /**
     * 生成小于 n 的平方数序列
     * @return 1,4,9,...
     */
    private static List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1, diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
