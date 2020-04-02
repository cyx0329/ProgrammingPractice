//
//Given a string, find the first non-repeating character in it and return it's i
//ndex. If it doesn't exist, return -1.
// 
// Examples:
// 
//s = "leetcode"
//return 0.
//
//s = "loveleetcode",
//return 2.
// 
// 
//
// 
//Note: You may assume the string contain only lowercase letters.
// Related Topics Hash Table String


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.HashMap;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution solution = new FirstUniqueCharacterInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            int n = s.length();
            for (int i = 0; i < n; i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            for (int i = 0; i < n; i++) {
                if (map.get(s.charAt(i)) == 1) {
                    return i;
                }
            }
            return -1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}