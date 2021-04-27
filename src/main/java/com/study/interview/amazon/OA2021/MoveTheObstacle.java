package com.study.interview.amazon.OA2021;

import java.util.*;
import java.util.stream.Collectors;

public class MoveTheObstacle {

    public static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[] deltaX = {0, -1, 0, 1};
    private static int[] deltaY = {1, 0, -1, 0};

    public static int moveObstacle(List<List<Integer>> lot) {
        // WRITE YOUR BRILLIANT CODE HERE
        int m = lot.size();
        int n = lot.get(0).size();
        boolean[][] visited = new boolean[m][n];
        return bfs(lot, 0, 0, visited);
    }

    private static int bfs(List<List<Integer>> lot, int x, int y, boolean[][] visited) {

        Queue<Coordinate> queue = new LinkedList<>();
        Coordinate start = new Coordinate(x, y);
        queue.add(start);
        visited[x][y] = true;
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate point = queue.poll();
                if(lot.get(point.x).get(point.y) == 9) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    int new_x = point.x + deltaX[j];
                    int new_y = point.y + deltaY[j];
                    Coordinate new_coor = new Coordinate(new_x, new_y);
                    if (!isValid(lot, new_x, new_y, visited)) {
                        continue;
                    }
                    queue.add(new_coor);
                    visited[new_x][new_y] = true;
                    step++;
                }
            }
        }
        return -1;
    }

    private static boolean isValid(List<List<Integer>> lot, int i, int j, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= lot.size() || j >= lot.get(0).size() || visited[i][j] || lot.get(i).get(j) == 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lotLength = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> lot = new ArrayList<>();
        for (int i = 0; i < lotLength; i++) {
            lot.add(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        }
        scanner.close();
        int res = moveObstacle(lot);
        System.out.println(res);
    }
}
