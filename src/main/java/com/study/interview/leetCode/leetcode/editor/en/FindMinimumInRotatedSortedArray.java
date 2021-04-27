//Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand. 
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// Find the minimum element. 
//
// You may assume no duplicate exists in the array. 
//
// Example 1: 
//
// 
//Input: [3,4,5,1,2] 
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: [4,5,6,7,0,1,2]
//Output: 0
// 
// Related Topics Array Binary Search 
// 👍 2678 👎 263

  
package com.study.interview.leetCode.leetcode.editor.en;
  public class FindMinimumInRotatedSortedArray{
      public static void main(String[] args) {
           Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int left = 0, right = nums.length-1;
        if(nums[0] < nums[right]) return nums[0];
        while(left < right) {
            int mid = left + (right-left)/2;
            if(nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return nums[left];
        /*
        //用二分法
        if(nums.length == 1) return nums[0];
        int left = 0, right = nums.length-1;
        if(nums[0] < nums[right]) return nums[0];

        while(left < right) {
            int mid = left + (right-left)/2;
            if(nums[mid] >= nums[0]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return nums[left];
        */
        /*
        //用二分法
        if(nums.length == 1) return nums[0];
        int left = 0, right = nums.length-1;
        if(nums[0] < nums[right]) return nums[0];

        while(left <= right) {
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[mid+1]) return nums[mid+1];
            else if(nums[mid-1] > nums[mid]) return nums[mid];

            if(nums[mid] > nums[0]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
         */

        /*
        for(int i = 1; i < nums.length; i++) {
            if(nums[i-1] > nums[i]) {
                return nums[i];
            }
        }
        return nums[0];
         */
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }