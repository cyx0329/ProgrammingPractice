//Say you have an array for which the ith element is the price of a given stock 
//on day i. 
//
// If you were only permitted to complete at most one transaction (i.e., buy one
// and sell one share of the stock), design an algorithm to find the maximum profi
//t. 
//
// Note that you cannot sell a stock before you buy one. 
//
// Example 1: 
//
// 
//Input: [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 
//6-1 = 5.
//             Not 7-1 = 6, as selling price needs to be larger than buying pric
//e.
// 
//
// Example 2: 
//
// 
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0.
// 
// Related Topics Array Dynamic Programming


package com.study.interview.leetCode.leetcode.editor.en;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) return 0;

            //in order to get max profit, i need to find the min price
            //because i can not sell before buy, so basically the first element is set to min
            //after that any element less than min, set to min
            //if not less then min, update max profit
            //initially set min to Integer.MAX
            int min = prices[0];
            int max_profit = 0;
            for(int price : prices) {
                if(price < min) {
                    min = price;
                } else {
                    max_profit = Math.max(max_profit, price-min);
                }
            }
            return max_profit;
        }
    }
    //Time complexity : O(n). Only a single pass is needed.
    //Space complexity : O(1). Only two variables are used.
//leetcode submit region end(Prohibit modification and deletion)

}