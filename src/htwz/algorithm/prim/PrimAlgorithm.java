package htwz.algorithm.prim;

import java.util.Arrays;

/**
 * @Description:
 * @Author wangy
 * @Date 2020/8/13 21:53
 * @Version V1.0.0
 **/
public class PrimAlgorithm {

    public static void main(String[] args) {
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        int[][] weight = {
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}
        };
        MGgrah mGgrah = new MGgrah(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(mGgrah, verxs, data, weight);
        minTree.showGraph(mGgrah);
        minTree.prim(mGgrah, 0);
    }


}

class MinTree {

    /**
     * 创建最小生成树
     * @param ggrah
     * @param verxs
     * @param data
     * @param weight
     */
    public void createGraph(MGgrah ggrah, int verxs, char data[], int[][] weight) {
        int i, j;
        for (i = 0; i < verxs; i++) {
            ggrah.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                ggrah.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph(MGgrah mGgrah) {
        for (int[] link : mGgrah.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 编写prim算法,得到最小生成树
     * @param mGgrah 图
     * @param v 表示从图的第几个顶点开始生成
     */
    public void prim(MGgrah mGgrah, int v) {
        //标记节点是否被访问过，默认元素都为0表示都没有被访问过
        int[] visited = new int[mGgrah.verxs];
        //把当前节点标记为已访问
        visited[v] = 1;
        //h1和h2记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;
        for (int k = 1; k < mGgrah.verxs; k++) {
            for (int i = 0; i < mGgrah.verxs; i++) {
                for (int j = 0; j < mGgrah.verxs; j++) {
                    if (visited[i] == 1 && visited[j] == 0 && mGgrah.weight[i][j] < minWeight) {
                        minWeight = mGgrah.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //找到一条边最小
            System.out.println("边<" + mGgrah.data[h1] + "," + mGgrah.data[h2] + ">权值：" + minWeight);
            visited[h2] = 1;
            minWeight = 10000;
        }

    }

}

class MGgrah {

    //表示图的节点个数
    int verxs;

    //存放节点数据
    char[] data;

    //存放便，就是我们的领接矩阵
    int[][] weight;

    public MGgrah(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }

}
