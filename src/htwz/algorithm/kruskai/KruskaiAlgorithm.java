package htwz.algorithm.kruskai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author wangy
 * @Date 2020/8/15 16:12
 * @Version V1.0.0
 **/
public class KruskaiAlgorithm {

    //边的个数
    private int edgeNum;

    //顶点数组
    private char[] vertexs;

    //领结矩阵
    private int[][] matrix;

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F','G'};
        int matrix[][] = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}
        };
        //创建Kruskai对象实例
        KruskaiAlgorithm kruskaiAlgorithm = new KruskaiAlgorithm(vertexs, matrix);
        kruskaiAlgorithm.print();
        List<EData> edeges = kruskaiAlgorithm.getEdeges();
        Collections.sort(edeges);
        for (EData eData : edeges) {
            System.out.println(eData);
        }
        kruskaiAlgorithm.kruskai();
    }

    public KruskaiAlgorithm(char[] vertexs, int[][] matrix) {
        int vlen = vertexs.length;

        this.vertexs = new char[vlen];

        for (int i = 0; i < vertexs.length; i++) {
            this.vertexs[i] = vertexs[i];
        }

        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }

        //统计边
        for (int i = 0; i < vlen; i++) {
            for (int j = i + 1; j < vlen; j++) {
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    public void print() {
        System.out.println("领结矩阵为：\n");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%12d\t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 返回顶点对应的下标值
     * @param ch
     * @return
     */
    private int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取图中的边，放入到EDATA数组中，后面我们需要遍历数组
     * @return
     */
    private List<EData> getEdeges() {
        List<EData> eData = new ArrayList<>();
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    eData.add(new EData(vertexs[i], vertexs[j], matrix[i][j]));
                }
            }
        }
        return eData;
    }

    /**
     * 获取下标为i的终点，用户后面判断两个顶点的终点是否相同
     * @param ends
     * @param i
     * @return 返回的就是下标为i的这个顶点对应终点的下标
     */
    private int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    public void kruskai() {
        int index = 0;
        int[] ends = new int[edgeNum];
        //创建结果数组，保存最小生成树
        EData[] rets = new EData[edgeNum];
        List<EData> edeges = getEdeges();
        Collections.sort(edeges);
        //遍历edegs集合，将边添加到最小生成树中，判断是否加入的边形成回路，如果没有就加入到rets中
        for (int i = 0; i < edgeNum; i++) {
            int p1 = getPosition(edeges.get(i).start);
            int p2 = getPosition(edeges.get(i).end);
            int end = getEnd(ends, p1);
            int end2 = getEnd(ends, p2);
            if (end != end2) {
                ends[end] = end2;
                rets[index++] = edeges.get(i);
            }
        }
        for (EData eData : rets) {
            System.out.println(eData);
        }
    }
}

class EData implements Comparable<EData>{
    //边的一个点
    char start;

    //边的另一个点
    char end;

    int weight;

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "start " + start + " end " + end + " weight " + weight;
    }

    @Override
    public int compareTo(EData eData) {
        return this.weight - eData.weight;
    }


}
