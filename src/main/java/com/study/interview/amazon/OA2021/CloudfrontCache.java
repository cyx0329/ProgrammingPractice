package com.study.interview.amazon.OA2021;

import java.util.*;

public class CloudfrontCache {

    public static int getEfficiencyOfCloudFrontCaching(int N, int[][] edges) {
        Map<Integer, Set<Integer>> graph = createGraph(N, edges);
        Set<Integer> visited = new HashSet<>();
        int cost = 0;
        for(int i = 0; i < N; i++) {
            if(!visited.contains(i)) {
                cost += bfs(i, graph, visited);
            }
        }
        return cost;
    }

    private static int bfs(int start, Map<Integer, Set<Integer>> graph, Set<Integer> visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                count++;
                int node = queue.poll();
                for(int point : graph.get(node)) {
                    if(!visited.contains(point)) {
                        visited.add(point);
                        queue.add(point);
                    }
                }
            }
        }
        return (int) Math.ceil(Math.sqrt(count));
    }


    private static Map<Integer, Set<Integer>> createGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for(int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        return graph;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{0, 2}, {1, 2}};
        int n1 = 10;
        int[][] edges1 = {{2, 6}, {3, 5}, {0, 1}, {2, 9}, {5, 6}};
        int cost = getEfficiencyOfCloudFrontCaching(4, edges);
        System.out.println(cost);
    }

}
