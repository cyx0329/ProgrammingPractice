package com.study.interview.amazon.OA2021;

/*
    You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous
    reefs. Other areas are safe to sail in. There are other explorers trying to find the treasure. So you must figure
    out a shortest route to the treasure island.

    Assume the map area is a two dimensional grid, represented by a matrix of characters. You must start from the
    top-left corner of the map and can move one block up, down, left or right at a time. The treasure island is marked
    as X in a block of the matrix. X will not be at the top-left corner.

    Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous blocks. You cannot leave
    the map area. Other areas O are safe to sail in. The top-left corner is always safe. Output the minimum number of
    steps to get to the treasure.

    Example:
    Input:
    [['O', 'O', 'O', 'O'],
    ['D', 'O', 'D', 'O'],
    ['O', 'O', 'O', 'O'],
    ['X', 'D', 'D', 'O']]

    Output: 5
    Explanation: Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps.
 */

import java.util.LinkedList;

public class TreasureIsland {
    public int shortestRoute(char[][] grid) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int m = grid.length;
        int n = grid[0].length;
        queue.add(0);
        grid[0][0] = 'D';
        int path = 1;
        while(!queue.isEmpty()) {
            for(int k = queue.size(); k > 0; k--) {
                int cur = queue.poll();
                for(int[] dir: dirs) {
                    int x = cur/n + dir[0];
                    int y = cur%n + dir[1];
                    if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 'D') {
                        if(grid[x][y] == 'X') {
                            return path;
                        }
                        grid[x][y] ='D';
                        queue.add(x * n + y);
                    }
                }
            }
            path++;
        }
        return path;
    }

}
