package com.study.interview.amazon.algorithm.bfs;

import com.study.interview.amazon.OA2021.TreasureIslandII;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreasureIslandIITest {

    TreasureIslandII treasureIslandII;

    @Before
    public void setUp() throws Exception {
        treasureIslandII = new TreasureIslandII();
    }

    @Test
    public void multiSourceBFSShorestPath() {
        char[][] grid = new char[][]{{'S', 'O', 'O', 'S', 'S'}, {'D', 'O', 'D', 'O', 'D'}, {'O', 'O', 'O', 'O', 'X'},
                {'X', 'D', 'D', 'O', 'O'}, {'X', 'D', 'D', 'D', 'O'}};
        int actual = treasureIslandII.multiSourceBFSShorestPath(grid);
        assertEquals(3, actual);
    }
}