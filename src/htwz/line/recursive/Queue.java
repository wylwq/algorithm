package htwz.line.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @author: wy
* @createDate: 2020/3/11/011 22:05
* @descption  递归解决八皇后问题
* @version: 1.0.0
*/
public class Queue {

}

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> r = new ArrayList<>();
        char[][] board = new char[n][n];
        init(board);
        helper(r, board, 0);
        return r;
    }

    private void init(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }
    }

    private void helper(List<List<String>> r, char[][] board, int rowIndex) {
        if (rowIndex == board.length) {
            r.add(generate(board));
        }

        for (int colIndex = 0; colIndex < board.length; colIndex++) {
            if (isValid(board, rowIndex, colIndex)) {
                board[rowIndex][colIndex] = 'Q';
                helper(r, board, rowIndex + 1);
                board[rowIndex][colIndex] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int rowIndex, int colIndex) {
        for (int i = 0; i < rowIndex; i++) {
            if (board[i][colIndex] == 'Q') return false;
        }

        for (int i = rowIndex - 1, j = colIndex - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = rowIndex - 1, j = colIndex + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    private List<String> generate(char[][] board) {
        List<String> list = new ArrayList<>();
        for(char[] row : board) {
            StringBuffer sb = new StringBuffer();
            for(char c : row) {
                sb.append(c);
            }
            list.add(sb.toString());
        }
        return list;
    }
}