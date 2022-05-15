package htwz.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 401. 二进制手表
 * 思路：暴力枚举，对每一个数字统计它的 二进制个数
 *
 * @author wangyu
 * @since 2022/5/15 12:58
 */
public class Solution401 {

    public static void main(String[] args) {
        List<String> list = readBinaryWatch(1);
        System.out.println(list);
    }

    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i <= 11; i++) {
            for (int j = 0; j <= 59; j++) {
                if (findOneCount(i) + findOneCount(j) == turnedOn) {
                    ans.add(i + ":" + (j < 10 ? "0" + j : j));
                }
            }
        }
        return ans;
    }

    private static int findOneCount(int num) {
        int ans = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                ans++;
            }
            num = num >> 1;
        }
        return ans;
    }
}