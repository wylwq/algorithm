package htwz.tree;

/**
* @author: wy
* @createDate: 2020/3/21/021 9:41
* @descption
* @version: 1.0.0
*/
public class BinaryTree {

    public static void main(String[] args) {
        Tree tree = new Tree();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.leftNode = node2;
        node1.rightNode = node3;
        node3.rightNode = node4;

        tree.setRoot(node1);

        /*System.out.println("前序遍历");
        tree.preOrder();
        System.out.println("中序遍历");
        tree.infixOrder();
        System.out.println("后序遍历");
        tree.suffixOrder();

        System.out.println("前序查找元素");
        tree.preOrderSearch(3);
        System.out.println("中序查找元素");
        tree.infixOrderSearch(3);
        System.out.println("后序查找元素");
        tree.suffixOrderSearch(3);*/


    }
}

class Tree {

    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void suffixOrder() {
        if (this.root != null) {
            this.root.suffixOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void preOrderSearch(int no) {
        if (this.root != null) {
            this.root.preOrderSearch(no);
        } else {
            System.out.println("未查找到该元素");
        }
    }

    public void infixOrderSearch(int no) {
        if (this.root != null) {
            this.root.infixOrderSearch(no);
        } else {
            System.out.println("未查找到该元素");
        }
    }

    public void suffixOrderSearch(int no) {
        if (this.root != null) {
            this.root.suffixOrderSearch(no);
        } else {
            System.out.println("未查找到该元素");
        }
    }

    public void delNode(int no) {
        if (root != null) {
            if (root.no == no) {
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("空树不能删除");
        }
    }
}


class Node {

    public int no;

    public Node leftNode;

    public Node rightNode;

    public Node(int no) {
        this.no = no;
    }


    public void delNode(int no) {
        if (this.leftNode != null && this.leftNode.no == no) {
            this.leftNode = null;
            return;
        }
        if (this.rightNode != null && this.rightNode.no == no) {
            this.rightNode = null;
            return;
        }
        if (this.leftNode != null) {
            this.leftNode.delNode(no);
        }
        if (this.rightNode != null) {
            this.rightNode.delNode(no);
        }
    }

    /**
     * 二叉树的先序遍历
     */
    public void preOrder() {
        System.out.println(this.no);
        if (this.leftNode != null) {
            this.leftNode.preOrder();
        }
        if (this.rightNode != null) {
            this.rightNode.preOrder();
        }
    }

    /**
     * 二叉树的中序遍历
     */
    public void infixOrder() {
        if (this.leftNode != null) {
            this.leftNode.infixOrder();
        }
        System.out.println(this.no);
        if (this.rightNode != null) {
            this.rightNode.infixOrder();
        }
    }

    /**
     * 二叉树的后序遍历
     */
    public void suffixOrder() {
        if (this.leftNode != null) {
            this.leftNode.suffixOrder();
        }
        if (this.rightNode != null) {
            this.rightNode.suffixOrder();
        }
        System.out.println(this.no);
    }

    /**
     * 前序查找
     */
    public  Node preOrderSearch(int no) {
        if (this.no == no) {
            return this;
        }
        Node node = null;
        if (this.leftNode != null) {
            node = this.leftNode.preOrderSearch(no);
        }
        if (node != null) {
            return node;
        }
        if (this.rightNode != null) {
            node = this.rightNode.preOrderSearch(no);
        }
        return node;
    }

    /**
     * 中序遍历
     * @param no
     * @return
     */
    public Node infixOrderSearch(int no) {
        Node node = null;
        if (this.leftNode != null) {
             node = this.leftNode.infixOrderSearch(no);
        }
        if (node != null) {
            return node;
        }
        if (this.no == no) {
            return node;
        }
        if (this.rightNode != null) {
            node = this.rightNode.infixOrderSearch(no);
        }
        return node;
    }

    /**
     * 后序遍历查找
     */
    public Node suffixOrderSearch(int no) {
        Node node = null;
        if (this.leftNode != null) {
            node = this.leftNode.suffixOrderSearch(no);
        }
        if (node != null) {
            return node;
        }
        if (this.rightNode != null) {
            node = this.rightNode.suffixOrderSearch(no);
        }
        if (node != null) {
            return node;
        }
        if (this.no == no) {
            return node;
        }
        return node;
    }

}
