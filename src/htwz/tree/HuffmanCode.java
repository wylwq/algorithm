package htwz.tree;

import java.util.*;

/**
 * @author: wy
 * @createDate: 2020/3/31/031 7:21
 * @descption
 * @version: 1.0.0
 */
public class HuffmanCode {

    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        byte[] bytes = str.getBytes();
        List<NodeCode> nodes = getNodes(bytes);
        //创建huffman树
        NodeCode huffmanTree = createHuffmanTree(nodes);
        //生成huffman编码
        huffmanCode(huffmanTree);
        System.out.println(map.toString());
        //压缩处理
        byte[] zip = zip(bytes, map);
        System.out.println(Arrays.toString(zip));
        //解压缩处理
        String result = unzip(zip, map);
        System.out.println("解压结果如下：" + result);
    }

    private static StringBuilder unzipString = new StringBuilder();

    private static String unzip(byte[] bytes, Map<Byte, String> map) {
        for (int i = 0; i < bytes.length; i++) {
            boolean flag = false;
            if (i == bytes.length - 1) {
                flag = true;
            }
            unzipString.append(zipToString(flag, bytes[i]));
        }
        System.out.println("解压后的二进制字符串如下：" + unzipString);
        //将map的key和value进行互换操作，方便根据编码前缀查找对应字符
        Map<String, Byte> reverseMap = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Byte, String> m : map.entrySet()) {
            reverseMap.put(m.getValue(), m.getKey());
        }
        for (int i = 0; i < unzipString.length();) {
            int count = 0;
            boolean flag = true;
            while (flag) {
                String substring = unzipString.substring(i, i + count);
                if (reverseMap.containsKey(substring)) {
                    result.append((char) ((byte)reverseMap.get(substring)));
                    i += count;
                    flag = false;
                }
                count++;
            }
        }
        return result.toString();
    }

    private static String zipToString(boolean flag, byte b) {
        int temp = b;
        if (!flag) {
            //将temp和256进行或操作，256对应的二进制编码为1 0000 0000
            temp |= 256;
        }
        String binaryString = Integer.toBinaryString(temp);
        if (!flag) {
            return binaryString.substring(binaryString.length() - 8);
        }
        return binaryString;
    }

    private static Map<Byte, String> map = new HashMap<>();

    private static StringBuffer stringBuffer = new StringBuffer();


    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        //1.利用buffman编码将bytes转换为赫夫曼编码对应的字符串
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bytes) {
            stringBuffer.append(huffmanCodes.get(b));
        }
        System.out.println("压缩后的二进制字符串：" + stringBuffer.toString());
        //统计返回的bytes数组的huffman长度
        int len = (stringBuffer.length() + 7) / 8;
        byte[] b = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuffer.length(); i+= 8) {
            String sb;
            if (i+8 > stringBuffer.length()) {
                sb = stringBuffer.substring(i);
            } else {
                sb = stringBuffer.substring(i, i+8);
            }
            b[index++] = (byte) Integer.parseInt(sb, 2);
        }
        return b;
    }

    private static void huffmanCode(NodeCode huffmanTree) {
        huffmanCode(stringBuffer, "", huffmanTree);
    }

    private static void huffmanCode(StringBuffer stringBuffer1, String code, NodeCode huffmanTree) {
        StringBuffer sb = new StringBuffer(stringBuffer1);
        sb.append(code);
        if (huffmanTree != null) {
            if (huffmanTree.data == null) {
                huffmanCode(sb, "0", huffmanTree.left);
                huffmanCode(sb, "1", huffmanTree.right);
            } else {
                map.put(huffmanTree.data, sb.toString());
            }
        }
    }

    private static List<NodeCode> getNodes(byte[] bytes) {
        List<NodeCode> nodes = new ArrayList<>();
        Map<Byte, Integer> map = new HashMap<>();
        for (byte b : bytes) {
            Integer integer = map.computeIfAbsent(b, k -> 0);
            map.put(b, integer + 1);
        }
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            nodes.add(new NodeCode(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    private static NodeCode createHuffmanTree(List<NodeCode> nodeCodes) {
        while (nodeCodes.size() > 1) {
            Collections.sort(nodeCodes);
            NodeCode left = nodeCodes.get(0);
            NodeCode right = nodeCodes.get(1);
            NodeCode root = new NodeCode(null, left.weight + right.weight);
            root.left = left;
            root.right = right;
            nodeCodes.remove(left);
            nodeCodes.remove(right);
            nodeCodes.add(root);
        }
        return nodeCodes.get(0);
    }

    private static void preNode(NodeCode nodeCode) {
        if (nodeCode == null) {
            System.out.println("树为null");
        } else {
            nodeCode.preOrder();
        }
    }

}

//创建Node,带数据和权值
class NodeCode implements Comparable<NodeCode>{

    public Byte data;

    public int weight;

    NodeCode left;

    NodeCode right;

    public NodeCode(Byte data, Integer weight) {
        this.data = data;
        this.weight = weight;
    }

    public NodeCode(NodeCode left, NodeCode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(NodeCode o) {
        return this.weight - o.weight;
    }

    public void preOrder() {
        System.out.println(this.data);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}