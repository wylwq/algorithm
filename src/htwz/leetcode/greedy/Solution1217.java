package htwz.leetcode.greedy;

/**
 * 1217. 玩筹码
 *
 * 思路：奇数移动到奇数，或者偶数移动到偶数，不需要 cost，因此分别统计奇数与偶数的个数，返回二者个数的最小值即可
 *
 * 有 n 个筹码。第 i 个芯片的位置是 position[i] 。
 * 我们需要把所有筹码移到同一个位置。在一步中，我们可以将第 i 个芯片的位置从 position[i] 改变为:
 * position[i] + 2 或 position[i] - 2 ，此时 cost = 0
 * position[i] + 1 或 position[i] - 1 ，此时 cost = 1
 * 返回将所有筹码移动到同一位置上所需要的 最小代价 。
 *
 * @author wangyu
 * @since 2022/6/4 15:03
 */
public class Solution1217 {

    public static int minCostToMoveChips(int[] position) {
        int odd = 0, even = 0;
        for (int j : position) {
            if (j % 2 == 0) {
                even++;
            }
            if (j % 2 != 0) {
                odd++;
            }
        }
        return Math.min(odd, even);
    }

    public static void main(String[] args) {
        int[] position = {1,2,3};
        int chips = minCostToMoveChips(position);
        System.out.println(chips);
    }
}
