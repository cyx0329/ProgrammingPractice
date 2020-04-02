//Given an array nums of n integers, are there elements a, b, c in nums such tha
//t a + b + c = 0? Find all unique triplets in the array which gives the sum of ze
//ro. 
//
// Note: 
//
// The solution set must not contain duplicate triplets. 
//
// Example: 
//
// 
//Given array nums = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// Related Topics Array Two Pointers


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new LinkedList<>();
            for(int i = 0; i < nums.length-2; i++) {
                if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                    int low = i + 1;
                    int high = nums.length - 1;
                    int sum = 0 - nums[i];

                    while(low < high) {
                        if(nums[low] + nums[high] == sum) {
                            ans.add(Arrays.asList(nums[i], nums[low], nums[high]));
                            while(low < high && nums[low] == nums[low+1]) low++;
                            while(low < high && nums[high] == nums[high-1]) high--;
                            low++;
                            high--;
                        } else if(nums[low] + nums[high] > sum) {
                            high--;
                        } else {
                            low++;
                        }
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}