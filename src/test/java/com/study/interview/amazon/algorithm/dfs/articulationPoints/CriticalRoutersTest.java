package com.study.interview.amazon.algorithm.dfs.articulationPoints;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CriticalRoutersTest {

    CriticalRouters criticalRouters;

    @Before
    public void setUp() throws Exception {
        criticalRouters = new CriticalRouters();
    }

    @Test
    public void criticalRouters() {
        int numNodes = 7;
        int numEdges = 7;
        List<List<Integer>> edges = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(0, 1);
        List<Integer> list2 = Arrays.asList(0, 2);
        List<Integer> list3 = Arrays.asList(1, 3);
        List<Integer> list4 = Arrays.asList(2, 3);
        List<Integer> list5 = Arrays.asList(2, 5);
        List<Integer> list6 = Arrays.asList(5, 6);
        List<Integer> list7 = Arrays.asList(3, 4);
        edges.add(list1);
        edges.add(list2);
        edges.add(list3);
        edges.add(list4);
        edges.add(list5);
        edges.add(list6);
        edges.add(list7);
        List<Integer> actual = criticalRouters.criticalRouters(numNodes, numEdges, edges);
        List<Integer> result = Arrays.asList(2, 3, 5);
        assertEquals(result, actual);
    }
}