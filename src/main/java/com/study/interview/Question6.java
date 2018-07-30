package com.study.interview;

import java.util.HashMap;
import java.util.Map;

public class Question6 {

    public static void main(String[] args) {

        String s = "Programming";

        System.out.println(findDuplicateCharacters(s));
    }

    public static Map<Character, Integer> findDuplicateCharacters(String input) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Map<Character, Integer> newMap = new HashMap<Character, Integer>();
        for (int i = 0; i < input.length(); i++) {
            if (!map.containsKey(input.charAt(i))) {
                map.put(input.charAt(i), 1);
            } else {
                map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
            }
        }
        for (Character key : map.keySet()) {
            if ((map.get(key) > 1)) {
                newMap.put(key, map.get(key));
            }
        }
        return newMap;
    }


}
