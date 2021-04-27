package com.study.interview.microsoft.VO2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://leetcode.com/problems/merge-intervals/

public class MergeIntervals {


    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        List<int[]> result = new ArrayList<>();

        int[] first = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            int first_start= first[0];
            int first_end = first[1];
            int second_start = intervals[i][0];
            int second_end = intervals[i][1];
            if(first_end >= second_start) {
                first = new int[]{first_start, Math.max(first_end, second_end)};
            } else {
                result.add(first);
                first = intervals[i];
            }
        }
        result.add(first);
        return result.toArray(new int[0][]);
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
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] result = merge(intervals);
        for(int [] re : result) {
            System.out.println(re[0] + "," + re[1]);
        }
    }

}
