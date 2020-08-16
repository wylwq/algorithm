package htwz.tree;

/**
 * @Description: 二叉排序树的创建和遍历
 * @Author wangy
 * @Date 2020/7/29 7:26
 * @Version V1.0.0
 **/
public class BinarySortTree {

    public static void main(String[] args) {

        int[] arr = {7, 3, 10,12, 5, 1, 9};
        BSTree bsTree = new BSTree();
        for (int i = 0; i < arr.length; i++) {
            bsTree.add(new Node1(arr[i]));
        }
        bsTree.infixOrder();

    }



}

class BSTree {

    private Node1 root;

    public void add(Node1 node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (root == null) {
            return;
        }
        root.infixOrder();
    }
}

class Node1 {

    Integer value;

    Node1 left;

    Node1 right;

    public Node1(int value) {
        this.value = value;
    }

    public void add(Node1 node) {
        if (node == null) {
            return;
        }

        //判断传入的结点的值，和当前节点子树节点的关系
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this.value);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

}
