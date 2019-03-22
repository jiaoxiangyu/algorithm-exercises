/**        
 * @author: 焦祥宇 
 * @date:   createDate：2017年3月30日 下午5:54:23   
 * @Description:  
 * 剪邮票

如【图1.jpg】, 有12张连在一起的12生肖的邮票。
现在你要从中剪下5张来，要求必须是连着的。
（仅仅连接一个角不算相连）
比如，【图2.jpg】，【图3.jpg】中，粉红色所示部分就是合格的剪取。

请你计算，一共有多少种不同的剪取方法。

请填写表示方案数目的整数。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。
改为：   1  2  3  4
       6  7  8  9
      11 12 13 15
	  
 */
package 蓝桥杯;

public class 剪邮票 {
	static int[] data={1,2,3,4,6,7,8,9,11,12,13,14};
	static int[] temp=new int[5];
	static int[] vio;
	static int[] cur={1,-1,5,-5};
	public static void main(String[] args) {
				
		int count=0;
		for(int a=0;a<12;a++){
			for(int b=a+1;b<12;b++){
				for(int c=b+1;c<12;c++){
					for(int d=c+1;d<12;d++){
						for(int e=d+1;e<12;e++){
							temp[0]=data[a];
							temp[1]=data[b];
							temp[2]=data[c];
							temp[3]=data[d];
							temp[4]=data[e];
							vio=new int[5];
							vio[0]=1;
							judge(0);
							boolean bool=true;
							for(int i=0;i<5;i++){
								if(vio[i]==0){
									bool=false;
									
								}
							}
							if(bool==true){
								count++;
							}
						}
					}
				}
			}
		}
		System.out.println(count);
	}
	
	static void judge(int u){
		for(int i=0;i<4;i++){
			int t=temp[u]+cur[i];
			if(t>=1&&t<=14){ 
				for(int j=0;j<5;j++){
					if(t==temp[j] && vio[j]==0){
						vio[j]=1;
						judge(j);
					}
						
				}
			}
		}								
	}
}
/*class 剪邮票2{
	static int[] data=new int[]{1,2,3,4,6,7,8,9,11,12,13,14};  
    static int[] arr=new int[5];  
    static int[] vis=new int[5];  
    static int[] dir=new int[]{1,-1,5,-5};  
    static int ans=0;  
      
    public static void main(String[] args) {  
        for (int a = 0; a < data.length; a++) {  
            for (int b = a+1; b < data.length; b++) {  
                for (int c = b+1; c < data.length; c++) {  
                    for (int d = c+1; d < data.length; d++) {  
                        for (int e = d+1; e < data.length; e++) {  
                            arr[0]=data[a];  
                            arr[1]=data[b];  
                            arr[2]=data[c];  
                            arr[3]=data[d];  
                            arr[4]=data[e];  
                            vis=new int[5];  
                            vis[0]=1;  
                            dfs(0);  
                            boolean fal=true;  
                            for (int i = 0; i < 5; i++) {  
                                if(vis[i]==0)  
                                    fal=false;  
                            }  
                            if(fal){  
                                ans++;                                
                            }  
                        }  
                    }  
                }  
            }  
        }  
        System.out.println(ans);  
    }  
  
    //判断连通性  
    private static void dfs(int u) {  
        for(isnt i=0 ;i<4 ;i++){    
            int t = arr[u]+dir[i];    
            if(t>=1&&t<=14){    
                for(int j=0 ;j<5 ;j++)    
                    if(t==arr[j]&&vis[j]==0){    
                        vis[j]=1;    
                        dfs(j);    
                    }               
            }    
        }  
    }  
}
*/