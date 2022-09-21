package htwz.leetcode.heap;

/**
 * LCP 06. 拿硬币
 *
 * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。
 * 我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
 *
 * @author wangyu
 * @since 2022/9/21 23:58
 */
public class SolutionLCP06 {

  public static void main(String[] args) {
    int[] coins = {4,2,1};
    System.out.println(minCount(coins));
  }

  public static int minCount(int[] coins) {
    int res=0;
    for(int i=0;i<coins.length;i++){
      res = coins[i]%2==0 ? res+ coins[i]/2 : res + coins[i]/2 + 1;
    }
    return res;
  }

}
