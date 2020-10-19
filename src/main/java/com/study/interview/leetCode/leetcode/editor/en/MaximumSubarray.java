//Given an integer array nums, find the contiguous subarray (containing at least
// one number) which has the largest sum and return its sum. 
//
// Example: 
//
// 
//Input: [-2,1,-3,4,-1,2,1,-5,4],
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Follow up: 
//
// If you have figured out the O(n) solution, try coding another solution using 
//the divide and conquer approach, which is more subtle. 
// Related Topics Array Divide and Conquer Dynamic Programming


package com.study.interview.leetCode.leetcode.editor.en;

public class MaximumSubarray {
    public static void main(String[] args) {

        Solution solution = new MaximumSubarray().new Solution();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int result = solution.maxSubArray(nums);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            //Pick the locally optimal move at each step, and that will lead to the globally optimal solution.
            //current element
            //
            //current local maximum sum (at this given point)
            //
            //global maximum sum seen so far.
            int sum = nums[0], maxSum = nums[0];
            for(int i = 1; i < nums.length; i++) {
                sum = Math.max(nums[i], sum+nums[i]);
                maxSum = Math.max(maxSum, sum);
            }
            return maxSum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}