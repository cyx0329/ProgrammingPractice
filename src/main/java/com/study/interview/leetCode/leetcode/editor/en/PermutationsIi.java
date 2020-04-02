//Given a collection of numbers that might contain duplicates, return all possib
//le unique permutations. 
//
// Example: 
//
// 
//Input: [1,1,2]
//Output:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// 
// Related Topics Backtracking

  
package com.study.interview.leetCode.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsIi{
      public static void main(String[] args) {
           Solution solution = new PermutationsIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        findPermutations(nums, 0, nums.length, used, current, result);
        return result;
    }

    public void findPermutations(int[] nums, int depth, int n, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if(depth == n) {
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(used[i]) continue;
            used[i] = true;
            current.add(nums[i]);
            findPermutations(nums, depth+1, n, used, current, result);
            current.remove(current.size()-1);
            used[i] = false;
            while(i+1 < nums.length && nums[i] == nums[i+1]) {
                i++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }