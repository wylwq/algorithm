package htwz.leetcode.matrix;

/**
 * 832. 翻转图像
 *
 * 给定一个 n x n 的二进制矩阵 image ，先 水平 翻转图像，然后 反转 图像并返回 结果 。
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。
 * 例如，水平翻转 [1,1,0] 的结果是 [0,1,1]。
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。
 * 例如，反转 [0,1,1] 的结果是 [1,0,0]。
 *
 * @author wangyu
 * @since 2022/5/11 7:49
 *
 */
public class Solution832 {

    public static void main(String[] args) {
        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
        int[][] ints = flipAndInvertImage(image);
        prinf(ints);
    }

    private static void prinf(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.printf("%d\t", mat[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] flipAndInvertImage(int[][] image) {
        int row = image.length, col = image[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <(col >> 1); j++) {
                int tmp = image[i][j];
                image[i][j] = image[i][col - j - 1];
                image[i][col - j - 1] = tmp;
            }
            for (int j = 0; j < col; j++) {
                image[i][j] = image[i][j] ^ 1;
            }
        }
        return image;
    }
}