package htwz.leetcode.divideandconquer;

import java.util.Arrays;

/**
 * 1985. 找出数组中的第 K 大整数
 *
 * 对 string 进行排序，如果长度不相等，那么就比较长度，否则比较字符串大小
 *
 * @author wangyu
 * @since 2022/5/30 15:20
 */
public class Solution1985 {

    public static String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, ((o1, o2) -> {
            int len1 = o1.length(), len2 = o2.length();
            return len1 == len2 ? o1.compareTo(o2) : len1 - len2;
        }));
        return nums[nums.length - k] + "";
    }

    public static void main(String[] args) {
        //String[] nums = {"3","6","7","10"};
        String[] nums = {"2","21","12","1"};
        String number = kthLargestNumber(nums, 3);
        System.out.println(number);
    }


}
