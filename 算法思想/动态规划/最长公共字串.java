import java.util.Arrays;

/**
 * 问题：有两个字符串str和str2，求出两个字符串中最长公共子串长度。
 *
 * 比如：str=acbcbcef，str2=abcbced，则str和str2的最长公共子串为bcbce，最长公共子串长度为5。
 */
public class 最长公共字串 {
    public static void maxStr(String str1, String str2) {
        //获得处理过的数组
        int row=str1.length();
        int col=str2.length();
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            if (str2.charAt(0) == str1.charAt(i)) {
                dp[i][0]=1;
            }
        }

        for (int j = 0; j < col; j++) {
            if (str1.charAt(0) == str2.charAt(j)) {
                dp[0][j]=1;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
            }
        }
        for(int[] a:dp){
            System.out.println(Arrays.toString(a));
        }

        //获得字串最大长度和下标
        int max=0;
        int maxX=0,maxY=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dp[i][j]>max) {
                    max=dp[i][j];
                    maxX=i;
                    maxY = j;
                }
            }
        }

        System.out.println(max+","+maxX+","+maxY);

        //获得最大字串
        int i=row-maxX;
        int j=col-maxX;
        StringBuilder builder = new StringBuilder();
        builder.append(str1.charAt(i));
        while (i < row - 1 && j < col - 1) {
            if (dp[i++][j++] > 0) {
                builder.append(str1.charAt(i));
            }else {
                break;
            }
        }

        System.out.println(builder.toString());

    }

    public static void main(String[] args) {
        maxStr("abcd", "bebcd");
    }
}
