//Write an efficient algorithm that searches for a value in an m x n matrix. Thi
//s matrix has the following properties: 
//
// 
// Integers in each row are sorted from left to right. 
// The first integer of each row is greater than the last integer of the previou
//s row. 
// 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
//Output: true
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
//Output: false
// 
//
// Example 3: 
//
// 
//Input: matrix = [], target = 0
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 0 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics Array Binary Search 
// 👍 2416 👎 171


package com.study.interview.leetCode.leetcode.editor.en;

public class SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //Use binary search.
        //
        //m * n matrix convert to an array => matrix[x][y] => a[x * n + y]
        //
        //an array convert to m * n matrix => a[x] =>matrix[x / n][x % n];
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) return false;
            int m = matrix.length;
            int n = matrix[0].length;
            int left = 0, right = m * n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int mid_element = matrix[mid / n][mid % n];
                if (target < mid_element) {
                    right = mid - 1;
                } else if (target > mid_element) {
                    left = mid + 1;
                } else {
                    return true;
                }
            }
            return false;

        /*
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n-1;
        while(i < m && j >= 0) {
            if(target < matrix[i][j]) {
                j--;
            } else if(target > matrix[i][j]) {
                i++;
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