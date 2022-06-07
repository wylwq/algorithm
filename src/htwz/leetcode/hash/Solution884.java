package htwz.leetcode.hash;

import java.util.*;

/**
 * 884. 两句话中的不常见单词
 *
 * 句子 是一串由空格分隔的单词。每个 单词 仅由小写字母组成。
 * 如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的 。
 * 给你两个 句子 s1 和 s2 ，返回所有 不常用单词 的列表。返回列表中单词可以按 任意顺序 组织。
 *
 * @author wangyu
 * @since 2022/6/7 20:59
 */
public class Solution884 {

    public static String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> sMap = new HashMap<>();
        String splitSent = " ";
        for (String s : s1.split(splitSent)) {
            sMap.put(s, sMap.getOrDefault(s, 0) + 1);
        }
        for (String s : s2.split(splitSent)) {
            sMap.put(s, sMap.getOrDefault(s, 0) + 1);
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sMap.entrySet()) {
            if (entry.getValue() == 1) {
                ans.add(entry.getKey());
            }
        }
        return ans.toArray(new String[0]);
    }

    public static void main(String[] args) {
        //String s1 = "this apple is sweet", s2 = "this apple is sour";
        String s1 = "apple apple", s2 = "banana";
        String[] uncommon = uncommonFromSentences(s1, s2);
        for (String u : uncommon) {
            System.out.printf("%s\t", u);
        }
    }

}
