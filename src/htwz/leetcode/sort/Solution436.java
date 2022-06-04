package htwz.leetcode.sort;

import java.util.Arrays;

/**
 * 436. 寻找右区间
 *
 * 思路：使用 二维数组进行存储，每个一维数组有两列，然后通过 每一个一维数组的 start 进行排序，后使用二分查找
 *
 * 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
 * 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。
 * 返回一个由每个区间 i 的 右侧区间 在 intervals 中对应下标组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
 *
 * @author wangyu
 * @since 2022/6/3 13:17
 */
public class Solution436 {

    public int[] findRightInterval(int[][] intervals) {
        int[] ans = new int[intervals.length];
        int[][] sort = new int[intervals.length][2];
        for(int i = 0; i < intervals.length; i++) {
            sort[i] = new int[]{intervals[i][0], i};
        }
        Arrays.sort(sort, (a, b) -> a[0] - b[0]);
        for(int i = 0; i < intervals.length; i++) {
            int end = intervals[i][1];
            int left = 0, right = intervals.length - 1;
            boolean find = false;
            while(left <= right) {
                int mid = (right + left) >> 1;
                int start = sort[mid][0];
                if(start >= end) {
                    find = true;
                    int location = sort[mid][1];
                    ans[i] = location;
                    right = mid - 1;
                }
                if(start < end) {
                    left = mid + 1;
                }
            }
            if(!find) {
                ans[i] = -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
