package com.study.interview.genernal.stringManipulation;

/*
2) How to check if two Strings are anagrams of each other? (solution)
A simple coding problem based upon String, but could also be asked with numbers.
You need to write a Java program to check if two given strings are anagrams of Each other.
Two strings are anagrams if they are written using the same exact letters, ignoring space,
punctuation and capitalization. Each letter should have the same count in both strings.
For example, Army and Mary are anagram of each other.

Read more: https://javarevisited.blogspot.com/2015/01/top-20-string-coding-interview-question-programming-interview.
html#ixzz5IAxJwolX
*/

import java.util.HashMap;
import java.util.Map;

public class Question2 {

    public boolean areAnagrams(String s1, String s2) {
        if(s1 == null && s2 == null){
            return true;
        }
        if(s1 == null || s2 == null){
            return false;
        }
        if(!(s1.length() == s2.length())){
            return false;
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i<= s1.length()-1; i++) {
            if(!map.containsKey(s1.charAt(i))) {
                map.put(s1.charAt(i), 1);
            }
            else{
                map.put(s1.charAt(i), map.get(s1.charAt(i))+1);
            }
        }
        for(int j = 0; j <= s2.length()-1; j++) {
            if(map.containsKey(s2.charAt(j))) {
                map.put(s2.charAt(j), map.get(s2.charAt(j))-1);
            }
            else{
                return false;
            }
        }
        for(Character c: map.keySet()){
            if(!(map.get(c) == 0)){
                return false;
            }
        }
        return true;
    }
}
