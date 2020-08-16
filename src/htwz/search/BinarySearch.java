package htwz.search;

import java.util.ArrayList;
import java.util.List;

/**
* @author: wy
* @createDate: 2020/3/18/018 7:19
* @descption 二分查找，前提要求数组有序
* @version: 1.0.0
*/
public class BinarySearch {

    public static void main(String[] args) {
        int[] arrays = {1, 8, 10, 89, 89, 1000, 1234};
        int result = binarySearch(arrays, 0, arrays.length - 1, 89);
        System.out.println(result);
        List<Integer> res = binarySearchV2(arrays, 0, arrays.length - 1, 89);
        System.out.println(res.size());

    }

    /**
     *
     * @param arrays 数组
     * @param left 左边的索引
     * @param right 右边的索引
     * @param finalVal 需要查找的值
     * @return
     */
    public static int binarySearch(int[] arrays, int left, int right, int finalVal) {
        int mid = (left + right) / 2;
        int midVal = arrays[mid];
        if (left > right) {
            return -1;
        }
        if (finalVal > midVal) {
            return binarySearch(arrays, mid + 1, right, finalVal);
        } else if (finalVal < midVal) {
            return binarySearch(arrays, left, mid - 1, finalVal);
        } else {
            return mid;
        }
    }

    /**
     * 查找满足条件的所有值，
     * @param arrays
     * @param left
     * @param right
     * @param finalVal
     * @return
     */
    public static List<Integer> binarySearchV2(int[] arrays, int left, int right, int finalVal) {
        int mid = (left + right) / 2;
        int midVal = arrays[mid];
        if (left > right) {
            return new ArrayList<>();
        }
        if (finalVal > midVal) {
            return binarySearchV2(arrays, mid + 1, right, finalVal);
        } else if (finalVal < midVal) {
            return binarySearchV2(arrays, left, mid - 1, finalVal);
        } else {
            List<Integer> res = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arrays[temp] != finalVal) {
                    break;
                }
                res.add(temp);
                temp -= 1;
            }
            temp = mid + 1;
            while (true) {
                if (temp > arrays.length - 1 || arrays[temp] != finalVal) {
                    break;
                }
                res.add(temp);
                temp += 1;
            }
            res.add(mid);
            return res;
        }
    }


}
