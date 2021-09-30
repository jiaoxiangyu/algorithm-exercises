package 搜索算法;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 如下，二维数组，求从第一个点（0，0）到某个特定点（tr,tc）的最短路径长度。
 * 代码中有详细的注释
 * 二维数组：
 * [
 *  [1,1,0,1],
 *  [1,0,1,0],
 *  [1,1,1,1],
 *  [1,0,1,1]
 * ]
 * 其中：
 * 1表示可以经过某个位置，0代表此位置不可走，求解从 (0, 0) 位置到 (tr, tc) 位置的最短路径长度。
 *
 * ————————————————
 * 原文链接：https://blog.csdn.net/skkw111/article/details/82774223
 *
 * @author jiaoxiangyu
 * @date 2021/9/24
 */
public class 网格最短路径 {

    public static int minPathLength(int[][] grids, int tr, int tc) {
        if(grids.length<=0 || grids[0].length<=0
                || tr<0 || tc < 0)
            return -1;
        //direction中分别代表右移，左移，上移，下移
        final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        //m代表有多少行，n代表多少列
        final int m = grids.length, n = grids[0].length;
        //queue用来存储接下来要遍历到的点
        //Pair存储当前点的坐标
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        //首先将0,0点入队列
        queue.add(new Pair<>(0, 0));
        //此时没有移动，所以长度为0
        int pathLength = 0;
        //当队列不为空的时候
        while (!queue.isEmpty()) {
            //size的作用为检测当前queue里面有多少个值，也就代表着走一步可以到达的点有多少个
            int size = queue.size();
            //每一次循环，pathLength会加一
            pathLength++;
            //就执行size次循环
            while (size-- > 0) {
                Pair<Integer, Integer> cur = queue.poll();
                for (int[] d : direction) {
                    int nr = cur.getKey() + d[0], nc = cur.getValue() + d[1];
                    Pair<Integer, Integer> next = new Pair<>(nr, nc);
                    //判断下一步是否越界
                    if (next.getKey()<0 || next.getValue()>=m
                            || next.getKey() >= n || next.getValue()<0) {

                        continue;
                    }
                    //判断当前点的值是否为0，为0代表不可以走
                    if(grids[next.getKey()][next.getValue()] ==0){
                        continue;
                    }
                    grids[next.getKey()][next.getValue()] = 0; // 标记
                    if (next.getKey() == tr && next.getValue() == tc) {
                        return pathLength;
                    }
                    queue.add(next);
                }
            }
        }
        return -1;
    }


    //自己写的
    public static int minPathLength2(int[][] grids, int tr, int tc) {
        if (grids.length == 0 || grids[0].length==0  || tr < 0 || tc < 0) {
            return -1;
        }
        //direction中分别代表右移，左移，上移，下移
        final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        //m代表有多少行，n代表多少列
        int m = grids.length, n = grids[0].length;
        //queue用来存储接下来要遍历到的点
        //Pair存储当前点的坐标
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        //首先将0,0点入队列
        queue.add(new Pair<>(0, 0));
        //此时没有移动，所以长度为0
        int pathLength = 0;
        //当队列不为空的时候
        while (!queue.isEmpty()) {
            //size的作用为检测当前queue里面有多少个值，也就代表着走一步可以到达的点有多少个
            int size = queue.size();
            //每一次循环，pathLength会加一
            pathLength++;
            //就执行size次循环
            while (size-- > 0) {
                Pair<Integer, Integer> curr = queue.poll();
                for (int[] d : direction) {
                    int nr = curr.getKey() + d[0], nc = curr.getValue() + d[1];
                    Pair<Integer, Integer> next = new Pair<>(nr, nc);
                    //判断下一步是否越界
                    if (next.getKey() < 0 || next.getKey() >= n
                            || next.getValue() < 0 || next.getValue() >= m) {
                        continue;
                    }

                    //判断当下一步的值是否为0，为0代表不可以走
                    if (grids[next.getKey()][next.getValue()] == 0) {
                        continue;
                    }
                    //把下一步可达标记为0
                    grids[next.getKey()][next.getValue()] = 0;
                    if (next.getKey() == tr && next.getValue() == tc) {
                        return pathLength;
                    }
                    queue.add(next);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args){

        /*
        grids: 测试用例
         */
        int[][] grids = {
                {1,1,0,1},
                {1,0,1,0},
                {1,1,1,1},
                {1,0,1,1}
        };
        int tr = 2;//target row
        int tc = 3;//target column
        int length = minPathLength2(grids,tr,tc);//最短路径长度
        System.out.println(length);
    }

}
