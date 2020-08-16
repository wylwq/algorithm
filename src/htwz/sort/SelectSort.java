package htwz.sort;
/**
* @author: wy
* @createDate: 2020/3/13/013 21:15
* @descption 选择排序，选择排序算法优于冒泡排序
* @version: 1.0.0
*/
public class SelectSort {

    public static void main(String[] args) {
        Integer[] arrays = {1,3,2,5,4};
        Integer[] sort = select(arrays);
        for (int i = 0; i < sort.length; i++) {
            System.out.print(sort[i] + " ");
        }
    }

    private static Integer[] select(Integer[] arrays) {
        for (int i = 0; i < arrays.length - 1; i++) {
            Integer temp;
            for (int j = i + 1; j < arrays.length; j++) {
                if (arrays[i] > arrays[j]) {
                    temp = arrays[i];
                    arrays[i] = arrays[j];
                    arrays[j] = temp;
                }
            }
        }
        return arrays;
    }
}
