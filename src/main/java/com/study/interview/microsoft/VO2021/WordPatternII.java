package com.study.interview.microsoft.VO2021;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPatternII {

    public static boolean wordPatternMatch(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        return isMatch(pattern, 0, s, 0, map, set);
    }

    private static boolean isMatch(String pattern, int i, String s, int j, Map<Character, String> map, Set<String> set) {

        if(i == pattern.length() && j == s.length()) return true;
        if(i == pattern.length() || j == s.length()) return false;

        char ch = pattern.charAt(i);

        if(map.containsKey(ch)) {
            String str = map.get(ch);
            if(!s.startsWith(str, j)) {
                return false;
            }
            return isMatch(pattern, i+1, s, j+str.length(), map, set);
        }

        for(int k = j; k < s.length(); k++) {
            String match_str = s.substring(j, k+1);

            if(set.contains(match_str)) {
                continue;
            }

            map.put(ch, match_str);
            set.add(match_str);

            if(isMatch(pattern, i+1, s, k+1, map, set)) {
                return true;
            }

            map.remove(ch);
            set.remove(match_str);
        }

        return false;
    }

    public static void main(String[] args) {
        String pattern = "abab";
        String s = "redblueredblue";
        System.out.println(wordPatternMatch(pattern, s));
    }
}
