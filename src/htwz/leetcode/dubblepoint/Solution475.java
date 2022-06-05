package htwz.leetcode.dubblepoint;

import java.util.Arrays;

/**
 * 475. 供暖器
 *
 * 思路：将供暖期进行排序，找到每个房子最近的一个供暖器，找到左右两边最短的距离，为当前供暖器可以供暖的距离。
 * 对于每个房子距离供暖器的最小距离的最大值，即为结果
 *
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 *
 * @author wangyu
 * @since 2022/6/5 11:34
 */
public class Solution475 {

    public static int findRadius(int[] houses, int[] heaters) {
        System.out.println("无用的提交");
        int ans = 0;
        Arrays.sort(heaters);
        for (int house : houses) {
            int i = bSearch(heaters, house);
            int j = i + 1;
            //房子左边供暖器的距离
            int leftDistance = i < 0 ? Integer.MAX_VALUE : house - heaters[i];
            //房子右边供暖器的距离
            int rightDistance = j >= heaters.length ? Integer.MAX_VALUE : heaters[j] - house;
            int curDistance = Math.min(leftDistance, rightDistance);
            ans = Math.max(ans, curDistance);
        }
        return ans;
    }

    private static int bSearch(int[] nums, int target) {
        int ans = -1;
        int left = 0, right = nums.length - 1;
        if (nums[left] > target) {
            return ans;
        }
        while (left <= right) {
            int mid = (right + left) >> 1;
            if (nums[mid] <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //int[] houses = {1,2,3}, heaters = {2};
        //int[] houses = {1,2,3,4}, heaters = {1,4};
        int[] houses = {1,5}, heaters = {2};
        int radius = findRadius(houses, heaters);
        System.out.println(radius);
    }

}
