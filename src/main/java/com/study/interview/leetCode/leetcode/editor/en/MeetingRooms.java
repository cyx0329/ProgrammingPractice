//Given an array of meeting time intervals consisting of start and end times [[s
//1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings. 
//
// Example 1: 
//
// 
//Input: [[0,30],[5,10],[15,20]]
//Output: false
// 
//
// Example 2: 
//
// 
//Input: [[7,10],[2,4]]
//Output: true
// 
//
// NOTE: input types have been changed on April 15, 2019. Please reset to defaul
//t code definition to get new method signature. 
// Related Topics Sort


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.Arrays;

public class MeetingRooms {
    public static void main(String[] args) {
        Solution solution = new MeetingRooms().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canAttendMeetings(int[][] intervals) {
            Arrays.sort(intervals, (int[] i1, int[] i2) -> i1[0] - i2[0]);

            for (int i = 0; i < intervals.length - 1; i++) {
                if (intervals[i][1] > intervals[i + 1][0])
                    return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}