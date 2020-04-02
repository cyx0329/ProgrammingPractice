package com.study.interview.amazon.dataStructure.heap;

/*
    You have some sticks with positive integer lengths.
    You can connect any two sticks of lengths X and Y into one stick by playing a cost of X + Y.
    You perform this action until there is one stick remaining.
    Return the minimum cost of connecting all the given sticks into one stick in this way.
 */

/*
    Given n ropes of different lengths, we need to connect these ropes into one rope. We can connect only 2 ropes
    at a time. The cost required to connect 2 ropes is equal to sum of their lengths. The length of this connected
    rope is also equal to the sum of their lengths. This process is repeated until n ropes are connected into a single
    rope. Find the min possible cost required to connect all ropes.
 */

import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        int cost = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int stick: sticks) {
            minHeap.add(stick);
        }

        while(minHeap.size() > 1) {
            int sum = minHeap.poll() + minHeap.poll();
            cost += sum;
            minHeap.add(sum);
        }

        return cost;
    }
}

//Time complexity: O(nlogn).
//Space complexity: O(n).
