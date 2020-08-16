package htwz.sort;
/**
* @author: wy
* @createDate: 2020/3/14/014 10:53
* @descption 简单插入排序
* @version: 1.0.0
*/
public class InsertSort {

    public static void main(String[] args) {
        Integer[] arrays = {3, 1, 7, 5, 4, 2};
        Integer[] sort = insertSort(arrays);
        for (int i = 0; i < sort.length; i++) {
            System.out.print(sort[i] + " ");
        }
    }

    private static Integer[] insertSort(Integer[] arrays) {
        for (int i = 1; i < arrays.length; i++) {
            int temp = arrays[i];
            int index = i - 1;
            while (index >= 0 && arrays[index] > arrays[i]) {
                arrays[i] = arrays[index];
                arrays[index] = temp;
                index --;
                i--;
            }
        }
        return arrays;
    }
}
