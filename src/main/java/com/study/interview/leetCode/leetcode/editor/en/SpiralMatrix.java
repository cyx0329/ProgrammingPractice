//Given a matrix of m x n elements (m rows, n columns), return all elements of t
//he matrix in spiral order. 
//
// Example 1: 
//
// 
//Input:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//Output: [1,2,3,6,9,8,7,4,5]
// 
//
// Example 2: 
//
// 
//Input:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics Array 
// 👍 2891 👎 605


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        int M[][] = {
                {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        solution.spiralOrder(M);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {

            List<Integer> res = new ArrayList<>();

            if(matrix == null || matrix.length == 0) return res;

            int rowS = 0;
            int rowE = matrix.length - 1;
            int colS = 0;
            int colE = matrix[0].length - 1;

            while (rowS <= rowE && colS <= colE) {

                for (int i = colS; i <= colE; i++) {
                    res.add(matrix[rowS][i]);
                }
                rowS++;
                System.out.println(res);

                for (int i = rowS; i <= rowE; i++) {
                    res.add(matrix[i][colE]);
                }
                colE--;
                System.out.println(res);

                if(rowS <= rowE) {
                    for (int i = colE; i >= colS; i--) {
                        res.add(matrix[rowE][i]);
                    }
                }
                rowE--;
                System.out.println(res);

                if(colS <= colE) {
                    for (int i = rowE; i >= rowS; i--) {
                        res.add(matrix[i][colS]);
                    }
                }
                colS++;
                System.out.println(res);
            }
            return res;
        }

        private void print(int[][] matrix) {
            for (int i = 0; i < matrix.length; ++i) {
                for (int j = 0; j < matrix[i].length; ++j) {
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