package com.study.interview.amazon.OA2021;

import java.util.*;
import java.util.stream.Collectors;

public class StorageOptimizationWithArrayInput {

    public static int storageOptimization(int n, int m, int[] h, int[] v) {
        // WRITE YOUR BRILLIANT CODE HERE
        System.out.println(getMax(n+1, h));
        System.out.println(getMax(m+1, v));
        return getMax(n+1, h) * getMax(m+1, v) * 1;
    }

    private static int getMax(int size, int[] arr) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 1; i < size; i++) {
            set.add(i);
        }
        for(int i = 0; i < arr.length; i++) {
            set.remove(arr[i]);
        }
        int set_size = set.size();
        if(set_size == 0) return size;
        int[] array = new int[set_size];
        int count = 0;
        for(Integer element : set) {
            array[count++] = element;
        }
        Arrays.sort(array);
        int max = array[0];
        for(int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i] - array[i - 1]);
        }
        return Math.max(max, size - array[array.length - 1]);
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 2;
        int[] h = {1, 2, 3};
        int[] v = {1, 2};
        System.out.println(storageOptimization(n, m, h, v));
    }
}
