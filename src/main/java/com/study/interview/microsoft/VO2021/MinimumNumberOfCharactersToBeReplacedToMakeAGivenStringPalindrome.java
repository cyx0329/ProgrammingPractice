package com.study.interview.microsoft.VO2021;

public class MinimumNumberOfCharactersToBeReplacedToMakeAGivenStringPalindrome {

    public static int findMinNum(String str) {
        int result = 0;
        int n = str.length();
        int mid = n/2 - 1;

        int i = mid;
        int j = (n % 2 == 0) ? mid + 1 : mid + 2;

        while(i >= 0 && j < n) {
            if(str.charAt(i) != str.charAt(j)) {
                result++;
            }
            i--;
            j++;
        }
        return result;
    }


    public static void main(String[] args) {
        String str = "geeks";
        int result = findMinNum(str);
        System.out.println(result);
        String str1 = "ameba";
        int result1 = findMinNum(str1);
        System.out.println(result1);
    }

}
/*
Given a string str, the task is to find the minimum number of characters to be replaced to make a given string
palindrome. Replacing a character means replacing it with any single character at the same position.
We are not allowed to remove or add any characters.

If there are multiple answers, print the lexicographically smallest string.


 */
