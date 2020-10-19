//Given an input string, reverse the string word by word. 
//
// 
//
// Example 1: 
//
// 
//Input: "the sky is blue"
//Output: "blue is sky the"
// 
//
// Example 2: 
//
// 
//Input: "  hello world!  "
//Output: "world! hello"
//Explanation: Your reversed string should not contain leading or trailing space
//s.
// 
//
// Example 3: 
//
// 
//Input: "a good   example"
//Output: "example good a"
//Explanation: You need to reduce multiple spaces between two words to a single 
//space in the reversed string.
// 
//
// 
//
// Note: 
//
// 
// A word is defined as a sequence of non-space characters. 
// Input string may contain leading or trailing spaces. However, your reversed s
//tring should not contain leading or trailing spaces. 
// You need to reduce multiple spaces between two words to a single space in the
// reversed string. 
// 
//
// 
//
// Follow up: 
//
// For C programmers, try to solve it in-place in O(1) extra space. Related Topi
//cs String

  
package com.study.interview.leetCode.leetcode.editor.en;
  public class ReverseWordsInAString{
      public static void main(String[] args) {

          Solution solution = new ReverseWordsInAString().new Solution();
          solution.reverseWords("the sky is blue");
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return "";
        String[] result = s.split("\\s+");
        reverse(result, 0, result.length-1);
        StringBuilder str = new StringBuilder();
        for(String re : result) {
            str.append(re).append(" ");
        }
        return str.toString().trim();
    }

          private void reverse(String[] result, int i, int j) {
              while(i < j) {
                  String temp = result[i];
                  result[i] = result[j];
                  result[j] = temp;
                  i++;
                  j--;
              }
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }