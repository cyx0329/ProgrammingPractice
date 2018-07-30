package com.study.interview;

import java.util.LinkedHashMap;

public class Question3 {

    public Question3(){}

    public static void main(String args[]){

        Character first = returnFirstUniqueChar("Morning");

        System.out.print("The first unique character: " + first);
    }

    public static Character returnFirstUniqueChar(String givenString) {

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();

        for(int i = 0; i < givenString.length(); i++) {
            if(!map.containsKey(givenString.charAt(i))){
                map.put(givenString.charAt(i), 1);
            }
            else{
                map.put(givenString.charAt(i), map.get(givenString.charAt(i)));
            }
        }

        Character firstUniqueC = null;

        for(char c: map.keySet()){
            if(map.get(c) == 1) {
                firstUniqueC = c;
                break;
            }
        }

        return firstUniqueC;
    }
}
