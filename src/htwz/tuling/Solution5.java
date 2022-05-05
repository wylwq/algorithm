package htwz.tuling;

import java.util.Arrays;

/**
 * 求出左右两边元素之和相同的中心元素下标
 *
 * @author : wangyu
 * @since :  2021/9/28 7:33
 */
public class Solution5 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 1, 5};
        int index = solution(array);
        System.out.println(index);
    }

    private static int solution(int[] array) {
        int sum = Arrays.stream(array).sum();
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            total = total + array[i];
            sum = sum - array[i];
            if (sum == total) {
                return i;
            }
        }
        return -1;
    }

}
