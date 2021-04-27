package com.study.interview.amazon.OA2021;

import java.util.*;

//https://aonecode.com/interview-question/turnstile

public class Turnstile {

    public static int[] getTimes(int numCustomers, int[] arrTime, int[] direction) {

        int[] result = new int[numCustomers];
        Queue<Integer> load = new LinkedList<>();
        Queue<Integer> unload = new LinkedList<>();

        int endTime = arrTime[arrTime.length-1];
        int index = 0;
        int turnstile = 2; //previous action

        for(int time = 0; time <= endTime; time++) {
            while(arrTime[index] == time) {
                if(direction[index] == 0) {
                    load.add(index);
                }
                if(direction[index] == 1) {
                    unload.add(index);
                }
                index++;
                if(index == numCustomers) break;
            }

            boolean noPersonOnTurn = (load.size() + unload.size()) == 0;
            if(noPersonOnTurn) turnstile = 2;

            if(!load.isEmpty() && !unload.isEmpty()) {
                if(turnstile == 2 && !unload.isEmpty()) {
                    int action = unload.poll();
                    result[action] = time;
                    turnstile = 1;
                } else if(turnstile == 0) {
                    int action = load.poll();
                    result[action] = time;
                    turnstile = 0;
                } else if(turnstile == 1) {
                    int action = unload.poll();
                    result[action] = time;
                    turnstile = 1;
                }
            } else if(!load.isEmpty()) {
                int action = load.poll();
                result[action] = time;
                turnstile = 0;
            } else if(!unload.isEmpty()) {
                int action = unload.poll();
                result[action] = time;
                turnstile = 1;
            }
        }

        while(!load.isEmpty()) {
            int action = load.poll();
            endTime++;
            result[action] = endTime;
        }
        while(!unload.isEmpty()) {
            int action = unload.poll();
            endTime++;
            result[action] = endTime;
        }

        return result;
    }

    public static void main(String[] args) {
        int numCustomers1 = 5;
        int[] arrTime1 = {0,1,1,3,3};
        int[] direction1 = {0,1,0,0,1};
        int[] result1 = getTimes(numCustomers1, arrTime1, direction1);
        for(int re : result1) {
            System.out.print(re + " ");
        }
        int numCustomers = 4;
        int[] arrTime = {0, 0, 1, 6};
        int[] direction = {0, 1, 1, 0};
        int[] result = getTimes(numCustomers, arrTime, direction);
        for(int re : result) {
            System.out.print(re + " ");
        }
    }

}

/*
A warehouse has one loading dock that workers use to load and unload goods.
Warehouse workers carrying the goods arrive at the loading dock at different times. They form two queues, a "loading" queue and an "unloading" queue. Within each queue, the workers are ordered by the time they arrive at the dock.
The arrival time (in minutes) array stores the minute the worker arrives at the loading dock. The direction array stores whether the worker is "loading" or "unloading", a value of 0 means loading and 1 means unloading. Loading/unloading takes 1 minute.
When a worker arrives at the loading dock, if no other worker is at the dock at the same time, then the worker can use the dock.
If a "loading" worker and an "unloading" worker arrive at the dock at the same time, then we decide who can use the dock with these rules:
1,if the loading dock was not in use in the previous minute, then the unloading worker can use the dock.
2,if the loading dock was just used by another unloading worker, then the unloading worker can use the dock.
3,if the loading dock was just used by another loading worker, then the loading worker can use the dock.
Return an array of the time (in minute) each worker uses the dock.

Example:
Input:
time = [0, 0, 1, 6] direction = [0, 1, 1, 0]

Output:
[2, 0, 1, 6]

Explanation:
At time 0, worker 0 and 1 want to use the dock. Worker 0 wants to load and worker 1 wants to unload. The dock was not used in the previous minute, so worker 1 unload first.
At time 1, workers 0 and 2 want to use the rock. Worker 2 wants to unload, and at the previous minute the dock was used to unload, so worker 2 uses the dock.
At time 2, worker 0 is the only worker at the dock, so he uses the dock.
At time 6, worker 3 arrives at the empty dock and uses the dock.
We return [2, 0, 1, 6].
 */
