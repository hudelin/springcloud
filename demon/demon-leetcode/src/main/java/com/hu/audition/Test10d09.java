package com.hu.audition;

/**
 * @author hudelin
 * @date 2021/1/6
 */
public class Test10d09 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(searchMatrix(matrix,5));
        System.out.println(searchMatrix(matrix,20));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int x = matrix.length-1;
        int y = 0;
        while(x>=0 && x<=matrix.length-1 && y>=0 && y<=matrix[0].length-1){
            if(target > matrix[x][y]){
                y++;
                continue;
            }
            if(target < matrix[x][y]){
                x--;
                continue;
            }
            if(target == matrix[x][y]){
                return true;
            }
        }
        return false;
    }
}
