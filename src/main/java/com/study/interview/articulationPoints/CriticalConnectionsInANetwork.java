package com.study.interview.articulationPoints;

/*
    There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network
    where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server
    directly or indirectly through the network.
    A critical connection is a connection that, if removed, will make some server unable to reach some other server.
    Return all critical connections in the network in any order.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CriticalConnectionsInANetwork {
    int time = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        LinkedList<Integer>[] graph = new LinkedList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for(List<Integer> connection: connections) {
            int node1 = connection.get(0);
            int node2 = connection.get(1);
            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        //graph[0] [1, 2]
        //graph[1] [0, 2, 3]
        //graph[2] [1, 0]
        //graph[3] [1]

        int[] disc = new int[n];
        int[] low = new int[n];
        int[] parent = new int[n];


        for(int i = 0; i < n; i++) {
            disc[i] = -1;
            parent[i] = -1;

        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < n; i++) {
            if(disc[i] == -1) {
                dfs(i, disc, low, graph, result, parent);
            }
        }
        return result;
    }

    private void dfs(int u, int[] disc, int[] low,
                     LinkedList<Integer>[] graph, List<List<Integer>> result, int[] parent) {
        disc[u] = low[u] = ++time;
        for(int v: graph[u]) {
            if(disc[v] == -1) {
                    parent[v] = u;
                    dfs(v, disc, low, graph, result, parent);
                    low[u] = Math.min(low[u], low[v]);
                    if (low[v] > disc[u]) {
                        result.add(Arrays.asList(u, v));
                    }
            } else if(v != parent[u]){
                    low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
