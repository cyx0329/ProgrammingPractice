//Given a string containing digits from 2-9 inclusive, return all possible lette
//r combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digit to letters (just like on the telephone buttons) is given b
//elow. Note that 1 does not map to any letters. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
// Related Topics String Backtracking 
// 👍 4582 👎 452


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
          String[] letters = new String[]{"", "", "abc", "def","ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if (digits == null || digits.length() == 0) return res;
            StringBuilder sb = new StringBuilder();
            backtrack(digits, sb,0, res);
            return res;
        }

        private void backtrack(String digits, StringBuilder sb, int index, List<String> res) {
            if(sb.length() == digits.length()) {
                res.add(sb.toString());
                return;
            }
            String word = letters[digits.charAt(index) - '0'];
            for(int i = 0; i < word.length(); i++) {
                sb.append(word.charAt(i));
                backtrack(digits, sb, index+1, res);
                sb.deleteCharAt(sb.length()-1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}