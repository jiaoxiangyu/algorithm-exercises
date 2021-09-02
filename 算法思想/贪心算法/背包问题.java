package 算法思想.贪心算法;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 背包问题：
 给定 n 种物品和一个容量为 C 的背包，物品 i 的重量是 wi，其价值为 vi 。
 问：可以选择物品i的一部分，而不一定要全部装入背包，1≤i≤n。
 应该如何选择装入背包的物品，使得装入背包中的物品的总价值最大？

 分析：
 依贪心选择策略，将尽可能多的单位重量价值最高的物品装入背包。若将这种物品全部装入背包后，
 背包内的物品总重量未超过C，则选择单位重量价值次高的物品并尽可能多地装入背包。
 依此策略一直地进行下去，直到背包装满为止。
 */

/**
 * 定义一个物体类
 */
class Body{
    int id;// 物体的序号
    int w;// 物体的重量
    int p;// 物体的价值

    public Body() {

    }

    public Body(int w, int p) {
        this.w = w;
        this.p = p;
    }

    public Body(int id, int w, int p) {
        this.id = id;
        this.w = w;
        this.p = p;
    }

    @Override
    public String toString() {
        return "Body{" +
                "id=" + id +
                ", w=" + w +
                ", p=" + p +
                '}';
    }
}

public class 背包问题 {
    /**
     * 一般背包问题的代码实现
     * @param w：每个物体重量的数组
     * @param p：每个物体收益的数组
     * @param m：背包载重
     * @return 结果集（放入哪几个物体、每个物体放入多少部分）
     */
    public static List<Body> commonPackage(int[] w, int[] p, int m ){
        // 构造物体对象列表（将入参存储在List<Body>中）
        List<Body> bodys = new ArrayList<>();
        for ( int i=0; i<w.length; i++ ) {
            bodys.add(new Body(w[i],p[i]));
        }
        // 对性价比排序（从高到低排序）
        Collections.sort(bodys, new Comparator<Body> (){
            @Override
            public int compare(Body b1,Body b2){
                return b2.p/b2.w-b1.p/b1.w;
            }
        });
        // 将物体按照性价比从高到低依次加入背包
        int rest = m;// 剩余重量
        int i=0;
        List<Body> results = new ArrayList<>();// 存放结果集
        for(; i<bodys.size(); i++){
            if ( rest<bodys.get(i).w )
                break;
            Body curBody = bodys.get(i);
            results.add(curBody);
            rest -= curBody.w;
        }
        // 计算最后一个物体能放入的部分
        Body lastBody = bodys.get(i);
        results.add(new Body(lastBody.id,rest,(lastBody.p*rest/lastBody.w)));
        return results;
    }

    public static void main(String[] args) {
        int[] w = { 4, 6, 2, 2, 5, 1};
        int[] p = { 8, 10, 6, 3, 7, 2};
        List<Body> bs= commonPackage(w, p, 12);
        System.out.println(bs);

    }

}
