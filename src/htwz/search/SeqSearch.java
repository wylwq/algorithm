package htwz.search;
/**
* @author: wy
* @createDate: 2020/3/18/018 7:15
* @descption 线性查找
* @version: 1.0.0
*/
public class SeqSearch {

    public static void main(String[] args) {
        int[] arrays = {1, 9, 11, -1, 34, 89};
        int result = seqSearch(arrays, 11);
        System.out.println(result);
    }

    public static int seqSearch(int[] arr, int value) {
        for (int i =0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

}
