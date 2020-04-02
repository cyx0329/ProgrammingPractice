//Given a string, find the length of the longest substring without repeating cha
//racters. 
//
// 
// Example 1: 
//
// 
//Input: "abcabcbb"
//Output: 3 
//Explanation: The answer is "abc", with the length of 3. 
// 
//
// 
// Example 2: 
//
// 
//Input: "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// 
// Example 3: 
//
// 
//Input: "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3. 
//             Note that the answer must be a substring, "pwke" is a subsequence
// and not a substring.
// 
// 
// 
// 
// Related Topics Hash Table Two Pointers String Sliding Window


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int i = 0, j = 0;
            int n = s.length();
            int max = 0;
            HashSet<Character> set = new HashSet<>();
            while (j < n) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    max = Math.max(set.size(), max);
                    j++;
                } else {
                    set.remove(s.charAt(i));
                    i++;

                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}