//Write an efficient algorithm that searches for a value in an m x n matrix. Thi
//s matrix has the following properties: 
//
// 
// Integers in each row are sorted in ascending from left to right. 
// Integers in each column are sorted in ascending from top to bottom. 
// 
//
// Example: 
//
// Consider the following matrix: 
//
// 
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// Given target = 5, return true. 
//
// Given target = 20, return false. 
// Related Topics Binary Search Divide and Conquer 
// 👍 3719 👎 80


package com.study.interview.leetCode.leetcode.editor.en;

public class SearchA2dMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrixIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //We start search the matrix from top right corner,
        // initialize the current position to top right corner,
        // if the target is greater than the value in current position,
        // then the target can not be in entire row of current position because the row is sorted,
        // if the target is less than the value in current position,
        // then the target can not in the entire column because the column is sorted too.
        // We can rule out one row or one column each time, so the time complexity is O(m+n).
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) return false;
            int m = matrix.length;
            int n = matrix[0].length;
            int i = 0;
            int j = n - 1;
            while (i < m && j >= 0) {
                if (target < matrix[i][j]) {
                    j--;
                } else if (target > matrix[i][j]) {
                    i++;
                } else {
                    return true;
                }
            }
            return false;
        /*
        int i = m-1;
        int j = 0;
        while(i >= 0 && j < n) {
            if(target < matrix[i][j]) {
                i--;
            } else if(target > matrix[i][j]) {
                j++;
            } else {
                return true;
            }
        }
        return false;
         */
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}