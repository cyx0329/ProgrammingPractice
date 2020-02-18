//Given two words (beginWord and endWord), and a dictionary's word list, find th
//e length of shortest transformation sequence from beginWord to endWord, such tha
//t: 
//
// 
// Only one letter can be changed at a time. 
// Each transformed word must exist in the word list. Note that beginWord is not
// a transformed word. 
// 
//
// Note: 
//
// 
// Return 0 if there is no such transformation sequence. 
// All words have the same length. 
// All words contain only lowercase alphabetic characters. 
// You may assume no duplicates in the word list. 
// You may assume beginWord and endWord are non-empty and are not the same. 
// 
//
// Example 1: 
//
// 
//Input:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//Output: 5
//
//Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog
//" -> "cog",
//return its length 5.
// 
//
// Example 2: 
//
// 
//Input:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//Output: 0
//
//Explanation: The endWord "cog" is not in wordList, therefore no possible trans
//formation.
// 
//
// 
// 
// Related Topics Breadth-first Search


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {

        Solution solution = new WordLadder().new Solution();
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        int result = solution.ladderLength("hit","cog", wordList);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet<>(wordList);
            if(!wordSet.contains(endWord)) {
                return 0;
            }
            Queue<String> queue = new LinkedList<>();
            queue.add(beginWord);
            int res = 0;
            while(!queue.isEmpty()) {
                for(int k = queue.size(); k>0; k--) {
                    String word = queue.poll();
                    if(word.equals(endWord)) {
                        return res + 1;
                    }
                    for(int i = 0; i < word.length(); i++) {
                        char[] newWord = word.toCharArray();
                        for(char ch = 'a'; ch <= 'z'; ch++) {
                            newWord[i] = ch;
                            String s = new String(newWord);
                            if(wordSet.contains(s) && !s.equals(word)) {
                                queue.add(s);
                                wordSet.remove(s);
                            }
                        }
                    }
                }
                res++;
            }
            return 0;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}