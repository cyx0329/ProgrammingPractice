package com.study.interview.amazon.algorithm.slidingWindow;

/* Given a string s and an int k, return an int representing the number of substrings (not unique) of s with
   exactly k distinct characters.
   If the given string doesn't have k distinct characters, return 0.

   Example 1:

   Input: s = "pqpqs", k = 2
   Output: 7
   Explanation: ["pq", "pqp", "pqpq", "qp", "qpq", "pq", "qs"]
   Example 2:

   Input: s = "aabab", k = 3
   Output: 0

   Constraints:
   The input string consists of only lowercase English letters [a-z]
   0 ≤ k ≤ 26
*/

import java.util.HashMap;

public class SubstringWithExactlyKDistinctChars {
    public int substringWithExactlyKDistinctChars(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        return substringWithAtMostKDistinctChars(s, k) - substringWithAtMostKDistinctChars(s, k-1);
    }

    public int substringWithAtMostKDistinctChars(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0, j = 0; j < s.length(); j++) {
            char chj = s.charAt(j);
            map.put(chj, map.getOrDefault(chj, 0)+ 1);
            while(map.size() > k) {
                char chi = s.charAt(i);
                if(map.get(chi) > 0) {
                    map.put(chi, map.get(chi) - 1);
                }
                if(map.get(chi) == 0) {
                    map.remove(chi);
                }
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }

}
