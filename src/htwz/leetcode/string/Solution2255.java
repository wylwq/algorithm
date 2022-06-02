package htwz.leetcode.string;

/**
 * 2255. 统计是给定字符串前缀的字符串数目
 *
 * 给你一个字符串数组 words 和一个字符串 s ，其中 words[i] 和 s 只包含 小写英文字母 。
 * 请你返回 words 中是字符串 s 前缀 的 字符串数目 。
 * 一个字符串的 前缀 是出现在字符串开头的子字符串。子字符串 是一个字符串中的连续一段字符序列。
 *
 * @author wangyu
 * @since 2022/6/2 15:47
 */
public class Solution2255 {

    public static int countPrefixes(String[] words, String s) {
        int len = s.length(), originLen = len;
        int ans = 0;
        boolean hasPrefix;
        for (String word : words) {
            len = Math.min(word.length(), originLen);
            hasPrefix = true;
            for (int i = 0; i < len; i++) {
                if (word.charAt(i) != s.charAt(i)) {
                    hasPrefix = false;
                    break;
                }
            }
            if (hasPrefix && word.length() <= originLen) {
                System.out.printf("%s\n", word);
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"ycwj","hak","v","kjg","zw","vtes","vom","ii","as","v","vo","v","w","vomy","loa","fbm","j","v","vo",
                "e","y","t","eh","yk","bt","x","vomy","vom","yab","v","sydi","wnb","z","v","iygp","vomy","vomy"};
        String s = "vomy";
        int prefixes = countPrefixes(words, s);
        System.out.println(prefixes);
    }

}
