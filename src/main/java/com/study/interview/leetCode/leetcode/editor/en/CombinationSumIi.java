//Given a collection of candidate numbers (candidates) and a target number (targ
//et), find all unique combinations in candidates where the candidate numbers sums
// to target. 
//
// Each number in candidates may only be used once in the combination. 
//
// Note: 
//
// 
// All numbers (including target) will be positive integers. 
// The solution set must not contain duplicate combinations. 
// 
//
// Example 1: 
//
// 
//Input: candidates = [10,1,2,7,6,1,5], target = 8,
//A solution set is:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,5,2,1,2], target = 5,
//A solution set is:
//[
//  [1,2,2],
//  [5]
//]
// 
// Related Topics Array Backtracking


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(candidates);
            List<Integer> current = new ArrayList<>();
            findCombinations(candidates, 0, target, current, result);
            return result;
        }

        public void findCombinations(int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> result) {
            if (target == 0) {
                result.add(new ArrayList<Integer>(current));
                return;
            }

            for (int i = index; i < candidates.length; i++) {
                if (i == index || candidates[i] != candidates[i - 1]) {
                    if (candidates[i] > target) break;
                    current.add(candidates[i]);
                    findCombinations(candidates, i + 1, target - candidates[i], current, result);
                    current.remove(current.size() - 1);
                }

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}