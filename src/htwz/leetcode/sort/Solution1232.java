package htwz.leetcode.sort;

/**
 * 1232. 缀点成线
 *
 * 给定一个数组 coordinates ，
 * 其中 coordinates[i] = [x, y] ， [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上。
 *
 * @author wangyu
 * @since 2022/9/3 23:14
 */
public class Solution1232 {

  public static void main(String[] args) {
    int[][] coordinates = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
    System.out.println(checkStraightLine(coordinates));
  }

  public static boolean checkStraightLine(int[][] coordinates) {
    int m = coordinates.length;
    if (m <= 2) {
      return true;
    }
    int x1 = coordinates[1][0] - coordinates[0][0];
    int y1 = coordinates[1][1] - coordinates[0][1];
    for(int i = 2; i < m; i++){
      int x2 = coordinates[i][0] - coordinates[0][0];
      int y2 = coordinates[i][1] - coordinates[0][1];
      if (x1 * y2 != x2 * y1) {
        return false;
      }
    }
    return true;
  }

}
