package com.study.interview.microsoft.VO2021;

//https://www.geeksforgeeks.org/find-the-minimum-cost-to-reach-a-destination-where-every-station-is-connected-in-one-direction/

public class FindTheMinimumCostToReachDestinationUsingATrain {
    static int INF = Integer.MAX_VALUE, N = 4;

    public static int minCost(int[][] cost, int N) {

        int[] dict = new int[N];

        for(int i = 0; i < N; i++) {
            dict[i] = cost[0][i];
        }

        for(int i = 0; i < N-1; i++) {
            for(int j = i+1; j < N; j++) {
                dict[j] = Math.min(dict[j], dict[i] + cost[i][j]);
            }
        }
        return dict[N-1];
    }

    /*
    The idea in below code is to first calculate min cost for station 1, then for station 2, and so on. These costs are stored in an array dist[0…N-1].

     1) The min cost for station 0 is 0, i.e., dist[0] = 0

     2) The min cost for station 1 is cost[0][1], i.e., dist[1] = cost[0][1]

     3) The min cost for station 2 is minimum of following two.
            a) dist[0] + cost[0][2]
            b) dist[1] + cost[1][2]

     4) The min cost for station 3 is minimum of following three.
            a) dist[0] + cost[0][3]
            b) dist[1] + cost[1][3]
            c) dist[2] + cost[2][3]

    Similarly, dist[4], dist[5], … dist[N-1] are calculated.

    Below is the implementation of above idea.
        */




    /*

    public static int minCost(int[][] cost, int N) {
        return getMinCost(cost, 0, N-1);
    }

    private static int getMinCost(int[][] cost, int s, int d) {
        if(s == d || s+1 == d) {
            return cost[s][d];
        }
        int min_cost = cost[s][d];
        for(int i = s+1; i < d; i++) {
            int could_cost = getMinCost(cost, s, i) + getMinCost(cost, i, d);
            min_cost = Math.min(min_cost, could_cost);
        }
        return min_cost;
    }
     */


    public static void main(String[] args) {
        int[][] cost = { {0, 15, 80, 90},
                {INF, 0, 40, 50},
                {INF, INF, 0, 70},
                {INF, INF, INF, 0}
        };
        System.out.println (minCost(cost, 4));
    }

}

/*
The minimum cost to reach N-1 from 0 can be recursively written as following:

minCost(0, N-1) = MIN { cost[0][n-1],
                        cost[0][1] + minCost(1, N-1),
                        minCost(0, 2) + minCost(2, N-1),
                        ........,
                        minCost(0, N-2) + cost[N-2][n-1] }
 */
