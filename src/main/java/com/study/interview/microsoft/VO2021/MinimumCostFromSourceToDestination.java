package com.study.interview.microsoft.VO2021;

public class MinimumCostFromSourceToDestination {

    public static int minCost(int[] SD, int[] DS) {

        int minCost = Integer.MAX_VALUE;

        int min = DS[DS.length-1];
        for(int i = DS.length-2; i >= 0; i--) {
            if(DS[i] < min) {
                min = DS[i];
            }
            DS[i] = min;
        }

        for(int i = 0; i < SD.length; i++) {
            minCost = Math.min(minCost, SD[i]+DS[i]);
        }
        return minCost;
    }

    public static void main(String[] args) {
        int[] SD = {10,30,20,10,15};
        int[] DS = {30,25,15,10,15};
        int result = minCost(SD, DS);
        System.out.println(result);
    }
}
