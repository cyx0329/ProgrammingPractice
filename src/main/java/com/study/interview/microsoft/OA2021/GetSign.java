package com.study.interview.microsoft.OA2021;

/*
Write a function solution that, given an array A of N integers [-100, 100], returns the sign (-1, 0, 1) of all numbers in the array multiple together.
Assuming that N is between 1 and 1000.

For example, given A = [1,-2,-3,5], the function should return 1
Given A = [1,2,3,-5], your function should return -1
Given A = [1,2,0,-5], your function should return 0
 */

public class GetSign {

    public static void main(String[] args) {
        GetSign getSign = new GetSign();
        int[] A = {1, -2, -3, 5};
        int[] A1 = {1, 2, 3, -5};
        int[] A2 = {1, 2, 0, -5};
        int[] A3 = new int[0];
        int[] A4 = null;
        System.out.println(getSign.getSign(A));
        System.out.println(getSign.getSign(A1));
        System.out.println(getSign.getSign(A2));
        System.out.println(getSign.getSign(A3));
        System.out.println(getSign.getSign(A4));
    }

    private int getSign(int[] A) {
        if(A == null || A.length == 0) {
            System.out.println("The array A has no elements or is null.");
        }
        int sign = 1;
        for(int i = 0; i < A.length; i++) {
            if(A[i] == 0) {
                return 0;
            } else if(A[i] < 0) {
                sign *= -1;
            } else {
                sign *= 1;
            }
        }
        return sign;
    }

    //time complexity: O(n) where n is the length of array A
    //there are two edges case:
    //  1. when array A has no elements
    //  2. when array A is null
    //Since the question isn't specific what will the output of these two edges case, I print out a message.
    //When array A has no elements, output will be 1;
    //When array A is null, it will throw null pointer exception
    //I can also remove the last else block, but I think keep it here is straightforward to express my thinking
    //process and ideas


}
