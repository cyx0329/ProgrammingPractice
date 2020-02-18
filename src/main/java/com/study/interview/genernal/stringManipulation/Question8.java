package com.study.interview.genernal.stringManipulation;

import java.util.HashMap;
import java.util.Map;

public class Question8 {

    public static void main(String[] args){

        System.out.println(countGivenCharacter("Java", 'a'));
    }

    public static int countGivenCharacter(String givenStr, char givenChar){

        if(givenStr == "" || givenStr == null){
            return 0;
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i = 0; i < givenStr.length(); i++) {
            if(!map.containsKey(givenStr.charAt(i))){
                map.put(givenStr.charAt(i), 1);
            }
            else{
                map.put(givenStr.charAt(i), map.get(givenStr.charAt(i))+1);
            }
        }

        return map.get(givenChar);

    }
}
