//Given an m x n 2d grid map of '1's (land) and '0's (water), return the number 
//of islands. 
//
// An island is surrounded by water and is formed by connecting adjacent lands h
//orizontally or vertically. You may assume all four edges of the grid are all sur
//rounded by water. 
//
// 
// Example 1: 
//
// 
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] is '0' or '1'. 
// 
// Related Topics Depth-first Search Breadth-first Search Union Find 
// 👍 6625 👎 214

  
package com.study.interview.leetCode.leetcode.editor.en;
  public class NumberOfIslands{
      public static void main(String[] args) {
           Solution solution = new NumberOfIslands().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i < grid.length && i >= 0 && j < grid[0].length && j >= 0 && grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid, i +1, j);
            dfs(grid, i -1, j);
            dfs(grid, i, j+1);
            dfs(grid, i, j-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }