package htwz.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1640. 能否连接形成数组
 *
 * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，
 * 其中的整数也 互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 *
 * @author wangyu
 * @since 2022/6/1 12:06
 */
public class Solution1640 {

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> arrMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            arrMap.put(arr[i], i);
        }
        for(int[] piece : pieces) {
            if (piece.length == 1 && arrMap.get(piece[0]) == null) {
                return false;
            }
            for (int p = 0; p < piece.length - 1; p++) {
                Integer preIdx = arrMap.getOrDefault(piece[p], -1);
                Integer idx = arrMap.getOrDefault(piece[p + 1], -1);
                if (preIdx > idx || idx - preIdx != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //[1,2,3]
        //[[2],[1,3]]

        //[1,3,5,7]
        //[[2,4,6,8]]
//        int[] arr = {15,88};
//        int[][] pieces = {{88},{15}};
//        int[] arr = {1,2,3};
//        int[][] pieces = {{2},{1,3}};
        int[] arr = {91,4,64,78};
        int[][] pieces = {{78},{4,64},{91}};
        boolean formArray = canFormArray(arr, pieces);
        System.out.println(formArray);
    }
}
