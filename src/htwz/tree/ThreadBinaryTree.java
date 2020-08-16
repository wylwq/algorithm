package htwz.tree;

/**
* @author: wy
* @createDate: 2020/3/27/027 21:09
* @descption
* @version: 1.0.0
*/
public class ThreadBinaryTree {

    public static void main(String[] args) {
        NodeThread nodeThread = new NodeThread(1);
        NodeThread nodeThread1 = new NodeThread(2);
        NodeThread nodeThread2 = new NodeThread(3);
        nodeThread.leftNode = nodeThread1;
        nodeThread.rightNode = nodeThread2;
        TreeThread treeThread = new TreeThread();
        treeThread.setRoot(nodeThread);
        treeThread.threadedNodes(nodeThread);
    }
}

class TreeThread {

    private NodeThread root;

    public void setRoot(NodeThread root) {
        this.root = root;
    }

    //为了实现线索化，需要创建一个指向当前节点的前驱节点
    private NodeThread pre = null;

    /**
     * 中序线索化节点
     * @param node
     */
    public void threadedNodes(NodeThread node) {
        if (node == null) {
            return;
        }

        //先线索化左节点
        threadedNodes(node.leftNode);
        //线索化当前节点
        if (node.leftNode == null) {
            node.leftNode = pre;
            //修改当前节点左指针的类型
            node.leftType = 1;
        }
        if (pre != null && pre.rightNode == null) {
            pre.rightNode = node;
            pre.rightType = 1;
        }

        pre = node;
        //线索化右节点
        threadedNodes(node.rightNode);
    }

    //遍历线索化二叉树的方法
    public void threadedList(NodeThread nodeThread) {
        //定义一个变量，存储当前遍历的节点，从root开始
        NodeThread node = root;
        while (node != null) {
            while (node.leftType == 0) {
                node = node.leftNode;
            }
            System.out.println(node.no);
            while (node.rightType == 1) {
                node = node.rightNode;
                System.out.println(node.no);
            }
            node = node.rightNode;
        }
    }
}

class NodeThread {

    public int no;

    public NodeThread leftNode;

    public NodeThread rightNode;

    /**
     * 如果leftType == 0表示指向的是左子树，如果是1则表示指向前驱节点
     * 如果rightType == 0表示指向右边子树，如果是1则表示指向后续节点
     */
    public int leftType;

    public int rightType;

    public NodeThread(int no) {
        this.no = no;
    }

}



