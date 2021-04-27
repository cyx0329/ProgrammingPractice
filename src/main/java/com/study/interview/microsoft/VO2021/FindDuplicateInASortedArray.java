package com.study.interview.microsoft.VO2021;

public class FindDuplicateInASortedArray {

    public static int findDuplicate(int[] A) {

        int start = 0;
        int end = A.length-1;

        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(A[mid] == A[mid+1]) {
                return A[mid];
            }
        }
        return 0;
    }
}
