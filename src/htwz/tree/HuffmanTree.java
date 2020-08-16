package htwz.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* @author: wy
* @createDate: 2020/3/29/029 9:15
* @descption 哈夫曼树
* @version: 1.0.0
*/
public class HuffmanTree {

    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        List<HNode> huffmanTree = createHuffmanTree(arr);
    }

    /**
     * 创建赫夫曼树
     * @param arr
     * @return
     */
    public static List<HNode> createHuffmanTree(int[] arr) {
        List<HNode> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new HNode(value));
        }
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            HNode left = nodes.get(0);
            HNode right = nodes.get(1);
            HNode parent = new HNode(left.value + right.value);
            parent.left = left;
            parent.right = right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes;
    }
}

class HNode implements Comparable<HNode> {

    public int value;

    public HNode left;

    public HNode right;

    public HNode(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(HNode o) {
        return this.value - o.value;
    }
}
