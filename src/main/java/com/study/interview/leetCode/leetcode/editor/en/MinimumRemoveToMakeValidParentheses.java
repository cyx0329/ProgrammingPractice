//Given a string s of '(' , ')' and lowercase English characters. 
//
// Your task is to remove the minimum number of parentheses ( '(' or ')', in any
// positions ) so that the resulting parentheses string is valid and return any va
//lid string. 
//
// Formally, a parentheses string is valid if and only if: 
//
// 
// It is the empty string, contains only lowercase characters, or 
// It can be written as AB (A concatenated with B), where A and B are valid stri
//ngs, or 
// It can be written as (A), where A is a valid string. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "lee(t(c)o)de)"
//Output: "lee(t(c)o)de"
//Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
// 
//
// Example 2: 
//
// 
//Input: s = "a)b(c)d"
//Output: "ab(c)d"
// 
//
// Example 3: 
//
// 
//Input: s = "))(("
//Output: ""
//Explanation: An empty string is also valid.
// 
//
// Example 4: 
//
// 
//Input: s = "(a(b(c)d)"
//Output: "a(b(c)d)"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10^5 
// s[i] is one of '(' , ')' and lowercase English letters. 
// Related Topics String Stack 
// 👍 1013 👎 28

  
package com.study.interview.leetCode.leetcode.editor.en;
  public class MinimumRemoveToMakeValidParentheses{
      public static void main(String[] args) {
           Solution solution = new MinimumRemoveToMakeValidParentheses().new Solution();
           solution.minRemoveToMakeValid("lee(t(c)o)de)");
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          String result = "";

    public String minRemoveToMakeValid(String s) {
        char[] pair = new char[]{'(', ')'};
        return remove(s, 0, pair);
    }

          private String remove(String s, int start, char[] pair) {
              int count = 0;
              for(int i = start; i < s.length(); i++) {
                  if(s.charAt(i) == pair[0]) count++;
                  if(s.charAt(i) == pair[1]) count--;
                  if(count < 0) {
                      remove(s.substring(0, i) + s.substring(i+1, s.length()), i, pair);
                  }
              }

              String str = new StringBuilder(s).reverse().toString();
              if(pair[0] == '(') {
                  remove(str, 0, new char[]{')', '('});
              } else {
                  result = str;
              }
              return result;
          }

      }
//leetcode submit region end(Prohibit modification and deletion)

  }