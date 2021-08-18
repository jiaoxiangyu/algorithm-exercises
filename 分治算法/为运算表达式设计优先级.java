package 分治算法;

import java.util.*;

/**
 * @ClassName: 为运算表达式设计优先级
 * @Description: 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +,-以及*。
 *
 * 示例1:
 *
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释: 
 * ((2-1)-1) = 0 
 * (2-(1-1)) = 2
 * 示例2:
 *
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释: 
 * (2*(3-(4*5))) = -34 
 * ((2*3)-(4*5)) = -14 
 * ((2*(3-4))*5) = -10 
 * (2*((3-4)*5)) = -10 
 * (((2*3)-4)*5) = 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/different-ways-to-add-parentheses
 *
 * 思路：
 * https://leetcode-cn.com/problems/different-ways-to-add-parentheses/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-5/
 *
 * @Author jiaoxiangyu
 * @Date 2021/8/18
 * @Version 1.0
 * @Since JDK1.8
 */
public class 为运算表达式设计优先级 {

    public static boolean isOp(char c) {
        if (c == '+' || c == '-' || c == '*') {
            return true;
        }
        return false;
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        //每轮结果集合
        List<Integer> ans=new ArrayList<>();
        //操作符左侧可能结果
        List<Integer> left=new ArrayList<>();
        //操作符右侧可能结果
        List<Integer> right=new ArrayList<>();

        //用分治穷举所有的运算
        for (int i = 0; i < expression.length(); i++) {
            if (isOp(expression.charAt(i))) {
                left = diffWaysToCompute(expression.substring(0, i));
                right = diffWaysToCompute(expression.substring(i + 1));
                System.out.print(left+" ");
                System.out.println(right);
                for (int l : left) {
                    for (int r : right) {
                        switch (expression.charAt(i)) {
                            case '+':
                                ans.add(l + r);
                                break;
                            case '-':
                                ans.add(l - r);
                                break;
                            case '*':
                                ans.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (ans.size() == 0) {
            ans.add(Integer.valueOf(expression));
        }

        return ans;
    }

    //优化：穷举会出现重复的表达式，记录已经计算过的表达式，直接返回结果
    static Map<String, List<Integer>> res = new HashMap<>();
    public static List<Integer> diffWaysToCompute2(String expression) {

        //已经计算过直接返回
        List<Integer> isRes = res.get(expression);
        if (isRes != null) {
            return isRes;
        }

        //每轮结果集合
        List<Integer> ans=new ArrayList<>();
        //操作符左侧可能结果
        List<Integer> left=new ArrayList<>();
        //操作符右侧可能结果
        List<Integer> right=new ArrayList<>();

        //用分治穷举所有的运算
        for (int i = 0; i < expression.length(); i++) {
            if (isOp(expression.charAt(i))) {
                left = diffWaysToCompute2(expression.substring(0, i));
                right = diffWaysToCompute2(expression.substring(i + 1));
                System.out.print(left+" ");
                System.out.println(right);
                for (int l : left) {
                    for (int r : right) {
                        switch (expression.charAt(i)) {
                            case '+':
                                ans.add(l + r);
                                break;
                            case '-':
                                ans.add(l - r);
                                break;
                            case '*':
                                ans.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (ans.size() == 0) {
            ans.add(Integer.valueOf(expression));
        }

        //记录已经计算过的表达式
        res.put(expression, ans);

        return ans;
    }

    public static void main(String[] args) {
        //System.out.println(为运算表达式设计优先级.diffWaysToCompute("2*3-4*5"));
        System.out.println(为运算表达式设计优先级.diffWaysToCompute("2-1-1"));
    }
}
