package htwz.tree;
/**
* @author: wy
* @createDate: 2020/3/27/027 0:10
* @descption 使用数组模拟顺序二叉树，左子树 2*n+1,右子树2*n+2,父节点n-1/2
* @version: 1.0.0
*/
public class SortBinaryTree {

    public static void main(String[] args) {
        int[] sortTree = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(sortTree);
        arrBinaryTree.preOrder(0);
    }
}

class ArrBinaryTree {

    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * index表示数组的下标
     * @param index
     */
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为null");
        }
        System.out.println(arr[index]);
        //向左递归
        if (index * 2 + 1 < arr.length) {
            preOrder(index * 2 + 1);
        }
        if (index * 2 + 2 < arr.length) {
            preOrder(index * 2 + 2);
        }

    }


}

