//Given a non-empty string s and a dictionary wordDict containing a list of non-
//empty words, add spaces in s to construct a sentence where each word is a valid 
//dictionary word. Return all such possible sentences. 
//
// Note: 
//
// 
// The same word in the dictionary may be reused multiple times in the segmentat
//ion. 
// You may assume the dictionary does not contain duplicate words. 
// 
//
// Example 1: 
//
// 
//Input:
//s = "catsanddog"
//wordDict = ["cat", "cats", "and", "sand", "dog"]
//Output:
//[
//  "cats and dog",
//  "cat sand dog"
//]
// 
//
// Example 2: 
//
// 
//Input:
//s = "pineapplepenapple"
//wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//Output:
//[
//  "pine apple pen apple",
//  "pineapple pen apple",
//  "pine applepen apple"
//]
//Explanation: Note that you are allowed to reuse a dictionary word.
// 
//
// Example 3: 
//
// 
//Input:
//s = "catsandog"
//wordDict = ["cats", "dog", "sand", "and", "cat"]
//Output:
//[] 
// Related Topics Dynamic Programming Backtracking


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.*;

public class WordBreakIi {
    public static void main(String[] args) {

        Solution solution = new WordBreakIi().new Solution();
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat","cats","and","sand","dog");
        System.out.println(solution.wordBreak(s, wordDict));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            Set<String> wordSet = new HashSet<>(wordDict);
            Map<String, List<String>> map = new HashMap<>();
            return helper(s, wordSet, map);
        }

        public List<String> helper(String s, Set<String> wordSet, Map<String, List<String>> map) {
            if(map.containsKey(s)) return map.get(s);
            List<String> ans = new ArrayList<>();
            if(s.length() == 0) {
                ans.add("");
                return ans;
            }
            for(int j = s.length(); j >= 0; j--) {
                String temp = s.substring(j);
                if(wordSet.contains(temp)) {
                    List<String> left = helper(s.substring(0, j), wordSet, map);
                    for(String str : left) {
                        if(str.equals("")) ans.add(temp);
                        else ans.add(str + " " + temp);
                    }
                }
            }
            map.put(s, ans);
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}