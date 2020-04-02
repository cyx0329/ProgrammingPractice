package com.study.interview.amazon.dataStructure.hashMap;

import com.study.interview.amazon.dataStructure.hashMap.TwoSumUniquePairs;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSumUniquePairsTest {

    TwoSumUniquePairs twoSumUniquePairs;

    @Before
    public void setUp() throws Exception {
        twoSumUniquePairs = new TwoSumUniquePairs();
    }

    @Test
    public void findUniquePairsSum1() {
        int[] nums = new int[]{1, 1, 2, 45, 46 ,46};
        int target = 47;
        int actual = twoSumUniquePairs.findUniquePairsSum(nums, target);
        assertEquals(2, actual);
    }

    @Test
    public void findUniquePairsSum2() {
        int[] nums = new int[]{1, 1};
        int target = 2;
        int actual = twoSumUniquePairs.findUniquePairsSum(nums, target);
        assertEquals(1, actual);
    }

    @Test
    public void findUniquePairsSum3() {
        int[] nums = new int[]{1, 5, 1, 5};
        int target = 6;
        int actual = twoSumUniquePairs.findUniquePairsSum(nums, target);
        assertEquals(1, actual);
    }
}