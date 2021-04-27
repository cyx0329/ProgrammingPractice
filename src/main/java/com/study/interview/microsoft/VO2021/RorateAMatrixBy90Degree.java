package com.study.interview.microsoft.VO2021;

public class RorateAMatrixBy90Degree {

    public static void rotateMatrix90(int[][] matrix) {

        for(int i = 0; i < matrix.length; i++) {
            swap(matrix[i]);
        }

        swap(matrix);
    }

    private static void swap(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i+1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private static void swap(int[] array) {
        int i = 0;
        int j = array.length-1;
        while(i < j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };

        rotateMatrix90(matrix);

        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }

        int[][] matrix1 = { { 1, 2, 3, 4},
                { 5, 6, 7, 8},
                { 9, 0, 1, 2},
                { 3, 4, 5, 6}};

        rotateMatrix90(matrix1);

        for(int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                System.out.print(matrix1[i][j] + ",");
            }
            System.out.println();
        }
    }
}
