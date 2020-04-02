package com.study.interview.amazon.algorithm.slidingWindow;

import com.study.interview.amazon.algorithm.slidingWindow.OptimalUtilization;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class OptimalUtilizationTest {

    OptimalUtilization optimalUtilization;

    @Before
    public void setUp() throws Exception {
        optimalUtilization = new OptimalUtilization();
    }

    @Test
    public void findThePerfectSum1() {
        List<Integer> list1 = Arrays.asList(1, 2);
        List<Integer> list2 = Arrays.asList(2, 4);
        List<Integer> list3 = Arrays.asList(3, 6);
        List<Integer> list4 = Arrays.asList(1, 2);
        List<Integer> list5 = Arrays.asList(2, 1);
        int target = 7;
        List<List<Integer>> a = new ArrayList<>();
        List<List<Integer>> b = new ArrayList<>();
        a.add(list1);
        a.add(list2);
        a.add(list3);
        b.add(list4);
        List<List<Integer>> result = new ArrayList<>();
        result.add(list5);
        List<List<Integer>> actual = optimalUtilization.findThePerfectSum(a, b, target);
        assertEquals(result, actual);
    }

    @Test
    public void findThePerfectSum2() {
        List<Integer> list1 = Arrays.asList(1, 3);
        List<Integer> list2 = Arrays.asList(2, 5);
        List<Integer> list3 = Arrays.asList(3, 7);
        List<Integer> list4 = Arrays.asList(4, 10);
        List<Integer> list5 = Arrays.asList(1, 2);
        List<Integer> list6 = Arrays.asList(2, 3);
        List<Integer> list7 = Arrays.asList(3, 4);
        List<Integer> list8 = Arrays.asList(4, 5);
        List<Integer> list9 = Arrays.asList(2, 4);
        List<Integer> list10 = Arrays.asList(3, 2);
        int target = 10;
        List<List<Integer>> a = new ArrayList<>();
        List<List<Integer>> b = new ArrayList<>();
        a.add(list1);
        a.add(list2);
        a.add(list3);
        a.add(list4);
        b.add(list5);
        b.add(list6);
        b.add(list7);
        b.add(list8);
        List<List<Integer>> result = new ArrayList<>();
        result.add(list9);
        result.add(list10);
        List<List<Integer>> actual = optimalUtilization.findThePerfectSum(a, b, target);
        assertEquals(result, actual);
    }

    @Test
    public void findThePerfectSum3() {
        List<Integer> list1 = Arrays.asList(1, 8);
        List<Integer> list2 = Arrays.asList(2, 7);
        List<Integer> list3 = Arrays.asList(3, 14);
        List<Integer> list4 = Arrays.asList(1, 5);
        List<Integer> list5 = Arrays.asList(2, 10);
        List<Integer> list6 = Arrays.asList(3, 14);
        List<Integer> list7 = Arrays.asList(3, 1);
        int target = 20;
        List<List<Integer>> a = new ArrayList<>();
        List<List<Integer>> b = new ArrayList<>();
        a.add(list1);
        a.add(list2);
        a.add(list3);
        b.add(list4);
        b.add(list5);
        b.add(list6);
        List<List<Integer>> result = new ArrayList<>();
        result.add(list7);
        List<List<Integer>> actual = optimalUtilization.findThePerfectSum(a, b, target);
        assertEquals(result, actual);
    }
    @Test
    public void findThePerfectSum4() {
        List<Integer> list1 = Arrays.asList(1, 8);
        List<Integer> list2 = Arrays.asList(2, 15);
        List<Integer> list3 = Arrays.asList(3, 9);
        List<Integer> list4 = Arrays.asList(1, 8);
        List<Integer> list5 = Arrays.asList(2, 11);
        List<Integer> list6 = Arrays.asList(3, 12);
        List<Integer> list7 = Arrays.asList(1, 3);
        List<Integer> list8 = Arrays.asList(3, 2);
        int target = 20;
        List<List<Integer>> a = new ArrayList<>();
        List<List<Integer>> b = new ArrayList<>();
        a.add(list1);
        a.add(list2);
        a.add(list3);
        b.add(list4);
        b.add(list5);
        b.add(list6);
        List<List<Integer>> result = new ArrayList<>();
        result.add(list7);
        result.add(list8);
        List<List<Integer>> actual = optimalUtilization.findThePerfectSum(a, b, target);
        assertEquals(result, actual);
    }
}