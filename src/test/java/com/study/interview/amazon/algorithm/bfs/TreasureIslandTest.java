package com.study.interview.amazon.algorithm.bfs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreasureIslandTest {

    TreasureIsland treasureIsland;

    @Before
    public void setUp() throws Exception {
        treasureIsland = new TreasureIsland();
    }

    @Test
    public void shortestRoute() {
        char[][] grid = new char[][]{{'O', 'O', 'O', 'O'}, {'D', 'O', 'D', 'O'}, {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'}};
        int actual = treasureIsland.shortestRoute(grid);
        assertEquals(5, actual);
    }
}