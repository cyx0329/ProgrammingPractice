//Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elemen
//ts appear twice and others appear once. 
//
// Find all the elements of [1, n] inclusive that do not appear in this array. 
//
// Could you do it without extra space and in O(n) runtime? You may assume the r
//eturned list does not count as extra space. 
//
// Example:
// 
//Input:
//[4,3,2,7,8,2,3,1]
//
//Output:
//[5,6]
// 
// Related Topics Array


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        Solution solution = new FindAllNumbersDisappearedInAnArray().new Solution();
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        solution.findDisappearedNumbers(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            if(nums == null || nums.length == 0) return Collections.emptyList();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < nums.length; i++) {
                int newIndex = Math.abs(nums[i]);
                if(nums[newIndex-1] > 0) {
                    nums[newIndex-1]  = nums[newIndex-1]*-1;
                }

            }
            for(int i = 1; i <= nums.length; i++) {
                if(nums[i-1] > 0) {
                    list.add(i);
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}