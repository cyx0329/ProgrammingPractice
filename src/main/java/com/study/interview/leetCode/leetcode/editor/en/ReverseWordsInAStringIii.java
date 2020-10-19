//Given a string, you need to reverse the order of characters in each word withi
//n a sentence while still preserving whitespace and initial word order. 
//
// Example 1: 
// 
//Input: "Let's take LeetCode contest"
//Output: "s'teL ekat edoCteeL tsetnoc"
// 
// 
//
// Note:
//In the string, each word is separated by single space and there will not be an
//y extra space in the string.
// Related Topics String


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.Arrays;

public class ReverseWordsInAStringIii {
    public static void main(String[] args) {

        Solution solution = new ReverseWordsInAStringIii().new Solution();
        solution.reverseWords("Let's take LeetCode contest");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            if (s == null || s.length() == 0) return "";
            StringBuilder str = new StringBuilder();
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) != ' ') {
                    str.append(s.charAt(i));
                } else {
                    str.reverse();
                    result.append(str).append(" ");
                    str.setLength(0);
                }
            }
            result.append(str.reverse());
            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}