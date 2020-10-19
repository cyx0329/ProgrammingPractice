//Given an input string (s) and a pattern (p), implement wildcard pattern matchi
//ng with support for '?' and '*'. 
//
// 
//'?' Matches any single character.
//'*' Matches any sequence of characters (including the empty sequence).
// 
//
// The matching should cover the entire input string (not partial). 
//
// Note: 
//
// 
// s could be empty and contains only lowercase letters a-z. 
// p could be empty and contains only lowercase letters a-z, and characters like
// ? or *. 
// 
//
// Example 1: 
//
// 
//Input:
//s = "aa"
//p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
// 
//
// Example 2: 
//
// 
//Input:
//s = "aa"
//p = "*"
//Output: true
//Explanation: '*' matches any sequence.
// 
//
// Example 3: 
//
// 
//Input:
//s = "cb"
//p = "?a"
//Output: false
//Explanation: '?' matches 'c', but the second letter is 'a', which does not mat
//ch 'b'.
// 
//
// Example 4: 
//
// 
//Input:
//s = "adceb"
//p = "*a*b"
//Output: true
//Explanation: The first '*' matches the empty sequence, while the second '*' ma
//tches the substring "dce".
// 
//
// Example 5: 
//
// 
//Input:
//s = "acdcb"
//p = "a*c?b"
//Output: false
// 
// Related Topics String Dynamic Programming Backtracking Greedy 
// 👍 2386 👎 114

  
package com.study.interview.leetCode.leetcode.editor.en;
  public class WildcardMatching{
      public static void main(String[] args) {

          Solution solution = new WildcardMatching().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        int s_len = s.length(), p_len = p.length();
        int s_idx = 0, p_idx = 0;
        int star_idx = -1, s_temp_idx = -1;

        while(s_idx < s_len) {
            if(p_idx < p_len && (p.charAt(p_idx) == s.charAt(s_idx) || p.charAt(p_idx) == '?')) {
                ++s_idx;
                ++p_idx;
            } else if(p_idx < p_len && p.charAt(p_idx) == '*') {
                star_idx = p_idx;
                s_temp_idx = s_idx;
                ++p_idx;
            } else if(star_idx == -1) {
                return false;
            } else {
                p_idx = star_idx+1;
                s_idx = s_temp_idx+1;
                s_temp_idx = s_idx;
            }
        }

        for(int i = p_idx; i < p_len; i++) {
            if(p.charAt(i) != '*') {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }