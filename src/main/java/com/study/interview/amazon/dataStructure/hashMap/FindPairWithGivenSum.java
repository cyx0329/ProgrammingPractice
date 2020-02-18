package com.study.interview.amazon.dataStructure.hashMap;

/*
    Given a list of positive integers nums and an int target, return indices of the two numbers such that they add up to a target - 30.

    Conditions:
    You will pick exactly 2 numbers.
    You cannot pick the same element twice.
    If you have muliple pairs, select the pair with the largest number.

    Example 1:
    Input: nums = [1, 10, 25, 35, 60], target = 90
    Output: [2, 3]
    Explanation:
    nums[2] + nums[3] = 25 + 35 = 60 = 90 - 30

    Example 2:
    Input: nums = [20, 50, 40, 25, 30, 10], target = 90
    Output: [1, 5]
    Explanation:
    nums[0] + nums[2] = 20 + 40 = 60 = 90 - 30
    nums[1] + nums[5] = 50 + 10 = 60 = 90 - 30
    You should return the pair with the largest number.
 */

import java.util.*;

public class FindPairWithGivenSum {
    public List<Integer> findSum(List<Integer> nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int highNums = 0;
        for(int i = 0; i < nums.size(); i++) {
            int x = target - 30;
            hashMap.put(nums.get(i), i);
            if(hashMap.containsKey(x - nums.get(i))){
                if(nums.get(i) > x-nums.get(i) && nums.get(i) > highNums){
                    highNums = nums.get(i);
                    if(i < hashMap.get(x-nums.get(i))){
                        result = Arrays.asList(i, hashMap.get(x-nums.get(i)));
                    } else {
                        result = Arrays.asList(hashMap.get(x-nums.get(i)), i);
                    }
                } else if(x-nums.get(i) >  nums.get(i) && x-nums.get(i) > highNums){
                    highNums = x - nums.get(i);
                    if(i < hashMap.get(x-nums.get(i))){
                        result = Arrays.asList(i, hashMap.get(x-nums.get(i)));
                    } else {
                        result = Arrays.asList(hashMap.get(x-nums.get(i)), i);
                    }
                }

            }

        }
        return result;
    }
}
