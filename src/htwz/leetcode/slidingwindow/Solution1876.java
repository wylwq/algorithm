package htwz.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口
 *
 * @author wangyu
 * @since 2022/5/6 7:34
 */
public class Solution1876 {

    public static void main(String[] args) {
        String s = "aababcabc";
        int i = countGoodSubstrings(s);
        System.out.println(i);
    }

    public static  int countGoodSubstrings(String s) {
        int result = 0, k = 3;
        Map<Character, Integer> map = new HashMap<>(4);
        for (int i = k; i <= s.length(); i++) {
            int count = 0;
            for (int j = i - k; j < i; j++) {
                if (!map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), 1);
                    count++;
                } else {
                    break;
                }
            }
            map.clear();
            if (count == k) {
                result++;
            }
        }
        return result;
    }
}
