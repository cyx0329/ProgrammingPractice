//Given two words (beginWord and endWord), and a dictionary's word list, find al
//l shortest transformation sequence(s) from beginWord to endWord, such that: 
//
// 
// Only one letter can be changed at a time 
// Each transformed word must exist in the word list. Note that beginWord is not
// a transformed word. 
// 
//
// Note: 
//
// 
// Return an empty list if there is no such transformation sequence. 
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
//Output:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
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
//Output: []
//
//Explanation: The endWord "cog" is not in wordList, therefore no possible trans
//formation.
// 
//
// 
// 
// Related Topics Array String Backtracking Breadth-first Search


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.*;

public class WordLadderIi {
    public static void main(String[] args) {
        Solution solution = new WordLadderIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet<>(wordList);
            List<List<String>> res = new ArrayList<>();
            Map<String, List<String>> nodeNeighbors = new HashMap<>();
            Map<String, Integer> distance = new HashMap<>();
            List<String> list = new ArrayList<>();
            wordSet.add(beginWord);
            bfs(beginWord, endWord, wordSet, nodeNeighbors, distance);
            dfs(beginWord, endWord, wordSet, nodeNeighbors, distance, list, res);
            return res;
        }

        public void bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, List<String>> nodeNeighbors,
                        Map<String, Integer> distance) {
            for (String str : wordSet) nodeNeighbors.put(str, new ArrayList<>());
            Queue<String> queue = new LinkedList<>();
            queue.add(beginWord);
            distance.put(beginWord, 0);
            while (!queue.isEmpty()) {
                boolean foundEnd = false;
                for (int k = queue.size(); k > 0; k--) {
                    String cur = queue.poll();
                    int curDistance = distance.get(cur);
                    List<String> neighbors = getNeighbors(cur, wordSet);
                    for (String n : neighbors) {
                        nodeNeighbors.get(cur).add(n);
                        if (!distance.containsKey(n)) {
                            distance.put(n, curDistance + 1);
                            if (endWord.equals(n)) foundEnd = true;
                            else queue.offer(n);
                        }
                    }
                }
                if (foundEnd) break;
            }

        }

        public List<String> getNeighbors(String word, Set<String> wordSet) {
            List<String> res = new ArrayList<>();

            for (int i = 0; i < word.length(); i++) {
                char[] newWord = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (newWord[i] == ch) continue;
                    char temp = newWord[i];
                    newWord[i] = ch;
                    if (wordSet.contains(String.valueOf(newWord))) {
                        res.add(String.valueOf(newWord));
                    }
                    newWord[i] = temp;
                }
            }
            return res;
        }

        public void dfs(String beginWord, String endWord, Set<String> wordSet, Map<String, List<String>> nodeNeighbors,
                        Map<String, Integer> distance, List<String> list, List<List<String>> res) {

            list.add(beginWord);
            if (endWord.equals(beginWord)) {
                res.add(new ArrayList<>(list));
            } else {
                for (String n : nodeNeighbors.get(beginWord)) {
                    if (distance.get(n) == distance.get(beginWord) + 1) {
                        dfs(n, endWord, wordSet, nodeNeighbors, distance, list, res);
                    }
                }
            }
            list.remove(list.size() - 1);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}