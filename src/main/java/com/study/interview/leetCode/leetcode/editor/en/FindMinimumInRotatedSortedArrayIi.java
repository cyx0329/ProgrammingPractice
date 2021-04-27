//Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand. 
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// Find the minimum element. 
//
// The array may contain duplicates. 
//
// Example 1: 
//
// 
//Input: [1,3,5]
//Output: 1 
//
// Example 2: 
//
// 
//Input: [2,2,2,0,1]
//Output: 0 
//
// Note: 
//
// 
// This is a follow up problem to Find Minimum in Rotated Sorted Array. 
// Would allow duplicates affect the run-time complexity? How and why? 
// 
// Related Topics Array Binary Search 
// 👍 1234 👎 251


package com.study.interview.leetCode.leetcode.editor.en;

public class FindMinimumInRotatedSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new FindMinimumInRotatedSortedArrayIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //To summarize, this algorithm differs to the classical binary search algorithm in two parts:
        //
        //We use the upper bound of search scope as the reference for the comparison with the pivot element,
        // while in the classical binary search the reference would be the desired value.
        //When the result of comparison is equal (i.e. Case #3), we further move the upper bound,
        // while in the classical binary search normally we would return the value immediately.
        public int findMin(int[] nums) {
            if (nums.length == 1) return nums[0];
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < nums[right]) {
                    right = mid;
                } else if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else {
                    right--;
                }
            }
            return nums[left];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}