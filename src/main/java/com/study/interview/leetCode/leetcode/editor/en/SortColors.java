//Given an array nums with n objects colored red, white, or blue, sort them in-p
//lace so that objects of the same color are adjacent, with the colors in the orde
//r red, white, and blue. 
//
// Here, we will use the integers 0, 1, and 2 to represent the color red, white,
// and blue respectively. 
//
// Follow up: 
//
// 
// Could you solve this problem without using the library's sort function? 
// Could you come up with a one-pass algorithm using only O(1) constant space? 
// 
//
// 
// Example 1: 
// Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
// Example 2: 
// Input: nums = [2,0,1]
//Output: [0,1,2]
// Example 3: 
// Input: nums = [0]
//Output: [0]
// Example 4: 
// Input: nums = [1]
//Output: [1]
// 
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] is 0, 1, or 2. 
// 
// Related Topics Array Two Pointers Sort 
// 👍 4188 👎 242

  
package com.study.interview.leetCode.leetcode.editor.en;
  public class SortColors{
      public static void main(String[] args) {
           Solution solution = new SortColors().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        /*
        //2 pass
        int count0 = 0, count1 = 0, count2 = 0;
        for(int num : nums) {
            if(num == 0) count0++;
            if(num == 1) count1++;
            if(num == 2) count2++;
        }

        for(int i = 0; i < nums.length; i++) {
            if(i < count0) nums[i] = 0;
            else if(i < count0+count1) nums[i] = 1;
            else nums[i] = 2;
        }
        */
        //1 pass
        int p0 = 0, p2 = nums.length-1;
        int i = 0;
        while(i <= p2) {
            if(nums[i] == 0) {
                int temp = nums[p0];
                nums[p0] = nums[i];
                nums[i] = temp;
                i++;
                p0++;
            } else if(nums[i] == 2) {
                int temp = nums[p2];
                nums[p2] = nums[i];
                nums[i] = temp;
                p2--;
            } else {
                i++;
            }

        }
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }