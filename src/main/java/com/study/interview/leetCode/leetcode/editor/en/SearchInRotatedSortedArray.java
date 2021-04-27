//You are given an integer array nums sorted in ascending order, and an integer 
//target. 
//
// Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [
//0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// If target is found in the array return its index, otherwise, return -1. 
//
// 
// Example 1: 
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// Example 2: 
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// Example 3: 
// Input: nums = [1], target = 0
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// All values of nums are unique. 
// nums is guranteed to be rotated at some pivot. 
// -10^4 <= target <= 10^4 
// 
// Related Topics Array Binary Search 
// 👍 6043 👎 526

  
package com.study.interview.leetCode.leetcode.editor.en;
  public class SearchInRotatedSortedArray{
      public static void main(String[] args) {
           Solution solution = new SearchInRotatedSortedArray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int i = getRotateIndex(nums);
        System.out.print(i);
        int left= 0, right = nums.length-1;
        if(nums[i] == target) return i;
        if(target <= nums[right]) {
            left = i+1;
        } else if(target > nums[right]) {
            right = i-1;
        }
        while(left <= right) {
            int mid = left+(right-left)/2;
            if(nums[mid] < target) {
                left = mid+1;
            } else if(nums[mid] > target){
                right = mid-1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int getRotateIndex(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right) {
            int mid = left+(right-left)/2;
            if(nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }