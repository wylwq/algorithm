package htwz.line.recursive;
/**
* @author: wy
* @createDate: 2020/3/11/011 7:13
* @descption 递归问题解决迷宫问题
* @version: 1.0.0
*/
public class Maze {

    /**
     * 说明，迷宫为8行7列的二维数组，入口为（1，1）,出口为（6，5）
     * 0,表示没有走过，1表示迷宫边界不能走，2表示可以走通，3表示该路走过，但是走不通
     */
    public static void main(String[] args) {
        int[][] maze = new int[8][7];
        //初始化迷宫
        for(int i = 0; i < maze[0].length; i++) {
            maze[0][i] = 1;
            maze[7][i] = 1;
        }
        for (int i = 0; i < maze.length; i++) {
            maze[i][0] = 1;
            maze[i][6] = 1;
        }
        maze[3][1] = 1;
        maze[3][2] = 1;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        //使用递归回溯来给小球找路
        setWay(maze, 1, 1);
        System.out.println("迷宫通路");
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 1.map表示地图
     * 2.走迷宫时，需要定义一个策略：下->右->上->左
     * @param map
     * @param i
     * @param j
     * @return
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWay(map, i+1, j)) {//向下走
                    return true;
                } else if (setWay(map, i, j+1)) {//向上走
                    return true;
                } else if (setWay(map, i-1, j)) {//向右走
                    return true;
                } else if (setWay(map, i, j-1)) {//向左走
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
