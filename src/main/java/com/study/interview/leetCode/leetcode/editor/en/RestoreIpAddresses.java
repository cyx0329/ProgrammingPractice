//Given a string s containing only digits. Return all possible valid IP addresse
//s that can be obtained from s. You can return them in any order. 
//
// A valid IP address consists of exactly four integers, each integer is between
// 0 and 255, separated by single points and cannot have leading zeros. For exampl
//e, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "19
//2.168.1.312" and "192.168@1.1" are invalid IP addresses. 
//
// 
// Example 1: 
// Input: s = "25525511135"
//Output: ["255.255.11.135","255.255.111.35"]
// Example 2: 
// Input: s = "0000"
//Output: ["0.0.0.0"]
// Example 3: 
// Input: s = "1111"
//Output: ["1.1.1.1"]
// Example 4: 
// Input: s = "010010"
//Output: ["0.10.0.10","0.100.1.0"]
// Example 5: 
// Input: s = "101023"
//Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
// 
// Constraints: 
//
// 
// 0 <= s.length <= 3000 
// s consists of digits only. 
// 
// Related Topics String Backtracking 
// 👍 1339 👎 517

  
package com.study.interview.leetCode.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses{
      public static void main(String[] args) {
           Solution solution = new RestoreIpAddresses().new Solution();
           String s = "25525511135";
           solution.restoreIpAddresses(s);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(new ArrayList<>(), s, result);
        return result;
    }

    private void backtrack(List<String> tempList, String s, List<String> result) {
              if(tempList.size() == 4) {
                  if(s.length() == 0) {
                      result.add(String.join(".", tempList));
                  }
                  return;
              }

              for(int i = 1; i < 4; i++) {
                  if(s.length() < i) {
                      break;
                  }
                  String substring = s.substring(0, i);
                  if((substring.startsWith("0") && substring.length() != 1) || Integer.parseInt(substring) > 255) {
                      continue;
                  }
                  tempList.add(substring);
                  backtrack(tempList, s.length() == i ? "": s.substring(i, s.length()), tempList);
                  tempList.remove(tempList.size()-1);
              }
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }