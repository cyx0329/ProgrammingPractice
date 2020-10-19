package com.study.interview.amazon.dataStructure.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomIndexOfMax {
    private static void findRandomIndexOfMax(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        int max = Integer.MIN_VALUE;

        int max_count = Integer.MIN_VALUE;

        for(Integer key : map.keySet()) {
            if(map.get(key) > max_count) {
                max_count = map.get(key);
                max = key;
            }
        }

        Random rand = new Random();

        // generate a random number between [1, max_count]
        int r = (int) (rand.nextInt(max_count) % max_count + 1);

        for(int i = 0, count = 0; i < n; i++) {
            if(arr[i] == max) {
                count++;
            }
            if(count == r) {
                System.out.print("Element with maximum frequency present "
                        +"at index " + i +"\n");
                break;
            }
        }
    }

    public static void main(String[] args)
    {
        // input array
        int arr[] = { -1, 4, 9, 7, 7, 2, 7, 3, 0, 9, 6, 5,
                7, 8, 9 };
        int n = arr.length;
        findRandomIndexOfMax(arr, n);
    }
}
