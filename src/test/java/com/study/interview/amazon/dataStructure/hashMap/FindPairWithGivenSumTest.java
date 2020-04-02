package com.study.interview.amazon.dataStructure.hashMap;

import com.study.interview.amazon.dataStructure.hashMap.FindPairWithGivenSum;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FindPairWithGivenSumTest {

    FindPairWithGivenSum findPairWithGivenSum;

    @Before
    public void setUp() throws Exception {
        findPairWithGivenSum = new FindPairWithGivenSum();
    }

    @Test
    public void findSum1() {
        List<Integer> nums = Arrays.asList(1, 10, 25, 35, 60);
        int target = 90;
        List<Integer> actual = findPairWithGivenSum.findSum(nums, target);
        List<Integer> result = Arrays.asList(2, 3);
        assertEquals(result, actual);
    }

    @Test
    public void findSum2() {
        List<Integer> nums = Arrays.asList(20, 50, 40, 25, 30, 10);
        int target = 90;
        List<Integer> actual = findPairWithGivenSum.findSum(nums, target);
        List<Integer> result = Arrays.asList(1, 5);
        assertEquals(result, actual);
    }
}