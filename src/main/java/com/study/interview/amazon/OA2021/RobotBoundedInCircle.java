package com.study.interview.amazon.OA2021;

import java.util.Scanner;

//Calculate the final vector of how the robot travels after executing all instructions once -
// it consists of a change in position plus a change in direction.
//The robot stays in the circle iff (looking at the final vector)
// it changes direction (ie. doesn't stay pointing north), or it moves 0.

public class RobotBoundedInCircle {

    public static class Coordinate {
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] directionX = {0, -1, 0, 1};
    static int[] directionY = {1, 0, -1, 0};

    //N: 0
    //W: 1
    //S: 2
    //E: 3

    public static boolean isRobotBounded(String movements) {
        // WRITE YOUR BRILLIANT CODE HERE
        Coordinate point = new Coordinate(0, 0);
        int direction = 0;
        for(char ch : movements.toCharArray()) {
            if(ch == 'G') {
                point = move(point, direction);
            } else {
                direction = turn(ch, direction);
            }
        }
        if(point.x == 0 && point.y == 0 || direction != 0) {
            return true;
        }
        return false;
    }

    private static int turn(char ch, int direction) {
        if(ch == 'L') {
            direction +=1;
        } else {
            direction -=1;
        }

        while(direction < 0) {
            direction = direction + 4;
        }
        while(direction >= 4) {
            direction = direction - 4;
        }
        return direction;
    }
    private static Coordinate move(Coordinate point, int direction) {
        point.x += directionX[direction];
        point.y += directionY[direction];
        return point;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String movements = scanner.nextLine();
        scanner.close();
        boolean res = isRobotBounded(movements);
        System.out.println(res);
    }


}
