//Given an array of meeting time intervals consisting of start and end times [[s
//1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms requir
//ed. 
//
// Example 1: 
//
// 
//Input: [[0, 30],[5, 10],[15, 20]]
//Output: 2 
//
// Example 2: 
//
// 
//Input: [[7,10],[2,4]]
//Output: 1 
//
// NOTE: input types have been changed on April 15, 2019. Please reset to defaul
//t code definition to get new method signature. 
// Related Topics Heap Greedy Sort


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsIi {
    public static void main(String[] args) {
        Solution solution = new MeetingRoomsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return 0;
            }
            Arrays.sort(intervals, (int[] i1, int[] i2) -> i1[0] - i2[0]);

            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            minHeap.add(intervals[0][1]);

            for (int i = 1; i < intervals.length; i++) {
                if (minHeap.peek() > intervals[i][0]) {
                    minHeap.add(intervals[i][1]);
                } else {
                    minHeap.poll();
                    minHeap.add(intervals[i][1]);
                }
            }
            return minHeap.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}