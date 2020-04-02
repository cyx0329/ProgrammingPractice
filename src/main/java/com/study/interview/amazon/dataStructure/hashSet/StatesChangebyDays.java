package com.study.interview.amazon.dataStructure.hashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class StatesChangebyDays {
    public static void main(String[] args) {
        StatesChangebyDays solution = new StatesChangebyDays();
        int[] states = {1, 0, 0, 0, 0, 1, 0, 0};
        int days = 1;
        int[] states1 = {1, 1, 1, 0, 1, 1, 1, 1};
        int days1 = 2;
        List<Integer> result = solution.cellCompete(states, days);
        System.out.println(result);
    }
    public List<Integer> cellCompete(int[] states, int days)
    {
        // WRITE YOUR CODE HERE
        HashSet<String> set = new HashSet<String>();
        boolean hasCycle = false;
        int count = 0;
        for(int i = 0; i < days; i++) {
            int[] nextDay = statesNextDay(states);
            String next = nextDay.toString();
            if(!set.contains(next)){
                set.add(next);
                count++;
            } else{
                hasCycle = true;
                break;
            }
            states = nextDay;
        }
        if(hasCycle) {
            int n = days%count;
            for(int j = 0; j < n; j++) {
                states = statesNextDay(states);
            }
        }
        List<Integer> list = Arrays.stream(states).boxed().collect(Collectors.toList());

        return list;
    }

    public int[] statesNextDay(int[] states) {
        int[] nextDay = new int[states.length];
        for(int i = 1; i < states.length-1; i++) {
            nextDay[0] = (states[1] == 0) ? 0 : 1;
            nextDay[i] = (states[i-1] == states[i+1]) ? 0 : 1;
            nextDay[states.length-1] = (states[states.length-2] == 0) ? 0 : 1;
        }
        return nextDay;
    }
}
