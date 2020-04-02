package com.study.interview.amazon.algorithm.unionFind;

/*
    Given an undirected graph with n nodes labeled 1..n. Some of the nodes are already connected.
    The i-th edge connects nodes edges[i][0] and edges[i][1] together. Your task is to augment this set of edges
    with additional edges to connect all the nodes. Find the minimum cost to add new edges between the nodes such
    that all the nodes are accessible from each other.

    Input:
    n, an int representing the total number of nodes.
    edges, a list of integer pair representing the nodes already connected by an edge.
    newEdges, a list where each element is a triplet representing the pair of nodes between which an edge can
    be added and the cost of addition, respectively (e.g. [1, 2, 5] means to add an edge between node 1 and 2,
    the cost would be 5).

    Example 1:
    Input: n = 6, edges = [[1, 4], [4, 5], [2, 3]], newEdges = [[1, 2, 5], [1, 3, 10], [1, 6, 2], [5, 6, 5]]
    Output: 7

    Explanation:
    There are 3 connected components [1, 4, 5], [2, 3] and [6].
    We can connect these components into a single component by connecting node 1 to node 2 and node 1 to node 6 at
    a minimum cost of 5 + 2 = 7.
 */

import java.util.Arrays;

public class MinCostToConnectAllNodes {

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{1, 4}, {4, 5}, {2, 3}};
        int[][] newEdges = {{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}};
        MinCostToConnectAllNodes solution = new MinCostToConnectAllNodes();
        System.out.println(solution.minCost(n, edges, newEdges));
    }

    private int[] parent;
    //private int component;

    /*public int findParent(int node) {
        if(node == parent[node]) {
            return node;
        }
        return parent[node] = findParent(parent[node]);
    }

    public void union(int v1, int v2) {
        if(findParent(v1) == findParent(v2)) return;
        int root = findParent(v1);
        while(v2 != parent[v2]){
            int temp = parent[v2];
            parent[v2] = root;
            v2 = temp;
        }
        --component;
        parent[v2] = root;
    }

    private boolean isConnected(int v1, int v2){
        return findParent(v1) == findParent(v2);
    }*/

    public int findParent(int node) {
        if(node != parent[node]) {
            parent[node] = findParent(parent[node]);
        }
        return parent[node];
    }

    public void union(int city1, int city2) {
        parent[findParent(city2)] = findParent(city1);
        //parent[parent[city2]] = parent[city1];
    }

    public int minCost(int n, int[][] edges, int[][] newEdges) {
        parent = new int[n];
        //component = n;
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int[] edge: edges) {
            union(edge[0]-1, edge[1]-1);
        }
        Arrays.sort(newEdges, (c1, c2) -> {return c1[2] - c2[2];});
        int cost = 0;

        /*
        for(int[] newEdge: newEdges) {
            if(findParent(newEdge[0] - 1) != findParent(newEdge[1] - 1)) {
                cost += newEdge[2];
                union(newEdge[0] - 1, newEdge[1] - 1);
                if(component == 1) return cost;
            }
        }
        return -1;
        */

        for(int[] newEdge: newEdges) {
            if(findParent(newEdge[0] - 1) != findParent(newEdge[1] - 1)) {
                cost += newEdge[2];
                union(newEdge[0] - 1, newEdge[1] - 1);
            }
        }
        int group = findParent(0);
        for(int i = 0; i < n; i++) {
            if(findParent(i) != group) return -1;
        }
        return cost;
    }
}

