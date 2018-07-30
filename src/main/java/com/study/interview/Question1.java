package com.study.interview;


/*1) How to Print duplicate characters from String?
To start with, we have a simple String related coding question frequently asked in programming interviews.
You need to write a program in C, C++, Java or Python to print duplicate characters from a given String,
for example if String is "Java" then program should print "a". Bonus points if your program is robust and
handle different kinds of input e.g. String without duplicate, null or empty String etc. Bonus points if
you also write unit tests for normal and edge cases.*/


import java.util.HashMap;
import java.util.Map;

public class Question1 {

    public Map<Character, Integer> returnDuplicate(String s){
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Map<Character, Integer> newMap = new HashMap<Character, Integer>();
        for(int i = 0; i <= s.length()-1; i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1);
            }
            else{
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
        }
        for(Character key: map.keySet()){
            if(map.get(key) > 1) {
                newMap.put(key,map.get(key));
            }
        }
        return newMap;
    }
}
