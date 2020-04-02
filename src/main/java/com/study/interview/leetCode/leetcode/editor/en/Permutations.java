//Given a collection of distinct integers, return all possible permutations. 
//
// Example: 
//
// 
//Input: [1,2,3]
//Output:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// 
// Related Topics Backtracking


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> current = new ArrayList<>();
            int[] used = new int[nums.length];
            findPermutations(nums, 0, nums.length, used, current, result);
            return result;
        }

        public void findPermutations(int[] nums, int depth, int n, int[] used, List<Integer> current, List<List<Integer>> result) {
            if(depth == n) {
                result.add(new ArrayList<>(current));
                return;
            }
            for(int i = 0; i < nums.length; i++) {
                if(used[i] == 1) {
                    continue;
                }
                used[i] = 1;
                current.add(nums[i]);
                findPermutations(nums, depth+1, n, used, current, result);
                current.remove(current.size()-1);
                used[i] = 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}