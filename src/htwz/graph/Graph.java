package htwz.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Description:
 * @Author wangy
 * @Date 2020/8/8 12:39
 * @Version V1.0.0
 **/
public class Graph {

    //存储定点集合
    private ArrayList<String> vertexList;

    //存储图对应的领结矩阵
    private int[][] edges;

    //表示边的数目
    private int numOfEdges;

    private boolean[] isVisited;

    public static void main(String[] args) {
        int n = 5; //结点的个数
        String vertexValue[] = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);
        //循环的添加顶点
        for (String value: vertexValue) {
            graph.insertVertex(value);
        }
        //A-B A-C B-C B-D B-E
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        graph.showGraph();

        System.out.println("深度遍历");
        graph.dfs();

        System.out.println("广度遍历");
        //graph.bfs();

    }

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    //得到第一个领结结点的下标w
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //根据前一个领结结点的下标获取下一个领结结点
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 深度优先遍历算法
     * 1 第一次就是0
     */
    public void dfs(boolean[] isVisited, int i) {
        //首先我们访问该结点，输出
        System.out.println(getValueByIndex(i) + "->");
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            w = getNextNeighbor(i, w);
        }
    }

    //对dfs进行一个重载，遍历我们所有的结点，并进行dfs
    public void dfs() {
        //遍历所有的结点，进行dfs[回溯]
        for (int i = 0; i < getNumOfEdges(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    private void bfs(boolean[] isVisited, int i) {
        int u;//表示队列的头对应的下标
        int w;//领结结点w
        LinkedList queue = new LinkedList();
        System.out.println(getValueByIndex(i) + "=>");
        isVisited[i] = true;
        queue.addLast(i);
        while (!queue.isEmpty()) {
            u = (Integer) queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.println(getValueByIndex(w) + "=>");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                //以u为前驱结点，找w后面的下一个邻结点
                w = getNextNeighbor(u, w);
            }

        }
    }

    public void bfs() {
        for (int i = 0 ; i < getNumOfEdges() ; i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    /**
     * 返回结点的个数
     * @return
     */
    public int getNumOfEdges() {
        return vertexList.size();
    }

    //返回结点i（下标）对应的数据 0->A 1->B 2->C
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //显示图对应的矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    //插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //添加边
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
