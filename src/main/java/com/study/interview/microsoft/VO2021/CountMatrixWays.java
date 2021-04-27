package com.study.interview.microsoft.VO2021;

public class CountMatrixWays {

    private static int[] deltaX = {1, -1, 0 , 0};
    private static int[] deltaY = {0, 0, 1, -1};
    public static int count = 0;

    public static int matrixWays(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        dfs(matrix, 0, 0, visited);
        return count;
    }

    private static void dfs(int[][] matrix, int x, int y, boolean[][] visited) {

        if(matrix[x][y] == -1) {
            count++;
            return;
        }

        for(int i = 0; i < 4; i++) {
            int new_x = x + deltaX[i];
            int new_y = y + deltaY[i];
            if(isValid(matrix, new_x, new_y, visited)) {
                visited[new_x][new_y] = true;
                dfs(matrix, new_x, new_y, visited);
                visited[new_x][new_y] = false;
            }
        }
    }

    private static boolean isValid(int[][] matrix, int i, int j, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || visited[i][j] || matrix[i][j] == 1) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        //int[][] matrix = {{0, 0, 0}, {1, 0, 0}, {0, 1, -1}};
        //int result = matrixWays(matrix);
        //System.out.println(result);

        int[][] matrix1 = {{0, 0, 0}, {-1, 0, 0}, {0, 1, 1}};
        int result1 = matrixWays(matrix1);
        System.out.println(result1);
    }

}
