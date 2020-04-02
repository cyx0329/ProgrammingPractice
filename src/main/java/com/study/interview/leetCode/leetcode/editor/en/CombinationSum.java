//Given a set of candidate numbers (candidates) (without duplicates) and a targe
//t number (target), find all unique combinations in candidates where the candidat
//e numbers sums to target. 
//
// The same repeated number may be chosen from candidates unlimited number of ti
//mes. 
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
//Input: candidates = [2,3,6,7], target = 7,
//A solution set is:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,3,5], target = 8,
//A solution set is:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
// 
// Related Topics Array Backtracking


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(candidates);
            List<Integer> current = new ArrayList<>();
            findCombination(candidates, 0, target, current, result);
            return result;
        }

        public void findCombination(int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> result) {
            if (target == 0) {
                result.add(new ArrayList<>(current));
                return;
            }
            for (int i = index; i < candidates.length; i++) {
                if (candidates[i] > target) break;
                current.add(candidates[i]);
                findCombination(candidates, i, target - candidates[i], current, result);
                current.remove(current.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}