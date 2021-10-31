package 搜索算法;

import java.util.*;

/**
 * 字典wordList 中从单词 beginWord和 endWord 的 转换序列 是一个按下述规格形成的序列：
 *
 * 序列中第一个单词是 beginWord 。
 * 序列中最后一个单词是 endWord 。
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典wordList 中的单词。
 * 给你两个单词 beginWord和 endWord 和一个字典 wordList ，找到从beginWord 到endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。
 *
 * 
 * 示例 1：
 *
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 * 示例 2：
 *
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：0
 * 解释：endWord "cog" 不在字典中，所以无法进行转换。
 *
 * 题解：https://leetcode-cn.com/problems/word-ladder/solution/yan-du-you-xian-bian-li-shuang-xiang-yan-du-you-2/
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 *
 *
 * @author jiaoxiangyu
 * @date 2021/10/31
 */
public class 单词接龙 {
    //广度搜索
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //1. 先将wordList放到set中，方便查询
        Set<String> wordSet=new HashSet<>(wordList);
        if (wordSet.size()==0 || !wordSet.contains(endWord)){
            return 0;
        }
        wordSet.remove(beginWord);

        //2. 图的广度优先遍历，必须使用队列和表示是否访问过的 visited 哈希表
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // 3. 开始广度优先遍历，包含起点，因此初始化的时候步数为 1
        int step = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 依次遍历当前队列中的单词
                String currentWord = queue.poll();
                // 如果 currentWord 能够修改 1 个字符与 endWord 相同，则返回 step + 1
                if (changeWordEveryOneLetter(currentWord, endWord, queue, visited, wordSet)) {
                    return step + 1;
                }
            }
            step++;
        }

        return 0;
    }

    /**
     * 尝试对 currentWord 修改每一个字符，看看是不是能与 endWord 匹配
     *
     * @param currentWord
     * @param endWord
     * @param queue
     * @param visited
     * @param wordSet
     * @return boolean
     */
    private boolean changeWordEveryOneLetter(String currentWord, String endWord,
                                             Queue<String> queue, Set<String> visited, Set<String> wordSet) {
        char[] chars = currentWord.toCharArray();
        for (int i=0; i<endWord.length(); i++) {
            // 先保存，然后恢复
            char originChar = chars[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (originChar == j) {
                    continue;
                }
                chars[i] = j;
                String nextWord = String.valueOf(chars);
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        queue.add(nextWord);
                        // 注意：添加到队列以后，必须马上标记为已经访问
                        visited.add(nextWord);
                    }
                }
            }
            // 恢复
            chars[i] = originChar;
        }
        return false;
    }
}
