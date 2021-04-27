package com.study.interview.amazon.OA2021;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://aonecode.com/amazon-interview-questions/find-critical-nodes
//https://www.algo.monster/problems/find_critical_nodes
public class FindCriticalNodes {

    static final int NIL = -1;
    int time = 0;
    public int[] findCriticalNodes(int nodeNum, int[][] graph) {

        List<Integer> list = new ArrayList<>();
        List<Integer>[] adj = new LinkedList[nodeNum];
        for(int i = 0; i < nodeNum; i++) {
            adj[i] = new LinkedList<>();
        }
        for(int i = 0; i < graph.length; i++) {
            adj[graph[i][0]].add(graph[i][1]);
            adj[graph[i][1]].add(graph[i][0]);
        }
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[nodeNum];
        int[] parent = new int[nodeNum];
        int[] disc = new int[nodeNum];
        int[] low = new int[nodeNum];
        boolean[] ap = new boolean[nodeNum];

        // Initialize parent
        for(int i = 0; i < nodeNum; i++) {
            parent[i] = NIL;
        }

        for(int i = 0; i < nodeNum; i++) {
            if(visited[i] == false) {
                APUtil(i, adj, visited, disc, low, parent, ap);
            }
        }

        for(int i = 0; i < nodeNum; i++) {
            if(ap[i] == true) {
                list.add(i);
            }
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    // A recursive function that find articulation points using DFS
    // u --> The vertex to be visited next
    // visited[] --> keeps tract of visited vertices
    // disc[] --> Stores discovery times of visited vertices
    // parent[] --> Stores parent vertices in DFS tree
    // ap[] --> Store articulation points
    private void APUtil(int u, List<Integer>[] adj, boolean[] visited, int[] disc, int[] low, int[] parent, boolean[] ap) {

        // Count of children in DFS Tree
        int children = 0;

        // Mark the current node as visited
        visited[u] = true;

        // Initialize discovery time and low value
        disc[u]= low[u] = ++time;

        // Go through all vertices aadjacent to this
        for(int v : adj[u]) {
            // If v is not visited yet, then make it a child of u
            // in DFS tree and recur for it
            if(!visited[v]) {
                children++;
                parent[v] = u;
                APUtil(v, adj, visited, disc, low, parent, ap);

                // Check if the subtree rooted with v has a connection to
                // one of the ancestors of u
                low[u] = Math.min(low[u], low[v]);

                // u is an articulation point in following cases

                // (1) u is root of DFS tree and has two or more chilren.
                if(parent[u] == NIL && children > 1) {
                    ap[u] = true;
                }

                // (2) If u is not root and low value of one of its child
                // is more than discovery value of u.
                if(parent[u] != NIL && low[v] >= disc[u]) {
                    ap[u] = true;
                }

                // Update low value of u for parent function calls.
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}

//Given an undirected graph, find out all the vertices when removed will make the graph disconnected.  Initially the graph is connected.
//
//For example given the graph below:
//
//
//Return [3, 6]. Because we can make the graph disconnected by removing either vertex 3 or vertex 6.
//
//Input:
//
//nodeNum, the total count of vertices in the graph. Each vertex has an unique id in the range from 0 to nodeNum - 1 inclusive.
//
//edges, a list of integer pairs representing all the edges on the graph.
//
//output:
//
//A list of integers representing the ids of the articulation points.
//
//example:
//
//Input:
//
//nodeNum = 7
//
//edges = [[0,1], [0, 2], [1, 3], [2, 3], [2, 5], [5, 6], [3,4]]
//
//Output:
//
//[2,3,5]
