package com.leetcode.matrix;

/**
 * @author HDU-AIOT-WuHD
 * @date 2024-05-03 9:45
 **/
public class MatrixLearn {

    /**
     * 有效的数独
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] box = new int[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';

                if(row[i][num] != 0) return false;
                if(col[j][num] != 0) return false;
                if(box[j/3 + (i/3)*3][num] != 0) return false;

                row[i][num] = 1;
                col[j][num] = 1;
                box[j/3 + (i/3)*3][num] =1;
            }
        }
        return true;
    }
}
