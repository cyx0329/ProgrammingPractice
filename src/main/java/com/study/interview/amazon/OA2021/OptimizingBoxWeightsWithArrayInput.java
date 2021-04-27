package com.study.interview.amazon.OA2021;

import java.util.Arrays;

public class OptimizingBoxWeightsWithArrayInput {

    public static int[] optimizingBoxWeights(int[] arr) {
        if(arr == null || arr.length == 0) return new int[0];
        long total_sum = getSum(arr);
        Arrays.sort(arr);
        int index = 0;
        long sum = 0;
        while(index < arr.length && sum * 2 <= total_sum) {
            sum += arr[index];
            System.out.println("sum:" + sum);
            index++;
        }
        System.out.println("index:" + index);

        int[] result = new int[arr.length - index + 1];
        int j = 0;
        for(int i = index - 1; i < arr.length; i++) {
            result[j++] = arr[i];
        }
        return result;
    }

    private static long getSum(int[] arr) {
        long sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 8, 3};
        int[] result = optimizingBoxWeights(arr);
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
