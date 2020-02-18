package com.study.interview.leetCode;

public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        if(s == null) {
            return true;
        }

        int i = 0;
        int j = s.length()-1;
        int count = 0;
        int deleteIndex;

        while(i<j){
            if(count <= 1){
                if(s.charAt(i) != s.charAt(j)){
                    if(s.charAt(i) == s.charAt(j-1)){
                        count++;
                        deleteIndex = j;
                        j = j-1;
                    }
                    else if(s.charAt(i+1) == s.charAt(j)){
                        count++;
                        deleteIndex = i;
                        i = i+1;
                    }
                    else{
                        return false;
                    }
                }
                i++;
                j--;
            }
            else {
                return false;
            }
        }
        return true;
    }



}
