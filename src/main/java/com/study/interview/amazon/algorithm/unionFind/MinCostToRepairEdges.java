package com.study.interview.amazon.algorithm.unionFind;

/*
    There's an undirected connected graph with n nodes labeled 1..n. But some of the edges has been broken
    disconnecting the graph. Find the minimum cost to repair the edges so that all the nodes are once again
    accessible from each other.

    Input:
    n, an int representing the total number of nodes.
    edges, a list of integer pair representing the nodes connected by an edge.
    edgesToRepair, a list where each element is a triplet representing the pair of nodes between which an edge is
    currently broken and the cost of repearing that edge, respectively (e.g. [1, 2, 12] means to repear an edge between
    nodes 1 and 2, the cost would be 12).

    Example 1:
    Input: n = 5, edges = [[1, 2], [2, 3], [3, 4], [4, 5], [1, 5]], edgesToRepair = [[1, 2, 12], [3, 4, 30], [1, 5, 8]]
    Output: 20
    Explanation:
    There are 3 connected components due to broken edges: [1], [2, 3] and [4, 5].
    We can connect these components into a single component by repearing the edges between nodes 1 and 2, and
    nodes 1 and 5 at a minimum cost 12 + 8 = 20.

    Example 2:
    Input: n = 6, edges = [[1, 2], [2, 3], [4, 5], [3, 5], [1, 6], [2, 4]], edgesToRepair = [[1, 6, 410], [2, 4, 800]]
    Output: 410

    Example 3:
    Input: n = 6, edges = [[1, 2], [2, 3], [4, 5], [5, 6], [1, 5], [2, 4], [3, 4]], edgesToRepair = [[1, 5, 110],
    [2, 4, 84], [3, 4, 79]]
    Output: 79
 */

import java.util.*;

public class MinCostToRepairEdges {

    public static void main(String[] args) {
        System.out.println(new MinCostToRepairEdges().getMinCostToRepairEdges(
                5, new int [][] {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}, new int[][] {{1, 2, 12}, {3, 4, 30}, {1, 5, 8}})
        );

        System.out.println(new MinCostToRepairEdges().getMinCostToRepairEdges(
                6, new int [][] {{1, 2}, {2, 3}, {4, 5}, {3, 5}, {1, 6}, {2, 4}}, new int[][] {{1, 6, 410}, {2, 4, 800}})
        );

        System.out.println(new MinCostToRepairEdges().getMinCostToRepairEdges(
                6, new int [][] {{1, 2}, {2, 3}, {4, 5}, {5, 6}, {1, 5}, {2, 4}, {3, 4}}, new int[][] {{1, 5, 110}, {2, 4, 84}, {3, 4, 79}})
        );
    }

    public static int getMinCostToRepairEdges(int n, int[][] edges, int[][] edgesToRepair) {
        if(n == 0 || edges == null || edges.length == 0 || edges[0].length < 2 || edgesToRepair == null || edgesToRepair[0].length < 3) return 0;

        //Remove the Repaired Edges from the edgesList
        Set<String> brokenEdges = new HashSet<>();
        for(int [] edge : edgesToRepair) {
            brokenEdges.add(edge[0] + "-" + edge[1]);
        }

        
        UF uf = new UF(n + 1); // + 1 because nodes are 1-based
        for (int[] edge : edges) {
            if(!brokenEdges.contains(edge[0] + "-" + edge[1])) {
                uf.union(edge[0], edge[1]);
            }
        }

        //Queue<int[]> queue = new PriorityQueue<>(edgesToRepair.length, Comparator.comparingInt(a -> a[2]));
        Queue<int[]> queue = new PriorityQueue<>(edgesToRepair.length, (e1, e2) -> Integer.compare(e1[2], e2[2]));
        for(int [] edge : edgesToRepair) {
            queue.offer(edge);
        }


        int costToRepair = 0;
        // 2 because nodes are 1-based and we have 1 unused component at index 0 (>2)
        while(!queue.isEmpty() && uf.count != 2) {
            int[] connection = queue.poll();
            if(!uf.connected(connection[0], connection[1])) {
                uf.union(connection[0], connection[1]);
                costToRepair += connection[2];
            }
        }
        return costToRepair;
    }
}

class UF {
    private int[] parent;  // parent[i] = parent of i
    private byte[] rank;   // rank[i] = rank of subtree rooted at i (never more than 31)
    public int count;      // number of connected components

    public UF(int n) {
        if (n < 0) throw new IllegalArgumentException();
        parent = new int[n];
        rank = new byte[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        count = n;
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pr = find(p);
        int qr = find(q);
        if (pr == qr) return;
        if (rank[pr] < rank[qr]) {
            parent[pr] = qr;
        } else {
            parent[qr] = pr;
            if (rank[pr] == rank[qr]) rank[pr]++;
        }
        count--;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}