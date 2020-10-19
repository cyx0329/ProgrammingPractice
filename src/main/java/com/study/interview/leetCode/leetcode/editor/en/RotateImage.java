//You are given an n x n 2D matrix representing an image, rotate the image by 90
// degrees (clockwise). 
//
// You have to rotate the image in-place, which means you have to modify the inp
//ut 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [[7,4,1],[8,5,2],[9,6,3]]
// 
//
// Example 2: 
//
// 
//Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// Example 3: 
//
// 
//Input: matrix = [[1]]
//Output: [[1]]
// 
//
// Example 4: 
//
// 
//Input: matrix = [[1,2],[3,4]]
//Output: [[3,1],[4,2]]
// 
//
// 
// Constraints: 
//
// 
// matrix.length == n 
// matrix[i].length == n 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
// Related Topics Array 
// 👍 3692 👎 263

  
package com.study.interview.leetCode.leetcode.editor.en;
  public class RotateImage{
      public static void main(String[] args) {

          Solution solution = new RotateImage().new Solution();
          int M[][] = {
                  {1, 2, 3, 4},     {5, 6, 7, 8},     {9, 10, 11, 12},
                  {13, 14, 15, 16},
          };
          solution.rotate(M);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        int start = 0;
        int end = matrix.length-1;
        //print(matrix);
        //System.out.println("------------");

        while(start < end) {
            int[] temp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = temp;
            //print(matrix);
            start++;
            end--;
        }
        //System.out.println("------------");
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = i+1; j < matrix[i].length; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
            //print(matrix);
        }
    }

    private void print(int[][] matrix) {
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[i].length; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
        //for (int[] ints : matrix) {
        //   for (int anInt : ints) {
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }