package com.study.interview.amazon.algorithm.dfs.articulationPoints;

/*
    You are given an undirected connected graph. An articulation point (or cut vertex) is defined as a vertex which,
    when removed along with associated edges, makes the graph disconnected (or more precisely, increases the number of
    connected components in the graph). The task is to find all articulation points in the given graph.

    Input:
    The input to the function/method consists of three arguments:
        numNodes, an integer representing the number of nodes in the graph.
        numEdges, an integer representing the number of edges in the graph.
        edges, the list of pair of integers - A, B representing an edge between the nodes A and B.

    Output:
    Return a list of integers representing the critical nodes.
 */

//Note: node begin with 0

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CriticalRouters {
    int time = 0;
    public List<Integer> criticalRouters(int numNodes, int numEdges, List<List<Integer>> edges) {
        List<Integer> result = new ArrayList<>();

        LinkedList<Integer> graph[] = new LinkedList[numNodes];

        for(int i = 0; i < numNodes; i++) {
            graph[i] = new LinkedList<>();
        }

        for(List<Integer> edge: edges) {
            int startNode = edge.get(0);
            int endNode = edge.get(1);
            graph[startNode].add(endNode);
            graph[endNode].add(startNode);
        }

        int disc[] = new int[numNodes];
        int low[] = new int[numNodes];
        int parent[] = new int[numNodes];

        for(int i = 0; i < numNodes; i++) {
            disc[i] = -1;
        }

        for(int i = 0; i < numNodes; i++) {
            if(disc[i] == -1) {
                dfs(i, disc, low, graph, result, parent);
            }
        }
        Collections.sort(result);
        return result;
    }

    private void dfs(int u, int disc[], int low[], LinkedList<Integer> graph[], List<Integer> result, int parent[]) {
        int children = 0;
        disc[u] = low[u] = ++time;
        for(int v: graph[u]) {
            if(disc[v] == -1) {
                children++;
                parent[v] = u;
                dfs(v, disc, low, graph, result, parent);
                low[u] = Math.min(low[u], low[v]);
                if(parent[u] != 0 && low[v] >= disc[u]) {
                    result.add(u);
                }
                if(parent[u] == 0 && children > 1) {
                    result.add(u);
                }
            } else if(v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
