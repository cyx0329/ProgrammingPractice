package com.study.interview.hackerrank;

import java.util.*;

public class SockMerchant {

    // Complete the sockMerchant function below.
    public int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int color : ar) {
            if (map.containsKey(color)) {
                map.put(color, map.get(color) + 1);
            } else {
                map.put(color, 1);
            }
        }
        int count = 0;
        for (int key : map.keySet()) {
            count += map.get(key) / 2;
        }
        return count;
    }
}


