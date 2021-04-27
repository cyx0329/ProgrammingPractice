package com.study.interview.amazon.OA2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AlgorithmSwap {

    public static int numberOfSwapsToSort(List<Integer> nums) {
        // WRITE YOUR BRILLIANT CODE HERE
        /*
        int count = 0;
        for(int i = 0; i < nums.size() - 1; i++) {
            for(int j = i+1; j < nums.size(); j++) {
                if(nums.get(i) > nums.get(j)) {
                    count++;
                }
            }
        }
        return count;
        */

        return mergeSort(nums, 0, nums.size() - 1);
    }

    private static int mergeSort(List<Integer> nums, int lo, int hi) {
        int count = 0;
        if(lo < hi) {
            int mid = lo + (hi - lo)/2;
            count += mergeSort(nums, lo, mid);
            count += mergeSort(nums, mid+1, hi);
            count += merge(nums, lo, mid, hi);
        }
        return count;
    }

    private static int merge(List<Integer> nums, int lo, int mid, int hi) {
        int n1 = mid - lo + 1;
        int n2 = hi - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i = 0; i < n1; i++) {
            L[i] = nums.get(lo+i);
        }

        for(int i = 0; i < n2; i++) {
            R[i] = nums.get(mid+1+i);
        }

        int i = 0, j = 0;
        int k = lo;
        int count = 0;
        while(i < n1 && j < n2) {
            if(L[i] <= R[j]) {
                nums.set(k, L[i]);
                i++;
            } else {
                count += (mid+1) - (lo+i);
                nums.set(k, R[j]);
                j++;
            }
            k++;
        }

        while(i < n1) {
            nums.set(k, L[i]);
            i++;
            k++;
        }

        while(j < n2) {
            nums.set(k, R[j]);
            j++;
            k++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        int res = numberOfSwapsToSort(nums);
        System.out.println(res);
    }

    /*
Given an array and a sorting algorithm, the sorting algorithm will do a selection swap. Find the number of swaps to sort the array.

Example 1:
Input: [5, 4, 1, 2]
Output: 5
Explanation:
Swap index 0 with 1 to form the sorted array [4, 5, 1, 2].
Swap index 0 with 2 to form the sorted array [1, 5, 4, 2].
Swap index 1 with 2 to form the sorted array [1, 4, 5, 2].
Swap index 1 with 3 to form the sorted array [1, 2, 5, 4].
Swap index 2 with 3 to form the sorted array [1, 2, 4, 5].



There is an unsorted array. The requirement is to return no. of swaps required to fullfill the below constraint.
if arr[i]>arr[j] and i<j then swap the elements.
The array length can be in the range 1<=len(array)<=10^9.

https://www.geeksforgeeks.org/counting-inversions/

Time Complexity: O(n log n), The algorithm used is divide and conquer, So in each level,
one full array traversal is needed, and there are log n levels, so the time complexity is O(n log n).
     */
}
