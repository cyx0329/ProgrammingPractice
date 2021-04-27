package com.study.interview.amazon.OA2021;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AmazonMusicPairs {
    public static int numPairsDivisibleBy60(List<Integer> times) {
        // WRITE YOUR BRILLIANT CODE HERE
        int count = 0;
        for(int i = 0; i < times.size()-1; i++) {
            for(int j = i+1; j < times.size(); j++) {
                int sum = times.get(i) + times.get(j);
                if(sum % 60 == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> times = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        int res = numPairsDivisibleBy60(times);
        System.out.println(res);
    }
}

