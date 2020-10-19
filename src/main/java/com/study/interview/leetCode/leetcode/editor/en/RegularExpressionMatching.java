//Given an input string (s) and a pattern (p), implement regular expression matc
//hing with support for '.' and '*' where: 
//
// 
// '.' Matches any single character. 
// '*' Matches zero or more of the preceding element. 
// 
//
// The matching should cover the entire input string (not partial). 
//
// 
// Example 1: 
//
// 
//Input: s = "aa", p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
// 
//
// Example 2: 
//
// 
//Input: s = "aa", p = "a*"
//Output: true
//Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, 
//by repeating 'a' once, it becomes "aa".
// 
//
// Example 3: 
//
// 
//Input: s = "ab", p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".
// 
//
// Example 4: 
//
// 
//Input: s = "aab", p = "c*a*b"
//Output: true
//Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, i
//t matches "aab".
// 
//
// Example 5: 
//
// 
//Input: s = "mississippi", p = "mis*is*p*."
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 20 
// 0 <= p.length <= 30 
// s contains only lowercase English letters. 
// p contains only lowercase English letters, '.', and '*'. 
// 
// Related Topics String Dynamic Programming Backtracking 
// 👍 4818 👎 769

  
package com.study.interview.leetCode.leetcode.editor.en;
  public class RegularExpressionMatching{
      public static void main(String[] args) {
           Solution solution = new RegularExpressionMatching().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        //firstMatch is very important, it decide the rest of letter match case
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if(p.length() >= 2 && p.charAt(1) == '*') {
                   //first is not match and the second char is '*', ex. p = 'X*xx'
                   //so recursively check the s with the rest of p
            return isMatch(s, p.substring(2)) ||
                    //first is match and the second char is '*'
                    //so recursively check the rest of s and p
                    (firstMatch && isMatch(s.substring(1), p));
        } else {
                   //first is match and the second char is not '*'
                   //so recursively check the rest of s and the rest of p
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }