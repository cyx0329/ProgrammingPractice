package com.study.interview.microsoft.VO2021;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class RotateAMatrixBy180Degree {

    public static void rotateMatrix(int[][] matrix) {

        for(int i = 0; i < matrix.length; i++) {
            swap(matrix[i]);
        }

        swap(matrix);
    }

    private static void swap(int[][] matrix) {
        int i = 0;
        int j = matrix.length-1;
        while(i < j) {
            int[] temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
            i++;
            j--;
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

        rotateMatrix(matrix);

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

        rotateMatrix(matrix1);

        for(int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                System.out.print(matrix1[i][j] + ",");
            }
            System.out.println();
        }
    }
}
