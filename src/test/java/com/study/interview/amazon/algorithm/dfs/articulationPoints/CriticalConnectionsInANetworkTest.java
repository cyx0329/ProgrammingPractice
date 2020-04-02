package com.study.interview.amazon.algorithm.dfs.articulationPoints;

import com.study.interview.amazon.algorithm.dfs.articulationPoints.CriticalConnectionsInANetwork;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsInANetworkTest extends TestCase {

    CriticalConnectionsInANetwork criticalConnectionsInANetwork;

    @Before
    public void setUp() throws Exception {
        criticalConnectionsInANetwork = new CriticalConnectionsInANetwork();
    }

    @Test
    public void testCriticalConnections() {
        int n = 6;
        List<Integer> connection1 = Arrays.asList(0, 1);
        List<Integer> connection2 = Arrays.asList(1, 2);
        List<Integer> connection3 = Arrays.asList(2, 0);
        List<Integer> connection4 = Arrays.asList(1, 3);
        List<Integer> connection5 = Arrays.asList(3, 4);
        List<Integer> connection6 = Arrays.asList(4, 5);
        List<Integer> connection7 = Arrays.asList(5, 3);
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(connection1);
        connections.add(connection2);
        connections.add(connection3);
        connections.add(connection4);
        connections.add(connection5);
        connections.add(connection6);
        connections.add(connection7);
        List<List<Integer>> actual = criticalConnectionsInANetwork.criticalConnections(n, connections);
        List<Integer> result = Arrays.asList(1, 3);
        List<List<Integer>> results = new ArrayList<>();
        results.add(result);
        assertEquals(results, actual);
    }
}