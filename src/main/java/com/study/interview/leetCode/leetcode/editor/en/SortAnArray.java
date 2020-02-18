//Given an array of integers nums, sort the array in ascending order. 
//
// 
// Example 1: 
// Input: nums = [5,2,3,1]
//Output: [1,2,3,5]
// Example 2: 
// Input: nums = [5,1,1,2,0,0]
//Output: [0,0,1,1,2,5]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
//


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortAnArray {
    public static void main(String[] args) {

        Solution solution = new SortAnArray().new Solution();
        int[] nums = new int[]{5,1,1,2,0,0};
        List<Integer> result = solution.sortArray(nums);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> sortArray(int[] nums) {
            //if(nums.length <= 1) {
            //    return Arrays.asList(ArrayUtils.toObject(nums));
            //}
            return sortList(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }

        public List<Integer> sortList(List<Integer> listNums) {
            if(listNums.size() <= 1) {
                return listNums;
            }
            int pivot = listNums.size()/2;
            List<Integer> left_side = sortList(listNums.subList(0, pivot));
            List<Integer> right_side = sortList(listNums.subList(pivot, listNums.size()));
            return merge(left_side, right_side);
        }

        public List<Integer> merge(List<Integer> left_side, List<Integer> right_side) {
            List<Integer> result = new ArrayList<>();
            int left = 0, right = 0, re = 0;
            while(left < left_side.size() && right < right_side.size()) {
                if(left_side.get(left) < right_side.get(right)) {
                    result.add(left_side.get(left++));
                } else {
                    result.add(right_side.get(right++));
                }
            }

            while(left < left_side.size()) {
                result.add(left_side.get(left++));
            }
            while(right < right_side.size()) {
                result.add(right_side.get(right++));
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}