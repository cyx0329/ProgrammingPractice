package com.study.interview.amazon.algorithm.bfs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RottingOrangesTest {

    RottingOranges rottingOranges;

    @Before
    public void setUp() throws Exception {
        rottingOranges = new RottingOranges();
    }

    @Test
    public void orangesRottingTest1() {
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int actual = rottingOranges.orangesRotting(grid);
        assertEquals(4, actual);
    }

    @Test
    public void orangesRottingTest2() {
        int[][] grid = new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int actual = rottingOranges.orangesRotting(grid);
        assertEquals(-1, actual);
    }

    @Test
    public void orangesRottingTest3() {
        int[][] grid = new int[][]{{0, 2}};
        int actual = rottingOranges.orangesRotting(grid);
        assertEquals(0, actual);
    }
}