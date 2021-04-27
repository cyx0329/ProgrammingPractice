package com.study.interview.microsoft.VO2021;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {

        int max_profit = Integer.MIN_VALUE;
        int min_cost = prices[0];
        for(int i = 1; i < prices.length; i++) {
            max_profit = Math.max(max_profit, prices[i]-min_cost);
            if(prices[i] < min_cost) {
                min_cost = prices[i];
            }
        }
        if(max_profit < 0) return 0;
        return max_profit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int result = maxProfit(prices);
        System.out.println(result);
        int[] prices1 = {7,6,4,3,1};
        int result1 = maxProfit(prices1);
        System.out.println(result1);
    }

}
