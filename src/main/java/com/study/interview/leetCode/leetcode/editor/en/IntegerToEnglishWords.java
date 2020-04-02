//Convert a non-negative integer to its english words representation. Given inpu
//t is guaranteed to be less than 231 - 1. 
//
// Example 1: 
//
// 
//Input: 123
//Output: "One Hundred Twenty Three"
// 
//
// Example 2: 
//
// 
//Input: 12345
//Output: "Twelve Thousand Three Hundred Forty Five" 
//
// Example 3: 
//
// 
//Input: 1234567
//Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven
//"
// 
//
// Example 4: 
//
// 
//Input: 1234567891
//Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven 
//Thousand Eight Hundred Ninety One"
// 
// Related Topics Math String


package com.study.interview.leetCode.leetcode.editor.en;

public class IntegerToEnglishWords {
    public static void main(String[] args) {
        Solution solution = new IntegerToEnglishWords().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final String[] THOUSANDS = new String[]{"", "Thousand", "Million", "Billion"};
        private final String[] LESS_THAN_TWENTY = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        private final String[] TENS = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        public String numberToWords(int num) {
            if (num == 0) return "Zero";
            StringBuilder str = new StringBuilder();
            int i = 0;
            while (num > 0) {
                if (num % 1000 != 0) {
                    StringBuilder temp = new StringBuilder();
                    helper(temp, num % 1000);
                    str.insert(0, temp.append(THOUSANDS[i]).append(" "));
                }
                i++;
                num = num / 1000;

            }
            return str.toString().trim();
        }

        public void helper(StringBuilder str, int num) {
            if (num == 0) {
                return;
            } else if (num < 20) {
                str.append(LESS_THAN_TWENTY[num]).append(" ");
                return;
            } else if (num < 100) {
                str.append(TENS[num / 10]).append(" ");
                helper(str, num % 10);
            } else {
                str.append(LESS_THAN_TWENTY[num / 100]).append(" ").append("Hundred ");
                helper(str, num % 100);
            }
        }
        //Time complexity : O(N). Intuitively the output is proportional to the number N of digits in the input.
        //Space complexity : O(1) since the output is just a string.
    }
//leetcode submit region end(Prohibit modification and deletion)

}