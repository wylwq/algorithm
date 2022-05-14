package htwz.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 1441. 用栈操作构建数组
 *
 * 给你一个目标数组 target 和一个整数 n。每次迭代，需要从  list = {1,2,3..., n} 中依序读取一个数字。
 *
 * 请使用下述操作来构建目标数组 target ：
 *
 * Push：从 list 中读取一个新元素， 并将其推入数组中。
 * Pop：删除数组中的最后一个元素。
 * 如果目标数组构建完成，就停止读取更多元素。
 * 题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
 *
 * 请返回构建目标数组所用的操作序列。
 * 题目数据保证答案是唯一的。
 *
 * @author wangyu
 * @since 2022/5/14 7:12
 */
public class Solution1441 {

    public static void main(String[] args) {
        int[] target = {1,3};
        int n = 3;
        List<String> ans = buildArray(target, n);
        System.out.println(ans);
    }

    public static List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        for(int i = 1, j = 0; i <= n; i++) {
            if(i == target[j]) {
                ans.add("Push");
                j++;
            }else if(i < target[j]) {
                ans.add("Push");
                ans.add("Pop");
            }
            if(i == target[target.length - 1]) {
                break;
            }
        }
        return ans;
    }
}
