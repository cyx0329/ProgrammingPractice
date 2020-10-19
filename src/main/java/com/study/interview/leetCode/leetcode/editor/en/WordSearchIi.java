//Given a 2D board and a list of words from the dictionary, find all words in th
//e board. 
//
// Each word must be constructed from letters of sequentially adjacent cell, whe
//re "adjacent" cells are those horizontally or vertically neighboring. The same l
//etter cell may not be used more than once in a word. 
//
// 
//
// Example: 
//
// 
//Input: 
//board = [
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//words = ["oath","pea","eat","rain"]
//
//Output: ["eat","oath"]
// 
//
// 
//
// Note: 
//
// 
// All inputs are consist of lowercase letters a-z. 
// The values of words are distinct. 
// 
// Related Topics Backtracking Trie 
// 👍 2997 👎 127

  
package com.study.interview.leetCode.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class WordSearchIi{
      public static void main(String[] args) {
           Solution solution = new WordSearchIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          //use backtracking to do this problem,
          //first build the trie for words
          //recursively search the word character by character in board
          //if i find the answer, i add it in to the res; else, then backtrack
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if(board.length == 0) return res;
        TrieNode root = buildTrie(words);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }

        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if(c == '#' || p.next[c-'a'] == null) return;
        p = p.next[c-'a'];
        if(p.word != null) {
            res.add(p.word); //satisfy the condition, add in res
            p.word = null; //avoid duplicate
        }

        board[i][j] = '#';
        if(i > 0) dfs(board, i-1, j, p, res);
        if(j > 0) dfs(board, i, j-1, p, res);
        if(i < board.length-1) dfs(board, i+1, j, p, res);
        if(j < board[0].length-1) dfs(board, i, j+1, p, res);
        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String w : words) {
            TrieNode p = root; //p means pointer
            for(char c : w.toCharArray()) {
                int i = c - 'a';
                if(p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    public class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }