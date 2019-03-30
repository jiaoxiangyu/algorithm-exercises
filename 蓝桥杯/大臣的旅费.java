/**        
 * @author: 焦祥宇 
 * @date:   createDate：2017年3月25日 下午8:10:54   
 * @Description:  
 * http://lx.lanqiao.cn/problem.page?gpid=T32
问题描述
很久以前，T王国空前繁荣。为了更好地管理国家，王国修建了大量的快速路，用于连接首都和王国内的各大城市。

为节省经费，T国的大臣们经过思考，制定了一套优秀的修建方案，使得任何一个大城市都能从首都直接或者通过其他大城市间接到达。同时，如果不重复经过大城市，从首都到达每个大城市的方案都是唯一的。

J是T国重要大臣，他巡查于各大城市之间，体察民情。所以，从一个城市马不停蹄地到另一个城市成了J最常做的事情。他有一个钱袋，用于存放往来城市间的路费。

聪明的J发现，如果不在某个城市停下来修整，在连续行进过程中，他所花的路费与他已走过的距离有关，在走第x千米到第x+1千米这一千米中（x是整数），他花费的路费是x+10这么多。也就是说走1千米花费11，走2千米要花费23。

J大臣想知道：他从某一个城市出发，中间不休息，到达另一个城市，所有可能花费的路费中最多是多少呢？

输入格式
输入的第一行包含一个整数n，表示包括首都在内的T王国的城市数

城市从1开始依次编号，1号城市为首都。

接下来n-1行，描述T国的高速路（T国的高速路一定是n-1条）

每行三个整数Pi, Qi, Di，表示城市Pi和城市Qi之间有一条高速路，长度为Di千米。

输出格式
输出一个整数，表示大臣J最多花费的路费是多少。

样例输入1
5
1 2 2
1 3 1
2 4 5
2 5 4
样例输出1
135
输出格式
大臣J从城市4到城市5要花费135的路费。
 */  
package 蓝桥杯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Edge{
    ArrayList<Integer> edge = new ArrayList<Integer>(); 
}
class Vertex{
    ArrayList<Integer> ver = new ArrayList<Integer>();
}

public class 大臣的旅费 {

    public static boolean DEBUG = true;
    public static int N,INF=1000000000 ;
    public static Vertex[] vertexs;
    public static Edge[] edges ;
    public static int[] dis;
    public static boolean[] visited;

    public static void init(){
        for(int i=0;i<N+10;i++){
            vertexs[i] = new Vertex();
            edges[i] = new Edge();
        }
    }
    public static void show(){
        System.out.println("Output graph:");
        for(int i=1;i<=N;i++){
            int t = vertexs[i].ver.size();
            for(int j=0;j<t;j++){
                System.out.print("i:"+i+",");
                System.out.println(vertexs[i].ver.get(j)+":"+edges[i].edge.get(j));
            }
        }
        System.out.println();
    }
    public static void show1(){
        for(int i=1;i<=N;i++) System.out.println(i+":"+dis[i]);
    }
    public static void test(){
        System.out.println("test!");
    }
    //搜索将结果存到数组中，然后一次次的递推
    //求起始点到其余点的距离,在上一层的递归中已经给出了i到t的距离，存储在了dis[t]中，所以与t相邻的再直接加上dis[t]就是源点到其距离

    public static void DFS(int t){
        int size = vertexs[t].ver.size();
        for(int i=0;i<size;i++){//第t个节点的所有边的另一顶点
            int j = vertexs[t].ver.get(i);
            if(!visited[j]){
                dis[j] = dis[t] + edges[t].edge.get(i);
                visited[j] = true;
                DFS(j);
            }
        }

    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            N = in.nextInt();
            vertexs = new Vertex[N+10];
            edges = new Edge[N+10];
            visited = new boolean[N+10];
            dis = new int[N+10];
            init();
            int s,d,v;
            for(int i=1;i<N;i++){
                s = in.nextInt();
                d = in.nextInt();
                v = in.nextInt();
                //边与顶点一一对应
                vertexs[s].ver.add(d);
                edges[s].edge.add(v);

                vertexs[d].ver.add(s);
                edges[d].edge.add(v);
            }
            //show();
            Arrays.fill(visited, false);
            Arrays.fill(dis, INF);
            dis[1] = 0;
            visited[1] = true;
            DFS(1);
            //show1();
            int start=-1,maxLen=-1;
            for(int i=1;i<=N;i++){
                if(dis[i]!=INF&&maxLen<dis[i]){
                    start = i;
                    maxLen = dis[i];
                }
            }
            //System.out.println("start:"+start+",maxlen:"+maxLen);
            Arrays.fill(visited, false);
            Arrays.fill(dis, INF);
            dis[start] = 0;
            visited[start] = true;
            DFS(start);
            //show1();
            for(int i=1;i<=N;i++){
                if(dis[i]!=INF&&maxLen<dis[i]){
                    start = i;
                    maxLen = dis[i];
                }
            }
            long ans = maxLen*11+(maxLen*(maxLen-1))/2;
            System.out.println(ans);
        }
    }

}