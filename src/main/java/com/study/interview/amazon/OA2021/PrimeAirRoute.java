package com.study.interview.amazon.OA2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PrimeAirRoute {

    public static List<int[]> getPair(int[][] A, int[][] B, int target) {
        sort2DArrayBasedOnIndex(A, 1);
        sort2DArrayBasedOnIndex(B, 1);

        List<int[]> result = new ArrayList<>();
        for(int i = 0; i < A.length; i++) {
            //int[] temp = new int[2];
            int value = target - A[i][1];
            int size = getIndex(B, 0, B.length - 1, value);
            for(int j = 0; j < size; j++) {
                //temp[0] = A[i][0];
                //temp[1] = B[j][0];
                result.add(new int[] {A[i][0], B[j][0]});
            }
            /*
            if(temp[0] != 0 && temp[1] != 0) {
                result.add(temp);
            }
            */
        }

        return result;
    }

    private static int getIndex(int[][] array, int start, int end, int target) {

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(array[mid][1] == target) {
                start = mid + 1;
            } else if(array[mid][1] < target) {
                start = mid + 1;
            } else{
                end = mid -1;
            }
        }
        return start;
    }

    public static void sort2DArrayBasedOnIndex (int[][] array, int index){
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] first, int[] second) {
                if(first[index] > second[index]) return 1;
                else return -1;
            }
        });
    }

    public static void main(String[] args) {
        int[][] A = { {1, 2000}, {2, 3000}, {3, 4000} };
        int[][] B = { { 1, 5000 }, {2, 3000} , {3, 3000}};
        int x = 5000;
        List<int[]> result = getPair(A, B, x);
        for(int[] i : result) {
            System.out.println("{" + i[0] + "," + i[1] + "}");
        }
    }
}

/*
This problem is a variant of closest pair sum. You'll be given two arrays
arr1 = { {1, 2000}, {2, 3000}, {3, 4000} }
arr2 = { { 1, 5000 }, {2, 3000} }
the first element of every pair represents id and the second value represents the value.
and a target x = 5000
Find the pairs from both the arrays whose vaue add upto a sum which is less than given target and should be close to the target.

Output for the above example:
{ {1, 2} } // Note that the output should be in id's


 */
