package com.study.interview.amazon.OA2021;

/*
    You have a map that marks the locations of treasure islands. Some of the map area has jagged rocks and dangerous
    reefs. Other areas are safe to sail in. There are other explorers trying to find the treasure. So you must figure
    out a shortest route to one of the treasure islands.

    Assume the map area is a two dimensional grid, represented by a matrix of characters. You must start from one of
    the starting point (marked as S) of the map and can move one block up, down, left or right at a time. The treasure
    island is marked as X. Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous
    blocks. You cannot leave the map area. Other areas O are safe to sail in. Output the minimum number of steps to
    get to any of the treasure islands.

    Example:
    Input:
    [['S', 'O', 'O', 'S', 'S'],
    ['D', 'O', 'D', 'O', 'D'],
    ['O', 'O', 'O', 'O', 'X'],
    ['X', 'D', 'D', 'O', 'O'],
    ['X', 'D', 'D', 'D', 'O']]

    Output: 3
    Explanation:
    You can start from (0,0), (0, 3) or (0, 4). The treasure locations are (2, 4) (3, 0) and (4, 0).
    Here the shortest route is (0, 3), (1, 3), (2, 3), (2, 4).
 */

import java.util.LinkedList;

public class TreasureIslandII {
    public int multiSourceBFSShorestPath(char[][] grid){
        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        LinkedList<Integer> queue = new LinkedList<>();
        int path = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 'S') {
                    queue.add(i * n + j);
                }
            }
        }

        while(!queue.isEmpty()){
            for(int k = queue.size(); k > 0; k--) {
                int cur = queue.poll();
                for(int[] dir: dirs) {
                    int x = cur/n + dir[0];
                    int y = cur*n + dir[1];
                    if(x >= 0 && y >= 0 && x < m && y < n && grid[x][y] != 'D') {
                        if(grid[x][y] == 'X') {
                            return path;
                        }
                        grid[x][y] = 'D';
                        queue.add(x * n + y);
                    }
                }
            }
            path++;
        }
        return path;
    }
}
