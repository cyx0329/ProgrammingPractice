package com.study.interview.leetCode;

//https://leetcode.com/problems/valid-palindrome/description/

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if(s == null || s == ""){
            return true;
        }

        s = s.replaceAll("[^a-zA-Z0-9]", "");

        s = s.toLowerCase();

        int j = s.length() - 1;

        for(int i = 0; i < (s.length()+1)/2; i++){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            j--;
        }
        return true;
    }

}
