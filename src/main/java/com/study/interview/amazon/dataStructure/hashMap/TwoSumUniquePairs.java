package com.study.interview.amazon.dataStructure.hashMap;

import java.util.HashSet;

public class TwoSumUniquePairs {
    public int findUniquePairsSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        int middle = nums.length/2;
        int pair = 0;
        for(int i = 0; i < middle; i++ ) {
            for(int j = nums.length-1; j>= middle; j--) {
                if (nums[j] == target - nums[i]) {
                    if(nums[i] == nums[j]) {
                        pair++;
                    }
                    set.add(nums[i]);
                    set.add(nums[j]);
                }
            }
        }
        return pair + set.size()/2;
    }
}
