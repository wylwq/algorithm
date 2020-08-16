package htwz.sort;
/**
* @author: wy
* @createDate: 2020/3/15/015 13:41
* @descption 希尔排序->移动法,思想：采用希尔加简单插入排序实现
* @version: 1.0.0
*/
public class ShellV2Sort {

    public static void main(String[] args) {
        Integer[] arrays = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        Integer[] sort = shellV2(arrays);
        for (int i = 0; i < sort.length; i++) {
            System.out.print(sort[i] + " ");
        }
    }

    private static Integer[] shellV2(Integer[] arrays) {
        for (int gap = arrays.length/2 ; gap > 0; gap /=2) {
            for (int i = gap; i < arrays.length; i++) {
                int j = i;
                int temp = arrays[j];
                if (arrays[j] < arrays[j - gap]) {
                    while (j - gap>= 0 && arrays[j - gap] > temp) {
                        arrays[j] = arrays[j - gap];
                        j -= gap;
                    }
                    arrays[j] = temp;
                }
            }
        }
        return arrays;
    }
}
