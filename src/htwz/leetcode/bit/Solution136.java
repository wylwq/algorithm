package htwz.leetcode.bit;

/**
 * 136. 只出现一次的数字
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * @author wangyu
 * @since 2022/5/10 6:36
 */
public class Solution136 {

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        int number = singleNumber(nums);
        System.out.println(number);
    }

    //任意两个相同的数字异或等于0，所以只要出现偶数个数字进行异或结果一定为0
    //交换律：a ^ b ^ c <=> a ^ c ^ b
    //任何数于0异或为任何数 0 ^ n => n
    //相同的数异或为0: n ^ n => 0
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
}
