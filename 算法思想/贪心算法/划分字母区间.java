package 贪心算法;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 *
 *
 * 示例：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 *
 * @Author jiaoxiangyu
 * @Date 2021/9/17
 */
public class 划分字母区间 {
    public static List<Integer> partitionLabels(String s) {
        List<Integer> ret=new ArrayList<>();
        if (s.length() == 0) {
            return ret;
        }

        char[] chars = s.toCharArray();

        //统计每个字母最后位置下标
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[chars[i] - 'a'] = i;
        }

        //划分字母区间
        //当前区间起始下标
        int start=0;
        //当前区间字母最大下标
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, lastIndex[chars[i] - 'a']);
            if (i == max) {
                ret.add(i - start + 1);
                start = i + 1;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
