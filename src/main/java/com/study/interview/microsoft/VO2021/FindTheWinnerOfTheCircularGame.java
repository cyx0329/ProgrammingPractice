package com.study.interview.microsoft.VO2021;

import java.util.LinkedList;
import java.util.Queue;

public class FindTheWinnerOfTheCircularGame {

    public static int findTheWinner(int n, int k) {

        Queue<Integer> queue = new LinkedList();

        for(int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while(queue.size() != 1) {
            int deleteCount = k -1;
            while(deleteCount > 0) {
                Integer front = queue.remove();
                queue.add(front);
                deleteCount--;
            }
            queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        System.out.println(findTheWinner(n, k));
    }
}
