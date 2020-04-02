//Given a collection of intervals, merge all overlapping intervals. 
//
// Example 1: 
//
// 
//Input: [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping. 
//
// NOTE: input types have been changed on April 15, 2019. Please reset to defaul
//t code definition to get new method signature. 
// Related Topics Array Sort


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length <= 1) {
                return intervals;
            }

            Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
            List<int[]> result = new ArrayList<>();
            int[] current = intervals[0];
            result.add(current);

            for (int[] interval : intervals) {
                int current_start = current[0];
                int current_end = current[1];
                int next_start = interval[0];
                int next_end = interval[1];
                if (current_end >= next_start) {
                    current[1] = Math.max(current_end, next_end);
                } else {
                    result.add(interval);
                    current = interval;
                }
            }
            return result.toArray(new int[result.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}