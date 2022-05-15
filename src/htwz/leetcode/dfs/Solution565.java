package htwz.leetcode.dfs;

/**
 * 565. 数组嵌套
 *
 * 思路：
 * 1. 根据题意，如果数字出现环，循环结束
 * 2. 如果被遍历过的数字，如果该数字作为第一个出现的数字，则他不会出现最大环
 *
 * 输入: A = [5,4,0,3,1,6,2]
 * 输出: 4
 * 解释:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 *
 * 其中一种最长的 S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 *
 * 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，
 * 其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
 * 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
 *
 * @author wangyu
 * @since 2022/5/15 11:47
 */
public class Solution565 {

    public static void main(String[] args) {
        int[] nums = {5,4,0,3,1,6,2};
        System.out.println(arrayNesting(nums));
    }

    public static int arrayNesting(int[] nums) {
        int ans = 1, curMax = 1;
        boolean[] visited = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(visited[nums[i]]) {
                continue;
            }
            visited[nums[i]] = true;
            curMax = 1;
            int num = nums[nums[i]];
            while(nums[i] != num) {
                visited[num] = true;
                num = nums[num];
                curMax++;
            }
            ans = Math.max(ans, curMax);
        }

        return ans;
    }
}
