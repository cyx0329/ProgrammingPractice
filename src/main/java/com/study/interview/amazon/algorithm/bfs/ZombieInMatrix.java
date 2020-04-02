package com.study.interview.amazon.algorithm.bfs;

/*
    Given a 2D grid, each cell is either a zombie 1 or a human 0.
    Zombies can turn adjacent (up/down/left/right) human beings into zombies every hour.
    Find out how many hours does it take to infect all humans?
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZombieInMatrix {
    public int FindHour(List<List<Integer>> grid) {
        if(grid == null || grid.size() == 0 || grid.get(0).size() == 0) {
            return 0;
        }
        int time = 0;
        int human = 0;
        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Queue<Integer> queue = new LinkedList<>();
        int m = grid.size();
        int n = grid.get(0).size();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid.get(i).get(j) == 1) {
                    queue.offer(i * n + j);
                } else {
                    human++;
                }
            }
        }

        if(human == 0) {
            return time;
        }

        while(!queue.isEmpty() && human != 0) {
            for(int k = queue.size(); k > 0; k--) {
                int cur = queue.poll();
                for(int[] dir: dirs) {
                    int x = cur/n + dir[0];
                    int y = cur%n + dir[1];
                    if(x >= 0 && x < m && y >= 0 && y < n && grid.get(x).get(y) == 0) {
                        grid.get(x).set(y, 1);
                        queue.offer(x * n  + y);
                        human--;
                    }
                }
            }
            time++;
        }
        if(human != 0) {
            return -1;
        }
        return time;
    }

}
