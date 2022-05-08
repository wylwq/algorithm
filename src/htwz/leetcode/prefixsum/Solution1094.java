package htwz.leetcode.prefixsum;

/**
 * 1094. 拼车
 *
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 * 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
 *
 * @author wangyu
 * @since 2022/5/8 21:09
 */
public class Solution1094 {

    public static void main(String[] args) {
        int[][] trips = {{2,1,5}, {3,3,7}};
        int capacity = 4;
        boolean pooling = carPooling(trips, capacity);
        System.out.println(pooling);
    }

    public static boolean carPooling(int[][] trips, int capacity) {
        int[] numPassengersi = new int[1001];
        int sum = 0;
        for (int i = 0; i < trips.length; i++) {
            int num = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];
            numPassengersi[from] += num;
            numPassengersi[to] -= num;
        }

        for (int i = 0; i < 1000; i++) {
            sum += numPassengersi[i];
            if (sum > capacity) {
                return false;
            }
        }
        return true;
    }
}
