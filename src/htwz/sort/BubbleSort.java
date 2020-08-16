package htwz.sort;

/**
* @author: wy
* @createDate: 2020/3/13/013 13:59
* @descption
 * 优化后的冒泡排序算法,假如在一次排序中，没有一次发生位置交换，我们则认为这是有序的
* @version: 1.0.0
*/
public class BubbleSort {

    public static void main(String[] args) {
        Integer[] arrays = new Integer[]{1,3,2,5,4};
        Integer[] maopao = maopao(arrays);
        for (int i = 0; i < maopao.length; i++) {
            System.out.print(maopao[i] + " ");
        }
    }

    private static Integer[] maopao(Integer[] arrays) {
        Integer temp;
        for (int i = 0; i < arrays.length - 1; i++) {
            Boolean flag = false;
            for (int j = 0; j < arrays.length - 1 - i; j++) {
                if (arrays[j] > arrays[j+1]) {
                    temp = arrays[j];
                    arrays[j] = arrays[j+1];
                    arrays[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return arrays;
    }
}
