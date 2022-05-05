package htwz.sort;

/**
* @author: wy
* @createDate: 2020/3/16/016 7:34
* @descption 快速排序
* @version: 1.0.0
*/
public class QuickSort {

    public static void main(String[] args) {
        Integer[] arrays = new Integer[]{-9, 78, 0, 23, -567, 70};
        Integer[] sort = quickSort(arrays, 0, arrays.length - 1);
        for (int i = 0; i < sort.length; i++) {
            System.out.print(sort[i] + " ");
        }
    }

    private static Integer[] quickSort(Integer[] arr, int low, int high) {

        if (low < high) {
            int index = getIndex(arr, low, high);
            quickSort(arr, 0, index - 1);
            quickSort(arr, index + 1, high);
        }
        return arr;

    }

    private static int getIndex(Integer[] arr, int low, int high) {
        int tmp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            arr[high] = arr[low];

        }
        arr[low] = tmp;
        return low;
    }

}
