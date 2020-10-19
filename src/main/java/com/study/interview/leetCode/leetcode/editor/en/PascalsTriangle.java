//Given a non-negative integer numRows, generate the first numRows of Pascal's t
//riangle. 
//
// 
//In Pascal's triangle, each number is the sum of the two numbers directly above
// it. 
//
// Example: 
//
// 
//Input: 5
//Output:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
// 
// Related Topics Array

  
package com.study.interview.leetCode.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle{
      public static void main(String[] args) {

          Solution solution = new PascalsTriangle().new Solution();
          solution.generate(3);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0) return result;
        for(int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < i+1; j++) {
                if(j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(result.get(i-1).get(j) + result.get(i-1).get(j-1));
                }
            }
            result.add(list);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }