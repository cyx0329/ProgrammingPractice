package com.study.interview.microsoft.VO2021;

//https://www.geeksforgeeks.org/count-number-ways-reach-destination-maze/

public class CountNumberOfWaysToReachDestinationInAMaze {

    public static int countPaths(int[][] maze) {

        int m = maze.length;
        int n = maze[0].length;

        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            if(maze[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        for(int i = 0; i < n; i++) {
            if(maze[0][i] == 0) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(maze[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];

    }

    public static void main(String[] args) {
        int maze[][] = {{0, 0, 0, 0},
                {0, -1, 0, 0},
                {-1, 0, 0, 0},
                {0, 0, 0, 0}};
        System.out.println (countPaths(maze));
    }
}
/*
Given a maze with obstacles, count number of paths to reach rightmost-bottommost cell from topmost-leftmost cell. A cell in given maze has value -1 if it is a blockage or dead end, else 0.
From a given cell, we are allowed to move to cells (i+1, j) and (i, j+1) only.

Examples:

Input: maze[R][C] =  {{0,  0, 0, 0},
                      {0, -1, 0, 0},
                      {-1, 0, 0, 0},
                      {0,  0, 0, 0}};
Output: 4
There are four possible paths as shown in
below diagram.
 */
