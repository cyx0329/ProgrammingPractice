package com.study.interview.amazon.OA2021;

public class RoverControl {

    //https://aonecode.com/amazon-online-assessment-rover-control

    final static String LEFT = "LEFT";
    final static String RIGHT = "RIGHT";
    final static String UP = "UP";
    final static String DOWN = "DOWN";

    private static int roverMove(int n, String[] cmds) {
        int[][] matrix = createMatrix(n);
        printMatrix(matrix);
        int cur = matrix[0][0];
        int x = 0;
        int y = 0;

        for(int i = 0; i < cmds.length; i++) {
            if(cmds[i] == LEFT) {
                int new_y = y - 1;
                if(isValid(x, new_y, matrix)) {
                    cur = matrix[x][new_y];
                    y = new_y;
                }
            } else if(cmds[i] == RIGHT) {
                int new_y = y + 1;
                if(isValid(x, new_y, matrix)) {
                    cur = matrix[x][new_y];
                    y = new_y;
                }
            } else if(cmds[i] == UP) {
                int new_x = x -1;
                if(isValid(new_x, y, matrix)) {
                    cur = matrix[new_x][y];
                    x = new_x;
                }
            } else if(cmds[i] == DOWN) {
                int new_x = x + 1;
                if(isValid(new_x, y, matrix)) {
                    cur = matrix[new_x][y];
                    x = new_x;
                }
            }
        }

        return cur;
    }

    private static boolean isValid(int x, int y, int[][] matrix) {
        if(x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
            return false;
        }
        return true;
    }

    private static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }



    private static int[][] createMatrix(int n) {
        int num = 0;
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = num;
                num++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int n = 4;
        String[] cmds = {"RIGHT", "UP", "DOWN", "LEFT", "DOWN", "DOWN"};
        int result = roverMove(n, cmds);
        System.out.println(result);

        int n1 = 4;
        String[] cmds1 = {"RIGHT", "DOWN", "LEFT", "LEFT", "DOWN"};
        int result1 = roverMove(n1, cmds1);
        System.out.println(result1);
    }

}

/*
A Mars rover is directed to move within a square matrix. It accepts a sequence of commands to move in any of the four directions from each cell: [UP, DOWN, LEFT or RIGHT]. The rover starts from cell 0. and may not move diagonally or outside of the boundary.

Each cell in the matrix has a position equal to:
(row * size) + column
where row and column are zero-indexed, size = row length of the matrix.

Return the final position of the rover after all moves.

Example
n = 4
commands = [RIGHT, UP, DOWN, LEFT, DOWN, DOWN]

The rover path is shown below.

0	1	2	3
4	5 	6 	7
8 	9 	10 	11
12 	13 	14 	15

RIGHT: Rover moves to position 1
UP: Position unchanged, as the move would take the rover out of the boundary.
DOWN: Rover moves to Position 5.
LEFT: Rover moves to position 4
DOWN: Rover moves to position 8
DOWN: The rover ends up in position 12.

The function returns 12.

Function Description
Complete the function roverMove in the editor below.
roverMove has the following parameter(s):
int n: the size of the square matrix
string cmds[m]: the commands

Returns
int: the label of the cell the rover occupies after executing all commands

Constraints
2 <= n <= 20
1 <= |cmds| <= 20

Input Format For Custom Testing

Input from stdin will be processed as follows and passed to the function.
The first line contains an integer, n, denoting the size of the square matrix.
The next line contains an integer, m, the number of commands to follow.
Each of the next m lines contains a command string, cmds[i].

Sample Input :
STDIN    Function
-------    ----------
4        → n = 4
5        → cmds [] size m = 5
RIGHT → cmds = ['RIGHT', 'DOWN', 'LEFT', 'LEFT', 'DOWN']
DOWN
LEFT
LEFT
DOWN

Sample Output:
8

Explanation:
0	1	2	3
4	5 	6 	7
8 	9 	10 	11
12 	13 	14 	15
Rover starts at position 0
RIGHT → pos 1
DOWN → pos 5
LEFT → pos 4
LEFT → pos 4, No effect
DOWN → pos 8
 */
