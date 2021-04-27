package com.study.interview.amazon.OA2021;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UtilizationCheck {

    public static int finalInstances(int instances, int[] averageUtil) {
        for(int i = 0; i < averageUtil.length; i++) {
            if(25 <= averageUtil[i] && averageUtil[i] <= 60) {
                continue;
            } else if(averageUtil[i] < 25) {
                if(instances > 1) {
                    instances = (int) Math.ceil((1.0 * instances/2));
                    i += 10;
                } else {
                    continue;
                }

            } else if(averageUtil[i] > 60) {
                if(instances > Math.pow(10, 8)) {
                    continue;
                } else {
                    instances *= 2;
                    i += 10;
                }
            }
        }

        return instances;
    }

    public static void main(String[] args) {
        int[] averageUtil1 = {30, 5, 4, 8, 19, 89};
        int instances1 = 5;
        int result1 = finalInstances(instances1, averageUtil1);
        System.out.println(result1);

        int[] averageUtil = {25,23,1,2,3,4,5,6,7,8,9,10,76,80};
        int instances = 2;
        int result = finalInstances(instances, averageUtil);
        System.out.println(result);

        int[] averageUtil2 = {5, 10, 80};
        int instances2 = 1;
        int result2 = finalInstances(instances2, averageUtil2);
        System.out.println(result2);
    }
}
