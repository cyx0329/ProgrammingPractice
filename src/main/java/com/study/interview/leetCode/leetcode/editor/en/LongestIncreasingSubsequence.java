//Given an unsorted array of integers, find the length of longest increasing sub
//sequence. 
//
// Example: 
//
// 
//Input: [10,9,2,5,3,7,101,18]
//Output: 4 
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the 
//length is 4. 
//
// Note: 
//
// 
// There may be more than one LIS combination, it is only necessary for you to r
//eturn the length. 
// Your algorithm should run in O(n2) complexity. 
// 
//
// Follow up: Could you improve it to O(n log n) time complexity? 
// Related Topics Binary Search Dynamic Programming 
// 👍 5637 👎 127


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /*public int lengthOfLIS(int[] nums) {
            return helper(nums, Integer.MIN_VALUE, 0);
        }

        private int helper(int[] nums, int prev, int cur) {
            if (cur == nums.length) {
                return 0;
            }
            int taken = 0;
            if (prev < nums[cur]) {
                taken = 1 + helper(nums, nums[cur], cur + 1);
            }
            int nontaken = helper(nums, prev, cur + 1);
            return Math.max(taken, nontaken);

        }*/
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);

            for(int i = 1; i < dp.length; i++) {
                for(int j = 0; j < i; j++) {
                    if(nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[j]+1, dp[i]);
                    }
                }
            }
            int max = 0;
            for(int element : dp) {
                max = Math.max(element, max);
            }
            return max;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}