package com.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

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


    /**
     * 矩阵置零
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] rowArr = new int[row];
        int[] colArr = new int[col];
        for(int i = 0;i<row;i++) {
            for(int j = 0;j<col;j++) {
                if(matrix[i][j] == 0) {
                    rowArr[i] = 1;
                    colArr[j] = 1;
                }
            }
        }

        for(int i = 0;i<row;i++) {
            for(int j = 0;j<col;j++) {
                if(rowArr[i] == 1 || colArr[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 旋转图像
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        List<List<Integer>> lists = new ArrayList<>();
        int top = 0;
        int buttom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length-1;

        while(left <= right && top <= buttom) {
            List<Integer> list = new ArrayList<>();
            for(int i = left;i<=right;i++) {
                list.add(matrix[top][i]);
            }
            top++;
            if(top > buttom) {
                lists.add(list);
                break;
            }


            for(int i = top;i<=buttom;i++) {
                list.add(matrix[i][right]);
            }
            right--;

            if(left > right)  {
                lists.add(list);
                break;
            }

            for (int i = right;i>=left;i--) {
                list.add(matrix[buttom][i]);
            }
            buttom--;
            if(top > buttom)  {
                lists.add(list);
                break;
            }
            for(int i = buttom;i>=top;i--) {
                list.add(matrix[i][left]);
            }
            left++;
            if(left > right)  {
                lists.add(list);
                break;
            }

            lists.add(list);
        }

        int index = 0;
        top = 0;
        buttom = matrix.length - 1;
        left = 0;
        right = matrix[0].length-1;

        while(left <= right && top <= buttom) {
            List<Integer> list = lists.get(index);
            int ind = 0;
            for(int i = top;i<=buttom;i++) {
                matrix[i][right] = list.get(ind);
                ind++;
            }
            right--;
            if(left > right) break;

            for(int i = right;i>=left;i--) {
                matrix[buttom][i] = list.get(ind);
                ind++;
            }
            buttom--;
            if(top > buttom) break;

            for(int i = buttom;i>=top;i--) {
                matrix[i][left] = list.get(ind);
                ind++;
            }
            left++;
            if(left > right) break;

            for(int i = left;i<=right;i++) {
                matrix[top][i] = list.get(ind);
                ind++;
            }
            top++;
            if(top > buttom) break;
            index++;
        }
    }

    /**
     * 生命游戏
     * @param board
     */
    public void gameOfLife(int[][] board) {

        int row = board.length;
        int col = board[0].length;

        int[][] arr = new int[row][col];
        int[] xrr = new int[]{1,1,0,0,-1,-1,1,-1};
        int[] yrr = new int[]{-1,1,1,-1,1,-1,0,0};
        for(int i = 0;i<row;i++) {
            for(int j = 0;j<col;j++) {
                int cnt = 0;
                for(int k = 0;k<8;k++) {
                    int curX = i+xrr[k];
                    int curY = j+yrr[k];
                    if(curY<0 || curY>=col || curX < 0 || curX >= row) {
                        continue;
                    }
                    if(board[curX][curY] == 1) {
                        cnt++;
                    }
                }

                if(cnt < 2 || cnt >3 || (cnt==2 && board[i][j] == 0)) {
                    arr[i][j] = 0;
                }else{
                    arr[i][j] = 1;
                }
            }
        }

        for(int i = 0;i<row;i++) {
            for(int j = 0;j<col;j++) {
                board[i][j] = arr[i][j];
            }
        }
    }
}


