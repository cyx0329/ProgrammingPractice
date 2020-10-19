//Given an array nums, write a function to move all 0's to the end of it while m
//aintaining the relative order of the non-zero elements. 
//
// Example: 
//
// 
//Input: [0,1,0,3,12]
//Output: [1,3,12,0,0] 
//
// Note: 
//
// 
// You must do this in-place without making a copy of the array. 
// Minimize the total number of operations. 
// Related Topics Array Two Pointers

  
package com.study.interview.leetCode.leetcode.editor.en;
  public class MoveZeroes{
      public static void main(String[] args) {

          Solution solution = new MoveZeroes().new Solution();
          int[] nums = {0,1,0,3,12};
          solution.moveZeroes(nums);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int i = 0;
        int j = i+1;
        while(i < j && j < nums.length) {
            if(i == 0 && j == 0) {
                j++;
            } else if(i == 0 && j != 0) {
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
                j++;
            } else {
                i++;
                j++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }