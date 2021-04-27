package com.study.interview.CTCI;

public class CountCommonElements {

    public static void main(String[] args) {
        int[] A = {13, 27, 35, 40, 49, 55, 59};
        int[] B = {17, 35, 39, 40, 55, 58, 60};
        CountCommonElements countCommonElements = new CountCommonElements();
        int result = countCommonElements.countCommonElements(A, B);
        System.out.println(result);
    }

    public int countCommonElements(int[] A, int[] B) {
        int i = 0;
        int j = 0;
        int count = 0;
        while(i < A.length) {
            if(B[j] > A[i]) {
                i++;
            } else if(B[j] < A[i]) {
                j++;
            } else {
                count++;
                i++;
                j++;
            }
        }
        return count;
    }
    /*
    time complexity: O(n) where n is the size of array A or array B
    space complexity: O(1)
     */
}
