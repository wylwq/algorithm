package htwz.line.sparsearray;
/**
* @author: wy
* @createDate: 2019/12/24/024 17:03
* @descption 稀疏矩阵的压缩
* @version: 1.7.0
*/
public class SparseArray {

    public static void main(String[] args) {
        int [][] chess = new int[8][8];
        int flag = 0;
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                if (chess[i][j] == 1 || chess[i][j] == 2) {
                    flag ++;
                }
            }
        }
        //如果二位数组中的元素个数少于总个数的33%，则为稀疏矩阵
        boolean bool = ((float)flag * 3 / chess.length * chess.length) < 0.33;

        if (bool) {
            int [][] xishu = new int[flag + 1][3];
            xishu[0][0] = chess.length;
            xishu[0][1] = chess.length;
            xishu[0][2] = flag;
            int count = 1;
            for (int i = 0; i < chess.length; i++) {
                for (int j = 0; j < chess.length; j++) {
                    if (chess[i][j] == 1 || chess[i][j] == 2) {
                        xishu[count][0] = i;
                        xishu[count][1] = j;
                        xishu[count][2] = chess[i][j];
                        count++;
                    }
                }
            }
        } else {
            //返回原数组
        }
        //返回压缩后的矩阵
    }

}
