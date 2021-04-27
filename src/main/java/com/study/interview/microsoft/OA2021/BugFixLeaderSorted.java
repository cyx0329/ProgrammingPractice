package com.study.interview.microsoft.OA2021;

public class BugFixLeaderSorted {

    public static void main(String[] args) {
        BugFixLeaderSorted bugFixLeaderSorted = new BugFixLeaderSorted();
        int[] A = {2, 2, 2, 2, 2, 3, 4, 4, 4, 6};
        int[] A1 = {1, 1, 1, 1, 50};
        int[] A3 = {0, 2, 2};
        int[] A4 = null;
        System.out.println(bugFixLeaderSorted.bugFixLeaderSorted(A));
        System.out.println(bugFixLeaderSorted.bugFixLeaderSorted(A1));
        System.out.println(bugFixLeaderSorted.bugFixLeaderSorted(A3));
    }


    int bugFixLeaderSorted(int[] A) {
        int n = A.length;
        int[] L = new int[n + 1];
        L[0] = -1;
        for (int i = 0; i < n; i++) {
            L[i + 1] = A[i];
        }
        int count = 0;
        int pos = (n + 1) / 2;
        int candidate = L[pos];
        for (int i = 1; i <= n; i++) {
            if (L[i] == candidate)
                count = count + 1;
        }
        if (2 * count > n)
            return candidate;
        return (-1);
    }
}
