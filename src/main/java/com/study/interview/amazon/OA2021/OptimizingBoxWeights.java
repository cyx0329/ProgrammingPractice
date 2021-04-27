package com.study.interview.amazon.OA2021;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class OptimizingBoxWeights {

    public static List<Integer> optimizingBoxWeights(List<Integer> arr) {
        // WRITE YOUR BRILLIANT CODE HERE
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.size() == 0) return result;
        int total_sum = getSum(arr);
        Collections.sort(arr);
        int index = 0;
        int sum = 0;
        while(index < arr.size() && sum * 2 <= total_sum) {
            sum += arr.get(index);
            index++;
        }

        for(int i = index-1; i < arr.size(); i++) {
            result.add(arr.get(i));
        }
        return result;
    }

    private static int getSum(List<Integer> arr) {
        int sum = 0;
        for(int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        List<Integer> res = optimizingBoxWeights(arr);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    /*
    An Amazon Fulfillment Associate has a set of items that need to be packed into two boxes. Given an integer array of
    the item weights (arr) to be packed, divide the item weights into two subsets, A and B, for packing into the
    associated boxes, while respecting the following conditions:
    The intersection of A and B is null.
    The union A and B is equal to the original array. The number of elements in subset Ais minimal.

    The sum of A's weights is greater than the sum of B's weights.
    Return the subset A in increasing order where the sum of A's weights is greater than the sum of B's weights.
    If more than one subset A exists, return the one with the maximal total weight.
    [5, 3, 2, 4, 1, 2] => [4,5]
     */

    /*
    Test #1:
    Input
    5 3 2 4 1 2
    Output
    4 5

    Test #2:
    Input
    10 5 3 1 20
    Output
    20

    Test #3:
    Input
    1 2 5 8 3
    Output
    5 8
     */
}

