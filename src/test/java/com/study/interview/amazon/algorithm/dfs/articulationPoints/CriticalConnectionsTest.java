package com.study.interview.amazon.algorithm.dfs.articulationPoints;

import com.study.interview.amazon.algorithm.dfs.articulationPoints.CriticalConnections;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CriticalConnectionsTest {

    CriticalConnections criticalConnections;

    @Before
    public void setUp() throws Exception {
        criticalConnections = new CriticalConnections();
    }

    @Test
    public void criticalConnectionsTest1() {
        int n = 5;
        List<List<Integer>> edges = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(1, 2);
        List<Integer> list2 = Arrays.asList(1, 3);
        List<Integer> list3 = Arrays.asList(3, 4);
        List<Integer> list4 = Arrays.asList(1, 4);
        List<Integer> list5 = Arrays.asList(4, 5);
        edges.add(list1);
        edges.add(list2);
        edges.add(list3);
        edges.add(list4);
        edges.add(list5);
        List<List<Integer>> actual = criticalConnections.criticalConnections(n, edges);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> resultList1 = Arrays.asList(1, 2);
        List<Integer> resultList2 = Arrays.asList(4, 5);
        result.add(resultList1);
        result.add(resultList2);
        assertEquals(result, actual);
    }

    @Test
    public void criticalConnectionsTest2() {
        int n = 6;
        List<List<Integer>> edges = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(1, 2);
        List<Integer> list2 = Arrays.asList(1, 3);
        List<Integer> list3 = Arrays.asList(2, 3);
        List<Integer> list4 = Arrays.asList(2, 4);
        List<Integer> list5 = Arrays.asList(2, 5);
        List<Integer> list6 = Arrays.asList(4, 6);
        List<Integer> list7 = Arrays.asList(5, 6);
        edges.add(list1);
        edges.add(list2);
        edges.add(list3);
        edges.add(list4);
        edges.add(list5);
        edges.add(list6);
        edges.add(list7);
        List<List<Integer>> actual = criticalConnections.criticalConnections(n, edges);
        List<List<Integer>> result = new ArrayList<>();
        assertEquals(result, actual);
    }

    @Test
    public void criticalConnectionsTest3() {
        int n = 9;
        List<List<Integer>> edges = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(1, 2);
        List<Integer> list2 = Arrays.asList(1, 3);
        List<Integer> list3 = Arrays.asList(2, 3);
        List<Integer> list4 = Arrays.asList(3, 4);
        List<Integer> list5 = Arrays.asList(3, 6);
        List<Integer> list6 = Arrays.asList(4, 5);
        List<Integer> list7 = Arrays.asList(6, 7);
        List<Integer> list8 = Arrays.asList(6, 9);
        List<Integer> list9 = Arrays.asList(7, 8);
        List<Integer> list10 = Arrays.asList(8, 9);
        edges.add(list1);
        edges.add(list2);
        edges.add(list3);
        edges.add(list4);
        edges.add(list5);
        edges.add(list6);
        edges.add(list7);
        edges.add(list8);
        edges.add(list9);
        edges.add(list10);
        List<List<Integer>> actual = criticalConnections.criticalConnections(n, edges);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> resultList1 = Arrays.asList(3, 4);
        List<Integer> resultList2 = Arrays.asList(3, 6);
        List<Integer> resultList3 = Arrays.asList(4, 5);
        result.add(resultList1);
        result.add(resultList2);
        result.add(resultList3);
        assertEquals(result, actual);
    }

}