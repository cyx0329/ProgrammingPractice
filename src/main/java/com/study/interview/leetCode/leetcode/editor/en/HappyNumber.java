//Write an algorithm to determine if a number is "happy". 
//
// A happy number is a number defined by the following process: Starting with an
//y positive integer, replace the number by the sum of the squares of its digits, 
//and repeat the process until the number equals 1 (where it will stay), or it loo
//ps endlessly in a cycle which does not include 1. Those numbers for which this p
//rocess ends in 1 are happy numbers. 
//
// Example: 
//
// 
//Input: 19
//Output: true
//Explanation: 
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// Related Topics Hash Table Math

  
package com.study.interview.leetCode.leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HappyNumber{
      public static void main(String[] args) {

          Solution solution = new HappyNumber().new Solution();
          solution.isHappy(19);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        while(sum != 1) {
            sum = 0;
            List<Integer> list = new ArrayList<>();
            while(n / 10 != 0) {
                list.add(n%10);
                n = n/10;
            }
            list.add(n%10);
            for(Integer i : list) {
                sum += i*i;
            }
            if(!set.contains(sum)) {
                set.add(sum);
                n = sum;
            } else {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }