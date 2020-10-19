package com.study.interview.amazon.algorithm.dfs;

/*
    Given an underected connected graph with n nodes labeled 1..n. A bridge (cut edge) is defined as an edge which,
    when removed, makes the graph disconnected (or more precisely, increases the number of connected components in the
    graph). Equivalently, an edge is a bridge if and only if it is not contained in any cycle. The task is to find all
    bridges in the given graph. Output an empty list if there are no bridges.
    Input:  n, an int representing the total number of nodes.
            edges, a list of pairs of integers representing the nodes connected by an edge.
 */

//Note: node begin with 1

import java.util.*;

public class CriticalConnections {
    int time = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> edges) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> graph[] = new LinkedList[n+1];

        for(int i = 1; i <= n; i++) { //node begin with 1
            graph[i] = new LinkedList<>();
        }

        for(List<Integer> edge: edges) {
            int startNode = edge.get(0);
            int endNode = edge.get(1);
            graph[startNode].add(endNode);
            graph[endNode].add(startNode);
        }

        int disc[] = new int[n+1]; // Initialize discovery time and low value
        int low[] = new int[n+1];
        int parent[] = new int[n+1];

        for(int i = 1; i <= n; i++) {
            disc[i] = -1;
        }

        for(int i = 1; i <= n; i++) {
            if(disc[i] == -1) {
                dfs(i, disc, low, graph, result, parent);
            }
        }

        Collections.sort(result, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        return result;
    }

    private void dfs(int u, int disc[], int low[], LinkedList<Integer> graph[], List<List<Integer>> result, int parent[]) {
        disc[u] = low[u] = ++time; // Initialize discovery time and low value
        for(int v: graph[u]) { // Go through all vertices in graph
            // If v is not visited yet, then make it a child
            // of u in DFS tree and recur for it.
            // If v is not visited yet, then recur for it
            if(disc[v] == -1) {
                parent[v] = u;
                dfs(v, disc, low, graph, result, parent);
                // Check if the subtree rooted with v has a
                // connection to one of the ancestors of u
                low[u] = Math.min(low[u], low[v]);
                // If the lowest vertex reachable from subtree
                // under v is below u in DFS tree, then u-v is
                // a bridge
                if(low[v] > disc[u]) {
                    result.add(Arrays.asList(u, v));
                }
                // Update low value of u for parent function calls.
            } else if(v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
