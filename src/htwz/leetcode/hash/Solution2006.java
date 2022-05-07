package htwz.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * hash ---  差的绝对值为 K 的数对数目
 *
 * 输入：nums = [1,2,2,1], k = 1
 * 输出：4
 * 解释：差的绝对值为 1 的数对为：
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 *
 * @author wangyu
 * @since 2022/5/7 7:31
 */
public class Solution2006 {

    public static void main(String[] args) {
        int[] nums = {1,2,2,1};
        int k = 1;
        int result = countKDifference(nums, k);
        System.out.println(result);

    }

    public static int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> resultMap = new HashMap<>(200);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (resultMap.containsKey(num + k)) {
                result = result + resultMap.get(num + k);
            }
            if (resultMap.containsKey(num - k)) {
                result = result + resultMap.get(num - k);
            }
            resultMap.put(num, resultMap.getOrDefault(num, 0) + 1);
        }
        return result;
    }
}
