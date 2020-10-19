//Given a non-negative index k where k ≤ 33, return the kth index row of the Pas
//cal's triangle. 
//
// Note that the row index starts from 0. 
//
// 
//In Pascal's triangle, each number is the sum of the two numbers directly above
// it. 
//
// Example: 
//
// 
//Input: 3
//Output: [1,3,3,1]
// 
//
// Follow up: 
//
// Could you optimize your algorithm to use only O(k) extra space? 
// Related Topics Array

  
package com.study.interview.leetCode.leetcode.editor.en;

import java.util.Arrays;
import java.util.List;

public class PascalsTriangleIi{
      public static void main(String[] args) {

          Solution solution = new PascalsTriangleIi().new Solution();
          //solution.getRow(3);
          System.out.println(solution.getRow(3));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] result = new Integer[rowIndex+1];
        Arrays.fill(result, 0);
        result[0] = 1;
        for(int i = 1; i <= rowIndex; i++) {
            for(int j = result.length-1; j > 0; j--) {
                result[j] += result[j - 1];
            }
            result[rowIndex] = 1;
        }
        return Arrays.asList(result);
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }