package com.study.interview.microsoft.VO2021;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        dfs(nums, 0, new ArrayList<>(), set, result);
        return result;
    }

    private static void dfs(int[] nums, int index, List<Integer> curr,
                            Set<Integer> set, List<List<Integer>> result) {

        result.add(new ArrayList<>(curr));

        for(int i = index; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            curr.add(nums[i]);
            set.add(nums[i]);
            dfs(nums, i + 1, curr, set, result);
            curr.remove(curr.size() - 1);
            set.remove(nums[i]);
        }
    }



    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets(nums);
        for(List<Integer> list : result) {
            System.out.print("[");
            for(int n : list) {
                System.out.print( n + ",");
            }
            System.out.print("],");
        }
    }
}
