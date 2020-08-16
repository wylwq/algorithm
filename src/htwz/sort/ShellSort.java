package htwz.sort;

/**
* @author: wy
* @createDate: 2020/3/15/015 12:36
* @descption 希尔排序（稳定性不好,弃用，请看ShellV2Sort）-交换法,因为会进行大量的交换，所以排序时间比简单排序还慢
* @version: 1.0.0
*/
public class ShellSort {

    public static void main(String[] args) {
        Integer[] arrays = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        Integer[] sort = shell(arrays);
        for (int i = 0; i < sort.length; i++) {
            System.out.print(sort[i] + " ");
        }
    }

    private static Integer[] shell(Integer[] arrays) {
        int group = arrays.length / 2;
        int temp;
        while (group > 0) {
            for (int i = group; i < arrays.length; i++) {
                for (int j = i - group; j>=0; j -= group) {
                    if (arrays[j] > arrays[j + group]) {
                        temp = arrays[j];
                        arrays[j] = arrays[j + group];
                        arrays[j + group] = temp;
                    }
                }
            }
            group /= 2;
        }
        return arrays;
    }

}
