package com.study.interview.leetCode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumCostToConnectSticksTest {

    MinimumCostToConnectSticks minimumCostToConnectSticks;

    @Before
    public void setUp() throws Exception {
        minimumCostToConnectSticks = new MinimumCostToConnectSticks();
    }

    @Test
    public void connectSticks1() {
        int[] sticks = new int[]{2, 4, 3};
        int actual = minimumCostToConnectSticks.connectSticks(sticks);
        assertEquals(14, actual);
    }

    @Test
    public void connectSticks2() {
        int[] sticks = new int[]{1, 8, 3, 5};
        int actual = minimumCostToConnectSticks.connectSticks(sticks);
        assertEquals(30, actual);
    }

    @Test
    public void connectSticks3() {
        int[] sticks = new int[]{8, 4, 6, 12};
        int actual = minimumCostToConnectSticks.connectSticks(sticks);
        assertEquals(58, actual);
    }

    @Test
    public void connectSticks4() {
        int[] sticks = new int[]{20, 4, 8, 2};
        int actual = minimumCostToConnectSticks.connectSticks(sticks);
        assertEquals(54, actual);
    }

    @Test
    public void connectSticks5() {
        int[] sticks = new int[]{1, 2, 5, 10, 35, 89};
        int actual = minimumCostToConnectSticks.connectSticks(sticks);
        assertEquals(224, actual);
    }

    @Test
    public void connectSticks6() {
        int[] sticks = new int[]{2, 2, 3, 3};
        int actual = minimumCostToConnectSticks.connectSticks(sticks);
        assertEquals(20, actual);
    }

}