package com.study.interview.amazon.algorithm.bfs;

/*
    In a given grid, each cell can have one of three values:

    the value 0 representing an empty cell;
    the value 1 representing a fresh orange;
    the value 2 representing a rotten orange.
    Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

    Return the minimum number of minutes that must elapse until no cell has a fresh orange.
    If this is impossible, return -1 instead.
 */

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Queue<Integer> queue = new LinkedList<>();
        int time = 0;
        int fresh = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    fresh++;
                } else if(grid[i][j] == 2) {
                    queue.offer(i * n + j);
                }
            }
        }

        while(!queue.isEmpty() && fresh != 0) {
            for(int k = queue.size(); k > 0; k--) {
                int cur = queue.poll();
                for(int [] dir: dirs) {
                    int x = cur/n + dir[0];
                    int y = cur%n + dir[1];
                    if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1) {
                        continue;
                    }
                    grid[x][y] = 2;
                    queue.offer(x * n + y);
                    fresh--;
                }
            }
            time++;
        }

        if(fresh != 0) {
            return -1;
        }
        return time;
    }
}
