package htwz.tuling;

/**
 * 使用双指针算法求出在一个排好序的数组中不重复元素的个数
 *
 * @author : wangyu
 * @since :  2021/9/28 7:28
 */
public class Solution4 {

    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 3, 4, 5};
        int count = solution(array);
        System.out.println(count);
    }

    private static int solution(int[] array) {
        int i = 0;
        for (int j = 1; j < array.length; j++) {
            if (array[j] != array[i]) {
                array[i++] = array[j];
            }
        }
        return i;
    }
}
