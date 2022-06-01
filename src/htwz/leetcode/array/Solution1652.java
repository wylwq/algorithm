package htwz.leetcode.array;

/**
 * 1652. 拆炸弹
 *
 * 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。
 * 为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。
 * 如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
 * 如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
 * 如果 k == 0 ，将第 i 个数字用 0 替换。
 * 由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。
 * 给你 循环 数组 code 和整数密钥 k ，请你返回解密后的结果来拆除炸弹！
 *
 * @author wangyu
 * @since 2022/6/1 10:20
 */
public class Solution1652 {

    public static int[] decrypt(int[] code, int k) {
        int len = code.length;
        int absK = Math.abs(k);
        int[] ans = new int[len];
        if (k == 0) {
            return ans;
        }
        for (int i = 0; i < len; i++) {
            int start = k > 0 ? (i + 1) % len : (i + k + len) % len;
            int count = 0, sum = 0;
            while (count < absK) {
                sum += code[start];
                start = (start + 1) % len;
                count++;
            }
            ans[i] = sum;
        }
        return ans;
    }

    public static void main(String[] args) {
        //int[] code = {5,7,1,4};
        //int k = 3;
        int[] code = {2,4,9,3};
        int k = -2;
        int[] decrypt = decrypt(code, k);
        for (int i = 0; i < decrypt.length; i++) {
            System.out.printf("%d\t", decrypt[i]);
        }
    }
}
