package com.study.interview.microsoft.VO2021;

import java.util.List;

public class SortColor {
    public static void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length-1;
        int i = 0;

        while(i <= p2) {
            if(nums[i] == 2) {
                swap(nums, i, p2);
                i++;
                p2--;
            } else if(nums[i] == 0) {
                swap(nums, i, p0);
                i++;
                p0++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        for(int num : nums) {
            System.out.print(num + ",");
        }
    }

}
